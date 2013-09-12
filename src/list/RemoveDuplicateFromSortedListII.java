package list;

public class RemoveDuplicateFromSortedListII {
	
	// remove all duplicate nodes
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null){
            ListNode first = p.next;
            ListNode last = p.next;
            while(last.next != null && last.val == last.next.val){
                last = last.next;               
            }
            if(first != last){
                p.next = last.next;
            } else {
                p = p.next;
            }
        }
        
        return dummy.next;
    }
}
