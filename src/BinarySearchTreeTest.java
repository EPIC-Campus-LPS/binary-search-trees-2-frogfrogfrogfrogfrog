import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();

    @org.junit.jupiter.api.Test
    void add() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(5); //adds root
        tree.add(3); //adds left child
        tree.add(8); //adds right child

        //elements to check for
        int[] elementsToCheck = {5,3,8};

        for (int element : elementsToCheck){
            assertEquals(true, tree.contains(element));
        }
    }

    @org.junit.jupiter.api.Test
    void delete() {
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
        assertEquals(false, tree.contains(8));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(5);
        tree.add(3);
        tree.add(8);

        //elements to check for
        int[] elementsToCheck = {5,3,8};

        for (int element : elementsToCheck){
            assertEquals(true, tree.contains(element));
        }

        assertEquals(false, tree.contains(90));
    }

    @org.junit.jupiter.api.Test
    void countNodes() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.add(7);
        tree.add(9);
        tree.add(2);
        tree.add(6);
        tree.add(10);

        assertEquals(10,tree.countNodes());

        tree.delete(10);
        tree.delete(5);

        assertEquals(8, tree.countNodes());
    }

    @org.junit.jupiter.api.Test
    void countLeafNodes() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.add(7);
        tree.add(9);
        tree.add(2);
        tree.add(6);
        tree.add(10);

        assertEquals(4, tree.countLeafNodes());
    }

    @org.junit.jupiter.api.Test
    void getHeight() {

        BinarySearchTree tree = new BinarySearchTree();

        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.add(7);
        tree.add(9);
        tree.add(2);
        tree.add(6);
        tree.add(10);

        assertEquals(3, tree.getHeight());
    }

    @org.junit.jupiter.api.Test
    void printInOrder() {
        BinarySearchTree tree = new BinarySearchTree();
        System.setOut(new java.io.PrintStream(out));
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.printInOrder();
        assertEquals("3 5 8 ",out.toString());
    }

    @org.junit.jupiter.api.Test
    void printPreorder() {
        BinarySearchTree tree = new BinarySearchTree();
        System.setOut(new java.io.PrintStream(out));
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.printPreorder();
        assertEquals("5 3 8 ",out.toString());
    }

    @org.junit.jupiter.api.Test
    void printPostorder() {
        BinarySearchTree tree = new BinarySearchTree();
        System.setOut(new java.io.PrintStream(out));
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.printPostorder();
        assertEquals("1 4 3 8 5 ",out.toString());
    }
}