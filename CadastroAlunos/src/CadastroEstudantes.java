import java.util.*;

public class CadastroEstudantes
{
    Alunos aluno=new Alunos();
    Alunos[] alunos=new Alunos[10];
    Scanner sc=new Scanner(System.in);
    public CadastroEstudantes(Alunos aluno){

    }

    public void iniciaVetor(){
        Random random=new Random();
        int posicao=random.nextInt(3);
        alunos[posicao]=new Alunos("João",23,"12345678910","051123456789",
                "Engenharia de Software",2,3);
        alunos[posicao].IniciaDisciplinas();

        int posicao2=random.nextInt(3);
        while(posicao2==posicao){
            posicao2=random.nextInt(3);
        }
        alunos[posicao2]=new Alunos("Maria",26,"12345678910","051123456789",
                "Cd Ia",1,4);
        alunos[posicao2].IniciaDisciplinas();

        int posicao3=random.nextInt(3);
        while(posicao3==posicao2||posicao3==posicao){
            posicao3=random.nextInt(3);
        }
        alunos[posicao3]=new Alunos("Ana",21,"12345678910","051123456789",
                "Ciências da computação",1,6);
        alunos[posicao3].IniciaDisciplinas();
    }

    public void menuAdicionaAlunos(){
        int opc;

        do{
            int cont=0;
            for (int i = 0; i < alunos.length; i++){
                if(alunos[i]==null){
                    cont++;
                }
            }
            System.out.println("\f");
            System.out.println("--------------------------------------");
            System.out.println("Ainda restam "+cont+" vagas na turma");
            System.out.println("--------------------------------------\n");
            System.out.println("Digite 1 para adicionar um novo aluno");
            System.out.println("Digite 2 para voltar ao Menu principal");

            opc = sc.nextInt();
            sc.nextLine();

            switch(opc){
                case 1: adicionaAlunos();
                    break;

                case 2: System.out.println("Voltando...");
                    break;

                default:System.out.println("Digite uma opção válida");

            }
        }while(opc!=2);

    }

