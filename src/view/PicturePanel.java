package view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
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
		int height = getHeight();
		int width = getWidth();
		int imageHeight = height * 9 / 16;
		int imagePosY = (height - imageHeight) / 2;
		g.drawImage(image, 0, imagePosY, width, imageHeight,
				null);
	}
	

}
