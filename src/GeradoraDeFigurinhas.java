import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.setColor(Color.YELLOW);
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setFont(fonte);
		
		graphics.drawString("TOPZERA", 0, novaAltura - 100);
		
		ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
		
	}	
}
