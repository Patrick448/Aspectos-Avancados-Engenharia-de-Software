package Refactoring;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApostaTest {

    @Test
    public void deveRetornarListaVerificada() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Aposta aposta = new Aposta();

        List<Integer> filteredList = aposta.verifySelectedNumbers(list);
        assertEquals(list, filteredList);

    }

    @Test
    public void deveRetornarExceçãoListaNumerosRepetidos() {
        List<Integer> list;
        list = Arrays.asList(1, 2, 3, 4, 5, 1);


        try {
            Aposta aposta = new Aposta(list);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("a lista não pode conter números repetidos", e.getMessage());
        }
    }


    @Test
    public void deveRetornarExceçãoNumeroMenorQue1() {
        List<Integer> list;
        list = Arrays.asList(0, 1, 2, 3, 4, 5);

        try {
            Aposta aposta = new Aposta(list);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("a lista deve conter números entre 1 e 60", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExceçãoNumeroMaioQue60() {
        List<Integer> list;
        list = Arrays.asList(0, 61, 2, 3, 4, 5);

        try {
            Aposta aposta = new Aposta(list);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("a lista deve conter números entre 1 e 60", e.getMessage());
        }
    }

    @Test
    void deveRetornarErroApostaPequena() {


        try {
            Aposta aposta = new Aposta(Arrays.asList(1, 2, 3, 4, 5));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("lista de números deve ter entre 6 e 15 elementos", e.getMessage());
        }
    }


    @Test
    void deveRetornarErroApostaGrande() {

        try {
            Aposta aposta = new Aposta(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("lista de números deve ter entre 6 e 15 elementos", e.getMessage());
        }
    }

}