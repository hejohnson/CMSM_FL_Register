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
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.AllItems;
import model.PurchasedItem;
import model.Receipt;
import views.ItemPurchaserView;
import views.PurchasableItemView;
import views.ReceiptView;
import views.RegisterView;

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
    public void start(Stage stage) {
		
		Font.loadFont(getClass().getResource("/DidactGothic-Regular.ttf").toExternalForm(), 10);
		Font.loadFont(getClass().getResource("/FredokaOne-Regular.ttf").toExternalForm(), 10);
		
        
//		RegisterView registerStage = new RegisterView();
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
//		welcomeStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		AnchorPane registerLayout = new AnchorPane();
        
        ImageView welcomeImage = new ImageView(new Image(getClass().getResourceAsStream("/images/welcomeImage.jpg")));
//        welcomeLayout.getChildren().add(welcomeImage);
        
        RegisterView registerScreen = new RegisterView(registerLayout, 1280, 1024);
        registerScreen.setWelcome(welcomeImage);
        
//        Scene welcomeScreen = new Scene(welcomeLayout, 1280, 1024);
        stage.setScene(registerScreen);
//        welcomeStage.setScene(welcomeScreen);
        
//        dialogStage.initStyle(StageStyle.UNDECORATED);
//        dialogStage.setMaximized(true);
//        dialogStage.show();
        
        //registerStage.setFullScreen(true);
        stage.initStyle(StageStyle.UNDECORATED);
        //registerStage.setMaximized(true);
	    stage.show();
	    stage.setX(0);
	    stage.setY(0);
	    stage.setFullScreen(true);
	    //registerStage.hide();
	    
//	    welcomeStage.initStyle(StageStyle.UNDECORATED);
//	   // welcomeStage.setMaximized(true);
////        welcomeStage.setFullScreen(true);
//	    welcomeStage.show();
//	    welcomeStage.setX(0);
//	    welcomeStage.setY(0);
//	    welcomeStage.setAlwaysOnTop(true);
//	    welcomeStage.setFullScreen(true);
	    
	    
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
	    registerLayout.setBottomAnchor(rv, 30.0);
	    registerLayout.setTopAnchor(rv, 60.0);
        registerLayout.setRightAnchor(rv, 68.0);
        
        ItemPurchaserView ipv = new ItemPurchaserView(allItems, 100, 50);
        for (PurchasableItemView piv:ipv.getPurchasableItems()) {
      		piv.setOnMouseClicked(new ItemPurchasedControllerScenario2(registerScreen, ipv, piv, rv));
        }
        
        //ipv.setOnMouseClicked(new controllers.TabClickController(ipv, 200, 80));
        registerLayout.getChildren().add(ipv);
        registerLayout.setBottomAnchor(ipv, 0.0);
	    registerLayout.setTopAnchor(ipv, 0.0);
        registerLayout.setLeftAnchor(ipv, 0.0);
        registerLayout.setRightAnchor(ipv, 0.0);
        rv.toFront();
        
//        ImageView grid = new ImageView(new Image(getClass().getResourceAsStream("/images/grid.png")));
//        registerLayout.getChildren().add(grid);
//        registerLayout.setBottomAnchor(grid, 0.0);
//	    registerLayout.setTopAnchor(grid, 0.0);
//        registerLayout.setLeftAnchor(grid, 0.0);
//        registerLayout.setRightAnchor(grid, 0.0);
        
        ActivityMonitorController amc = new ActivityMonitorController(rv, ipv, registerScreen); 
        
        rv.getShoppingCart().setOnMouseClicked(new TotalReceiptController(rv, ipv, registerScreen, amc));
        rv.getCartImage().setOnMouseClicked(new TotalReceiptController(rv, ipv, registerScreen, amc));
        
//        registerStage.addEventFilter(KeyEvent.KEY_PRESSED, new KeyExitController(registerStage, welcomeStage));
        
        ArrayList<Rectangle> boxes = new ArrayList<Rectangle>();
        boxes.add(new Rectangle(0,0,250,250));
        boxes.add(new Rectangle(1030,0,250,250));
        boxes.add(new Rectangle(0,775,250,250));
        boxes.add(new Rectangle(1030,775,250,250));
        
        stage.addEventFilter(KeyEvent.KEY_PRESSED, new KeyExitController(stage));
        stage.addEventFilter(MouseEvent.MOUSE_PRESSED, new ApplicationExitController(stage, boxes));
        stage.addEventFilter(MouseEvent.MOUSE_PRESSED, amc);
        
//        registerLayout.setOnMouseMoved(amc);
//        ipv.setOnMouseMoved(amc);
	    welcomeImage.setOnMousePressed(new WelcomeClickedController(registerScreen, amc));
	    registerScreen.showWelcome();
        
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
