package Aluno;

public class Aluno {

    private String nome;
    private String nomeCurso;
    private Diploma diploma;

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Diploma getDiploma() {
        return diploma;
    }

    public void setDiploma(Diploma diploma) {
        this.diploma = diploma;
    }

    public String imprimirDiploma(){
        String diplomaStr ="Diploma de conclusão do curso de " + this.nomeCurso +
                ". Conferido ao aluno " + this.nome + " na data " +
        this.diploma.getData()+".";

        return diplomaStr;
    }
}