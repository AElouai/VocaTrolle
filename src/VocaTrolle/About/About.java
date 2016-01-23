/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VocaTrolle.About;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author C#
 */
public class About {
    
    public void display() throws IOException{
        /*Stage windows = new Stage();
        windows.initModality(Modality.APPLICATION_MODAL);
        windows.setTitle("About Ali Elouai");
        windows.setWidth(400d);
        Label label = new Label();
        label.setText("");
        VBox vb = new VBox();
        vb.getChildren().addAll(label);
        Scene scene = new Scene(vb);
        windows.setResizable(false);
        windows.setScene(scene);

        windows.showAndWait();*/
        Stage about = new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/VocaTrolle.About/about.css");
        
        about.setScene(scene);
        about.setTitle(this.getClass().getSimpleName());
        about.setResizable(false);
        about.show();
    }
    
}
