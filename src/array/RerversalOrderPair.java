package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RerversalOrderPair {

	List<int[]> findOrderPair(int a[]){
		int[] b = a.clone();
		Arrays.sort(b);
		int i = 0;
		int j = b.length - 1;
		while(i < j){
			int tmp = b[i];
			b[i] = b[j];
			b[j] = tmp;
			i++; j--;
		}
		List<int[]> res = new ArrayList<int[]>();
		for(i = 0; i < a.length; i++){
			int k = search(a[i], b, i);
			if(k != -1){
				for(j = k+1;j < b.length; j++){
					int[] p = new int[2];
					p[0] = a[i];
					p[1] = b[j];
					res.add(p);
				}
			}
		}
		
		
		return res;
	}

	private int search(int i, int[] b, int i2) {
		return Arrays.binarySearch(Arrays.copyOfRange(b, i2, b.length), i) + i2;
	}
	
	public static void main(String[] args) {
		RerversalOrderPair p = new RerversalOrderPair();
		int a[] = {3,2,4,1};
		for(int[] r : p.findOrderPair(a)){
			for(int i : r){
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
