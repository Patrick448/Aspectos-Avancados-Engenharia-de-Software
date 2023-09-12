package Aluno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AlunoTest {

    Aluno aluno;

    @BeforeEach
    void setUp(){
        aluno = new Aluno();
    }

    @Test
    public void deveRetornarDiploma(){
        Diploma diploma = new Diploma();
        diploma.setData("21/07/2015");
        aluno.setDiploma(diploma);
        System.out.println(aluno.imprimirDiploma());

        ;
    }


}
