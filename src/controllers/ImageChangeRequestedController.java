package controllers;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Optional;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import views.EditItemView;

public class ImageChangeRequestedController implements EventHandler<ActionEvent> {

	private EditItemView eiv;
	private Stage stage;
	
	public ImageChangeRequestedController(EditItemView _eiv) {
		this.eiv = _eiv;
		this.stage = this.eiv.getStage();
	}

	@Override
	public void handle(ActionEvent arg0) {
		FileChooser fileChooser = new FileChooser();
		LinkedList<String> driveLetters = new LinkedList<String>();
		driveLetters.add("D:\\");
		driveLetters.add("E:\\");
		driveLetters.add("F:\\");
		
		File initialDirectory = new File(System.getProperty("user.home"));
		
		for (String dl:driveLetters) {
			File tmpDir = new File(dl);
			if (tmpDir.isDirectory()) {
				initialDirectory = tmpDir;
				break;
			}
		}
		
		fileChooser.setInitialDirectory(initialDirectory);
		fileChooser.setTitle("Select new image");
		fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
		File sourceFile = fileChooser.showOpenDialog(stage);
		
		if (sourceFile != null) {
			String fileExt = sourceFile.getName().substring(sourceFile.getName().length()-3);
//			System.out.println(fileExt);
//			String destPath = "./resources/images/temp.".concat(fileExt);
//			File destFile = "file:"+new File(destPath);
//			try {
//				Files.copy(sourceFile.toPath(), destFile.toPath());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			Alert cropper = new Alert(AlertType.CONFIRMATION);
			cropper.initOwner(this.stage);
			cropper.setGraphic(null);
			cropper.setTitle("");
			cropper.setHeaderText("");
			
			Image img = new Image(sourceFile.toURI().toString());
			ImageView imageView = new ImageView(img);
			imageView.setPreserveRatio(true);
			double scale = img.getHeight()/600.0;
			imageView.setFitHeight(600);
	        Rectangle r = new Rectangle(0,0,0,0);
	        r.setStroke(Color.BLACK);
	        r.setFill(null);
	        r.setStrokeWidth(3);
	        Point p = new Point(0,0);
	        Line vl = new Line();
	        Line hl = new Line();
	        
	        System.out.println(scale);
	        
	        VBox imageContainer = new VBox();
	        imageContainer.getChildren().add(imageView);
	        imageContainer.setBorder(new Border((new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)))));

	        // Add rectangle at the last, so it shows up on the top of other children
	        Pane pane = new Pane( imageContainer, r , vl, hl);
	       // pane.setBorder(new Border((new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10)))));
	        
	        cropper.getDialogPane().setContent(pane);
	        
	        Rectangle bounds = new Rectangle(img.getWidth()/scale, imageView.getFitHeight());
	        
	        pane.setOnMouseMoved(new CrosshairsController(vl, hl, bounds));
	        pane.setOnMousePressed(new ImageAreaSelectorRectangleStartController(r, p));
	        pane.setOnMouseDragged(new ImageAreaSelectorRectangleDragController(r, p, bounds));
			
			Optional<ButtonType> result = cropper.showAndWait();
		
			if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
				
				BufferedImage bi = SwingFXUtils.fromFXImage(img, null);
				
				//System.out.println(r.toString());
				BufferedImage cropped = bi.getSubimage((int)(scale*r.getX()), (int)(scale*r.getY()), (int)(scale*r.getWidth()), (int)(scale*r.getHeight()));
				
				try {
				    // retrieve image
				    File outputfile = new File("./resources/images/".concat(sourceFile.getName()));
				    ImageIO.write(cropped, fileExt, outputfile);
				    this.eiv.getItem().setImagePath("/images/".concat(sourceFile.getName()));
				    WritableImage tmp = null;
				    
					this.eiv.updateImage(SwingFXUtils.toFXImage(cropped, tmp));
				} catch (IOException e) {
				    Alert alert = new Alert(AlertType.ERROR);
				    alert.setTitle("Image failed to save");
				    alert.setContentText("Image failed to save. Ensure you have write access to that directory.");
				    alert.showAndWait();
				}
			}

			
			
			
		}

	}

}
