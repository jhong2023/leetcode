package tree;

import java.util.ArrayList;
import java.util.Stack;

//http://leetcode.com/2010/04/binary-search-tree-in-order-traversal.html
public class BinaryTreeInorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		if (root == null) {
			return r;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode tmp = root;
		while (true) {
			if (tmp != null) {
				s.push(tmp);
				tmp = tmp.left;
			} else {
				if (s.isEmpty()) {
					break;
				}
				tmp = s.pop();
				r.add(tmp.val);
				tmp = tmp.right;
			}

		}
		return r;
	}

	// too complicated.
	public ArrayList<Integer> inorderTraversal_(TreeNode root) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		if (root == null) {
			return r;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode tmp = root;
		boolean done = false;
		while (!done) {
			while (tmp.left != null) {
				s.push(tmp);
				tmp = tmp.left;
			}
			r.add(tmp.val);
			while (tmp.right == null) {
				if (s.isEmpty()) {
					done = true;
					break;
				}
				tmp = s.pop();
				r.add(tmp.val);
			}
			tmp = tmp.right;

		}
		return r;
	}

}
