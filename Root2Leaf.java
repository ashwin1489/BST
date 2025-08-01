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
  
    public static void printPath(ArrayList<Integer>path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+ "->");
        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root,ArrayList<Integer>path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        printRoot2Leaf(root.left,path);
        printRoot2Leaf(root.right,path);
        path.remove(path.size()-1);
    }
    public static void main(String args[]){
        int Values[]={8,5,3,1,4,6,10,11,14};
        Node root = null;
         // Build the tree
        for (int val : Values) {
            root = insert(root, val);
        }

        printRoot2Leaf(root,new ArrayList<>());
        // printInRange(root,5,12);
        }
}


