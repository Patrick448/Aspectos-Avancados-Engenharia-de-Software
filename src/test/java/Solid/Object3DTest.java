package Solid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Object3DTest {

    @Test
    public void deveRetornarEsfera(){
        Object3D object3D = new Object3D("Sphere");
        assertEquals("Sphere.\n Radius: 15.0", object3D.print());
    }

    @Test
    public void deveRetornarCubo(){
        Object3D object3D = new Object3D("Cube");
        assertEquals("Sphere.\n Side: 10.0", object3D.print());
    }

}