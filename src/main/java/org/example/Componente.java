package org.example;

abstract class Componente {

    private String descricao;

    public Componente(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract String exibir();
}

