package br.com.rogerwendel.estacionamento.vaga.ticket.veiculo.proprietario;

public abstract class Pessoa {
    private String nome;
    private String telefone;
    
    public Pessoa(String nome, String telefone) {
        this.nome = validarNome(nome);
        this.telefone = validarTelefone(telefone);
    }

    private String validarNome(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException("Nome inválido! O nome deve ter no mínimo 3 caracteres.");
        }
        return nome.replaceAll("[^a-zA-Z ]", ""); // Filtra para permitir letras e espaços
    }

    private String validarTelefone(String telefone) {
        if (telefone == null) {
            throw new IllegalArgumentException("Telefone inválido! Não pode ser nulo.");
        }

        String telefoneFiltrado = telefone.replaceAll("[^0-9]", ""); // Filtra apenas os números

        if (telefoneFiltrado.length() != 11) {
            throw new IllegalArgumentException("Telefone inválido! Deve conter 11 dígitos (DDD + número).");
        }

        // Formata para o padrão (XX) X XXXX-XXXX
        return String.format("(%s) %s %s-%s",
                telefoneFiltrado.substring(0, 2),
                telefoneFiltrado.substring(2, 3),
                telefoneFiltrado.substring(3, 7),
                telefoneFiltrado.substring(7, 11));
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    } 
}