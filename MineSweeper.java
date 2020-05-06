package mineSweeper;

import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.Text;


public class MineSweeper extends Application {
	
	public static final boolean DEBUG = true;
    private BorderPane window;
    public static final int HEIGHT = 400;
    public static final int WIDTH = 400;
    private int height;
    private int width;
    private int bombs;
    Board gameBoard; 
    @Override
    public void start(Stage primaryStage) {
        //level window
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        Button begin = new Button("Beginner");
        Button inter = new Button("Intermediate");
        Button expert = new Button("Expert");
        Button custom = new Button("Custom");
        TextField heightTf = new TextField();
        TextField widthTf = new TextField();
        TextField bombTf = new TextField();
        pane.add(begin, 0, 1);
        pane.add(inter, 0, 2);
        pane.add(expert, 0, 3);
        pane.add(custom, 0, 4);
        pane.add(new Label("Height"), 1, 0);
        pane.add(new Label("Width"), 3, 0);
        pane.add(new Label("Bombs"), 6, 0);
        pane.add(new Label ("9"), 1, 1);
        pane.add(new Label("9"), 3, 1);
        pane.add(new Label("10"), 6, 1);
        pane.add(new Label("16"), 1, 2);
        pane.add(new Label("16"), 3, 2);
        pane.add(new Label("16"), 6, 2);
        pane.add(new Label("16"), 1, 3);
        pane.add(new Label("30"), 3, 3);
        pane.add(new Label("99"), 6, 3);
        pane.add(heightTf, 1, 4);
        pane.add(widthTf, 3, 4);
        pane.add(bombTf, 6, 4);
        

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Game Settings");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        /////////Game Board///////////
        /**
        window = new BorderPane();
        window.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(0,50,0,0));

        Text title = new Text("Minesweeper");
        title.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 30));
        title.setFill(Color.BLACK);
        title.setVisible(true);

        Button reset = new Button("Restart game");
        reset.setOnMouseClicked(e -> resetGrid());
        vBox.getChildren().addAll(title,gameBoard.getGameBoard(),reset);
        window.setBottom(vBox);

        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(window, HEIGHT, WIDTH));
        secondStage.show();
        **/


    ////////Settings Mouse clicked events///////////
    begin.setOnMouseClicked(e -> {
        height = 9;
        width = 9;
        bombs = 10;
        gameBoard = new Board(height,width,bombs);
        
        StartGame();
        
    });
    
    inter.setOnMouseClicked(e -> {
        height = 10;
        width = 16;
        bombs = 16;
        gameBoard = new Board(height,width,bombs);
        
        StartGame();
    });
    expert.setOnMouseClicked(e -> {
        height = 16;
        width = 30;
        bombs = 99;
        gameBoard = new Board(height,width,bombs);
        
        StartGame();
    
    });
    custom.setOnMouseClicked(e -> {
        int custHeight = Integer.parseInt(heightTf.getText());
        height = custHeight;
        int custWidth = Integer.parseInt(widthTf.getText());
        width = custWidth;
        int custBombs = Integer.parseInt(bombTf.getText());
        bombs = custBombs;
        gameBoard = new Board(height,width,bombs);
        
        StartGame();

    });
    
    
    }
    private void StartGame() {
    	
    	window = new BorderPane();
        window.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(0,50,0,0));

        Text title = new Text("Minesweeper");
        title.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, 30));
        title.setFill(Color.BLACK);
        title.setVisible(true);

        Button reset = new Button("Restart game");
        reset.setOnMouseClicked(e -> resetGrid());
        vBox.getChildren().addAll(title,gameBoard.getGameBoard());
        window.setBottom(vBox);

        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(window, HEIGHT, WIDTH));
        secondStage.show();
    }
    
    private Object resetGrid() {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args) {
        launch(args);
    }}
