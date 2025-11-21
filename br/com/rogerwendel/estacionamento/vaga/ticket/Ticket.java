package br.com.rogerwendel.estacionamento.vaga.ticket;
import br.com.rogerwendel.estacionamento.vaga.Vaga;
import br.com.rogerwendel.estacionamento.vaga.ticket.veiculo.Veiculo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    private final LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private double valor;
    private Veiculo veiculo;
    private Vaga vaga;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //Formato data e horário BR

    private static final int VALOR_VAGA_HORA = 5;

    public Ticket(Veiculo veiculo, Vaga vaga) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.dataHoraEntrada = LocalDateTime.now();
        this.dataHoraSaida = this.dataHoraEntrada;
        this.valor = VALOR_VAGA_HORA; // Valor inicial do ticket 
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public double getValor() {
        return valor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void calcularValorTicket() { 

        if(dataHoraSaida == null) return;

        Duration duracao = Duration.between(dataHoraEntrada, dataHoraSaida);
        long horas = duracao.toHours();

        if(horas < 1) horas = 1;

        this.valor = horas * VALOR_VAGA_HORA;
    }

    @Override
    public String toString() {
        return "Ticket [dataHoraEntrada=" + dataHoraEntrada.format(formatter) + ";\ndataHoraSaida=" + dataHoraSaida == null ? "Saída não registrada" : dataHoraSaida.format(formatter) + "\nvalor= R$" + valor
                + "\n" + veiculo + "\n" + vaga + "\n-------------------------------------\n";
    }

    
    

}
