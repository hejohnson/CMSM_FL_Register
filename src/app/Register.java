package app;

import java.util.ArrayList;

import controllers.TabClickController;
import controllers.KeyExitController;
import controllers.TotalReceiptController;
import controllers.ActivityMonitorController;
import controllers.ApplicationExitController;
import controllers.ItemPurchasedControllerScenario2;
import controllers.WelcomeClickedController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
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
		Stage dialogStage = new Stage();
        
        AnchorPane registerLayout = new AnchorPane();
        BorderPane welcomeLayout = new BorderPane();
        
        ImageView welcomeImage = new ImageView(new Image(getClass().getResourceAsStream("/images/welcomeImage.jpg")));
        welcomeLayout.getChildren().add(welcomeImage);
        
        Scene registerScreen = new Scene(registerLayout);
        Scene welcomeScreen = new Scene(welcomeLayout);
        registerStage.setScene(registerScreen);
        welcomeStage.setScene(welcomeScreen);
        
//        dialogStage.initStyle(StageStyle.UNDECORATED);
//        dialogStage.setMaximized(true);
//        dialogStage.show();
        
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
	    registerLayout.getChildren().add(rv);
	    registerLayout.setBottomAnchor(rv, 80.0);
	    registerLayout.setTopAnchor(rv, 150.0);
        registerLayout.setRightAnchor(rv, 60.0);
        
        ItemPurchaserView ipv = new ItemPurchaserView(allItems, registerStage, 200, 80);
        for (PurchasableItemView piv:ipv.getPurchasableItems()) {
      		piv.setOnMouseClicked(new ItemPurchasedControllerScenario2(ipv, piv, rv));
        }
        
        ipv.setOnMouseClicked(new controllers.TabClickController(ipv, 200, 80));
        registerLayout.getChildren().add(ipv);
        registerLayout.setBottomAnchor(ipv, 0.0);
	    registerLayout.setTopAnchor(ipv, 0.0);
        registerLayout.setLeftAnchor(ipv, 0.0);
        registerLayout.setRightAnchor(ipv, 0.0);
        rv.toFront();
        rv.getShoppingCart().setOnMouseClicked(new TotalReceiptController(rv, ipv, welcomeStage, registerStage));
        
        welcomeStage.addEventFilter(KeyEvent.KEY_PRESSED, new KeyExitController(welcomeStage, registerStage));
        registerStage.addEventFilter(KeyEvent.KEY_PRESSED, new KeyExitController(registerStage, welcomeStage));
        
        ArrayList<Rectangle> boxes = new ArrayList<Rectangle>();
        boxes.add(new Rectangle(0,0,250,250));
        boxes.add(new Rectangle(1030,0,250,250));
        boxes.add(new Rectangle(0,775,250,250));
        boxes.add(new Rectangle(1030,775,250,250));
        
        registerStage.addEventFilter(MouseEvent.MOUSE_PRESSED, new ApplicationExitController(welcomeStage, registerStage, boxes));
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
