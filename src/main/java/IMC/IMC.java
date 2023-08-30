package IMC;

public class IMC {
    private float peso;
    private float altura;
    private String sexo;

    public IMC() {
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if(altura<=0.0){
            throw new IllegalArgumentException("Altura não pode ser menor ou igual a zero.");
        }
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if(!sexo.equals("M") && !sexo.equals("F")){
            throw new IllegalArgumentException("Sexo inválido.");
        }
        this.sexo = sexo;
    }

    public String calcularIMC(){
        float imc = peso/(altura*altura);
        String resultado;

        if(sexo.equals("F")){
            if(imc < 19.1f){
                resultado = "abaixo do peso";
            }else if(imc < 25.8f){
                resultado = "no peso normal";
            }else if(imc < 27.3f){
                resultado = "marginalmente acima do peso";
            }else if(imc < 32.3f){
                resultado = "acima do peso ideal";
            }else{
                resultado = "obeso";
            }
        }else{
            if(imc < 20.7f){
                resultado = "abaixo do peso";
            }else if(imc < 26.4f){
                resultado = "no peso normal";
            }else if(imc < 27.8f){
                resultado = "marginalmente acima do peso";
            }else if(imc < 31.1f){
                resultado = "acima do peso ideal";
            }else{
                resultado =  "obeso";
            }
        }

        return resultado;
    }

}
