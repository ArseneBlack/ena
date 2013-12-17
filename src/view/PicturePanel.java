package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PicturePanel extends JPanel {
	private BufferedImage image;

	public PicturePanel(String imagePath) {
		try {
			image = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = this.getHeight();
		int width = this.getWidth();
		int imageHeight = height * 9 / 16;
		g.drawImage(image, 0, (height - imageHeight) / 2, width, 450 * 9 / 16,
				null);
	}
}
