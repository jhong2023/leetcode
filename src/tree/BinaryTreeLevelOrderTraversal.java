package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {


	class Node{
	    char val;
	    Node left;
	    Node right;
	}

	void print(Node root){
	    if(root == null) return;
	    Queue<Node> q = new LinkedList<Node>();
	    q.add(root);
	    q.add(null);
	    String res = "";
	    while(true){
	        Node n = q.remove();
	        if(n == null){
	          System.out.println(res);
	          if(q.isEmpty()){
	            break;
	          }
	          res = "";
	          q.add(null);
	          continue;
	        }
	       
	        res += n.val;
	       
	        if(n.left != null) {
	            q.add(n.left);
	        }
	        if(n.right != null){
	            q.add(n.right);
	        }
	    }
	}
}
