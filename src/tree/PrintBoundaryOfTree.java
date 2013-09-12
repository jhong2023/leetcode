package tree;

import java.util.ArrayList;
import java.util.Stack;

public class PrintBoundaryOfTree {

	void printBoundary(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		TreeNode n = root;
		while(n != null) {
			res.add(n.val);
			s.push(n);
		}
		
		while(!s.isEmpty()){
			printLeaf(s.pop().right, res);
		}
		
		n = root.right;
		while(n != null && n.left != null) {
			s.push(n);
		}
		while(!s.isEmpty()){
			res.add(s.pop().val);
		}
		
	}

	private void printLeaf(TreeNode n, ArrayList<Integer> res) {
		if(n == null) return;
		if(n.left != null){
			printLeaf(n.left, res);
		} else if(n.right != null){
			printLeaf(n.right, res);
		} else {
			res.add(n.val);
		}
		
	}

}
