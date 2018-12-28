package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import controllers.ItemPurchasedControllerScenario1;
import controllers.ItemPurchasedControllerScenario2;
import controllers.ItemPurchasedControllerScenario3;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
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
import model.Receipt;
import views.ItemPurchaserView;
import views.PurchasableItemView;
import views.ReceiptView;

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
	    
//	    VBox totalTracker = new VBox();
//	    BorderPane totalBox = new BorderPane();
//	    
//	    Text total = new Text("$0");
//	    total.setFont(Font.font("Verdana", FontWeight.BOLD, 48));
//	    
//	    
//	    totalTracker.setMinWidth(150);
//	    totalTracker.setMaxWidth(150);
//	    totalTracker.setPrefWidth(150);
//	    
//	    totalBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
//	    
//	    totalTracker.setAlignment(Pos.BOTTOM_CENTER);
//	    
//	    totalBox.setCenter(total);
//	    totalTracker.getChildren().add(totalBox);
//	    
	    Receipt r = new Receipt();
	    ReceiptView rv = new ReceiptView(r);
        root.setRight(rv);
        
        ItemPurchaserView ipv = new ItemPurchaserView(allItems, purchasedItems, primaryStage);
        for (PurchasableItemView piv:ipv.getPurchasableItems()) {
      		piv.setOnMouseClicked(new ItemPurchasedControllerScenario2(ipv, piv, rv));
        }
        root.setCenter(ipv);
        
//        String [] arrayData = {"Scenario 1", "Scenario 2", "Scenario 3"};
//        List<String> dialogData;
//        
//        dialogData = Arrays.asList(arrayData);
//
//        ChoiceDialog<String> dialog = new ChoiceDialog(dialogData.get(0), dialogData);
//        dialog.setTitle("Select a scenario");
//        dialog.setHeaderText("Select your choice");
//        dialog.initOwner(primaryStage);
//
//        Optional<String> result = dialog.showAndWait();
//        		
//        if (result.isPresent()) {
//
//        	ItemPurchaserView ipv = new ItemPurchaserView(allItems, purchasedItems, primaryStage);
//            for (PurchasableItemView piv:ipv.getPurchasableItems()) {
//            	if (result.get().equals("Scenario 1")) {
//            		piv.setOnMouseClicked(new ItemPurchasedControllerScenario1(ipv, piv, total));
//            	} else if (result.get().equals("Scenario 2")) {
//            		piv.setOnMouseClicked(new ItemPurchasedControllerScenario2(ipv, piv, total));
//            	} else if (result.get().equals("Scenario 3")) {
//            		piv.setOnMouseClicked(new ItemPurchasedControllerScenario3(ipv, piv, total, totalBox));
//            	}
//            }
//            root.setCenter(ipv);
//        }
        
    }

}
