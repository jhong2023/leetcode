package array;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int size = triangle.size();
		if(size == 0) {
			return 0;
		}

		for(int i=1; i<size; i++) {
			List<Integer> pre = triangle.get(i-1);
			List<Integer> line = triangle.get(i);
			line.set(0, line.get(0) + pre.get(0));
			int j=1;
			for(;j<line.size() -1; j++) {
				line.set(j, line.get(j) + Math.min(pre.get(j-1), pre.get(j)));
			}
			line.set(j, line.get(j) + pre.get(j-1));
		}
		
		List<Integer> line = triangle.get(size -1);
		
		// Not max
		int min = line.get(0);
		for(int i=1;i<line.size();i++) {
			if(min > line.get(i)) {
				min = line.get(i);
			}
		}
		return min;
	}

}
