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
        if(altura==0.0){
            throw new RuntimeException("Altura não pode ser zero");
        }
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if(!sexo.equals("M") && !sexo.equals("F")){
            throw new RuntimeException("Sexo inválido.");
        }
        this.sexo = sexo;
    }

    public String calcularIMC(){
        float imc = peso/(altura*altura);
        String resultado;

        if(sexo.equals("F")){
            if(imc < 19.1){
                resultado = "abaixo do peso";
            }else if(imc < 25.8){
                resultado = "no peso normal";
            }else if(imc < 27.3){
                resultado = "marginalmente acima do peso";
            }else if(imc < 32.3){
                resultado = "acima do peso ideal";
            }else{
                resultado = "obeso";
            }
        }else{
            if(imc < 20.7){
                resultado = "abaixo do peso";
            }else if(imc < 26.4){
                resultado = "no peso normal";
            }else if(imc < 27.8){
                resultado = "marginalmente acima do peso";
            }else if(imc < 31.1){
                resultado = "acima do peso ideal";
            }else{
                resultado =  "obeso";
            }
        }

        return resultado;
    }

}
