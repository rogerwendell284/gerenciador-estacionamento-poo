package br.com.rogerwendel.estacionamento.vaga.ticket.veiculo;
import br.com.rogerwendel.estacionamento.vaga.TipoVaga;
import br.com.rogerwendel.estacionamento.vaga.ticket.veiculo.proprietario.Proprietario;

public class Veiculo {
    private String placa; // BRA1A23
    private TipoVaga tipoVeiculo;
    private Proprietario proprietario;

    public Veiculo(TipoVaga tipoVeiculo, String placa, Proprietario proprietario) {
        this.placa = validarPlaca(placa);
        this.tipoVeiculo = tipoVeiculo;
        this.proprietario = proprietario;
    }

    public Veiculo(String placa) {
        this.placa = validarPlaca(placa);
    }

    private static String validarPlaca(String placa) {
        if (placa == null) {
            throw new IllegalArgumentException("Placa não pode ser nula.");
        }

        String placaFiltrada = placa.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

        // Regex que valida tanto o formato antigo (ABC1234) quanto o Mercosul (ABC1D23)
        String regexPlaca = "([A-Z]{3}[0-9]{4})|([A-Z]{3}[0-9][A-Z][0-9]{2})";

        if (placaFiltrada.length() != 7 || !placaFiltrada.matches(regexPlaca)) {
            throw new IllegalArgumentException("Placa inválida. Use o formato ABC1234 ou ABC1D23.");
        }

        return placaFiltrada;
    }

    public String getPlaca() {
        return placa;
    }

    public TipoVaga getTipoVeiculo() {
        return tipoVeiculo;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    @Override
    public String toString() {
        return "Veiculo [placa=" + placa + ", tipoVeiculo=" + tipoVeiculo.getDescricao() + ", proprietario=" + proprietario.getNome() + "]";
    }
}

