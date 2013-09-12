package tree;

public class CountCompleteBinayTreeNodes {
	
	 public int countNodes(TreeNode root) {
		return countDown(root).count;
	 }
	 
	 Result countDown(TreeNode root){
		 if(root.left == null) {
			 Result r = new Result();
			 r.height = 0;
			 r.count = 1;
			 r.isFull = true;
			 return r;
		 }
		 
		 if(root.right == null){
			 Result r = new Result();
			 r.height = 1;
			 r.count = 2;
			 r.isFull = false;
			 return r;
		 }
		 
		 Result r1 = countDown(root.right);
		 if(!r1.isFull) {
			 r1.height++;
			 r1.count += 1 << r1.height;
			 return r1;
		 }
		 
		 Result r2 = countDown(root.left);
		 Result r = new Result();
		 r.height = r2.height + 1;
		 r.count = r1.count + r2.count + 1;
		 r.isFull = r2.height == r1.height;
		 
		 return r;
	 }
	 
	 class Result{
		 int height;
		 int count;
		 boolean isFull;
	 }
}
