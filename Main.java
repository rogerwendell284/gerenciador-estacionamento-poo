import java.util.InputMismatchException;
import java.util.Scanner;
import br.com.rogerwendel.estacionamento.Estacionamento;
import br.com.rogerwendel.estacionamento.vaga.TipoVaga;
import br.com.rogerwendel.estacionamento.vaga.ticket.veiculo.Veiculo;
import br.com.rogerwendel.estacionamento.vaga.ticket.veiculo.proprietario.Proprietario;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final Estacionamento estacionamento = new Estacionamento(10, 5);
    public static void main(String[] args) {
       System.out.println("-----Bem vindo ao Estacionamento------");
       var opcao = 4;
       try {
            do {
                System.out.println("Selecione um dos números abaixo para continuar:");
                System.out.println("1 - Registrar entrada de veículo");
                System.out.println("2 - Registrar saída de veículo");
                System.out.println("3 - Listar vagas disponíveis");
                System.out.println("4 - Sair");
                opcao = scanner.nextInt();
                scanner.nextLine();
                    switch (opcao) {
                    case 1 -> {
                        registrarVagaEntrada();
                        estacionamento.listarVagasDisponiveis();
                        estacionamento.listarTickets();
                    }
                    case 2 -> registrarSaida();
                    case 3 -> estacionamento.listarVagasDisponiveis();
                    case 4 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                    }
                    } while (opcao != 4);
        
       } catch (InputMismatchException e) {
            System.out.println("Opção inválida!");
       }
    }

    private static void registrarVagaEntrada() {
        Proprietario proprietario = null;
        while (proprietario == null) {
            try {
                // Recolhimento dos dados do proprietário
                System.out.print("Nome do proprietário(a): ");
                String nomeProprietario = scanner.nextLine();

                System.out.print("Telefone contato (somente números, 11 dígitos): ");
                String telefoneProprietario = scanner.nextLine();

                proprietario = new Proprietario(nomeProprietario, telefoneProprietario);

            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Por favor, insira os dados novamente.\n");
            }
        }

        Veiculo veiculo = null;
        while (veiculo == null) {
            try {
                 // Recolhimento dos dados do veículo
                System.out.print("Tipo do veículo: ");
                var tipoVeiculo = scanner.nextLine();
                System.out.print("Placa do veículo: ");
                var placaVeiculo = scanner.nextLine();
                
                veiculo = new Veiculo(TipoVaga.fromString(tipoVeiculo), placaVeiculo, proprietario);
                
            } catch (IllegalArgumentException e) {
                System.out.println("Erro, " + e.getMessage());
                System.out.println("Por favor, insira os dados novamente.\n");
            }
        }

        estacionamento.registrarEntrada(veiculo);
    }

    private static void registrarSaida() {
        Veiculo veiculo = null;
        while (veiculo == null) {
            try {
                 // Recolhimento da placa
                System.out.print("Placa do veículo: ");
                var placaVeiculo = scanner.nextLine();
                
                veiculo = new Veiculo(placaVeiculo);
                
            } catch (IllegalArgumentException e) {
                System.out.println("Erro, " + e.getMessage());
                System.out.println("Por favor, insira os dados novamente.\n");
            }
        }

        estacionamento.registrarSaida(veiculo);
    }

}
