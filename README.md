# HtmlAnalyzer TechnicalTest Software Developer Intern PT-BR

Este programa analisa uma página HTML e encontra o trecho de texto mais profundo da estrutura de tags. Ele utiliza a classe URL e as classes relacionadas à manipulação de streams de entrada do Java para abrir uma conexão com a página web, ler o conteúdo HTML e identificar o trecho de texto mais profundo.

## Como usar 
Este programa deve ser executado através da linha de comando, com um argumento que corresponde à URL da página HTML a ser analisada. Por exemplo:

~~~java
java HtmlAnalyzer.java http://www.example.com 
~~~

## Como funciona 
O programa começa verificando se um argumento foi passado na linha de comando. Caso contrário, ele exibe uma mensagem de erro e encerra. Em seguida, ele cria uma instância da classe URL com a URL fornecida como argumento.

O programa então abre uma conexão com a página web e cria um BufferedReader para ler o conteúdo HTML da página. Ele usa uma Deque para manter o controle da estrutura de tags HTML conforme elas são lidas do stream de entrada.

Para cada linha do stream de entrada, o programa verifica se a linha é vazia ou começa com uma tag HTML. Se a linha for vazia, o programa a ignora. Se a linha começar com uma tag HTML, o programa verifica se é uma tag de abertura ou fechamento. Se for uma tag de abertura, o programa adiciona a tag à pilha. Se for uma tag de fechamento, o programa verifica se a tag é correspondente à última tag adicionada à pilha. Se não for correspondente, o programa exibe uma mensagem de erro e encerra. Se a tag for correspondente, o programa remove a última tag adicionada da pilha.

Se a linha não começar com uma tag HTML, o programa assume que é um trecho de texto e verifica o nível da pilha de tags para determinar a profundidade do trecho de texto. O programa armazena o trecho de texto mais profundo encontrado até o momento, junto com o nível da pilha de tags correspondente.

Após ler todo o conteúdo HTML da página, o programa exibe o trecho de texto mais profundo encontrado. Se nenhum trecho de texto for encontrado, o programa exibe uma mensagem de erro.

## Limitações 
Este programa só é capaz de analisar páginas HTML válidas e bem formadas. Se a página contiver erros de sintaxe ou tags mal formadas, o programa pode exibir mensagens de erro ou não funcionar corretamente. Além disso, o programa só é capaz de analisar o conteúdo HTML da página e não pode processar JavaScript ou outros tipos de conteúdo dinâmico.


<sub>Autor: Davi Faustino Jonck </sub>
<sub>Última atualização: 03/26/2023</sub>



============================================================================================



# HtmlAnalyzer TechnicalTest Software Developer Intern ENG

This program parses an HTML page and finds the deepest piece of text in the tag structure. It uses a URL class and related classes for handling Java input streams to open a connection to the web page, read the HTML content, and identify the deepest piece of text.

## How to use
This program must be run through the command line, with an argument that corresponds to the URL of the HTML page to be followed. For example:

~~~java
java HtmlAnalyzer.java http://www.example.com
~~~

## How it works
The program starts by checking whether an argument was passed on the command line. Otherwise, it displays an error message and crashes. It then creates an instance of the URL class with an available URL as an argument.

The program then opens a connection to the web page and creates a BufferedReader to read the HTML content of the page. It uses a Deque to keep track of the structure of HTML tags as they are read from the input stream.

For each line of the input stream, the program checks whether the line is empty or starts with an HTML tag. If the line is empty, the program ignores it. If the line starts with an HTML tag, the program checks whether it is an opening or closing tag. If it is an opening tag, the program adds a tag to the stack. If it is a closing tag, the program checks whether the tag matches the last tag added to the stack. If it does not match, the program displays an error message and crashes. If the tag matches, the program removes the last added tag from the stack.

If the line does not start with an HTML tag, the program assumes it is a text snippet and checks the tag stack level to determine the depth of the text snippet. The program stores the deepest text snippet found so far, along with the corresponding tag stack level.

After reading all the HTML content on the page, the program displays the deepest text snippet found. If no text snippet is found, the program displays an error message.

## Limitations
This program is only capable of parsing valid, well-formed HTML pages. If the page contains syntax errors or malformed tags, the program may display error messages or not function correctly. Furthermore, the program is only capable of parsing the HTML content of the page and cannot process JavaScript or other types of dynamic content.
