import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;



public class App {
    public static void main(String[] args) throws Exception {   
        // Fazer uma conexão HTTP e buscar os TOP 250 filmes
      String url = "https://alura-filmes.herokuapp.com/conteudos";
      URI endereco = URI.create(url);
      var client = HttpClient.newHttpClient();
      var request = HttpRequest.newBuilder(endereco).GET().build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      String body = response.body();

      // Extrair só os dados que interresam (titulo, poster e classificação)
       var parser = new JsonParser();
      List<Map<String, String>> listaDeFilmes = parser.parse(body);

      //Extrair e manipular os dados
      for (Map<String,String> filme : listaDeFilmes) {
      System.out.println( "\u001b[35;1m\u001b[45;1mTitulo:\u001b[m" + filme.get( "title")) ;
      System.out.println("\u001b[33;1m\u001b[43;1mNota:\u001b[m" + filme.get( "imDbRating"));
      System.out.println("\u001b[37;1m\u001b[44;1mAno do filme:\u001b[m" + filme.get( "year"));
      System.out.println("\u001b[32;1m\u001b[42;1mPoster do filme:\u001b[m" + filme.get( "image"));;
      System.out.println();
        
      
    
      
    

        
    
      

      
      

     
     

      

      }

    }
}

