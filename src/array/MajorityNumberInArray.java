package array;

public class MajorityNumberInArray {
	static int findMajority(int[] num){
		int count = 0;
		int m = 0;
		for(int i = 0; i < num.length; i++){
			if(count == 0){
				m = num[i];
				count = 1;
			} else if(num[i] == m){
				count++;
			} else {
				count--;
			}
		}
		return m;
	}

	public static void main(String[] args) {
		int a[] = {1,1,1,3,5};
		System.out.println(findMajority(a));
	}
}
