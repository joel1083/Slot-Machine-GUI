/**
 * Name: Joel Rivas
 * Date: 6/24/17
 * Purpose: This is an interactive GUI game that revolves around the idea of Casino-like gambling.
 * 
 */

import java.util.Random;
import javafx.application.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExtraCredit extends Application
{
	// Global values ( In-Class ) used for accumulators
	private double m,sum, usernum; 
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage game)
	{
		// 1 Controls
		Image[] pictures = new Image[10];
		
		// Single Button
		Button b1 = new Button("Press To Confirm Your Amount!");
		
		// Pictures in array
		pictures[0] = new Image ("File:Apple.png");
		pictures[1] = new Image ("File:Banana.png");
		pictures[2] = new Image ("File:Cherries.png");
		pictures[3] = new Image ("File:Grapes.png");
		pictures[4] = new Image ("File:Lemon.png");
		pictures[5] = new Image ("File:Lime.png");
		pictures[6] = new Image ("File:Orange.png");
		pictures[7] = new Image ("File:Pear.png");
		pictures[8] = new Image ("File:Strawberry.png");
		pictures[9] = new Image ("File:Watermelon.png");
		
		// Labels - Just text
		Label insertmoney = new Label("Enter wager amount: $");
		Label winnings = new Label("You have Won: $");
		Label currentbet = new Label("Your current bet: $");
		
		// Single TextField - Gets user input
		TextField amount = new TextField();
		
		//ImageViewssssss
		ImageView view1 = new ImageView(pictures[2]); // I like Cherries
		ImageView view2 = new ImageView(pictures[2]);
		ImageView view3 = new ImageView(pictures[2]);
		b1.setOnAction(e -> { 
						// Data Types being declared / initialized
						String money;
						money = "";
						int num1,num2,num3; // used for Random integers
						Random randInt = new Random();
						
						
						// The game asking the user to input their amount
						// Having that amount being added to the accumulator ( sum )
						try
						{
						money = amount.getText();
						m = Double.parseDouble(money);
						currentbet.setText("Current bet: $" + m);
						sum+=m;
						insertmoney.setText("So far you gave the casino: $" + sum);
						}
						catch(NumberFormatException w)
						{
							currentbet.setText("You didn't enter a number!");
							insertmoney.setText("Enter a NUMBER!");
							m=0;
						}
						
						// Generates random integers every button click
						num1 = randInt.nextInt(10);
						view1.setImage(pictures[num1]);
						num2 = randInt.nextInt(10);
						view2.setImage(pictures[num2]);
						num3 = randInt.nextInt(10);
						view3.setImage(pictures[num3]);
						
						// The algorithm to determine how much the user has won
						if (num1 == num2 && num1 == num3 && num2 == num3)
						{
							winnings.setText("[TRIPLE] $" + (m * 3));
							usernum += m;
						}
						else if ( num1 == num2 || num1 == num3 || num2 == num3 )
						{
							winnings.setText("[DOUBLE] $" + (m * 2));
							usernum += m;
						}
						else
							winnings.setText("You have lost your bet.");
						
						// A nice gesture to print how much the user has won / having it be centered
						b1.setTranslateX(21);
						b1.setText("You have won: $" + usernum);
						});
		
		// 2 Layout
		// All the nodes are in their own boxes with completely different (X,Y) coordinates
		HBox d = new HBox(view1,view2,view3);
		HBox d1 = new HBox(currentbet);
		d1.setTranslateX(230);
		d1.setTranslateY(160);
		HBox d2 = new HBox(insertmoney);
		d2.setTranslateX(25);
		d2.setTranslateY(160);
		HBox d3 = new HBox(winnings);
		d3.setTranslateX(230);
		d3.setTranslateY(195);
		VBox v = new VBox(b1);
		v.setTranslateX(106);
		v.setTranslateY(240);
		HBox d4 = new HBox(amount);
		d4.setTranslateX(25);
		d4.setTranslateY(190);
		
		//	Group all the layout containers
		Group root = new Group(d,d1,d2,d3,d4,v);
		
		// 3 Create Scene
		Scene singleFrame = new Scene(root, 384, 300);
		
		// 4 Add Scene to stage
		game.setScene(singleFrame);
		game.setTitle("Every Casino Ever!");
		game.show();
		
	}
}
