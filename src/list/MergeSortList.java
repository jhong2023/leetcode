package list;

public class MergeSortList {
	ListNode merge(ListNode head){
		ListNode dummy =  new ListNode(-1);
		dummy.next = head;
		int k = 1;
		ListNode p = head;
		int size = 0;
		while(p != null){
			p = p.next;
			size++;
		}
		while(k < size){
			p = dummy;
			while(p.next != null){
				ListNode left = p.next;
				ListNode q = p;
				int i = 0;
				while(i < k && q.next != null){
					q = q.next;
					i++;
				}
				ListNode right = q.next;
				q.next = null;
				q = right;
				i = 1;
				while(i < k && q != null){
					q = q.next;
					i++;
				}
				if(q != null){
					ListNode tmp = q.next;
					q.next = null;
					q = tmp;
				}
				Result res = merge(left, right);
				p.next = res.head;
				p = res.tail;
				p.next = q;
			}
			k = k*2;
		}
		return dummy.next;
	}
	
	class Result{
		ListNode head;
		ListNode tail;
	}
	Result merge(ListNode left, ListNode right){
		ListNode dummy =  new ListNode(-1);
		ListNode p = dummy;
		while(left != null && right != null){
			if(left.val < right.val){
				p.next = left;
				left = left.next;
			} else {
				p.next = right;
				right = right.next;
			}
			p = p.next;
		}
		if(left != null){
			p.next = left;
		}
		if(right != null){
			p.next = right;
		}
		
		while(p.next != null){
			p = p.next;
		}
		
		Result res = new Result();
		res.head = dummy.next;
		res.tail = p;
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = {3,5,2,4,1,8,9,6,7};
		ListNode head = new ListNode(-1);
		ListNode p = head;
		for(int i = 0; i < a.length; i++){
			p.next = new ListNode(a[i]);
			p = p.next;
		}
		p = new MergeSortList().merge(head.next);
		while(p != null){
			System.out.println(p.val);
			p = p.next;
		}
	}
}
