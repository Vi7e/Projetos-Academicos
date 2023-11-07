# CADASTRO DE ALUNOS
Projeto acadêmico final da cadeira de fundamentos de programação, as instruções para ser feito foram as seguintes.

Crie uma classe chamada Aluno para representar um/a estudante que faz parte do cadastro
da universidade. Considere que este classe deve armazenar os seguintes dados:
• Nome (String)
• Idade (int positivo)
• Cpf (String, cuidar nao ultrapassar 11 caracteres, sem o traço.
O cpf ao ser digitado deve considerar apenas os números, sem
formatação. A formatação deverá ser feita pelo método
toString). Você deve garantir que quando o usuário cadastrar
este dado ele seja exatamente de tamanho 11.
• Telefone (String, incluindo DDD). O telefone ao ser digitado
deve considerar apenas os números, sem formatação. A
formatação deverá ser feita pelo método toString). Você deve
garantir que quando o usuário cadastrar este dado ele seja
exatamente de tamanho 12 -> 9 dígitos do telefone + 3 do
DDD).
• modalidade do cursos (código numérico):
1 - extensão
2 - graduação tecnológica
3 - especialização
• Nome do curso (String)
• quantidade de disciplinas (numero natural variando de 2 até
máximo 6)
• nome da disciplinas matriculadas (armazenado num vetor de
String)
Nesta classe devem existir métodos que permitam resgatar e ou modificar as informações do
estudante. Deve ter ainda um método chamado toString que retorne um String com um
resumo das informações do estudante.
Atenção para formatação do método toString:
• O cpf deve ser escrito neste formato:
• 123.456.678-99 , ou seja, a cada 3 dígitos colocar um ponto e os dois últimos dígitos
devem ser separados por um traço.
• O telefone deve aparecer desta formato: (051) 99999-8888. OU seja, o DDD entre
2
parênteses, os 5 primeiros dígitos do número separados por um traço dos últimos 4
números.
• O tipo do curso deve ser escrito por extenso e não o seu código.

Crie uma classe chamada CadastroEstudantes para representar o cadastro da universidade.
Considere que este classe deve armazenar objetos do tipo Aluno.
Crie um construtor que cria o cadastro (vetor de objetos) que pode armazenar 10 estudantes.
Crie os seguintes métodos:
1. Adicionar estudante no vetor
2. Remover estudante do vetor, localizando-o pelo nome
3. Escrever todo vetor de alunos com suas informações. Atenção:
   escrever somente as posições ocupadas do vetor
4. Escrever os nomes dos estudantes em ordem alfabética crescente
   e respectivo nome do curso matriculado
5. Media de idade dos alunos cadastrados
6. Escrever qual nome de aluno possui maior número de vogais. Em
   caso haver mais de um, escrever todos os nomes que atendem a
   este quesito
7. Percentagem de estudantes nos seguintes cursos:
   1 - extensão
   2 - graduação tecnológica
   3 - especialização
   Faça uma nova classe aplicação que execute todos os métodos criados na classe
   CadastroEstudantes.
   Ao executar o programa já tem 3 estudantes cadastrados e devidamente colocados no vetor.
   Detalhe: as posições onde estes objetos serão armazenados deve ser sorteado e aleatória. Ou
   seja, ao iniciar o programa a sua aplicação já instância de maneira direta 3 objetos do tipo
   Aluno e os coloca em 3 locais do vetor. Isto fará com que ao cadastrar um novo aluno ele seja
   colocado na primeira posição disponível do vetor.
   Tudo isto com acesso por um menu de opções que permite o usuário escolher a opções mais
   de uma vez sem a necessidade de executar o programa novamente!
   Não se esqueça de colocar uma opção de sair do programa.