package tree;

public class LCA {
	
	TreeNode find(TreeNode root, TreeNode n1, TreeNode n2){
		if (root == null) return null;
		if(root == n1 || root == n2) return root;
		
		TreeNode l = find(root.left, n1, n2);
		TreeNode r = find(root.right, n1, n2);
		if(l != null && r != null) return root;
		if(l != null) return l;
		if(r != null) return r;
		return null;
	}
	
	class Result{
		
	}
	
	/* with parent
    public TreeNode getLCA(TreeNode node1, TreeNode node2) {
        TreeNode p1 = node1;
        int i = 0;
        while(p1 != null){
            i++;
            p1 = p1.parent;
        }
        
        TreeNode p2 = node2;
        int j = 0;
        while(p2 != null){
            j++;
            p2 = p2.parent;
        }
        
        p1 = node1;
        p2 = node2;
        
        while(i > j){
            p1 = p1.parent;
            i--;
        }
        while(j > i){
            p2 = p2.parent;
            j--;
        }
        
        while(p1 != null){
            if(p1 == p2){
                return p1;
            }
            p1 = p1.parent;
            p2 = p2.parent;
        }
        
        return null;
    }
    */
}
