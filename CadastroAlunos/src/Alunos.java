import java.util.*;
public class Alunos
{
    private String nome,cpf,telefone,curso;
    private int codCurso,idade,numDisciplinas;
    private String[] nomDisciplinas;
    public Alunos(){}

    public Alunos (String nome,int idade,String cpf,String telefone,
                   String curso,int codCurso,int numDisciplinas){
        this.nome=nome;
        this.idade=idade;
        this.cpf=cpf;
        this.telefone=telefone;
        this.curso=curso;
        this.codCurso=codCurso;
        this.numDisciplinas=numDisciplinas;
        this.nomDisciplinas=new String[this.numDisciplinas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getNumDisciplinas() {
        return numDisciplinas;
    }

    public void setNumDisciplinas(int numDisciplinas) {
        this.numDisciplinas = numDisciplinas;
    }

    public void addDisciplinas(){
        Scanner sc=new Scanner(System.in);
        String Disciplina;
        nomDisciplinas=new String[this.numDisciplinas];
        for(int i=0;i<nomDisciplinas.length;i++){
            System.out.printf("Digite o nome da %d Diciplina\n",(i+1));
            Disciplina=sc.next();
            nomDisciplinas[i]=Disciplina;
        }
    }

    // MÉTODO PARA INICIAR AS DICIPLINAS DE MANEIRA ALEATÓRIA DOS 3 ALUNOS JÁ EXISTENTES DA CLASSE CadastroEstudantes ELE AINDA VERIFICA SE A DISCIPLINA SORTEADA 
    // JÁ FOI SORTEADA NO MESMO ALUNO CASO FOR ELE SORTEIA NOVAMENTE.

    public void IniciaDisciplinas(){
        Random random=new Random();
        Scanner sc=new Scanner(System.in);
        String Disciplina;
        nomDisciplinas=new String[this.numDisciplinas];
        String[] disciplinas = {"Calculo 1", "Calculo 2", "Fundamentos de programação", "Matemática discreta",
                "BD 1", "Matemática Concreta", "Jogos Digitais", "AGES 1", "Moral e ética","Fundamentos de Sistemas Computacionais",
                "Programação Orientada a Objetos","Algoritmos e Estrutura de Dados"};

        for(int i=0;i<nomDisciplinas.length;i++){

            Disciplina=(disciplinas[random.nextInt(disciplinas.length)]);

            nomDisciplinas[i]=Disciplina;

            for(int b=0;b<i;b++){
                if(b!=i){
                    if(Disciplina.equals(nomDisciplinas[b])){
                        Disciplina=(disciplinas[random.nextInt(disciplinas.length)]);
                        nomDisciplinas[i]=Disciplina;

                    }
                }
            }
        }
    }


    public String listarDisciplinas() {
        if (nomDisciplinas.length > 0) {

            String disciplinasString = "Disciplinas que está cursando:\n";
            for (int i = 0; i < nomDisciplinas.length; i++) {
                disciplinasString += nomDisciplinas[i] + "\n";
            }
            return disciplinasString;
        } else {
            return "Nenhuma disciplina foi adicionada ainda.";
        }
    }

    public String toString() {
        String formataCpf = String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9));
        String formataTel = String.format("(%s)%s-%s", telefone.substring(0, 3), telefone.substring(3, 8), telefone.substring(8));

        return  "Nome: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "CPF: " + formataCpf + "\n" +
                "Telefone: " + formataTel + "\n" +
                "Curso: " + curso + "\n" +
                "numDisciplinas: " + numDisciplinas + "\n" +
                listarDisciplinas();
    }

}