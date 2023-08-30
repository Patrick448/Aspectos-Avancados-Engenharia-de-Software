package Loteria;
import Refactoring.Loteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoteriaTest {

    Loteria loteria;
    @BeforeEach
    public void init(){
         loteria = new Loteria();
    }

    @Test
    public void deveRetornarListaVazia(){
        List<Integer> list ;
        list = Arrays.asList(1, 1, 2, 2);
        List<Integer> filteredList = loteria.filterNumbers(list);
        assertArrayEquals();

    }
}
