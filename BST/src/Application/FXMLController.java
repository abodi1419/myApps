/**
 *
 * @author Abdullah Alzhrani
 */
package Application;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
/*
    this class is a controller for the FXML File
    it is same when you design the web page using HTML
    and then gives it life using javascript same concept

    We don't write the FXML File there is a program let u 
    design the interface an then generates the FXML
    The program called SceneBuilder you JDK 8 as Default in netbeans
    to use the SceneBuilder you can know more search on youtube
*/
public class FXMLController implements Initializable {
    // we see @FXML this is called Annotation there is annotation we always see before 
    // creating toString method
    // @FXML Annotation means this variable came from FXML file
    // 
    @FXML
    private Circle c0;
    @FXML
    private Circle c2;
    @FXML
    private Circle c1;
    @FXML
    private Circle c3;
    @FXML
    private Circle c6;
    @FXML
    private Circle c5;
    @FXML
    private Circle c12;
    @FXML
    private Circle c13;
    @FXML
    private Circle c11;
    @FXML
    private Circle c14;
    @FXML
    private Circle c9;
    @FXML
    private Circle c10;
    @FXML
    private Circle c7;
    @FXML
    private Circle c8;
    @FXML
    private Circle c4;
    @FXML
    private Label t0;
    @FXML
    private Label t1;
    @FXML
    private Label t2;
    @FXML
    private Label t3;
    @FXML
    private Label t4;
    @FXML
    private Label t5;
    @FXML
    private Label t6;
    @FXML
    private Label t7;
    @FXML
    private Label t8;
    @FXML
    private Label t9;
    @FXML
    private Label t10;
    @FXML
    private Label t11;
    @FXML
    private Label t12;
    @FXML
    private Label t13;
    @FXML
    private Label t14;
    @FXML
    private Line rl1;
    @FXML
    private Line rr1;
    @FXML
    private Line rl2;
    @FXML
    private Line rr2;
    @FXML
    private Line rl3;
    @FXML
    private Line rl4;
    @FXML
    private Line rr5;
    @FXML
    private Line rr3;
    @FXML
    private Line rl5;
    @FXML
    private Line rr4;
    @FXML
    private Line rr6;
    @FXML
    private Line rl6;
    @FXML
    private Line rl7;
    @FXML
    private Line rr7;
    @FXML
    private Label numOfLeafs;

    @FXML
    private Button flip;
    @FXML
    private Button insert;
    @FXML
    private Button delete;
    @FXML
    private JFXTextField textField;
    @FXML
    private Label hint;
    @FXML
    private Label numOfNodes;
    @FXML
    private Label pre;
    @FXML
    private Label in;
    @FXML
    private Label post;
    @FXML
    private Label max;
    @FXML
    private Label min;
    @FXML
    private Label breadthFirst;
    MyBst tree = new MyBst();
    // initialize Method is the first method will be called before showing the layout
    // to the user 
    // you should write here all commands you want to do before user start using this interface
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label[] labels = {t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14};
        Circle[] circles = {c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14};
        Line[] lines = {rl1, rr1, rl2, rr2, rl3, rr3, rl4, rr4, rl5, rr5, rl6, rr6, rl7, rr7};

