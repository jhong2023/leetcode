package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int ilen = inorder.length;
		int plen = postorder.length;
		if (ilen != plen) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < ilen; i++) {
			map.put(inorder[i], i);
		}

		return buildTree(postorder, 0, plen - 1, map, 0);
	}

	public TreeNode buildTree(int[] postorder, int i, int j,
			Map<Integer, Integer> map, int offset) {

		if (i > j)
			return null;
		
		TreeNode root = new TreeNode(postorder[j]);
		// must have this to avoid dead loop
		if(i == j) return root;
		int mid =  map.get(postorder[j]) - offset;
		root.left = buildTree(postorder, i, mid - 1, map, offset);
		root.right = buildTree(postorder, mid, j - 1, map, offset+1);
		return root;
	}

	public static void main(String[] args) {
		int a[] = { 1,3,2};
		int b[] = { 3,2,1};
		TreeNode root = new ConstructBinaryTree().buildTree(a, b);
		System.out.println(root.val);
	}
}
