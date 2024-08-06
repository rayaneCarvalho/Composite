package org.example;

class ComponenteVisual extends Componente {

    private String tipo;

    public ComponenteVisual(String descricao, String tipo) {
        super(descricao);
        this.tipo = tipo;
    }

    @Override
    public String exibir() {
        return "Componente " + tipo + ": " + this.getDescricao() + "\n";
    }
}

