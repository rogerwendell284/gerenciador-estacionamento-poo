package br.com.rogerwendel.estacionamento.vaga;

public enum TipoVaga {
    MOTO("Moto"),
    CARRO("Carro"),
    PCD("Pcd");

    private final String descricao;

    TipoVaga(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoVaga fromString(String texto) {
        for (TipoVaga tipo : TipoVaga.values()) {
            if (tipo.descricao.equalsIgnoreCase(texto)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de vaga inválido: '" + texto + "'. Use 'Moto', 'Carro' ou 'Pcd'.");
    }
}
