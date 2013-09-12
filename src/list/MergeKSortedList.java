package list;


import java.util.ArrayList;
public class MergeKSortedList {
	static public class ListNode {
		  public ListNode(int i) {
			  val = i;
		}
		public int val;
		  public ListNode next = null;
		}
	
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	// validate input
    	if(lists == null || lists.size() == 0) return null;
    	
        int k = lists.size();
        ListNode[] heap = new ListNode[k];
        int i = 0;
        int j = 0;
        // two index to resize the heap
        while(i < k){
            if(lists.get(i) != null) {
                heap[j] = lists.get(i);
                ajustup(heap, j);
                j++;
            }
            i++;
        }
        // not j+1
        k = j;
        
        ListNode res = new ListNode(-1);
        ListNode header = res;
        while(k > 0){
            ListNode tmp = heap[0];
            if(tmp == null){
                if(k  > 1){
                    heap[0] = heap[k-1];
	                ajustdown(heap, k-1);
            	} 
                k--;
            } else {
                res.next = tmp;
                res = res.next;
                tmp = tmp.next;
                heap[0] = tmp;
                if(tmp != null){
                    ajustdown(heap, k);
                }
            }
        }
        return header.next;
    }
    
    void ajustup(ListNode[] heap, int i){
        while(i > 0){
            int j = (i-1)/2;
            if(heap[i].val < heap[j].val){
                ListNode tmp = heap[i];
                heap[i] = heap[j];
                // Remember to swap with  tmp not heap[i]
                heap[j] = tmp;
            }
            i = j;
        }
    }
    
    void ajustdown(ListNode[] heap, int k){
        int i = 0;
        while(i < k){
            int m = 2*i + 1;
            if(m >= k) break;
            if(m + 1 < k && heap[m+1].val < heap[m].val){
                m = m + 1;
            }
            if(heap[i].val > heap[m].val){
                ListNode tmp = heap[i];
                heap[i] = heap[m];
                heap[m] = tmp;
                i = m;
            } else {
                break;
            }
            
        }
    }
    
    public static void main(String[] args) {
		ArrayList<ListNode> input = new ArrayList<MergeKSortedList.ListNode>();
		input.add(null);
		input.add(new ListNode(1));
		ListNode res = new MergeKSortedList().mergeKLists(input);
		System.out.println(res.val);
	}
}
