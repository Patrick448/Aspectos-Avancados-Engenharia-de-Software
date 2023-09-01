package Refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoteriaTest {

    Loteria loteria;
    @BeforeEach
    public void init(){
        loteria = new Loteria();
    }


    @Test
    public void deveRetornarExceçãoListaVerificada(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> filteredList = loteria.verifySelectedNumbers(list);
        assertEquals(list, filteredList);

    }

    @Test
    public void deveRetornarExceçãoListaNumerosRepetidos(){
        List<Integer> list ;
        list = Arrays.asList(1, 2, 3, 4, 5, 1);

        try {
            List<Integer> filteredList = loteria.verifySelectedNumbers(list);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("a lista não pode conter números repetidos", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExceçãoNumeroMenorQue1(){
        List<Integer> list ;
        list = Arrays.asList(0, 1, 2, 3, 4, 5);

        try {
            List<Integer> filteredList = loteria.verifySelectedNumbers(list);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("a lista deve conter números entre 1 e 60", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExceçãoNumeroMaioQue60(){
        List<Integer> list ;
        list = Arrays.asList(0, 61, 2, 3, 4, 5);

        try {
            List<Integer> filteredList = loteria.verifySelectedNumbers(list);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("a lista deve conter números entre 1 e 60", e.getMessage());
        }
    }

    @Test
    void deveRetornar0Acertos() {
        List<Integer> aposta = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Integer> sorteio = Arrays.asList(13, 14, 15, 16, 17, 18);

        int acertos = loteria.countMatches(aposta, sorteio);
        assertEquals(0, acertos);
    }

    @Test
    void deveRetornar6Acertos(){
        List<Integer> aposta = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Integer> sorteio = Arrays.asList(1, 2, 3, 4, 5, 6);

        int acertos = loteria.countMatches(aposta, sorteio);
        assertEquals(6, acertos);
    }

    @Test
    void deveRetornarErroListaNulaCountMatches1() {
        List<Integer> listB = Arrays.asList(13, 14, 15, 16, 17, 18);
        try {
            loteria.countMatches(null, listB);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("lista não pode ser nula", e.getMessage());
        }
    }

    @Test
    void deveRetornarErroListaNulaCountMatches2() {
        List<Integer> listA = Arrays.asList(13, 14, 15, 16, 17, 18);
        try {
            loteria.countMatches(listA, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("lista não pode ser nula", e.getMessage());
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

        List<Integer> aposta = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Integer> sorteio = Arrays.asList(1, 2, 3, 4, 5, 6);


        try{
            loteria.verifyLoteryResult(null, sorteio, 100.0);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("lista não pode ser nula", e.getMessage());
        }
    }

    @Test
    void deveRetornarErroSorteioNulo() {

        List<Integer> aposta = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Integer> sorteio = Arrays.asList(1, 2, 3, 4, 5, 6);


        try{
            loteria.verifyLoteryResult(aposta, null, 100.0);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("lista não pode ser nula", e.getMessage());
        }
    }

    @Test
    void deveRetornarErroApostaPequena() {

        List<Integer> aposta = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sorteio = Arrays.asList(1, 2, 3, 4, 5, 6);


        try{
            loteria.verifyLoteryResult(aposta, sorteio, 100.0);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("lista de números deve ter entre 6 e 15 elementos", e.getMessage());
        }
    }


    @Test
    void deveRetornarErroApostaGrande() {

        List<Integer> aposta = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,16);
        List<Integer> sorteio = Arrays.asList(1, 2, 3, 4, 5, 6);


        try{
            loteria.verifyLoteryResult(aposta, sorteio, 100.0);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("lista de números deve ter entre 6 e 15 elementos", e.getMessage());
        }
    }
}