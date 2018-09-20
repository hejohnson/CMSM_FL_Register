package app;

import java.util.ArrayList;

import controllers.ItemPurchasedControllerScenario1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
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
        ItemPurchaserView ipv = new ItemPurchaserView(allItems, purchasedItems, primaryStage);
        
        for (PurchasableItemView piv:ipv.getPurchasableItems()) {
        	piv.setOnMouseClicked(new ItemPurchasedControllerScenario1(ipv, piv));
        }
        
        StackPane root = new StackPane();
        
        
        root.getChildren().add(ipv);
        
        
        
        primaryStage.setScene(new Scene(root));
        primaryStage.setFullScreen(true);        
	    primaryStage.show();
    }

}
