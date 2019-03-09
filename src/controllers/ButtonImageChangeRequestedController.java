package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import views.EditItemView;

public class ButtonImageChangeRequestedController implements EventHandler<ActionEvent> {

	private EditItemView eiv;
	private Stage stage;
	
	public ButtonImageChangeRequestedController(EditItemView _eiv) {
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
			
			Image img = new Image(sourceFile.toURI().toString());
			
			BufferedImage bi = SwingFXUtils.fromFXImage(img, null);
				
				try {
				    // retrieve image
				    File outputfile = new File("./resources/images/".concat(sourceFile.getName()));
				    ImageIO.write(bi, fileExt, outputfile);
				    this.eiv.getItem().setImagePath("/images/".concat(sourceFile.getName()));
				    WritableImage tmp = null;
				    
					this.eiv.updateButtonImage(SwingFXUtils.toFXImage(bi, tmp));
				} catch (IOException e) {
				    Alert alert = new Alert(AlertType.ERROR);
				    alert.setTitle("Image failed to save");
				    alert.setContentText("Image failed to save. Ensure you have write access to that directory.");
				    alert.showAndWait();
				}

		}

	}

}
