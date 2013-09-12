package list;


public class MergeTwoSortedList {

	 class ListNode{
	        int val;
	        ListNode next;
	        
	        ListNode(int val) {
	            this.val = val;
	        }
	    }
	 
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode header = l3;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            }
        }
        // if not while
        if(l1 != null) {
            l3.next = l1;
        }
        
        if(l2 != null) {
            l3.next = l2;
        }
        
        // not l3.next
        return header.next;
   }

}
