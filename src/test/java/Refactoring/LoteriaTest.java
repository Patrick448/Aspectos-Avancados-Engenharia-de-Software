package Refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoteriaTest {

    Loteria loteria;

    @BeforeEach
    public void init() {
        loteria = new Loteria();
    }


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
    void deveRetornar0Acertos() {
        Aposta aposta = new Aposta(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        Sorteio sorteio = new Sorteio(Arrays.asList(13, 14, 15, 16, 17, 18));

        int acertos = loteria.countMatches(aposta, sorteio);
        assertEquals(0, acertos);
    }

    @Test
    void deveRetornar6Acertos() {
        Aposta aposta = new Aposta(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        Sorteio sorteio = new Sorteio(Arrays.asList(1, 2, 3, 4, 5, 6));

        int acertos = loteria.countMatches(aposta, sorteio);
        assertEquals(6, acertos);
    }

    @Test
    void deveRetornarErroApostaNulaCountMatches1() {
        Sorteio sorteio = new Sorteio();
        try {
            loteria.countMatches(null, sorteio);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Objetos passados como parâmetro não podem ser nulos", e.getMessage());
        }
    }

    @Test
    void deveRetornarErroListaNulaCountMatches2() {
        Aposta aposta = new Aposta();
        try {
            loteria.countMatches(aposta, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Objetos passados como parâmetro não podem ser nulos", e.getMessage());
        }
    }

    @Test
    void deveRetornarPremioInteiro() {
        double prize = loteria.calculateFinalPrize(100.0, 6);
        assertEquals(100.0, prize);
    }

    @Test
    void deveRetornarPremioSegundo() {
        double prize = loteria.calculateFinalPrize(100.0, 5);
        assertEquals(20.0, prize);
    }

    @Test
    void deveRetornarPremioTerceiro() {
        double prize = loteria.calculateFinalPrize(100.0, 4);
        assertEquals(5.0, prize);
    }

    @Test
    void deveRetornarPremioZero() {
        double prize = loteria.calculateFinalPrize(100.0, 3);
        assertEquals(0.0, prize);
    }

    @Test
    void deveRetornarErroApostaNula() {

        Sorteio sorteio = new Sorteio(Arrays.asList(1, 2, 3, 4, 5, 6));


        try {
            loteria.verifyLoteryResult(null, sorteio, 100.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Objetos passados como parâmetro não podem ser nulos", e.getMessage());
        }
    }

    @Test
    void deveRetornarErroSorteioNulo() {

        Aposta aposta = new Aposta(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));


        try {
            loteria.verifyLoteryResult(aposta, null, 100.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Objetos passados como parâmetro não podem ser nulos", e.getMessage());
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