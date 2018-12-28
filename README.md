<p> 
  
 # Teste Mutantes - Mercado Livre

Apresentação:
O exercício a seguir consiste em uma API REST que poderá consultar e verificar se é DNA mutante ou humano.
Também poderá analisar a quantidade de mutantes e a proporção de de humanos e mutantes analisados pela API.

 ## 	APIS
 
 ### Análise do DNA:

Acessar o endpoint http://localhost:8000/swagger-ui.html#/Teste_-_Mercado_Livre e acessar o método Analise Mutante - Mercado Livre no exemplo a seguir:

POST → / mutant /
{
"Dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}

Se o DNA mutante for verificado, será obtido um 200-OK. Caso contrário, se for humano, obteremos um 403-FORBIDDEN.

Esclarecimentos: as correntes enviadas devem ser compostas somente pelas bases nitrogenadas A, C, G ou T. O número de bases por cadeia deve ser igual para todos e igual ao número de correntes enviadas.

Se a mesma sequência de DNA for enviada mais de uma vez, ela será pisada no banco de dados, não gravada em duplicata. Portanto, se for a única seqüência que entra no sistema, a razão ou os contadores serão modificados.
 
 
 ### Estatísticas:

Acessar o endpoint http://localhost:8000/swagger-ui.html#/Teste_-_Mercado_Livre e acessar o método Estatisticas DNA - Mercado Livre

Irá retornar o seguinte JSON:

{"count_mutant_dna": 2, "count_human_dna": 3, "ratio": 0,0}

## Tecnologias - Backend

O projeto foi construído com JAVA 8.
O Maven foi utilizado para o gerenciamento de dependências e atividades de instalação, construção e empacotamento.
A tecnologia usada para criar a API Rest foi o SpringBoot
O banco de dados é um banco cloud da Amazon DynamoDB que é consumida por meio da API da AWS para JAVA.
O JUnit e Mockito foram utilizados para os testes.

Para rodar a aplicação de forma local executar o comando Maven install no diretório do projeto, após criar o jar, executar o comando Java -jar mutants-0.0.1-SNAPSHOT.jar 

Solicitar as chaves da AWS para conectividade do DynamoDB. Contato:lucas.nascimento.scr@hotmail.com

Essas credenciais são necessárias para comunicação com o banco de dados do DynamoDB. Eles devem ser incorporados nas variáveis
do ambiente Windows / Linux, para que o JAVA AWS SDK possa gravar / ler a partir da base. Também é possível usar as credenciais definindo  as Propriedades do Sistema JAVA ou colocando o arquivo de credenciais no usuário local / .aw

**Desenvolvimento

Desenvolvido by lucasnscr
