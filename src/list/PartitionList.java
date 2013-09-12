package list;

public class PartitionList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;

		ListNode qhead = null;
		ListNode q = null;

		while (head != null && head.val >= x) {

			if (q == null) {
				q = head;
				qhead = q;
			} else {
				q.next = head;
				q = q.next;
			}
			head = head.next;
			q.next = null;
		}

		if (head == null) {
			return qhead;
		}

		ListNode p = head;

		while (p.next != null) {
			if (p.next.val >= x) {
				if (q == null) {
					q = p.next;
					qhead = q;
				} else {
					q.next = p.next;
					q = q.next;
				}
				p.next = q.next;
			} else {
				p = p.next;
			}
		}
		p.next = qhead;
		if (q != null) {
			q.next = null;
		}

		return head;
	}
}