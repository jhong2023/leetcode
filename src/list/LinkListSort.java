package list;

public class LinkListSort {
	
	static public class ListNode {
	    public ListNode(int i) {
	    	val = i;
		}
		public int val;
	    public ListNode next;
	}
	
    public ListNode sort(ListNode head) {
        if(head == null) return null;
        int len = 0;
        ListNode p = head;
        while(p != null){
            len++;
            p = p.next;
        }
        int k = 1;
        p = head;
        while(k < len){
        	// use p to connect to the next
            p = merge(p, k);
            k = k*2;
        }
        return p;
    }
    
    ListNode merge(ListNode n1, int k){
        ListNode n2 = n1;
        int i = 0;
        while(n2 != null && i<k){
            n2 = n2.next;
            i++;
        }
        if(i < k) return n1;
        
        i = 0;
        int j = 0;
        ListNode head = new ListNode(0);
        ListNode n3 = head;
        while(n2 != null && i < k && j<k){
            if(n1.val < n2.val){
                n3.next = n1;
                n1 = n1.next;
                n3 = n3.next;
                i++;
            } else {
                n3.next = n2;
                n2 = n2.next;
                n3 = n3.next;
                j++;
            }
        }        
        while(i < k){
             n3.next = n1;
             n1 = n1.next;
             n3 = n3.next;
             i++;
        }
        while(j < k && n2 != null){
             n3.next = n2;
             n2 = n2.next;
             n3 = n3.next;
             j++;
        }
        
        if(n2 != null) {
            n3.next = merge(n2, k);
        } else{
        	// set last node.next to null to avoid loop, only for the last merge
        	n3.next = null;
        }
        return head.next;
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	n1.next = n2;
    	n2.next = n3;
    	ListNode res = new LinkListSort().sort(n1);
    	while(res != null){
    		System.out.println(res.val);
    		res = res.next;
    	}
		
	}
}
