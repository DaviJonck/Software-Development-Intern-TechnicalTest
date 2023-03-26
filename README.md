# HtmlAnalyzer TechnicalTest-Axur

Este programa analisa uma página HTML e encontra o trecho de texto mais profundo da estrutura de tags. Ele utiliza a classe URL e as classes relacionadas à manipulação de streams de entrada do Java para abrir uma conexão com a página web, ler o conteúdo HTML e identificar o trecho de texto mais profundo.

###### Como usar
Este programa deve ser executado através da linha de comando, com um argumento que corresponde à URL da página HTML a ser analisada. Por exemplo:

ˋjava HtmlAnalyzer.java http://www.example.comˋ

###### Como funciona
O programa começa verificando se um argumento foi passado na linha de comando. Caso contrário, ele exibe uma mensagem de erro e encerra. Em seguida, ele cria uma instância da classe URL com a URL fornecida como argumento.

O programa então abre uma conexão com a página web e cria um BufferedReader para ler o conteúdo HTML da página. Ele usa uma Deque para manter o controle da estrutura de tags HTML conforme elas são lidas do stream de entrada.

Para cada linha do stream de entrada, o programa verifica se a linha é vazia ou começa com uma tag HTML. Se a linha for vazia, o programa a ignora. Se a linha começar com uma tag HTML, o programa verifica se é uma tag de abertura ou fechamento. Se for uma tag de abertura, o programa adiciona a tag à pilha. Se for uma tag de fechamento, o programa verifica se a tag é correspondente à última tag adicionada à pilha. Se não for correspondente, o programa exibe uma mensagem de erro e encerra. Se a tag for correspondente, o programa remove a última tag adicionada da pilha.

Se a linha não começar com uma tag HTML, o programa assume que é um trecho de texto e verifica o nível da pilha de tags para determinar a profundidade do trecho de texto. O programa armazena o trecho de texto mais profundo encontrado até o momento, junto com o nível da pilha de tags correspondente.

Após ler todo o conteúdo HTML da página, o programa exibe o trecho de texto mais profundo encontrado. Se nenhum trecho de texto for encontrado, o programa exibe uma mensagem de erro.

###### Limitações
Este programa só é capaz de analisar páginas HTML válidas e bem formadas. Se a página contiver erros de sintaxe ou tags mal formadas, o programa pode exibir mensagens de erro ou não funcionar corretamente. Além disso, o programa só é capaz de analisar o conteúdo HTML da página e não pode processar JavaScript ou outros tipos de conteúdo dinâmico.

<sub>Autor: Davi Faustino Jonck
Última atualização: 03/26/2023</sub>
