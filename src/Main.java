import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String args[]){
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(5);
        tree.add(4);
        tree.add(6);

        tree.delete(5); //two children + root
        assertEquals(false, tree.contains(5));

        tree.add(3); //leaf
        tree.delete(3);
        assertEquals(false, tree.contains(3));

        tree.add(8);
        tree.delete(6); //one right child
        assertEquals(false, tree.contains(6));

        tree.delete(90); //deletes a value that doesn't exist in tree
        tree.add(10);
        tree.add(7);
        tree.delete(8); //two children + not root
    }
}
