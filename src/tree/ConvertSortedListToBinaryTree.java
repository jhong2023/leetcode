package tree;

import list.ListNode;

public class ConvertSortedListToBinaryTree {

    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode node = head;
        while(node != null) {
            len++;
            node = node.next;
        }
        if(len < 1){
        	return null;
        }
        return sortedListToBSTHelper(head, 0, len - 1).root;
    }
    
    class Result{
        TreeNode root;
        ListNode head;
        public Result(TreeNode root, ListNode head){
            this.root = root;
            this.head = head;
        }
    }
    
    private Result sortedListToBSTHelper(ListNode list, int start, int end){
        if(start > end) return null;
        int middle = start + (end - start) / 2;
        Result r = sortedListToBSTHelper(list, start, middle - 1);
        if(r != null) {
        	list = r.head;
        }
        TreeNode parentNode = new TreeNode(list.val);
        if( r!= null){
        	parentNode.left = r.root;
        }
        list = list.next;
        r = sortedListToBSTHelper(list, middle + 1, end);
        if(r != null){
	        parentNode.right = r.root;
	        list = r.head;
        }
        return new Result(parentNode, list);
    }

}
