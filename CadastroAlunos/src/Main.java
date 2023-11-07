import java.util.*;

public class Main

{
    public static void main(String args[]){
        Menu();

    }


    public static void print(String a){
        System.out.println(a);
    }

    public static void Menu(){
        Alunos aluno=new Alunos();
        CadastroEstudantes cadastro=new CadastroEstudantes(aluno);
        Scanner sc=new Scanner(System.in);
        int opc;
        cadastro.iniciaVetor();
        do{

            print("\f");
            print("Bem Vindo a nossa sala!");
            print("Digite a opção desejada:");
            print("____________________________");
            print("1. Adicionar alunos na sala");
            print("2. Remover alunos da lista");
            print("3. Listar todos alunos com suas informações");
            print("4. Escrever os nomes dos alunos em ordem alfabética crescente e respectivo nome do curso matriculado");
            print("5. Média de idade dos alunos cadastrados");
            print("6. Escrever qual nome de aluno possui o maior número de vogais");
            print("7. Porcentagem de estudantes em cada modalidade de curso");
            print("8. Para Sair");
            opc=sc.nextInt();
            switch(opc){
                case 1:cadastro.menuAdicionaAlunos();
                    break;

                case 2: cadastro.removerAluno();

                    break;

                case 3: cadastro.listaAlunos();

                    break;

                case 4: cadastro.listaAlfabeto();

                    break;

                case 5: cadastro.mediaIdade();

                    break;

                case 6: cadastro.AlunosVogais();

                    break;

                case 7: cadastro.porcentagemCurso();

                    break;


                case 8: print("Saindo...");

                    break;

                default:
                    System.out.println("\f");
                    print("XXXXXXXXXXXXXXXXXXXXXXX");
                    print("Digite uma opção válida");
                    print("XXXXXXXXXXXXXXXXXXXXXXX\n");

            }
        }while(opc!=8);
    }

}