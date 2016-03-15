import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.TexturePaint;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JSONMap {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new Map();	
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}

class Map extends JPanel {
	//BufferedImage tile;
	//JSONObject jsonObject;
	//JSONObject pathandobjects;
	//JSONArray tilesets;
	//ArrayList layers;
	//ArrayList tilesets;
	//long tileHeight;
	//long tileWidth;
	//int rows;
	//int columns;
	
	//ArrayList<BufferedImage> tiles = new ArrayList<BufferedImage>();
	//BufferedImage tilemap;
	
	public Map() {
		//setPreferredSize( new Dimension(600,600) );
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		
	//	JSONParser parser = new JSONParser();
		//	try {
			//	Object obj = parser.parse(new FileReader("AgendaModule/mapv1.json"));
				//jsonObject = (JSONObject) obj;
				
				//tileHeight = (long)jsonObject.get("tileheight");
				//tileWidth = (long)jsonObject.get("tilewidth");
			//	String orientation = (String) jsonObject.get("orientation");
			//	String renderorder = (String) jsonObject.get("renderorder");
			//	layers = (ArrayList) jsonObject.get("layers");
			//	tilesets = (JSONArray) jsonObject.get("tilesets");
			//	pathandobjects = (JSONObject) tilesets.get(1);
				//System.out.println(jsonObject.get("height"));
				//columns = (int)jsonObject.get("width");
				//rows = (int) jsonObject.get("heigth");
			//} catch (FileNotFoundException e) {
				//e.printStackTrace();
			//} catch (IOException e) {
				//e.printStackTrace();
			//} catch (org.json.simple.parser.ParseException e) {
				//e.printStackTrace();
			//}
			
			//BufferedImage layerImage = new BufferedImage(columns * tileWidth, rows * tileHeight, BufferedImage.TYPE_INT_ARGB);
			//BufferedImage layerImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);	
			//System.out.println(layerImage);
			//g2.drawImage(layerImage, 10, 10, null);
			
			
			//TileMap("AgendaModule/PathAndObjects.png", 32, 32);
				//g2.drawImage(tiles.get(0), 300, 300, null);
				//g2.drawImage(tilemap, 0, 0, null);
	}
	
	public void TileMap(String filepath, int tilewidth, int tileheight) {
		//try {
			//tilemap = ImageIO.read(new File(filepath));
			//System.out.print(pathandobjects.get("firstgid"));
			//for (int y = 0; y < tilemap.getHeight() / 32; y++) {
				//for (int x = 0; x < tilemap.getWidth() / 32; x++){
					//tiles.add(tilemap.getSubimage(1 * tilewidth, 11 * tileheight, tilewidth, tileheight));
		//		}
			//}
	//	} catch (IOException e) {
		//	e.printStackTrace();
		//}
	}
}

	


