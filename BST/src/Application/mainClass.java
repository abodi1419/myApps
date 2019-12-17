/**
 *
 * @author Abdullah Alzhrani
 */
package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainClass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // The next line takes the Layout properties from a FXML file called FXML with Extension fxml
        // I used AnchorPane Layout
        // The AnchorPane class all layouts classes are childs for parent class 
        // So we use Parent class to get layout from the fxml file because in Parent reference we can assign any layout
        // As Animal cat = new Cat(); cat is Animal so no problem
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        primaryStage.setTitle("BST Drawer");
        primaryStage.setResizable(false);
        // The next Line lets Stage take its size from the scene 
        primaryStage.sizeToScene();
        // the next line creates new Scene and gives it our layout 
        // you cannot set the layout to the stage directly
        // you have to use scene 
        // it looks like the cinema we have stage and scenes and actors 
        // Stage never changes actors and scenes are always changing but Stage doesn't change
        primaryStage.setScene(new Scene(root));
        // finally remove the curtain to let people watch the scenes 
        primaryStage.show();
    }
    public static intBST myTree = new intBST();

    public static void main(String[] args) {
        launch(args);

    }
}
