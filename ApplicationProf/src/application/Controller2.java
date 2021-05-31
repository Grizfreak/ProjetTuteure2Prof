package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller2 implements Initializable {
	
	@FXML
	private TextArea texteAide;
	@FXML
	
	private CheckBox eval;
	@FXML
	private CheckBox casseText;
	@FXML
	private CheckBox afficheRaport;
	@FXML
	private CheckBox remplacementPartiel;
	@FXML
	private CheckBox solution;
	@FXML
	private CheckBox time;
	@FXML
	private TextField nom;
	@FXML
	private TextField carocc;
	@FXML
	private TextField min2;
	@FXML
	private TextField sec2;
	@FXML
	private Text deb;

	@FXML
	public static Stage stage;
	
	private String nomExo;
	private String caractère;
	private int min;
	private int sec;
	private String aide;
	private boolean evalu;
	private boolean casseTexte;
	private boolean afficheRaports;
	private boolean remplacementPartiels;
	private boolean solutions;
	private boolean time2;
	private static String chem;
	private static String tex;
	
	private static String nomm;
	private static String caro;
	private static boolean valu;
	private static boolean timme;
	private static int minn;
	private static int secc;
	private static boolean sol;
	private static boolean cassetext;
	private static boolean remplacement;
	private static boolean affR;
	private static String aide2;
	
	private Controller cnt = new Controller();
	private FXMLLoader ancien = new FXMLLoader(getClass().getResource("/application/Creerexo.fxml"));
	private FXMLLoader test = new FXMLLoader(getClass().getResource("/application/voirexo.fxml"));
	@Override
	public void initialize( URL arg0, ResourceBundle arg1) {
		nom.setText(nomm);
		carocc.setText(caro);
		eval.setSelected(valu);
		if (!eval.isSelected()) {
			remplacementPartiel.setSelected(remplacement);
			solution.setSelected(sol);
			afficheRaport.setSelected(affR);
		}

		casseText.setSelected(cassetext);
		time.setSelected(timme);
		if (time.isSelected()) {
			min2.setText(String.valueOf(minn));
			sec2.setText(String.valueOf(secc));
		}
		texteAide.setText(aide2);
		
	}
	


	public void changeScene(Parent root) {
		Stage thisStage = (Stage) Main.actualRoot.getScene().getWindow();
		Main.actualRoot = root;
		Scene next = new Scene(root);
		
		thisStage.setResizable(false);
		thisStage.setX(200);
		thisStage.setScene(next);
		//cnt.arriere(chem,tex);
	}
	

	public void save() throws IOException {
		if (cnt.getchemin() != null) {
			try {
				FileInputStream fus = new FileInputStream(cnt.getchemin());
				FileOutputStream fas = new FileOutputStream(nom.getText() + ".ang");
				PrintWriter sortie = new PrintWriter(new FileWriter(nom.getText() + ".ang", true));
				int nb = 0;
				byte[]  Vide= fus.readAllBytes();
				nb = Vide.length;
				fus.close();
				fas.write(Vide);
				sortie.print("\n");

				sortie.print("Nombre octet: ");
				sortie.print(nb);
				sortie.print("\n");
				fas.close();
				sortie.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		PrintWriter sortie1 = new PrintWriter(new FileWriter(nom.getText() + ".ang", true));
		sortie1.print("\n\n");
		sortie1.print("TextOcculte: ");
		sortie1.print(Controller.getTexto());
		sortie1.print("\n\n");
		sortie1.print("Caractere: ");

		sortie1.print(caractère);
		sortie1.print("\n\n");

		if (eval.isSelected()) {
			sortie1.print("Eval: ");
			sortie1.print("1");
			sortie1.print("\n\n");
			sortie1.print("AffichR: 0");
			sortie1.print("\n\n");
			sortie1.print("RemplacementP: 0");
			sortie1.print("\n\n");
			sortie1.print("BtnSolution: 0");

		} else {
			sortie1.print("Eval: ");
			sortie1.print("0");
			sortie1.print("\n\n");
			sortie1.print("AffichR: ");

			if (afficheRaport.isSelected()) {
				sortie1.print(1);
			} else {
				sortie1.print(0);
			}
			sortie1.print("\n\n");
			sortie1.print("RemplacementP: ");

			if (remplacementPartiel.isSelected()) {
				sortie1.print(1);
			} else {
				sortie1.print(0);
			}
			sortie1.print("\n\n");
			sortie1.print("BtnSolution: ");

			if (solution.isSelected()) {
				sortie1.print(1);
			} else {
				sortie1.print(0);
			}
		}
		sortie1.print("\n\n");
		sortie1.print("Time: ");

		if (time.isSelected()) {

			sortie1.print(min2.getText());
			sortie1.print(" : ");

			sortie1.print(sec2.getText());
		} else {
			sortie1.print("null");
		}
		sortie1.print("\n\n");
		sortie1.print("Casse: ");

		if (casseText.isSelected()) {
			sortie1.print("1");
		} else {
			sortie1.print("0");
		}
		sortie1.print("\n\n");
		sortie1.print("aide: ");
		sortie1.print(texteAide.getText());
		sortie1.close(); 
		Stage thisStage = (Stage) Main.actualRoot.getScene().getWindow();
		thisStage.close();
	}
	public void arriere() throws IOException {

		nomExo = nom.getText();
		nomm = nomExo;
		
		caractère = carocc.getText();
		caro = caractère;

		evalu = eval.isSelected();
		valu = evalu;

		if (!valu) {

			remplacementPartiels = remplacementPartiel.isSelected();
			remplacement = remplacementPartiels;

			solutions = solution.isSelected();
			sol = solutions;

			afficheRaports = afficheRaport.isSelected();
			affR = afficheRaports;
		}

		aide = texteAide.getText();
		aide = aide2;

		casseTexte = casseText.isSelected();
		cassetext = casseTexte;

		time2 = time.isSelected();
		timme = time2;
		if (time.isSelected()) {
			min = Integer.parseInt(min2.getText());
			minn = min;
			sec = Integer.parseInt(sec2.getText());
			secc = sec;
		}
	
		Parent root = ancien.load();
	
		changeScene(root);
	}

	public void checkEvaluation() {
		evalu = eval.isSelected();
		if (!evalu) {
			solution.setDisable(false);
			remplacementPartiel.setDisable(false);
			afficheRaport.setDisable(false);
		} else {
			solution.setDisable(true);
			remplacementPartiel.setDisable(true);
			afficheRaport.setDisable(true);
		}
	}

	public void checktime() {
		if (!time.isSelected()) {
			min2.setVisible(false);
			sec2.setVisible(false);
			deb.setVisible(false);
		} else {
			min2.setVisible(true);
			sec2.setVisible(true);
			deb.setVisible(true);
		}
	}

	public void clavier() {
		if (!min2.getText().matches("[0-9]+") || min2.getText().length() > 2) {
			min2.deletePreviousChar();
		}
		if (!sec2.getText().matches("[0-9]+") || sec2.getText().length() > 2) {
			sec2.deletePreviousChar();
		}
	}



	public void setChem(String chem) {
		this.chem = chem;
		System.out.println(this.chem);
	}

	public void setTex(String tex) {
		this.tex = tex;
	}
	
}
