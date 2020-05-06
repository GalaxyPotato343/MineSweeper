package mineSweeper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class BombTile extends Tile {
	private ImageView openedImage;
	private ImageView flag;
	private boolean flagged;
	
	
	public BombTile(int x, int y) throws FileNotFoundException {
		super(x,y);
		//System.out.println("Inside Bomb tile class after super");
		flagged = false;
		openedImage = new ImageView(new Image(new FileInputStream("bomb.png")));
		openedImage.setFitHeight(Tile.HEIGHT-15);
		openedImage.setFitWidth(Tile.WIDTH-15);
		
		flag = new ImageView(new Image(new FileInputStream("flag.png")));
		
		flag.setFitHeight(Tile.HEIGHT-15);
		flag.setFitWidth(Tile.WIDTH-15);
		
	}
	
	
	@Override
	protected void onClick(MouseEvent e){
		if (e.getButton() == MouseButton.PRIMARY) {
			open();
		}else {
			flag();
		}
	}
	
	
	
	@Override
	public void open() {
		if(!(super.getOpen()) && !(flagged)) {
			super.setOpen(true);
			super.getButton().setGraphic(openedImage);
			///TODO Add game over
		}
	}
	
	public void flag() {
		super.getButton().setGraphic(flag);
		super.getButton().setDisable(true);
	}
	
	
}
