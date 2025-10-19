package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {
    
    private NumberAscOrder<Integer> numberAscOrder;
    @Mock
    CustomStack<Integer> customStack;

    @Test
    public void validarSortStackComSeisNumeros() throws StackEmptyException{
        when(customStack.isEmpty()).thenReturn(false, false, false, false, false, false, true);
        when(customStack.pop()).thenReturn(42).thenReturn(34).thenReturn(12).thenReturn(40).thenReturn(2).thenReturn(23);

        numberAscOrder = new NumberAscOrder<>(customStack);
        List<Integer> listaOrdenada = numberAscOrder.sort();

        List<Integer> listaEsperada = Arrays.asList(2, 12, 23, 34, 40, 42);
        assertEquals(listaEsperada, listaOrdenada);
    }

    @Test
    public void validarSortStackVazia() throws StackEmptyException{
        when(customStack.isEmpty()).thenReturn(true);

        numberAscOrder = new NumberAscOrder<>(customStack);
        List<Integer> listaOrdenada = numberAscOrder.sort();

        List<Integer> listaEsperada = Arrays.asList();
        assertEquals(listaEsperada, listaOrdenada);
    }
}
