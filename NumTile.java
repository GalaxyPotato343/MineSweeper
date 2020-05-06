package mineSweeper;

import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class NumTile extends Tile{
	
	///TODO set color after maybe in board with list see github
	private ImageView openedImage;
	private int numBombs;
	private static final Color[] COLORS = new Color[] {null,Color.BLUE,Color.GREEN, Color.RED, Color.NAVY};

	public NumTile (int x, int y, int numBombs) {
		super(x,y);
		this.numBombs = numBombs;
		
		
		
	}


	@Override
	protected void onClick(MouseEvent e) {
		if (e.getButton() == MouseButton.PRIMARY) {
			open();
		}
		
	}
	
	@Override
	public void open() {
		if (!(super.getOpen())){
			super.setOpen(true);
			super.getButton().setText(Integer.toString(numBombs));
			super.getButton().setDisable(true);
			
			if(numBombs <= 4) {
				super.getButton().setTextFill(COLORS[numBombs]);
			}else {
				super.getButton().setTextFill(COLORS[4]);
			}
			
		}
		
	}
	
	
}
