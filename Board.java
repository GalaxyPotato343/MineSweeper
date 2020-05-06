package mineSweeper;

import java.io.FileNotFoundException;
import java.util.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Board {
      
	///Create the height and width of the board according to the game window 
	//This is later used to determine tile size
	public static final int HEIGHT = (int)(MineSweeper.HEIGHT);
	public static final int WIDTH = (int)(MineSweeper.WIDTH);
	private static int rows;
	private static int columns;
	private GridPane gameBoard;
	private static Tile[][] grid;
	private int bombs;
	
	public Board(int r, int c, int bombs) {
		rows = r;
		columns = c;
		this.bombs = bombs;
		gameBoard = new GridPane();
		this.initialize();
		
	}
	
	
	////Initializes and puts everything in the gameboard and grid.
	private void initialize() {
		
		grid = new Tile[rows][columns];
		////Create bombs
		int bombCounter = 0;
		int r;
		int c;
		while (bombCounter<bombs) {
			r = (int)(Math.random() * ((rows)));
			c = (int)(Math.random() * ((columns)));
			if(grid[r][c] == null) {
				try {
					grid[r][c] = new BombTile(r,c);
					bombCounter++;
				}catch (FileNotFoundException ex) {
					System.out.println("File Not found");
					System.exit(0);
				}
			}
		}
		for (int i = 0; i<grid.length; i++) {
			for (int j = 0; j<grid[i].length; j++) {
				
				if (!(grid[i][j] instanceof BombTile)) {
					if(getNeighborBombs(i,j)!= 0) {
						grid[i][j] = new NumTile(i,j,getNeighborBombs(i,j));
					}else {
						grid[i][j] = new BlankTile(i,j);
					}	
				}
				gameBoard.add(grid[i][j].getButton(), i, j);
			}
		}
	}
	
	
	////So to get the actual pane that contains the game the method has to be used after creating a board
	public GridPane getGameBoard() {
		return gameBoard;
	}
	
	
	////Get the number of bombs surrounding a tile at a certain index
	private int getNeighborBombs(int r, int c) {
		int count =0;
		for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            int he = r - 1 + i;
	            int wi = c - 1 + j;
	            if (he>= 0 && wi >= 0 && he<rows && wi<columns) {
	            	if (grid[he][wi] instanceof BombTile) {
	            		count ++;
	            	}
	            }
	        }
	     }
		return count;
	}
	
	
	////For the tile class to get neighbor given their own coordinate location
	 public static ArrayList<Tile> getNeighbors(int x, int y) {
	        ArrayList<Tile> neighbors = new ArrayList<>();
	       
	        //System.out.println("x: " +  x + "y:" + y);
	        for (int i = 0; i < 3; i++) {
		        for (int j = 0; j < 3; j++) {
		            int he = x - 1 + i;
		            int wi = y - 1 + j;
		            if (he>= 0 && wi >= 0 && he<rows && wi<columns) {
		            	neighbors.add(grid[he][wi]);
		            	}
		            }
		        }
	        return neighbors;
	    }
	 
	 public static void blankOpen(int x,int y) {
		 ArrayList<Tile> neighbors = getNeighbors(x,y);
		 for(int i = 0; i<neighbors.size(); i++) {
				Tile t = neighbors.get(i);
				if (t instanceof BlankTile && !(t.getOpen())) {
					t.open();
					blankOpen(t.getX(), t.getY());
				}else if(t instanceof NumTile && !(t.getOpen())){
					t.open();
				}
			}
	 }
	
	 
	 
	 
	 
	public static int getRows() {
		return rows;
	}
	
	public static int getColumns() {
		return columns;
	}

}
