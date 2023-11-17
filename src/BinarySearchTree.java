import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int nodeCount = 0;

    public void add(E value) {

        TreeNode<E> addedElement = new TreeNode<>(value, null, null);

        //defines root
        if (root == null) {

            root = addedElement;

        } else {

            //makes node that starts at root
            TreeNode<E> trace = root;

            while (trace.getLeftChild() != null || trace.getRightChild() != null) {

                if (addedElement.getValue().compareTo(trace.getValue()) <= 0) {

                    if(trace.getLeftChild() == null){
                        break; //no left child
                    }

                    //follows left if smaller or equal to compared
                    trace = trace.getLeftChild();

                } else {

                    if(trace.getRightChild() == null){
                        break; //no right child
                    }

                    //follows right if bigger
                    trace = trace.getRightChild();

                }

            }

            if (addedElement.getValue().compareTo(trace.getValue()) <= 0) {

                //follows left if smaller or equal to compared
                trace.setLeftChild(addedElement);

            } else {

                //follows right if bigger
                trace.setRightChild(addedElement);

            }

        }

        nodeCount++;
    }

    /*
    public E delete (E value){

    }

    public boolean contains(E value){

    }
    int countNodes(){

    }

    int countLeafNodes(){

    }
    int getHeight(){

    }

    public void printInOrder(){

    }
    */

    public void printPreorder() {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.println(current.getValue()); // Visit the current node
                stack.push(current.getRightChild()); // Push the right child to the stack
                current = current.getLeftChild(); // Move to the left child
            }
            if (!stack.isEmpty()) {
                current = stack.pop(); // Pop a node from the stack (right child)
            }
        }
    }
    /*

    public void printPostorder(){

    }
    */

}
