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
		System.out.println(allItems.getWelcomeImage());
		launch();
		
	}
	
	@Override
    public void start(Stage stage) {
		
		Font.loadFont(getClass().getResource("/core/DidactGothic-Regular.ttf").toExternalForm(), 10);
		Font.loadFont(getClass().getResource("/core/FredokaOne-Regular.ttf").toExternalForm(), 10);
		
		AnchorPane registerLayout = new AnchorPane();
        
        ImageView welcomeImage = new ImageView(new Image(getClass().getResourceAsStream(this.allItems.getWelcomeImage())));

        
        RegisterView registerScreen = new RegisterView(registerLayout, 1280, 1024);
        registerScreen.setWelcome(welcomeImage);
        
        stage.setScene(registerScreen);
        stage.initStyle(StageStyle.UNDECORATED);
	    stage.show();
	    stage.setX(0);
	    stage.setY(0);
	    stage.setFullScreen(true);
	    stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
	    
	    Receipt r = new Receipt();
	    ReceiptView rv = new ReceiptView(r);
	    registerLayout.getChildren().add(rv);
	    registerLayout.setBottomAnchor(rv, 20.0);
	    registerLayout.setTopAnchor(rv, 66.0);
        registerLayout.setRightAnchor(rv, 68.0);
        
        ItemPurchaserView ipv = new ItemPurchaserView(allItems, 116, 78);
        for (PurchasableItemView piv:ipv.getPurchasableItems()) {
      		piv.setOnMouseClicked(new ItemPurchasedControllerScenario2(registerScreen, piv, rv));
        }
        
        registerLayout.getChildren().add(ipv);
        registerLayout.setBottomAnchor(ipv, 0.0);
	    registerLayout.setTopAnchor(ipv, 0.0);
        registerLayout.setLeftAnchor(ipv, 0.0);
        registerLayout.setRightAnchor(ipv, 0.0);
        rv.toFront();
        
        ActivityMonitorController amc = new ActivityMonitorController(rv, ipv, registerScreen); 
        
        rv.getShoppingCart().setOnMouseClicked(new TotalReceiptController(rv, ipv, registerScreen, amc));
        rv.getCartImage().setOnMouseClicked(new TotalReceiptController(rv, ipv, registerScreen, amc));
        
        ArrayList<Rectangle> boxes = new ArrayList<Rectangle>();
        boxes.add(new Rectangle(0,0,250,250));
        boxes.add(new Rectangle(1030,0,250,250));
        boxes.add(new Rectangle(0,775,250,250));
        boxes.add(new Rectangle(1030,775,250,250));
        
        stage.addEventFilter(KeyEvent.KEY_PRESSED, new KeyExitController(stage));
        stage.addEventFilter(MouseEvent.MOUSE_PRESSED, new ApplicationExitController(stage, boxes));
        stage.addEventFilter(MouseEvent.MOUSE_PRESSED, amc);

	    welcomeImage.setOnMousePressed(new WelcomeClickedController(registerScreen, amc));
	    registerScreen.showWelcome();
        
    }

}
