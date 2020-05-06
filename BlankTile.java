package mineSweeper;

import java.util.ArrayList;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class BlankTile extends Tile{
	//private ArrayList <Tile> neighbors; 
	
	public BlankTile(int x, int y) {
		super(x,y);
		//neighbors = Board.getNeighbors(x,y);
	}
	
	@Override
	protected void onClick(MouseEvent e){
		if (e.getButton() == MouseButton.PRIMARY) {
			open();
			Board.blankOpen(this.getX(),this.getY());
		}
	}

	@Override
	public void open() {
		if (!(super.getOpen())){
			super.setOpen(true);
			super.getButton().setDisable(true);
			
		}
	}
	
	
	//TODO mouse event recursive opening
}
