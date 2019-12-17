/**
 *
 * @author Abdullah Alzhrani
 */

package Application;

import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class MyNode {
    private Circle c;
    private Label data;
    private MyNode left;
    private MyNode right;

    public MyNode(Circle c, Label data) {
        this.c = c;
        this.data = data;
    }

    public int getData() {
        return Integer.valueOf(data.getText());
    }
    
    public void setData(int data) {
        this.data.setText(data+"");
    }
    public Label getLabel(){
        return data;
    }
    public Circle getC() {
        return c;
    }

    public void setC(Circle c) {
        this.c = c;
    }

    public MyNode getLeft() {
        return left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }
    
    
    
    
}
