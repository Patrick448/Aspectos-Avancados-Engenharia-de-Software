package Solid;

public class Object3D {
    private String position;
    private Printable printable;

    public Object3D(String objectName) {
        Class objectClass = null;
        Object objectInstance = null;

        try{
            objectClass = Class.forName("Solid." + objectName);
            objectInstance = objectClass.newInstance();
        }catch (Exception e){
            this.printable = null;
        }

        if(!(objectInstance instanceof Printable)){
            this.printable = null;
        }

        this.printable = (Printable) objectInstance;

    }

    public String print(){
        return this.printable.print();
    }



}
