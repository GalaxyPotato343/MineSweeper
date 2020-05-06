package mineSweeper;
import javafx.util.*;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public abstract class Tile{
	public static final int HEIGHT = Board.HEIGHT / Board.getRows();
	public static final int WIDTH = Board.WIDTH / Board.getColumns();
	private ToggleButton btn;
	private boolean open;
	private int x, y;
	
	
	public Tile(int x,int y) {
		//System.out.println("Inside tile constructor");
		this.btn = new ToggleButton();
		open = false;
		
		this.x = x;
		this.y = y;
		btn.setPrefSize(HEIGHT, WIDTH);
		btn.setMaxHeight(40);
		btn.setMaxWidth(40);
		
		btn.setOnMouseClicked(e -> {
			onClick(e);
		});
		
		
		
	}
	
	protected abstract void onClick(MouseEvent e);
	
	public abstract void open();
	
	public boolean getOpen() {
		return this.open;
	}
	
	public ToggleButton getButton() {
		return btn;
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
