package tree;

import java.util.ArrayList;


public class RecoverTree {

    public void recoverTree_n_space(TreeNode root) {
        ArrayList<TreeNode> a = new ArrayList<TreeNode>();
		inOrder(root, a);
		int i = 1;
		while(i < a.size()) {
			int j = i-1;
			while(j>=0 && a.get(j).val > a.get(j+1).val){
				int tmp = a.get(j).val;
				a.get(j).val = a.get(j+1).val;
				a.get(j+1).val = tmp;
				// Don't forget j--
                j--;
			}
			i++;
		}
    }
    
     private void inOrder(TreeNode root, ArrayList<TreeNode> a) {
    	 if(root == null) return;
		 inOrder(root.left, a);
		 a.add(root);
		 inOrder(root.right, a);
	}

	public void recoverTree(TreeNode root) {
	        findInvalidNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }
	    
	    TreeNode findInvalidNode(TreeNode root, int min, int max){
	        if(root == null) return null;
	        
	        if(root.val < min || root.val > max){
	            return root;
	        }
	        
	        TreeNode l = findInvalidNode(root.left, min, root.val);
	        TreeNode r = findInvalidNode(root.right, root.val, max);
	        
	        if(l != null && r!= null){
	            swap(l, r);
	            return null;
	        }
	        
	        if(l != null){
	            if(l.val > root.val){
	                swap(l, root);
	            }else{
	                return l;
	            }
	        }
	        
	        if(r != null){
	            if(r.val < root.val){
	                swap(r, root);
	            }else{
	                return r;
	            }
	        }
	        
	        return null;
	    }
	    
	    void swap(TreeNode n1, TreeNode n2){
	        int tmp = n1.val;
	        n1.val = n2.val;
	        n2.val = tmp;
	    }

}
