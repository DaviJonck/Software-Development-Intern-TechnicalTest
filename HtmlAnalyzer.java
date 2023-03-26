package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Deque;

public class HtmlAnalyzer {

    public static void main(String[] args) throws IOException {
    	
    	// Verifica se foi passado uma URL como argumento
        if (args.length == 0) {
            System.out.println("Por favor, informe a URL a ser analisada.");
            return;
        }
        
        
        //Cria uma instancia da classe URL com base na URL passada como argumento
        String urlStr = args[0];
        URL url = new URL(urlStr);
        
        
        
        // Cria um objeto BufferedReader para ler o conteúdo da URL
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
        	
        	
        	
        	// Cria uma pilha para armazenar as TAGS de abertura
            Deque<String> stack = new ArrayDeque<>();
            String line;
            String deepestText = null;
            int deepestLevel = 0;
              
            
            
            // Lê cada linha do conteúdo da URL | Remove espacos em branco do inicio e do fim da linha.
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                
                
                
                // Verifica se a linha comeca com uma tag HTML
                if (line.startsWith("<")) {
                	
                	
                	// Extrai o nome da tag (sem os sinais "<" e ">")
                    String tag = line.substring(1, line.indexOf('>'));
                    if (tag.endsWith("/")) {
                    	
                    	
                        // Verifica se a tag é de abertura sem fechamento explícito e a ignora
                        continue;
                    }
                    
                    
                 // Verifica se a tag é de abertura
                    if (!tag.startsWith("/")) {       
                        stack.push(tag); // Adiciona tag na  Pilha
                    } else {           
                    	
                    	// Verifica se a tag é de fechamento e se corresponde à última tag de abertura
                        if (!stack.isEmpty() && stack.peek().equals(tag.substring(1))) {
                            stack.pop(); // Remove a última tag de abertura da pilha
                        } else {                        	
                        	
                            // erro de sintaxe, HTML mal-formado
                            System.out.println("malformed HTML");
                            return;
                        }
                    }
                    
                } else {
                    // trecho de texto
                    int level = stack.size();
                  //  Verifica se o nível atual é o mais profundo encontrado até o momento
                    if (level > deepestLevel) {
                        deepestText = line;
                        deepestLevel = level;
                    }
                }
            }
            
            // Exibe o trecho de texto mais profundo encontrado ou mensagem de erro se nenhum trecho foi encontrado
            if (deepestText != null) {
                System.out.println(deepestText);
            } else {        
                System.out.println("No text snippets found in the HTML.");
            }
        } catch (IOException e) {
            System.out.println("URL connection error");
        }
    }
}