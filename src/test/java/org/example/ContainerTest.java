package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container container;

    @BeforeEach
    void setUp() {
        container = new Container("Container Principal");
    }

    @Test
    void deveCriarContainerComDescricao() {
        assertEquals("Container Principal", container.getDescricao());
    }

    @Test
    void deveAdicionarComponente() {
        Componente componente1 = new ComponenteVisual("Botão de Login", "Botão");
        Componente componente2 = new ComponenteVisual("Botão de Cadastro", "Botão");

        container.adicionarComponente(componente1);
        container.adicionarComponente(componente2);

        String resultadoExibicao = container.exibir();
        assertTrue(resultadoExibicao.contains("Componente Botão: Botão de Login\n"));
        assertTrue(resultadoExibicao.contains("Componente Botão: Botão de Cadastro\n"));
    }

    @Test
    void deveExibirDescricaoEComponentes() {
        Componente componente1 = new ComponenteVisual("Botão de Login", "Botão");
        Componente componente2 = new ComponenteVisual("Botão de Cadastro", "Botão");

        container.adicionarComponente(componente1);
        container.adicionarComponente(componente2);

        String resultadoExibicao = container.exibir();
        assertTrue(resultadoExibicao.contains("Container: Container Principal\n"));
        assertTrue(resultadoExibicao.contains("Componente Botão: Botão de Login\n"));
        assertTrue(resultadoExibicao.contains("Componente Botão: Botão de Cadastro\n"));
    }
}
