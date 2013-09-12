package hack;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem {
	
	class Result{
		List<Integer> selected = new ArrayList<Integer>();
		int value;
	}
	
	Result pick(int w[], int v[], int maxW, int i){
		Result r1 = pick(w, v, maxW, i+1);
		Result r2 = pick(w, v, maxW - w[i], i+1);
		r2.value = r2.value + v[i];
		r2.selected.add(i);
		if(r1.value > r2.value){
			return r1;
		} else {
			return r2;
		}
	}
	
	int  pick_dp(int w[], int v[], int maxW){
		int a[] = new int[maxW + 1];
		int b[] = new int[maxW + 1];
		for(int i = 0; i < w.length; i++){
			for(int j=1; j <= maxW; j++){
				b[j] = Math.max(a[j], j >= w[i] ? a[j-w[i]] + v[i] :0 );
			}
			int[] tmp = a;
			a = b;
			b = tmp;
		}
		
		return a[maxW];
	}
	
	public static void main(String[] args) {
		int w[] = {2,3,5};
		int v[] = {10,4,8};
		int max = 5;
		System.out.println(new KnapsackProblem().pick_dp(w, v, max));
		
	}
	 
}
