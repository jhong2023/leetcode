package hack;

public class CopyListWithRandomPtr {
	
	static public class ListNode {
		   public ListNode next;
		   public ListNode random;
		};
		
    public ListNode copyListWithRandomPtr(ListNode head) {
        ListNode p = head;
        while(p != null){
            ListNode tmp = new ListNode();
            // Don't forget to point p to next
            p.next = tmp;
            tmp.next = p.next;
            p = p.next.next;
        }
        p = head;
        while(p != null){
            if(p.random != null){
               p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        
        ListNode newHead = new ListNode();
        ListNode n = newHead;
        p = head;
        while(p != null){
            n.next = p.next;
            n = n.next;
            p.next = n.next;
            p = p.next;
        }
        
        return newHead.next;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode();
    	ListNode n2 = new ListNode();
    	n1.next = n2;
    	n1.random = n2;
    	n2.random = n1;
    	
    	ListNode res = new CopyListWithRandomPtr().copyListWithRandomPtr(n1);
    	System.out.println(res);
    	
	}
}
