package app;

import java.util.ArrayList;
import java.util.Timer;

import controller.TotalReceiptController;
import controllers.KeyExitController;
import controllers.ActivityMonitorController;
import controllers.ItemPurchasedControllerScenario2;
import controllers.Reset;
import controllers.ResetBackground;
import controllers.WelcomeClickedController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    public void start(Stage welcomeStage) {
        
		Stage registerStage = new Stage();
        
        BorderPane registerLayout = new BorderPane();
        BorderPane welcomeLayout = new BorderPane();
        
        ImageView welcomeImage = new ImageView(new Image(getClass().getResourceAsStream("/images/welcomeImage.jpg")));
        welcomeLayout.getChildren().add(welcomeImage);
        
        Scene registerScreen = new Scene(registerLayout);
        Scene welcomeScreen = new Scene(welcomeLayout);
        registerStage.setScene(registerScreen);
        welcomeStage.setScene(welcomeScreen);
        
        //registerStage.setFullScreen(true);
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setMaximized(true);
	    registerStage.show();
	    //registerStage.hide();
	    
	    welcomeStage.initStyle(StageStyle.UNDECORATED);
	    welcomeStage.setMaximized(true);
//        welcomeStage.setFullScreen(true);
	    welcomeStage.show();
	    welcomeStage.setAlwaysOnTop(true);
	    
	    
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
        registerLayout.setRight(rv);
        
        ItemPurchaserView ipv = new ItemPurchaserView(allItems, purchasedItems, registerStage);
        for (PurchasableItemView piv:ipv.getPurchasableItems()) {
      		piv.setOnMouseClicked(new ItemPurchasedControllerScenario2(ipv, piv, rv));
        }
        registerLayout.setCenter(ipv);
        rv.getShoppingCart().setOnMouseClicked(new TotalReceiptController(rv, ipv, welcomeStage, registerStage));
        
        welcomeStage.addEventFilter(KeyEvent.KEY_PRESSED, new KeyExitController(welcomeStage, registerStage));
        registerStage.addEventFilter(KeyEvent.KEY_PRESSED, new KeyExitController(registerStage, welcomeStage));
//        ipv.setOnKeyPressed(new KeyExitController(registerStage));
//        welcomeImage.setOnKeyPressed(new KeyExitController(welcomeStage));
        
        ActivityMonitorController amc = new ActivityMonitorController(rv, ipv, welcomeStage, registerStage); 
        
        registerStage.addEventFilter(MouseEvent.MOUSE_MOVED, amc);
        
//        registerLayout.setOnMouseMoved(amc);
//        ipv.setOnMouseMoved(amc);
	    welcomeLayout.setOnMousePressed(new WelcomeClickedController(welcomeStage, registerStage));
        
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
