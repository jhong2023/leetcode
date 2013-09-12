package tree;

import java.util.ArrayList;

public class PathSumTwo {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root != null) {

			ArrayList<Integer> a = new ArrayList<Integer>();

			pathSum(root, sum, res, a);
		}
		return res;

	}

	void pathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> a) {
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				a.add(root.val);
				res.add(a);
			}
			return;
		}

		if (root.left != null) {
			// copy into a new ArrayList
			ArrayList<Integer> aa = new ArrayList<Integer>();
			aa.addAll(a);
			aa.add(root.val);
			pathSum(root.left, sum - root.val, res, aa);
		}

		if (root.right != null) {
			// copy into a new ArrayList
			ArrayList<Integer> aa = new ArrayList<Integer>();
			aa.addAll(a);
			aa.add(root.val);
			pathSum(root.right, sum - root.val, res, aa);
		}

	}

}
