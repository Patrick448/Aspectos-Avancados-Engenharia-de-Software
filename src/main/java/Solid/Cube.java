package Solid;

public class Cube implements Printable{

    private float side = 10;
    @Override
    public String print() {
        return "Sphere.\n Side: " + this.side;
    }
}
