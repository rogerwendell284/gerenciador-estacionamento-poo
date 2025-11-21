package br.com.rogerwendel.estacionamento.vaga;

import java.util.Objects;

public class Vaga implements Comparable<Vaga> {

    private int numeroVaga;
    private TipoVaga tipoVaga;
    private boolean ocupada;

    public Vaga(int numeroVaga, TipoVaga tipoVaga) {
        this.numeroVaga = numeroVaga;
        this.tipoVaga = tipoVaga;
        this.ocupada = false;
    }

     @Override
    public int compareTo(Vaga outraVaga) { //Comparador dos números das vagas para ordenação da lista treeset
        return Integer.compare(this.numeroVaga, outraVaga.numeroVaga);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vaga = (Vaga) o;
        return numeroVaga == vaga.numeroVaga && Objects.equals(tipoVaga, vaga.tipoVaga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroVaga, tipoVaga);
    }

    public int getNumeroVaga() {
        return numeroVaga;
    }

    public TipoVaga getTipoVaga() {
        return tipoVaga;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "Vaga - numeroVaga=" + numeroVaga + ", tipoVaga=" + tipoVaga;
    }
}
