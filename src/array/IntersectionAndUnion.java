package array;

import java.util.ArrayList;
import java.util.List;

public class IntersectionAndUnion {
	
	class Task implements Runnable{
		int a[];
		int b[];
		int i, j, m, n;
		ArrayList<Integer> res;
		
		public Task(int a[], int i, int j, int b[], int m, int n, ArrayList<Integer> res){
			this.a = a;
			this.b = b;
			this.i = i;
			this.j = j;
			this.m = m;
			this.n = n;
			this.res = res;
		}

		@Override
		public void run() {
			union(a, i, j, b, m, n, res);
		}

		private void union(int[] a, int g, int k, int[] b, int m, int n,
				ArrayList<Integer> res) {
		     int i = g;
		     int j = m;
		     while(i < k && j < n){
		         if(res.size() > 0 && a[i] == res.get(res.size() -1).intValue()){
		             i++;
		         } else if(res.size() > 0 && b[j] == res.get(res.size() -1).intValue()){
		             j++;
		         } else if(a[i] == b[j]){
		             res.add(a[i]);
		             i++;
		             j++;
		         } else if(a[i] < b[j]){
		             res.add(a[i]);
		             i++;
		         } else {
		             res.add(b[j]);
		             j++;
		         }
		     }
		    
		     while(i < k){
		         if(res.size() > 0 && a[i] == res.get(res.size() -1).intValue()){   
		             i++;
		         } else {
		             res.add(a[i]);
		             i++;
		         }
		        
		     }
		     while(j < n){
		         if(res.size() > 0 && b[j] == res.get(res.size() -1).intValue()){
		           j++;
		         } else {
		           res.add(b[j]);
		           j++;
		         }
		     }
		}
	}
	
	void unionAll(int a[], int b[], int N){
		int lenA = a.length;
		int span = lenA / N;
		int i = 0, m = 0, n = 0;
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		while(i < lenA){
			int j = Math.min(i + span, a.length);
			m = n;
			n = findIndex(b, m, a[j-1]);
			ArrayList<Integer> res = new ArrayList<Integer>();
			resList.add(res);
			Task task = new Task(a, i, j, b, m, n, res);
			Thread t = new Thread(task);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i = i + span;
		}
		
		for(List<Integer> list : resList){
			for(int t : list){
				System.out.println(t);
			}
		}
	}
	private int findIndex(int[] b, int start,  int target) {
		int i = start;
		while(i < b.length && target >= b[i]){
			i++;
		}
		return i;
	}

	int[] intersect(int a[], int b[]){
	     ArrayList<Integer> res = new ArrayList<Integer>();
	     int i = 0;
	     int j = 0;
	     while(i < a.length && j < b.length){
	         if(a[i] == b[j]){
	             res.add(a[i]);
	             i++;
	             j++;
	         } else if(a[i] < b[j]){
	             i++;
	         } else {
	             j++;
	         }
	     }
	    
	     int c[] = new int[res.size()];
	     for(int k = 0; k < res.size(); k++){
	         c[k] = res.get(k).intValue();
	     }
	    
	     return c;
	 }
	 

	 int[] union(int a[], int b[]){
	     ArrayList<Integer> res = new ArrayList<Integer>();
	     int i = 0;
	     int j = 0;
	     while(i < a.length && j < b.length){
	         if(res.size() > 0 && a[i] == res.get(res.size() -1).intValue()){
	             i++;
	         } else if(res.size() > 0 && b[j] == res.get(res.size() -1).intValue()){
	             j++;
	         } else if(a[i] == b[j]){
	             res.add(a[i]);
	             i++;
	             j++;
	         } else if(a[i] < b[j]){
	             res.add(a[i]);
	             i++;
	         } else {
	             res.add(b[j]);
	             j++;
	         }
	     }
	    
	     while(i < a.length){
	         if(res.size() > 0 && a[i] == res.get(res.size() -1).intValue()){   
	             i++;
	         } else {
	             res.add(a[i]);
	             i++;
	         }
	        
	     }
	     while(j < b.length){
	         if(res.size() > 0 && b[j] == res.get(res.size() -1).intValue()){
	           j++;
	         } else {
	           res.add(b[j]);
	           j++;
	         }
	     }
	    
	     int c[] = new int[res.size()];
	     for(int k = 0; k < res.size(); k++){
	         c[k] = res.get(k).intValue();
	     }
	    
	     return c;
	 }
	 
	 
	 
	 
	 public static void main(String[] args) {
		 IntersectionAndUnion iu = new IntersectionAndUnion();
		int a[] = {1, 2,3,3,4,8, 9, 10, 11};
		int b[] = {1, 1, 3, 3,5,6, 14,15, 16};
		
		//System.out.println(  Arrays.binarySearch(b, 8));
		
		iu.unionAll(a, b, 3);
		
		
//		for(int i : iu.intersect(a, b) ){
//			System.out.println(i);
//		}
//		for(int i : iu.union(a, b) ){
//			System.out.println(i);
//		}
	}

}
