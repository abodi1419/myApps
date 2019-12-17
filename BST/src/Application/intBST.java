/**
 *
 * @author Abdullah Alzhrani
 */
package Application;

import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class intBST {

    private BSTnode root;
    boolean isFlipped;


    public intBST() {
        root = null;
    }


    public void NodesSumOdd() {
        NodesSumOdd(root);
        isFlipped = false;
    }

    private void NodesSumOdd(BSTnode p) {                  

        if (p != null && (p.getRight() != null || p.getLeft() != null)) {
            if (hasOnlyLeftChild(p)) {
                if (p.getLeft().getData() % 2 == 1) {
                    System.out.print(p.getData() + ", ");
                }
            } else if (hasOnlyRightChild(p)) {
                if (p.getRight().getData() % 2 == 1) {
                    System.out.print(p.getData() + ", ");
                }
            } else {
                if (hasTwoChilds(p)) {
                    if ((p.getLeft().getData() + p.getRight().getData()) % 2 == 1) {
                        System.out.print(p.getData() + ", ");
                    }
                }
            }
            NodesSumOdd(p.getLeft());
            NodesSumOdd(p.getRight());
        }

    }

    public void preOrder(MyNode p1) {
        preOrder(root, p1);
    }

    private void preOrder(BSTnode p, MyNode p1) {

        if (p != null) {
            preOrder(p.getRight(), p1.getRight());
            preOrder(p.getLeft(), p1.getLeft());
            p1.setData(p.getData());
            p1.getC().setVisible(true);
            p1.getLabel().setVisible(true);
        }

    }

    public void SubTreeDescending(BSTnode temp) {
        BSTnode sub = findNode(temp.getData());
        if (sub == null) {
            System.out.println("ERROR Number not found!");
        }
        desOrder(sub);

    }

    private void desOrder(BSTnode p) {
        if (p != null) {
            desOrder(p.getRight());
            System.out.print(p.getData() + ", ");
            desOrder(p.getLeft());
        }
    }

    public int numLeaves() {
        return (numLeaves(root));
    }

    private int numLeaves(BSTnode p) { 
        if (p != null) {
            if (isLeaf(p)) {
                return 1 + numLeaves(p.getLeft()) + numLeaves(p.getRight());
            } else {
                return 0 + numLeaves(p.getLeft()) + numLeaves(p.getRight());
            }
        }
        return 0;
    }

    public int numNodes() {
        return (numNodes(root));
    }

    private int numNodes(BSTnode p) {
        if (p != null) {
            return 1 + numNodes(p.getLeft()) + numNodes(p.getRight());
        }
        return 0;
    }

    public void FlipBST() {
        root = FlipBST(root);
        if (isFlipped) {
            isFlipped = false;
        } else {
            isFlipped = true;
        }
    }

    private BSTnode FlipBST(BSTnode p) {
        if (p != null) {

            if (hasTwoChilds(p)) {
                BSTnode temp = p.getLeft();
                p.setLeft(p.getRight());
                p.setRight(temp);
            } else if (hasOnlyLeftChild(p)) {
                p.setRight(p.getLeft());
                p.setLeft(null);
            } else if (hasOnlyRightChild(p)) {
                p.setLeft(p.getRight());
                p.setRight(null);
            }
            FlipBST(p.getLeft());
            FlipBST(p.getRight());

        }
        return p;
    }

    private boolean hasTwoChilds(BSTnode p) {
        return (p != null && (p.getLeft() != null && p.getRight() != null));
    }

    public boolean isEmpty() {
        return root == null;// returns true if BST is empty
    }

    public void insert(int data) {
        BSTnode newNode = new BSTnode(data);
        if (isFlipped) {
            FlipBST();
            root = insert(root, newNode);
            FlipBST();
        } else {
            root = insert(root, newNode);
        }
        if (height() > 4) {
            delete(newNode.getData());
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Maximum Allowed height is 4!", ButtonType.OK);
            alert.setHeaderText("");
            alert.setTitle("Alert");
            alert.show();
        }
    }

    private BSTnode insert(BSTnode p, BSTnode newNode) {

        if (p == null) {
            return newNode;
        } else {

            if (newNode.getData() > p.getData()) {
                BSTnode temp = insert(p.getRight(), newNode);
                p.setRight(temp);
            } else {
                BSTnode temp = insert(p.getLeft(), newNode);

                p.setLeft(temp);
            }
        }

        return p;
    }

    public boolean search(int data) {
        return search(root, data);
    }

    private boolean search(BSTnode p, int data) {
        if (p == null) {
            return false;
        } else {
            if (data == p.getData()) {
                return true;
            } else if (data < p.getData()) {
                return search(p.getLeft(), data);
            } else {
                return search(p.getRight(), data);
            }
        }
    }

    public BSTnode findNode(int data) {
        return findNode(root, data);
    }

    private BSTnode findNode(BSTnode p, int data) {
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

    public String inorder() {
        StringBuilder str = new StringBuilder();
        inorder(root, str);
        if (str.length() > 0) {
            return str.toString().substring(0, str.toString().length() - 2);
        } else {
            return "Undefined";
        }
    }

    private void inorder(BSTnode p, StringBuilder str) {
        if (p != null) {
            inorder(p.getLeft(), str);
            str.append(p.getData() + ", ");
            inorder(p.getRight(), str);
        }
    }

    public String preOrder() {
        StringBuilder str = new StringBuilder();
        preOrder(root, str);
        if (str.length() > 0) {
            return str.toString().substring(0, str.toString().length() - 2);
        } else {
            return "Undefined";
        }
    }

    private void preOrder(BSTnode p, StringBuilder str) {
        if (p != null) {
            str.append(p.getData() + ", ");
            preOrder(p.getLeft(), str);
            preOrder(p.getRight(), str);
        }
    }

    public String postOrder() {
        StringBuilder str = new StringBuilder();
        postOrder(root, str);
        if (str.length() > 0) {
            return str.toString().substring(0, str.toString().length() - 2);
        } else {
            return "Undefined";
        }
    }

    private void postOrder(BSTnode p, StringBuilder str) {
        if (p != null) {
            postOrder(p.getLeft(), str);
            postOrder(p.getRight(), str);
            str.append(p.getData() + ", ");
        }
    }

    public int sumNodes() {
        return sumNodes(root);
    }

    private int sumNodes(BSTnode p) {
        if (p != null) {
            return p.getData() + sumNodes(p.getLeft()) + sumNodes(p.getRight());
        } else {
            return 0;
        }
    }

    public void delete(int data) {
        if (isFlipped) {
            FlipBST();
            root = delete(root, data);
            FlipBST();
        } else {
            root = delete(root, data);

        }
    }

    private BSTnode delete(BSTnode p, int data) {
        BSTnode node2delete, newnode2delete, node2save, parent;
        int saveValue;

        node2delete = findNode(p, data);

        if (node2delete == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Node not found in the Tree!", ButtonType.OK);
            alert.setHeaderText("");
            alert.setTitle("Alert");
            alert.show();
            return root;

        }

        parent = parent(p, node2delete);

        if (isLeaf(node2delete)) {

            if (parent == null) {
                return null;
            }

            if (data < parent.getData()) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }

            return p;
        }

        if (hasOnlyLeftChild(node2delete)) {

            if (parent == null) {
                return node2delete.getLeft();
            }

            if (data < parent.getData()) {
                parent.setLeft(parent.getLeft().getLeft());
            } else {
                parent.setRight(parent.getRight().getLeft());
            }

            return p;
        }

        if (hasOnlyRightChild(node2delete)) {

            if (parent == null) {
                return node2delete.getRight();
            }

            if (data < parent.getData()) {
                parent.setLeft(parent.getLeft().getRight());
            } else {
                parent.setRight(parent.getRight().getRight());
            }

            return p;
        }

        newnode2delete = minNode(node2delete.getRight());

        saveValue = newnode2delete.getData();

        p = delete(p, saveValue);

        node2delete.setData(saveValue);

        return p;
    }

    public String minNode() {
        BSTnode minNode = null;
        if (isFlipped) {
            FlipBST();
            minNode = minNode(root);
            FlipBST();
        } else {
            minNode = minNode(root);
        }
        if (minNode != null) {
            return minNode.getData() + "";
        } else {
            return "Undefined";
        }
    }

    private BSTnode minNode(BSTnode root) {
        if (root == null) {
            return null;
        } else {
            if (root.getLeft() == null) {
                return root;
            } else {
                return minNode(root.getLeft());
            }
        }
    }

    public String maxNode() {
        BSTnode maxNode = null;
        if (isFlipped) {
            FlipBST();
            maxNode = maxNode(root);
            FlipBST();
        } else {
            maxNode = maxNode(root);
        }

        if (maxNode != null) {
            return maxNode.getData() + "";
        } else {
            return "Undefined";
        }
    }

    public BSTnode maxNode(BSTnode root) {
        if (root == null) {
            return null;
        } else {
            if (root.getRight() == null) {
                return root;

            } else {
                return maxNode(root.getRight());
            }
        }
    }

    public BSTnode parent(BSTnode p) {
        return parent(root, p);
    }

    private BSTnode parent(BSTnode root, BSTnode p) {

        if (root == null || root == p) {
            return null;
        }

        if (root.getLeft() == p || root.getRight() == p) {
            return root;
        }

        if (p.getData() < root.getData()) {
            return parent(root.getLeft(), p);
        } else if (p.getData() > root.getData()) {
            return parent(root.getRight(), p);
        } else {
            return null;
        }
    }

    public Boolean isLeaf(BSTnode p) {
        return (p.getLeft() == null && p.getRight() == null);
    }

    public Boolean hasOnlyLeftChild(BSTnode p) {
        return (p.getLeft() != null && p.getRight() == null);
    }

    public Boolean hasOnlyRightChild(BSTnode p) {
        return (p.getLeft() == null && p.getRight() != null);
    }

    public int height() {
        return height(root);
    }

    private int height(BSTnode p) {
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

    private void levelToArray(BSTnode p, int level, ArrayList<BSTnode> array) {
        if (p == null) {
            array.add(p);
            return;
        }
        if (level == 1) {
            array.add(p);
        } else if (level > 1) {
            levelToArray(p.getLeft(), level - 1, array);
            levelToArray(p.getRight(), level - 1, array);
        }
    }

    public void toArray(ArrayList<BSTnode> array) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            levelToArray(root, i, array);
        }
    }

}
