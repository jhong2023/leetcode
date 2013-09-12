package array;

import java.util.ArrayList;
import java.util.List;

public class TetrisGame {

	List<int[][]> getShaps(int k){
		List<int[][]> res = new ArrayList<int[][]>();
		if(k == 1) {
			int[][] a= new int[1][1];
			res.add(a);
			return res;
		}
		for(int[][] s : getShaps(k-1)){
			int m = s.length;
			int n = s[0].length;
		}
		return res;
	}

}
