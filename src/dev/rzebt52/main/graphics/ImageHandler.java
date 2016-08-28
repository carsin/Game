package dev.rzebt52.main.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHandler {

	public static BufferedImage loadImage(String path) {
		
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			System.err.println("Image " + path + " could not be loaded");
		}
		
		return null;
		
	}
	
}
