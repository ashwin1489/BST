import java.util.*;   // ✅ Correct
public class BST{
    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
            this.right = this.left = null;
            
        }
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void getInorder(Node root,ArrayList<Integer>inorder){
        if(root==null){
            return;
        }
        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }
    public static Node createBST(ArrayList<Integer>inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid  = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder,st,mid-1);
        root.right = createBST(inorder,mid+1,end);
        return root;
    }
    public static Node balanceBST(
        Node root){
            //inorder seq
            ArrayList<Integer>inorder = new ArrayList<>();
            getInorder(root,inorder);
            
            //sorted inorder -->balanced BST
            root = createBST(inorder,0,inorder.size()-1);
            return root;
        }
    public static void main(String args[]){
       
//         8
//       /   \
//      5     10
//     / \      \
//   3   6     11

        
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        
        root  = balanceBST(root);
        preorder(root);
        



//         8
//       /   \
//     10     5
//   /      / \
//  11      6   3

        
        
    }
}


