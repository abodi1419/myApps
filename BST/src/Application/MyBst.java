/**
 *
 * @author Abdullah Alzhrni
 */

package Application;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class MyBst {

    private MyNode root;

    public MyBst() {
        root = null;
    }

    public MyNode getRoot() {
        MyNode p = root;
        return p;
    }


    public boolean isEmpty() {
        return root == null;
    }

    public void insert(Circle c, Label data) {
        MyNode newNode = new MyNode(c, data);
        root = insert(root, newNode);
    }

    public void instialize() {
        instialize(root);
    }

    private void instialize(MyNode p) {
        if (p != null) {
            p.setData(-99);
            instialize(p.getLeft());
            instialize(p.getRight());
        }
    }

    private MyNode insert(MyNode p, MyNode newNode) {

        if (p == null) {
            return newNode;
        } else {

            if (newNode.getData() > p.getData()) {
                MyNode temp = insert(p.getRight(), newNode);
                p.setRight(temp);
            } else {
                MyNode temp = insert(p.getLeft(), newNode);

                p.setLeft(temp);
            }
        }

        return p;
    }

    public MyNode findNode(int data) {
        return findNode(root, data);
    }

    private MyNode findNode(MyNode p, int data) {
        if (p == null) {
            return null;
        } else {
            if (data == p.getData()) {
                return p;
            } else if (data < p.getData()) {
                return findNode(p.getLeft(), data);
            } else {
                return findNode(p.getRight(), data);
            }
        }
    }

    public int height() {
        return height(root);
    }

    private int height(MyNode p) {
        if (p == null) {
            return 0;
        } else {
            int lheight = height(p.getLeft());
            int rheight = height(p.getRight());
            
            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

    private void levelToArray(MyNode p, int level, ArrayList<Integer> array) {
        if (p == null) {
            return;
        }
        if (level == 1) {
            array.add(p.getData());
        } else if (level > 1) {
            levelToArray(p.getLeft(), level - 1, array);
            levelToArray(p.getRight(), level - 1, array);

        }
    }

    public void getLines(ArrayList<Integer> array) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            levelToArray(root, i, array);
        }
    }

}
