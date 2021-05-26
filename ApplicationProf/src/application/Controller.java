package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Controller implements Initializable{
	@FXML
	private String chemin2;
	@FXML
	private TextField video;
	@FXML
	private TextArea texte;
	@FXML
	public static Stage stage;
	private String texteocculte;
	private static Scene ancien;
	private static String chemin1;
	private static String texto;
	
	private FXMLLoader creer= new FXMLLoader(getClass().getResource("/application/creerexo2.fxml"));
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initialize();

	}

	public void initialize() {
		if (chemin1 != null) {
			video.setText(chemin1);
		}
		if (texto != null) {
			texte.setText(texto);
		}
	
	}
	
	private void creerScene() throws IOException {
		FXMLLoader f = new FXMLLoader(getClass().getResource(""));
		Parent root = f.load();
		Scene a = new Scene(root);
		Stage stg = new Stage();
		ancien = stage.getScene();
		stg.setScene(a);
		stg.show();
		stage = stg;

	}

	private void changeScene(Parent root) {
		   Stage thisStage = (Stage) Main.actualRoot.getScene().getWindow();
	       Main.actualRoot=root;
	       Scene next = new Scene(root);
	       thisStage.setResizable(false);
	       thisStage.setX(200);
	       thisStage.setScene(next);
	}

	public void changeScene(Parent root, float width, float height) {
		Stage thisStage = (Stage) Main.actualRoot.getScene().getWindow();
		Main.actualRoot = root;
		Scene next = new Scene(root, width, height);
		ancien = stage.getScene();
		thisStage.setScene(next);
		
	}
	
	public void ouvrirVideo() throws IOException {
		FileChooser ouv = new FileChooser();
		ouv.getExtensionFilters().add(new ExtensionFilter("mp3", "*.mp3"));
		ouv.getExtensionFilters().add(new ExtensionFilter("mp4", "*.mp4"));
		File fich = ouv.showOpenDialog(null);
		video.setText(fich.getAbsolutePath());
		chemin2 = fich.getAbsolutePath();
		chemin1 = chemin2;
	}


	public void deuxiemePage() throws IOException{
		texteocculte = texte.getText();
		texto = texteocculte;
		Parent root= creer.load();
		changeScene(root);
		
	}
	public static String getchemin() {
		return chemin1;
	}
	public static Scene getAncien() {
		return ancien;
	}
	public static String getTexto() {
		return texto;
	}

	

	


}
