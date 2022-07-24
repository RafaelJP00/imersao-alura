import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import javax.imageio.ImageIO;

public class GeradorasDeFigurinhas {

	void cria() throws Exception {

		//leitura da imagem
		BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.png.jpg"));

		int width = imagemOriginal.getWidth();
		int height = imagemOriginal.getHeight();
		int novaAltura = height + 200;
		
		BufferedImage novaImagem = new BufferedImage(width, novaAltura, BufferedImage.TRANSLUCENT);
		
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);

		 GeradorasDeFigurinhas geradora = new GeradorasDeFigurinhas();
		Map<String, String>[] listaDeFilmes;

		//exibir e manipular os dados
		for (Map<String, String> filme : listaDeFilmes) {
			String urlImagem = filme.get("image");
			String titulo = filme.get("title");
			
			InputStream inputStream = new URL(urlImagem).openStream();
			String nomeArquivo = titulo + ".png";
			
			geradora.cria(inputStream, nomeArquivo);
			
			System.out.println(filme.get("title"));
				 }
		
		ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
	}
	
	public static void main(String[] args) throws Exception {
		GeradorasDeFigurinhas geradora = new GeradorasDeFigurinhas();
		geradora.cria();
	}
}