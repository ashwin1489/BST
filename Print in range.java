public class BST{
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            
        }
    }
     // Insert function to build the BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void printInRange(Node root,int k1 ,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data);
            printInRange(root.right,k1,k2);
        }else if(root.data<k1){
            printInRange(root.left,k1,k2);
        }else{
            printInRange(root.right,k1,k2);
        }
        
    }
    public static void main(String args[]){
        int Values[]={8,5,3,1,4,6,10,11,14};
        Node root = null;
         // Build the tree
        for (int val : Values) {
            root = insert(root, val);
        }

        
        printInRange(root,5,12);
    }
}


