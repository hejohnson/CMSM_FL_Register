package app;

import java.util.ArrayList;

import controllers.ItemPurchasedControllerScenario1;
import controllers.ItemPurchasedControllerScenario2;
import controllers.ItemPurchasedControllerScenario3;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.AllItems;
import model.PurchasedItem;
import views.ItemPurchaserView;
import views.PurchasableItemView;

public class Register extends Application{
	
	private static AllItems allItems;
	private ArrayList<PurchasedItem> purchasedItems = new ArrayList<PurchasedItem>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		allItems = new AllItems();
		System.out.println(allItems.toString());
		launch();
		
	}
	
	@Override
    public void start(Stage primaryStage) {
        
        
        BorderPane root = new BorderPane();
        
        primaryStage.setScene(new Scene(root));
        primaryStage.setFullScreen(true);        
	    primaryStage.show();
	    
	    VBox totalTracker = new VBox();
	    BorderPane totalBox = new BorderPane();
	    
	    Text total = new Text("$0");
	    total.setFont(Font.font("Verdana", FontWeight.BOLD, 48));
	    
	    
	    totalTracker.setMinWidth(150);
	    totalTracker.setMaxWidth(150);
	    totalTracker.setPrefWidth(150);
	    
	    totalBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    
	    totalTracker.setAlignment(Pos.BOTTOM_CENTER);
	    
	    totalBox.setCenter(total);
	    totalTracker.getChildren().add(totalBox);
	    
        root.setRight(totalTracker);
	    
	    ItemPurchaserView ipv = new ItemPurchaserView(allItems, purchasedItems, primaryStage);
        for (PurchasableItemView piv:ipv.getPurchasableItems()) {
        	//piv.setOnMouseClicked(new ItemPurchasedControllerScenario1(ipv, piv, total));
        	piv.setOnMouseClicked(new ItemPurchasedControllerScenario2(ipv, piv, total));
        	//piv.setOnMouseClicked(new ItemPurchasedControllerScenario3(ipv, piv, total, totalBox));
        }
        
             
        
        root.setCenter(ipv);
        
        
        
        
        
    }

}
