package tree;

public class ConvertSortedList2BST {
    
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; next = null; }
    }
    
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        
        int len = 0;
        ListNode p = head;
        while(p != null) {
            len++;
            p = p.next;
        }
        Result res = sortedListToBST(head, 0, len-1);
        return res == null? null : res.root;
    }
    
    class Result{
        TreeNode root;
        ListNode next;
    }

    private Result sortedListToBST(ListNode list, int i, int j) {
        Result result = new Result();
        if (i > j) return result;

        int mid = (i+j)/2;
        Result leftRes = sortedListToBST(list, i, mid - 1);
        
        // Very important
        if (leftRes != null) {  
            list = leftRes.next;
        }
        TreeNode parent = new TreeNode(list.val);
        list = list.next;
        Result rightRes = sortedListToBST(list, mid+1, j);
        parent.left = leftRes == null? null : leftRes.root;
        parent.right = rightRes == null? null : rightRes.root;
        
        result.root = parent;
        if (rightRes != null) {
            result.next = rightRes.next;
        } else {
            result.next = list;
            
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
