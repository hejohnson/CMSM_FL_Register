package app;

import java.util.ArrayList;

import controllers.ItemPurchasedControllerScenario1;
import controllers.ItemPurchasedControllerScenario2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
	    
	    Text total = new Text("$0");
	    total.setFont(Font.font("Verdana", FontWeight.BOLD, 48));
        root.setRight(total);
	    
	    ItemPurchaserView ipv = new ItemPurchaserView(allItems, purchasedItems, primaryStage);
        for (PurchasableItemView piv:ipv.getPurchasableItems()) {
        	//piv.setOnMouseClicked(new ItemPurchasedControllerScenario1(ipv, piv, total));
        	piv.setOnMouseClicked(new ItemPurchasedControllerScenario2(ipv, piv, total));
        }
        
             
        
        root.setCenter(ipv);
        
        
        
        
        
    }

}
