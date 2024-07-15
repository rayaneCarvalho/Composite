package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

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

        List<Componente> componentes = obterComponentes(container);
        assertEquals(2, componentes.size());
        assertEquals("Componente Botão: Botão de Login\n", componentes.get(0).exibir());
        assertEquals("Componente Botão: Botão de Cadastro\n", componentes.get(1).exibir());
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

    private List<Componente> obterComponentes(Container container) {
        // Método auxiliar para obter os componentes do container usando reflexão
        try {
            java.lang.reflect.Field field = Container.class.getDeclaredField("componentes");
            field.setAccessible(true);
            return (List<Componente>) field.get(container);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
