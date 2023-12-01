import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int nodeCount = 0;
    private int leafNodes = 0;
    private int height = 0;

    public void add(E value) {
        TreeNode<E> addedElement = new TreeNode<>(value, null, null);
        int count = 0;
        if (root == null) {
            root = addedElement; //defines root
        } else {
            TreeNode<E> trace = root;
            while (true) {

                count++;

                if (value.compareTo(trace.getValue()) <= 0) {
                    if (trace.getLeftChild() == null) {
                        //suitable spot as left child
                        trace.setLeftChild(addedElement);
                        break;
                    }
                    //traverses left child
                    trace = trace.getLeftChild();
                } else {
                    if (trace.getRightChild() == null) {
                        //suitable spot as right child
                        trace.setRightChild(addedElement);
                        break;
                    }
                    //traverses right child
                    trace = trace.getRightChild();

                }
            }
        }
        if (count > height) {
            height = count;
        }
        nodeCount++;
    }


    public E delete(E value) {
        TreeNode<E> parent = null;
        TreeNode<E> trace = root;

        //loop stops when it finds the value or if trace becomes null
        while (trace != null && value.compareTo(trace.getValue()) != 0) {
            parent = trace;
            if (value.compareTo(trace.getValue()) < 0) {
                trace = trace.getLeftChild(); // traverses left child
            } else {
                trace = trace.getRightChild(); // traverses right child
            }
        }

        //checks if the value was found
        if (trace == null) {

            return null;

        } else {

            if (parent == null) {
                root = null; //root is being deleted
                return trace.getValue();
            }

            //leaf node
            else if (trace.getLeftChild() == null && trace.getRightChild() == null) {
                if (parent.getLeftChild() == trace) {
                    parent.setLeftChild(null); //deleted left child
                } else {
                    parent.setRightChild(null); //deleted right child
                }
                return trace.getValue();
            }

            //parent of two children
            else if (trace.getLeftChild() != null && trace.getRightChild() != null) {

                TreeNode<E> rightSubtree = trace.getRightChild();

                if (parent.getLeftChild().getValue().compareTo(trace.getValue()) == 0) {
                    //value being deleted is left child
                    parent.setLeftChild(trace.getLeftChild()); //replaces with left child
                } else {
                    //value being deleted is right child
                    parent.setRightChild(trace.getLeftChild());
                }

                //follows the tree until it finds suitable spot for right subtree
                while (parent.getRightChild() != null) {
                    parent = parent.getRightChild();
                }

                parent.setRightChild(rightSubtree);
            }

            //parent of one child
            else {
                //replaces with whatever child it has
                if (trace.getLeftChild() != null) {
                    parent.setLeftChild(trace.getLeftChild());
                } else {
                    parent.setRightChild(trace.getRightChild());
                }
            }
        }
        nodeCount--;
        return null;
    }


    public boolean contains(E value) {
        TreeNode<E> trace = root;
        //loop stops when it finds the value or if trace becomes null
        while (trace != null && value.compareTo(trace.getValue()) != 0) {
            if (value.compareTo(trace.getValue()) < 0) {
                trace = trace.getLeftChild(); // traverses left child
            } else {
                trace = trace.getRightChild(); // traverses right child
            }
        }
        //if trace is null it means not found, if trace is not null the value was found
        return trace != null;
    }

    int countNodes() {
        return nodeCount;
    }

    int countLeafNodes() {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> trace = root;
        //continues loop until neither left nor right child is empty

        while (trace != null || !stack.isEmpty()) {
            while (trace != null) {
                if (trace.getLeftChild() == null && trace.getRightChild() == null) {
                    leafNodes++;
                }
                stack.push(trace.getRightChild()); //stores right child information
                trace = trace.getLeftChild(); //traverses left child
            }
            if (!stack.isEmpty()) {
                trace = stack.pop();
            }
        }
        return leafNodes;
    }

    int getHeight() {
        return height;
    }

    public void printInOrder() {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> trace = root;
        //continues loop until neither left nor right child is empty
        while (trace != null || !stack.isEmpty()) {

            //goes as far left as possible
            while (trace != null) {
                stack.push(trace);
                trace = trace.getLeftChild();
            }
            trace = stack.pop(); //goes to next available node to check its right tree
            System.out.print(trace.getValue() + " ");

            //traverses the right subtree
            trace = trace.getRightChild();
        }
    }

    public void printPreorder() {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> trace = root;
        //continues the loop until neither the left or right child is empty
        while (trace != null || !stack.isEmpty()) {
            while (trace != null) {
                System.out.println(trace.getValue()); //prints root
                stack.push(trace.getRightChild()); //pushes right child in stack
                trace = trace.getLeftChild(); //traverses left child
            }
            if (!stack.isEmpty()) {
                trace = stack.pop(); //traverses right child
            }
        }
    }

    public void printPostorder() {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> trace = root;
        TreeNode<E> lastTraced = null;

        while (trace != null || !stack.isEmpty()) {
            while (trace != null) {
                stack.push(trace);
                trace = trace.getLeftChild();
            }

            TreeNode<E> top = stack.peek();

            if (top.getRightChild() == null || top.getRightChild() == lastTraced) {
                // Process the node
                System.out.println(top.getValue());
                lastTraced = stack.pop(); // Mark the current node as processed
            } else {
                trace = top.getRightChild(); // Move to the right child
            }
        }
    }
}

