package Solid;

public class Sphere implements Printable{

    private float radius = 15;
    @Override
    public String print() {
        return "Sphere.\n Radius: " + this.radius;
    }
}