        for (Label l : labels) {
            l.setVisible(false);
        }
        for (Circle c : circles) {
            c.setVisible(false);
        }
        for (Line l : lines) {
            l.setVisible(false);
        }
        if (url != null) {
            for (int i = 0; i < labels.length; i++) {
                tree.insert(circles[i], labels[i]);
            }
        }
        tree.instialize();
        ArrayList<Integer> array = new ArrayList<>();
        mainClass.myTree.preOrder(tree.getRoot());
        tree.getLines(array);

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) != -99) {
                lines[i - 1].setVisible(true);
            }
        }

        numOfLeafs.setText("Number of leafs: " + mainClass.myTree.numLeaves());
        numOfNodes.setText("Number of Nodes: " + mainClass.myTree.numNodes());
        pre.setText(mainClass.myTree.preOrder());
        in.setText(mainClass.myTree.inorder());
        post.setText(mainClass.myTree.postOrder());
        max.setText(mainClass.myTree.maxNode());
        min.setText(mainClass.myTree.minNode());
        ArrayList<BSTnode> BFSArray = new ArrayList<>();
        mainClass.myTree.toArray(BFSArray);
        String BFS = "";
        if (BFSArray.size() != 0) {
            for (BSTnode n : BFSArray) {
                if (n != null) {
                    BFS += n.getData() + ", ";
                }
            }
        } else {
            BFS = "Undefined";
        }
        if (!BFS.equals("Undefined")) {
            BFS = BFS.substring(0, BFS.length() - 2);
        }
        breadthFirst.setText(BFS);
    }
// @FXML here means this method will be Called from the fxml file
// we have the same idea in html and android studio
// in html you can write onClick = "someMethodFromJavascript" 
// This method does something when the user Click on a specific button
// the button event called ActionEvent so it recieves a variable of type ActionEvent
    @FXML
    private void flip(ActionEvent event) {
        mainClass.myTree.FlipBST();
        tree.instialize();
        initialize(null, null);
    }

    @FXML
    private void insert(ActionEvent event) {
        if (textField.isVisible()) {
            if (!textField.getFocusColor().equals(Color.RED) && !textField.getText().equals("")) {
                textField.setVisible(false);
                textField.setDisable(true);
                flip.setDisable(false);
                delete.setDisable(false);
                mainClass.myTree.insert(Integer.valueOf(textField.getText()));
                tree.instialize();
                initialize(null, null);
            } else {
                textField.requestFocus();
            }
        } else {
            textField.setText("");
            textField.setVisible(true);
            textField.setDisable(false);
            textField.requestFocus();
            delete.setDisable(true);
            flip.setDisable(true);
        }

    }

    @FXML
    private void delete(ActionEvent event) {

        if (textField.isVisible()) {
            if (!textField.getFocusColor().equals(Color.RED) && !textField.getText().equals("")) {
                textField.setVisible(false);
                textField.setDisable(true);
                flip.setDisable(false);
                insert.setDisable(false);
                mainClass.myTree.delete(Integer.valueOf(textField.getText()));
                tree.instialize();
                initialize(null, null);
            } else {
                textField.requestFocus();
            }
        } else {
            textField.setText("");
            textField.setVisible(true);
            textField.setDisable(false);
            textField.requestFocus();
            insert.setDisable(true);
            flip.setDisable(true);
        }
    }
// MouseEvent is called when the user click, hover, pressed or anything using mouse in specific place
    @FXML
    private void onClick(MouseEvent event) {
        if (textField.isVisible()) {
            textField.setVisible(false);
            textField.setDisable(true);
            delete.setDisable(false);
            insert.setDisable(false);
            flip.setDisable(false);
            textField.setFocusColor(Color.valueOf("#4059a9"));
            hint.setVisible(false);
        }
    }
// KeyEvent called when user click, release or press a key in specific TextField or TextArea
    @FXML
    private void onKeyReleased(KeyEvent event) {
        if (!textField.getText().equals("")) {
            try {
                Integer.valueOf(textField.getText());
                textField.setFocusColor(Color.valueOf("#4059a9"));
                hint.setVisible(false);
            } catch (Exception e) {
                textField.setFocusColor(Color.RED);
                hint.setVisible(true);
            }
        } else {
            textField.setFocusColor(Color.valueOf("#4059a9"));
            hint.setVisible(false);
        }
        if (event.getCode() == KeyCode.ENTER) {
            if (!insert.isDisable()) {
                insert(null);
                insert(null);
            } else {
                delete(null);
                delete(null);
            }
        } else if (event.getCode() == KeyCode.ESCAPE) {
            onClick(null);
        }
    }

}
