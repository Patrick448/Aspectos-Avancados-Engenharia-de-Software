import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class IMCTest {

    IMC imc;

    @BeforeEach
    void setUp(){
        imc = new IMC();
    }

    @Test
    public void deveRetornarAlturaInvalidaMenorIgualZero(){
        try {
            imc.setAltura(0.0f);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("Altura não pode ser menor ou igual a zero.", e.getMessage());
        }
    }

    @Test
    public void deveRetornarSexoInvalido(){
        try {
            imc.setSexo("X");
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("Sexo inválido.", e.getMessage());
        }
    }

    @Test
    public void deveRetornarAbaixoPesoFeminino(){
        imc.setPeso(19.0f);
        imc.setAltura(1.0f);
        imc.setSexo("F");

        assertEquals("abaixo do peso", imc.calcularIMC());
    }

    @Test
    public void deveRetornarPesoNormalFeminino(){
        imc.setPeso(25.7f);
        imc.setAltura(1.0f);
        imc.setSexo("F");

        assertEquals("no peso normal", imc.calcularIMC());
    }

    @Test
    public void deveRetornarMarginalmenteAcimaPesoFeminino(){
        imc.setPeso(27.2f);
        imc.setAltura(1.0f);
        imc.setSexo("F");

        assertEquals("marginalmente acima do peso", imc.calcularIMC());
    }

    @Test
    public void deveRetornarAcimaPesoFeminino(){
        imc.setPeso(32.2f);
        imc.setAltura(1.0f);
        imc.setSexo("F");

        assertEquals("acima do peso ideal", imc.calcularIMC());
    }

    @Test
    public void deveRetornarObesoFeminino(){
        imc.setPeso(32.3f);
        imc.setAltura(1.0f);
        imc.setSexo("F");

        assertEquals("obeso", imc.calcularIMC());
    }

    @Test
    public void deveRetornarAbaixoPesoMasculino(){
        imc.setPeso(20.6f);
        imc.setAltura(1.0f);
        imc.setSexo("M");

        assertEquals("abaixo do peso", imc.calcularIMC());
    }

    @Test
    public void deveRetornarPesoNormalMasculino(){
        imc.setPeso(26.3f);
        imc.setAltura(1.0f);
        imc.setSexo("M");

        assertEquals("no peso normal", imc.calcularIMC());
    }

    @Test
    public void deveRetornarMarginalmenteAcimaPesoMasculino(){
        imc.setPeso(27.7f);
        imc.setAltura(1.0f);
        imc.setSexo("M");

        assertEquals("marginalmente acima do peso", imc.calcularIMC());
    }

    @Test
    public void deveRetornarAcimaPesoMasculino(){
        imc.setPeso(31.0f);
        imc.setAltura(1.0f);
        imc.setSexo("M");

        assertEquals("acima do peso ideal", imc.calcularIMC());
    }

    @Test
    public void deveRetornarObesoMasculino(){
        imc.setPeso(31.1f);
        imc.setAltura(1.0f);
        imc.setSexo("M");

        assertEquals("obeso", imc.calcularIMC());
    }


}
