package tree;

public class BinarySearchTreeInOrderNext {

	// divide and conqure
	/*
	static int findNext(TreeNode n, int x){
		if(x >= n.val && n.right != null){
			return findNext(n.right, x);
		}
		if(n.left != null){
			int res = findNext(n.left, x);
			if(res > x) {
				return res;
			}
		}
		return n.val;
	}*/
	
	static TreeNode findNext(TreeNode n, int x){
		if(x >= n.val && n.right != null){
			return findNext(n.right, x);
		}
		if(n.left != null){
			TreeNode res = findNext(n.left, x);
			if(res != null) {
				return res;
			}
		}
		if(n.val > x){
			return n;
		}
		return null;
	}
	
	static int n = 0;;
	static TreeNode findKthNode(TreeNode t, int k){
		if(t == null) return null;
		TreeNode tmp = findKthNode(t.left, k);
		if(tmp != null) return tmp;
		n++;
		if(n == k) return t;
		tmp = findKthNode(t.right, k);
		return tmp;
	}
	
	static class IndexWrapper{
		int i;
	}
	
	static TreeNode findKthNode(TreeNode t, int k, IndexWrapper iw){
		if(t == null) return null;
		TreeNode tmp = findKthNode(t.left, k, iw);
		if(tmp != null) return tmp;
		iw.i++;
		if(iw.i == k) return t;
		tmp = findKthNode(t.right, k, iw);
		return tmp;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n2.left = n1;
		n3.left = n2;
		n3.right = n4;
		n5.left = n3;
		n5.right = n6;
		for(int i=0; i<=7; i++){
			// TreeNode n = findNext(n5, i);
			TreeNode t = findKthNode(n5, i, new IndexWrapper());
			if(t != null){
				System.out.println(t.val);
			} else {
				System.out.println("Not found");
			}
		}
	}

}
