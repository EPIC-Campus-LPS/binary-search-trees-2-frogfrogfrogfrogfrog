import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String args[]){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.printInOrder();
    }
}
