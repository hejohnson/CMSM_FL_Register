package app;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import controllers.TabClickController;
import controllers.KeyExitController;
import controllers.ReturnToRegisterController;
import controllers.TotalReceiptController;
import controllers.ActivityMonitorController;
import controllers.ApplicationExitController;
import controllers.ItemPurchasedControllerScenario2;
import controllers.WelcomeClickedController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
		
		Font.loadFont("file:"+new File("./resources/core/DidactGothic-Regular.ttf").getAbsolutePath(), 10);
		Font.loadFont("file:"+new File("./resources/core/FredokaOne-Regular.ttf").getAbsolutePath(), 10);
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		
		AnchorPane registerLayout = new AnchorPane();
		
//		File fi = new File(this.allItems.getWelcomeImage());
//		String f = fi.getAbsolutePath();
//		System.out.println(f);
//		System.out.println(fi.exists());
//		System.out.println(getClass().getResource("/core/haveANiceDay.png").toExternalForm());
        
        ImageView welcomeImage = new ImageView(new Image("file:"+new File(this.allItems.getWelcomeImage()).getAbsolutePath()));
        
        AnchorPane haveNiceDay = new AnchorPane();
        ImageView haveNDImage = new ImageView(new Image("file:"+new File("resources/core/haveANiceDay.png").getAbsolutePath()));
        ImageView haveNDBack = new ImageView(new Image("file:"+new File("resources/core/backCart.png").getAbsolutePath()));
        
        VBox haveNDBackContainer = new VBox();
        haveNDBackContainer.getChildren().add(haveNDBack);
        haveNDBackContainer.setAlignment(Pos.CENTER);
        haveNiceDay.getChildren().add(haveNDBackContainer);
        haveNiceDay.setBottomAnchor(haveNDBackContainer, 0.0);
        haveNiceDay.setTopAnchor(haveNDBackContainer, 600.0);
        haveNiceDay.setRightAnchor(haveNDBackContainer, 0.0);
        haveNiceDay.setLeftAnchor(haveNDBackContainer, 0.0);
       
        
        haveNiceDay.getChildren().add(haveNDImage);
        haveNiceDay.setBottomAnchor(haveNDImage, 0.0);
        haveNiceDay.setTopAnchor(haveNDImage, 0.0);
        haveNiceDay.setRightAnchor(haveNDImage, 0.0);
        haveNiceDay.setLeftAnchor(haveNDImage, 0.0);
        haveNiceDay.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.80), CornerRadii.EMPTY, Insets.EMPTY)));

        
        RegisterView registerScreen = new RegisterView(registerLayout, 1280, 1024);
        registerScreen.setWelcome(welcomeImage);
        registerScreen.setHaveNiceDay(haveNiceDay);
        registerScreen.setHDBBack(haveNDBack);
        
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
      		piv.setOnMousePressed(new ItemPurchasedControllerScenario2(registerScreen, piv, rv));
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
