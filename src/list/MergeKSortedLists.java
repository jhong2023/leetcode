package list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.isEmpty()) return null;
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
                lists.size(),
                new Comparator<ListNode>() {

                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val - o2.val;
                    }
                });
        for (ListNode n : lists) {
            if (n != null) {
                queue.offer(n);
            }
        }
        
        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            p.next = n;
            p = p.next;
            if (n.next != null) {
                queue.offer(n.next);
            }
        }
        
        return head.next;
    }

}
