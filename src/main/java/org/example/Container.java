package org.example;

import java.util.ArrayList;
import java.util.List;

class Container extends Componente {

    private List<Componente> componentes;

    public Container(String descricao) {
        super(descricao);
        this.componentes = new ArrayList<>();
    }

    public void adicionarComponente(Componente componente) {
        componentes.add(componente);
    }

    @Override
    public String exibir() {
        StringBuilder saida = new StringBuilder();
        saida.append("Container: ").append(this.getDescricao()).append("\n");
        for (Componente componente : componentes) {
            saida.append(componente.exibir());
        }
        return saida.toString();
    }
}

