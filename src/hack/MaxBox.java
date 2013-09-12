package hack;

import java.util.Arrays;
import java.util.Comparator;

public class MaxBox {
    public int maxBoxes(Box[] a) {
        Arrays.sort(a, new Comparator<Box>() {

			@Override
			public int compare(Box o1, Box o2) {
				return o1.vol - o2.vol;
			}
		});
        
        int len = a.length;
		Box b[] = new Box[len];
		int n = 0;
		for(int i = 0; i < len; i++){
			if(n == 0 || a[i].weight > b[n-1].weight){
				b[n] = a[i];
				n++;
			} else {
				int j = 0;
				while(j < n && b[j].weight < a[i].weight){
					j++;
				}
				//int j = binarySearchInsert(b, 0, n-1, a[i].weight);
				b[j] = a[i];
			}
		}
		return n;
    }
    
	int binarySearchInsert(Box[] a, int i, int j, int t){
		while(i < j){
			int m = (i+j)/2;
			if(t > a[m].weight && t <= a[m+1].weight) {
				return m + 1;
			}
			if(t < a[m].weight) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}
		return i;
	}
}

class Box {
	  int vol, weight;
}