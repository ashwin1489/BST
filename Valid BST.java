import java.util.*;   // ✅ Correct
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
    public static boolean isValidBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }else if (max!=null && root.data>=max.data){
            return false;
        }
        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }
  
 
    public static void main(String args[]){
        int Values[]={8,5,3,1,4,6,10,11,14};
        Node root = null;
         // Build the tree
        for (int val : Values) {
            root = insert(root, val);
        }

       if(isValidBST(root,null,null)){
           System.out.println("Valid");
       }else{
           System.out.println("Not Valid");
        }
    }
}


