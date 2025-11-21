package br.com.rogerwendel.estacionamento;
import br.com.rogerwendel.estacionamento.vaga.ticket.Ticket;
import br.com.rogerwendel.estacionamento.vaga.ticket.veiculo.Veiculo;
import br.com.rogerwendel.estacionamento.vaga.TipoVaga;
import br.com.rogerwendel.estacionamento.vaga.Vaga;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Estacionamento {

    private Set<Vaga> vagas; //Lista de vagas para que não tenha nenhum em duplicidade
    private Set<Ticket> tickets; //Lista de tickets para que não tenha nenhum em duplicidade


    public Estacionamento(int totalMotos, int totalCarros) { // Determina a quantidade máxima de carros e motos no estacionamento via parâmetro
        double pcd = (double) ((totalMotos+totalCarros) * 0.05);

        this.vagas = new TreeSet<>();
        this.tickets = new HashSet<>();

        int numeroVagaAtual = 1;
        // Se o tipo da vaga for igual ao tipo de veiculo, será adicionado automaticamente à respectiva vaga do tipo de veiculo
        for(int i = 0; i < totalMotos; i++) {
            vagas.add(new Vaga(numeroVagaAtual++, TipoVaga.MOTO)); 
        }

        for(int i = 0; i < totalCarros; i++) {
            vagas.add(new Vaga(numeroVagaAtual++, TipoVaga.CARRO));
        }

        for(int i = 0; i < Math.round(pcd); i++) {
            vagas.add(new Vaga(numeroVagaAtual++, TipoVaga.PCD));
        }

    }

    public void registrarEntrada(Veiculo veiculo) {
        // Checagem e confirmação da primeira vaga disponível e respectiva ao tipo de veículo
        Optional<Vaga> vaga = vagas 
                            .stream()
                            .filter(v -> !v.isOcupada() && v.getTipoVaga().equals(veiculo.getTipoVeiculo()))
                            .findFirst();

        vaga.ifPresentOrElse(
            (v-> {
                 // Se for confirmado alguma vaga livre
                v.setOcupada(true); // Preenche a vaga como ocupada
                tickets.add(new Ticket(veiculo, v));// Cria um ticket da vaga e veiculo
                System.out.println("Ticket "+veiculo.getPlaca()+" registrado com sucesso! - Vaga: "+v.getNumeroVaga());
        
            }), 
            ()-> {// Se não tiver nenhuma vaga livre
                System.out.println("Vaga não encontrada, tente mais tarde.");
            });
    }

    public void registrarSaida(Veiculo veiculo) {
        // Checagem e confirmação do registro existente do ticket do veiculo
        Optional<Ticket> ticket = tickets
                            .stream()
                            .filter(t-> t.getVeiculo().getPlaca().equalsIgnoreCase(veiculo.getPlaca()))
                            .findFirst();
        
        ticket.ifPresentOrElse(
            (t-> {
                // Se confirmado o registro do ticket
                t.getVaga().setOcupada(false);// Preenche a vaga como livre
                t.setDataHoraSaida(LocalDateTime.now());//Pega o horário da saída para calculo do valor do ticket
                t.calcularValorTicket();
                System.out.println(t);
                tickets.remove(t);// Libera o ticket do veiculo e vaga
                System.out.println("Ticket do veículo " + veiculo.getPlaca() + " removido com sucesso! Vaga: " + t.getVaga().getNumeroVaga());
            })
            ,()->{
                // Se não tiver registro do ticket                                                 
                System.out.println("Ticket não encontrado, verifique se registrou a entrada do veículo.\nTickets registrados:");
                System.out.println(tickets);
            } 
            );
    }

    public void listarVagasDisponiveis() {
        System.out.println("Vagas disponíveis:");
        for(Vaga v : vagas){
            if(v.isOcupada()) continue;
            System.out.println(v);
        }
    }

    public void listarTickets() {
        System.out.println("Tickets registrados: "+ tickets.size());
        System.out.println(tickets);
    }

}
