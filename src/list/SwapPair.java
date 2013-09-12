package list;

public class SwapPair {

    public ListNode swapPairs(ListNode head) {
    	// Before head change
    	ListNode q = head;
    	
        // head != null
        if(head!=null && head.next != null) {
            head = head.next;
        }
        ListNode p = null;
        
        while(q!=null && q.next!=null){
            ListNode t = q.next;
            if(p != null) p.next = t;
            q.next = t.next;
            t.next = q;
            p = q;
            q = q.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
		head = new SwapPair().swapPairs(head);
		System.out.println(head.next.val);
	}

}
