import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @org.junit.jupiter.api.Test
    void add() {
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

        //elements to check for
        int[] elementsToCheck = {1,2,3,4,5,6,7,8,9,10};

        for (int element : elementsToCheck){
            assertEquals(true, tree.contains(element));
        }
    }

    @org.junit.jupiter.api.Test
    void delete() {
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

        tree.delete(10);
        tree.delete(5);
        tree.delete(8);

        //elements to check for
        int[] elementsToCheck = {10,5,8,90};

        for (int element : elementsToCheck){
            assertEquals(false, tree.contains(element));
        }
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
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
    }

    @org.junit.jupiter.api.Test
    void printInOrder() {
    }

    @org.junit.jupiter.api.Test
    void printPreorder() {
    }

    @org.junit.jupiter.api.Test
    void printPostorder() {
    }
}