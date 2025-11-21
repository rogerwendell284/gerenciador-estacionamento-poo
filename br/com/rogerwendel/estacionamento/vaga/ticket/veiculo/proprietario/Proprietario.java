package br.com.rogerwendel.estacionamento.vaga.ticket.veiculo.proprietario;

public class Proprietario extends Pessoa{

    public Proprietario(String nome, String telefone) {
        super(nome, telefone);
    }

    @Override
    public String toString() {
        return "Proprietario [ nome=" + getNome() + ", telefone=" + getTelefone()+" ]";
    }
}
