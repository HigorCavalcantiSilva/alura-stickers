import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String token = "k_odx5puuh";
        String url = "https://imdb-api.com/en/API/Top250Movies/" + token;
        
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        String body = response.body();
        
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        for (Map<String, String> filme : listaDeFilmes) {
        	String urlImagem = filme.get("image");
        	String titulo = filme.get("title");
        	
        	String urlImagemGrande = urlImagem.substring(0, urlImagem.length() - 32) + ".jpg";
        	System.out.println(urlImagemGrande);
        	InputStream inputStream = new URL(urlImagemGrande).openStream();
        	System.out.println(inputStream);
        	String nomeArquivo = titulo;
        	
        	var geradora = new GeradoraDeFigurinhas();
        	geradora.cria(inputStream, nomeArquivo);
		}
        
    }
}
