package tree;

public class MaxiumDiameterOfBinaryTree {
	class Result{
		public Result(int max, int height) {
			this.max = max;
			this.height = height;
		}
		int max;
		int height;
	}
	
	Result max(TreeNode root){
		if(root == null){
			return new Result(0, 0);
		}
		
		Result lres = max(root.left);
		Result rres = max(root.right);
		int max = Math.max(lres.height + rres.height + 1, Math.max(lres.max, rres.max));
		int height = Math.max(lres.height, rres.height) + 1;
		return new Result(max, height);
	}
}
