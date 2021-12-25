/* 
    * 1. Design the class for the binary tree
    * 2. addChild: adds a child to a node if the node does not have two children already.
    * 3. deleteChild: delete a child from a node if the child is a leaf node.
    * 4. In the main() method, use your code to build a tree A in the following example.
    * 5. Delete the node with key=20 in tree A, to get the Tree B in the following example.

 */

// Class containing left and right child of current node and key value
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// A Java program to introduce Binary Tree
class Q2_BinaryTree {
    // Root of Binary Tree
    Node root; // The root node of the binary tree.

    // Design the constructor of the class 'Q2_BinaryTree'

    Q2_BinaryTree (int item) {
        /* place your code here */
        root = new Node(item);

    }

    // addChild() adds 'child_node' as a child of the 'parent_node'.
    // if 'is_left' is true, then add the 'child_node' as a left child of the 'parent node'
    // if 'is_left' is false, then add the 'child_node' as a right child of the 'parent node'
    // if the target position of the child is already taken, then we should stop adding.
   
    public void addChild(Node parent_node, Node child_node, boolean is_left){
       

        if(is_left == true && parent_node.left == null){
            parent_node.left = child_node;

        }
        else if(parent_node.right == null){
            parent_node.right = child_node;

        }
    }

    // deleteChild() deletes a child of teh 'parent_node'.
    // if 'is_left' is true, then delete the left child of the 'parent_node'
    // if 'is_left' is false, then delete the right child of the 'parent_node'
    // if the target child to delete is null, then the deletion should stop.
  
    public void deleteChild(Node parent_node, boolean is_left) {
       

        if(is_left == true && parent_node.left != null){
            parent_node.left = null;
        }
        else if(is_left == false && parent_node.right != null){
            parent_node.right = null;

        }
    }

    
    private void printTree() {
        String prefix = "";
        printTreeCore(prefix, this.root, false);
    }

   
    private void printTreeCore(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "L-- " : "R-- ") + n.key);
            printTreeCore(prefix + (isLeft ? "|   " : "    "), n.right, false);
            printTreeCore(prefix + (isLeft ? "|   " : "    "), n.left, true);
        }
    }

    public static void main(String[] args) {
        /* building tree A
        Q2_BinaryTree binarytreeA = new Q2_BinaryTree(50);
        Node n30 = new Node (30);
        Node n70 = new Node (70);
        Node n20 = new Node (20);
        Node n40 = new Node (40);
        Node n60 = new Node (60);
        Node n80 = new Node (80);
        binarytreeA.addChild(binarytreeA.root, n30,true);
        binarytreeA.addChild(binarytreeA.root, n70,false);
        binarytreeA.addChild(n30, n20,true);
        binarytreeA.addChild(n30, n40,false);
        binarytreeA.addChild(n70, n60,true);
        binarytreeA.addChild(n70, n80,false);


        /* converting tree A into Tree B*/
        Q2_BinaryTree binarytreeB = new Q2_BinaryTree(50);
        binarytreeB = binarytreeA;
        binarytreeB.deleteChild(n30,true);

    }
}