    public void adicionaAlunos() {
        boolean lotado=true;
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] == null) {
                lotado=false;
                String nome, cpf, telefone, curso;
                int idade, codCurso, numDisciplinas;

                System.out.println();
                System.out.println("Digite o nome do " + (i + 1) + " aluno");
                nome = sc.nextLine();

                System.out.println();
                System.out.println("Digite a idade do " + (i + 1) + " aluno");
                idade = sc.nextInt();
                sc.nextLine();

                do{
                    System.out.println();
                    System.out.println("Digite o CPF do " + (i + 1) + " aluno");
                    cpf = sc.nextLine();

                    if((cpf.length()!=11)){
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("O CPF precisa conter 11 dígitos");
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("Digite o CPF novamente do " + (i + 1) + " aluno");

                        cpf = sc.nextLine();}
                }while(cpf.length()!=11);
                do {
                    System.out.println();
                    System.out.println("Digite o telefone do " + (i + 1) + " aluno");
                    telefone = sc.nextLine();
                    if((telefone.length() != 12)){
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("O telefone precisa conter 12 dígitos, 3 do DDD e 9 do número");
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("Digite o telefone novamente do " + (i + 1) + " aluno");
                        telefone = sc.nextLine();}
                }while (telefone.length() != 12);
                System.out.println();
                System.out.println("Digite o curso do " + (i + 1) + " aluno");
                curso = sc.nextLine();

                do {
                    System.out.println();
                    System.out.println("Digite o código do curso do " + (i + 1) + " aluno");
                    System.out.println("1 - Extensão");
                    System.out.println("2 - Graduação tecnológica");
                    System.out.println("3 - Especialização");
                    codCurso = sc.nextInt();
                    if (codCurso < 1 || codCurso > 3) {
                        System.out.println("XXXXXXXXXXXXXXX");
                        System.out.println("Código inválido");
                        System.out.println("XXXXXXXXXXXXXXX\n");
                    }
                } while (codCurso < 1 || codCurso > 3);

                do {
                    System.out.println();
                    System.out.println("Digite o número de disciplinas do " + (i + 1) + " aluno");
                    System.out.println("No mínimo 2 e no máximo 6");
                    numDisciplinas = sc.nextInt();
                    sc.nextLine();
                    if (numDisciplinas <2||numDisciplinas >6) {
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("Número de disciplinas inválido. Deve ser um valor positivo.");
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                    }

                } while (numDisciplinas <2||numDisciplinas >6);
                Alunos aluno = new Alunos(nome, idade, cpf, telefone, curso, codCurso, numDisciplinas);
                alunos[i] = aluno;
                aluno.addDisciplinas();
                System.out.println("Aluno adicionado com sucesso.\n");

                break;
            }
        }
        if(lotado){
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("A sala está lotada remova algum aluno para poder adicionar outro!");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
        }
    }

    public void removerAluno() {
        Scanner sc = new Scanner(System.in);
        int opc=0;
        int opcAux=0;
        do{
            boolean Encontrado=false;

            if(!salaVazia()){
                System.out.println("\f");
                System.out.println("Digite o nome do aluno a ser removido:");
                for (int i=0;i<alunos.length;i++){
                    if(alunos[i]!=null){
                        System.out.println(alunos[i].getNome());

                    }
                }
                String nomeAluno = sc.nextLine();

                for (int i = 0; i < alunos.length; i++) {
                    if (alunos[i] != null &&alunos[i].getNome().equalsIgnoreCase(nomeAluno)) {
                        alunos[i]=null;
                        System.out.println("Aluno removido com sucesso.\n");
                        Encontrado = true;
                    }
                }
                if(Encontrado==false){
                    System.out.println("XXXXXXXXXXXXXXXXXXXX");
                    System.out.println("Aluno não encontrado.");
                    System.out.println("XXXXXXXXXXXXXXXXXXXX\n");
                    Encontrado=false;
                }

                do{
                    System.out.println("Deseja remover mais algum aluno?");
                    System.out.println("1-Sim");
                    System.out.println("2-Não");
                    System.out.println("3-Remover todos Alunos");
                    opc=sc.nextInt();
                    sc.nextLine();
                    if(opc==3){
                        removeTodosAlunos();

                    }
                }while(opc<0||opc>3);

            }

        }while(opc==1);
    }

    public void removeTodosAlunos(){
        for (int i=0;i<alunos.length;i++){
            if(alunos[i]!=null){
                alunos[i]=null;


            }

        }
        System.out.println();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Todos alunos foram removidos da sala");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        sair();
    }

    public void listaAlunos(){
        if(!salaVazia()){
            System.out.println("\f");
            for(int i=0;i<alunos.length;i++){
                if (alunos[i]!=null){
                    System.out.println("Aluno "+(i+1)+":");
                    System.out.println(alunos[i]);
                    System.out.println();
                }
            }
            sair();
        }

    }

    public void listaAlfabeto() {
        int cont = 0;



        if (!salaVazia()) {

            for (int i = 0; i < alunos.length; i++) {
                if (alunos[i] != null) {
                    cont++;
                }
            }

            String[] listaAlfabeto = new String[cont];
            int posicao = 0;

            for (int i = 0; i < alunos.length; i++) {
                if (alunos[i] != null) {
                    listaAlfabeto[posicao] = alunos[i].getNome().toUpperCase()+" - "+alunos[i].getCurso();
                    posicao++;
                }
            }

            Arrays.sort(listaAlfabeto);

            System.out.println("\f");
            System.out.println("Lista de Alunos em Ordem Alfabética:");
            System.out.println("");
            for (int i = 0; i < cont; i++) {

                System.out.println(listaAlfabeto[i]);
                System.out.println("");
            }
            sair();
        }

    }

    public void mediaIdade(){
        double soma =0;
        double cont=0;
        double media;

        if(!salaVazia()){
            for(int i=0;i<alunos.length;i++){
                if(alunos[i]!=null){
                    soma+=alunos[i].getIdade();
                    cont++;

                }
            }

            media=soma/cont;
            System.out.println("\f");
            System.out.printf("A média de idade dos alunos é: %.1f anos\n",media);
            System.out.println();
            sair();
        }

    }

    public void AlunosVogais() {
        int MaisVogais = 0;
        int posicao = 0;
        String[] AlunosVogais = new String[alunos.length];
        if(!salaVazia()){
            for (int i = 0; i < alunos.length; i++) {
                int cont = 0;

                if (alunos[i] != null) {
                    String nome = alunos[i].getNome().toLowerCase();

                    for (int b = 0; b < nome.length(); b++) {
                        char caractere = nome.charAt(b);

                        if(caractere=='a'||caractere=='e'||caractere=='i'||caractere =='o'||caractere=='u') {
                            cont++;}
                        else if(caractere=='á'||caractere=='é'||caractere=='í'||caractere=='ó'||caractere == 'ú'){
                            cont++;}
                        else if(caractere=='ã'||caractere=='ẽ'||caractere=='ĩ'||caractere =='õ'||caractere=='ũ'){
                            cont++; }

                        if (cont > MaisVogais) {
                            MaisVogais = cont;
                            posicao = 0;
                            AlunosVogais[posicao] = alunos[i].getNome();
                            posicao++;
                        } else if (cont == MaisVogais) {
                            AlunosVogais[posicao] = alunos[i].getNome();
                            posicao++;
                        }
                    }
                }

            }
            System.out.println("\f");
            System.out.println("Aluno(s) com o maior número de vogais no nome (" + MaisVogais + " vogais):");
            System.out.println();
            for (int c = 0; c < posicao; c++) {
                System.out.println(AlunosVogais[c]);
                System.out.println();
            }
            System.out.println();
            sair();
        }
    }

    public void porcentagemCurso(){
        double cont=0;
        double porcentagem1 =0;
        double porcentagem2 =0;
        double porcentagem3 =0;
        double cod1=0;
        double cod2=0;
        double cod3=0;
        double media;
        if(!salaVazia()){
            for(int i=0;i<alunos.length;i++){
                if(alunos[i]!=null){
                    cont++;
                    if(alunos[i].getCodCurso()==1){
                        cod1++;
                    }
                    else if(alunos[i].getCodCurso()==2){
                        cod2++;
                    }
                    else if(alunos[i].getCodCurso()==3){
                        cod3++;
                    }

                }
            }
            porcentagem1=(cod1*100)/cont;
            porcentagem2=(cod2*100)/cont;
            porcentagem3=(cod3*100)/cont;
            System.out.println("\f");
            System.out.printf("Porcentagem de estudantes nos seguintes cursos:\n"+
                            "1 - extensão: %.2f%%\n"+
                            "2 - graduação tecnológica: %.2f%%\n"+
                            "3 - especialização: %.2f%%\n",porcentagem1,
                    porcentagem2,porcentagem3);
            System.out.println();
            sair();
        }
    }

    public boolean salaVazia(){
        int cont=0;
        for(int i=0;i<alunos.length;i++){
            if(alunos[i]==null){
                cont++;
            }
        }
        if(cont==alunos.length ){
            System.out.println("\f");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("A sala está vazia  adicione novos alunos na sala");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
            sair();
            return true;

        }
        else{
            return false;
        }
    }
    public void sair(){
        int opc=0;
        while(opc!=2){
            System.out.println("Digite 2 para voltar ao menu");
            opc=sc.nextInt();
        }
    }
}