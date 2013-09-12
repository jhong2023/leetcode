package list;

public class RerveseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2) return head;
        
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;
        ListNode q = p.next;
        while(q != null){
            
            int i = 1;
            ListNode first  = q;
            ListNode last = q;
            q = q.next;
            last.next = null;
            while(i < k && q != null){
                ListNode tmp = q.next;
                q.next = first;
                first = q;
                i++;
                q = tmp;
            }
            if(i < k){
                p.next = last;
                
                q = first.next;
                first.next = null;
                while(q != null){
                    ListNode tmp = q.next;
                    // attentions: 1 before 2
                    q.next = first;  // 1
                    first = q;  // 2
                    q = tmp;
                }
                break;
            }
            p.next = first;
            p = last;
        }
        return head.next;
    }
    
    public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next  = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
		ListNode res = new RerveseKGroup().reverseKGroup(n1, 3);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}
}
