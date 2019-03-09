import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class View extends JPanel {
	BufferedImage[] pics;
	int picNum = 0;
	final int numPics = 8;
	final int frameWidth = 500;
    final int frameHeight = 300;
    final int imgWidth = 165;
    final int imgHeight = 165;
    final int frameCount = 10;
    final static Direction[] directions = {Direction.SOUTHEAST, Direction.SOUTHWEST, Direction.NORTHEAST, Direction.NORTHWEST, Direction.NORTH, Direction.WEST, Direction.SOUTH, Direction.EAST};
    int picSet = 0;
    JFrame frame;
    int xPos;
    int yPos;
/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
	public int getWidth() {
		return frameWidth;
	}
	
	public int getHeight() {
		return frameHeight;
	}
	
	public int getImageWidth() {
		return imgWidth;
	}
	
	public int getImageHeight() {
		return imgHeight;
	}
	
	public void update(int newX, int newY, Direction newDirect) {
		switch(newDirect) {
		case SOUTHEAST:
			picSet = 0;
			break;
		case SOUTHWEST:
			picSet = 1;
			break;
		case NORTHEAST:
			picSet = 2;
			break;
		case NORTHWEST:
			picSet = 3;
			break;
		case NORTH:
			picSet = 4;
			break;
		case WEST:
			picSet = 5;
			break;
		case SOUTH:
			picSet = 6;
			break;
		case EAST:
			picSet = 7;
			break;
		}
		xPos = newX;
		yPos = newY;
		picNum = ((picNum + 1) % frameCount) + (picSet * 10);
		frame.repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public View(){
		frame = new JFrame();
    	frame.getContentPane().add(new Animation());
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    } 
	class Animation extends JPanel {
		public Animation(){
	    	pics = new BufferedImage[80];
	    	BufferedImage img;
	    	for (int i = 0; i < numPics; i++) {
	    		img = myCreateImage("images/orc/orc_forward_" + directions[i].getName() + ".png");
		    	for(int j = 0; j < frameCount; j++) {
		    		pics[i*10 + j] = img.getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
		    	}
	    	}
	    }  
		private BufferedImage myCreateImage(String path){
	    	BufferedImage bufferedImage;
	    	try {
	    		bufferedImage = ImageIO.read(new File(path));
	    		return bufferedImage;
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return null;
		}
		public void paint(Graphics g) {
	    	g.drawImage(pics[picNum], xPos, yPos, Color.gray, this);
		}
    
	}
	
	
}