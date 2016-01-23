/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VocaTrolle;

import VocaTrolle.About.About;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import resource.hang;

/**
 * FXML Controller class
 *
 * @author C#
 */
public class MainViewController implements Initializable {
    
    public static hang handeller;
    
    @FXML
    private ImageView img;
    @FXML
    private Label Toption;
    @FXML
    private TextField Rword;
    @FXML
    private Button Btest;
    @FXML
    private Button Breload;
    @FXML
    private Label Tscore;
    @FXML
    private ListView<String> LHisto;
    @FXML
    private Button Bplay;    
    @FXML
    private TextField Rwordsize;
    @FXML
    private Label Lscore;
    @FXML
    private Label Loptionsize;
    ObservableList<String> data = FXCollections.observableArrayList();
    @FXML
    private StackPane spane;
    @FXML
    private Menu MitemLang;
    @FXML
    private MenuItem ar;
    @FXML
    private MenuItem en;
    @FXML
    private MenuItem es;
    @FXML
    private MenuItem fr;
    @FXML
    private ImageView imglang;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handeller = new hang();
        switch(hang.lang){
            case "AR" :handeller.loadWords(hang.wordpathAR);
            break;
            case "FR" :handeller.loadWords(hang.wordpathFR);
            break;
            case "EN" :handeller.loadWords(hang.wordpathEN);
            break;
            case "ES" :handeller.loadWords(hang.wordpathES);
            break;   
            default:handeller.loadWords(hang.wordpathEN);
        }
        handeller.loadWords(hang.wordpathEN);
        
        Breload.setDisable(true);
        Btest.setDisable(true);
        Rword.setDisable(true);
        LHisto.setItems(data);
        Toption.setText("............");
        Image image = new Image("/resource/original.gif");
        img.setImage(image);
        
        //Set languag Menu
        imglang.setImage(new Image("/resource/en.png"));
        
    }    

    @FXML
    private void playGame(ActionEvent event) {
        if(!hang.ingame){
            System.out.println("Test PlayGame");

            try {
                System.out.println(" Word size"+Rwordsize.getText());
                String s = Rwordsize.getText();
                System.out.println("Integer.getInteger(s) : "+Integer.valueOf(s));
                hang.OptionSize = Integer.valueOf(s);
            } catch (Exception e) {
                System.out.println("Error " +e);
            }
            Bplay.setText("Ok i am than here");
            System.out.println("WordSize PlayGame");
            Rwordsize.setDisable(true);
            hang.ingame = true;
            Breload.setDisable(false);
            Btest.setDisable(false);
            Rword.setDisable(false);
            
            handeller.setOptionword(hang.OptionSize);
            Toption.setText(hang.optionword);
            data.add("Option : "+hang.optionword);
            
       }else{
            data.clear();
            hang.ingame = false;
            hang.score = 0;
            Tscore.setText("0");
            Image image = new Image("/resource/original.gif");
            img.setImage(image);
            Bplay.setText("play");
            Breload.setDisable(true);
            Btest.setDisable(true);
            Rword.setDisable(true);
            Rwordsize.setDisable(false);
            Toption.setText("................");    
       }
    }

    @FXML
    private void IsValide(ActionEvent event) {
        System.out.println("Test IsValide");
        String wordtest = Rword.getText();
        
        boolean valid = handeller.ValideWord(wordtest, hang.optionword);
        if(valid){
            boolean trueword = handeller.lookforWord(wordtest);
            int sc =handeller.score(wordtest);
            if(trueword){
                System.out.println("valide");
                hang.score += sc;
                data.add(wordtest+"   + "+sc);
                int t = handeller.randomimgs();
                System.out.println("t -->"+t);
                Image image = new Image("/resource/imgS/"+t+".gif");
                img.setImage(image);
                if(handeller.updateOption(wordtest, hang.optionword)){
                    hang.score += 100;
                    data.add("END   +  100");
                    Reload(event);
                }else{
                    Toption.setText(hang.optionword);
                }
            }else{
                System.out.println("Not valide");
                hang.score -= sc;
                data.add(wordtest+"   - "+sc);
                int t = handeller.randomimgf();
                System.out.println("t -->"+t);
                Image image = new Image("/resource/imgF/"+t+".gif");
                img.setImage(image);
            }
        }else{
            System.out.println("Not valide");
            hang.score -= 10;
            data.add("Out of Scope   - 10");
            Image image = new Image("/resource/out.gif");
            img.setImage(image);
        }
        Tscore.setText(""+hang.score);
        Rword.clear();
    }

    @FXML
    private void Reload(ActionEvent event) {
        System.out.println("Test Reload");        
        handeller.setOptionword(hang.OptionSize);
        Toption.setText(hang.optionword);
        data.add("   ------------   ");
        data.add("Option : "+hang.optionword);
            
    }

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void changeLangAr(ActionEvent event) {
        hang.lang = "AR";
        handeller.loadWords(hang.wordpathAR);
        if(hang.ingame)
            Reload(event);
        imglang.setImage(new Image("/resource/ar.png"));
    }

    @FXML
    private void changeLangEn(ActionEvent event) {
        hang.lang = "EN";
        handeller.loadWords(hang.wordpathEN);
        if(hang.ingame)
            Reload(event);
        imglang.setImage(new Image("/resource/en.png"));        
    }

    @FXML
    private void changeLangEs(ActionEvent event) {
        hang.lang = "ES";
        handeller.loadWords(hang.wordpathES);
        if(hang.ingame)
            Reload(event);
        imglang.setImage(new Image("/resource/es.png"));
    }

    @FXML
    private void changeLangFr(ActionEvent event) {
        hang.lang = "FR";
        handeller.loadWords(hang.wordpathFR);
        if(hang.ingame)
            Reload(event);
        imglang.setImage(new Image("/resource/fr.png"));
    }

    @FXML
    private void About(ActionEvent event) {
        About about = new About();
        try {
            about.display();
        } catch (IOException ex) {
            System.out.println("Error hhh i don't need to handl this for the moment but i wil later");
            System.out.println("if i have time hhhhh");
        }
    }
    
}
