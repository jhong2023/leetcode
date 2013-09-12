package hack;

public class WildcardMatch {
	
    //Implement wildcard pattern matching with support for '?' and '*'.
	// 1*, ?*, *, **, 
	boolean isMatch(String str, String reg){
		if(str == null || reg == null) return false;
		int lstr = str.length();
		int lreg = reg.length();
		
		if(lstr == 0 || lreg == 0) return true;
		
		boolean matchHead = reg.charAt(0) == '?' || reg.charAt(0) == str.charAt(0);
		if(lreg == 1){
			return lstr == 1 && matchHead;
		}
		
		return (matchHead && isMatch(str.substring(1), reg.substring(1))) 
				|| (reg.charAt(1) == '*' && ( isMatch(str, reg.substring(2)) 
												|| (matchHead && isMatch(str.substring(1), reg.substring(2)) || isMatch(str.substring(1), reg))));
		
	}
	
	static boolean isMatch_dp(String str, String reg){
		if(str == null || reg == null) return false;
		int lstr = str.length();
		int lreg = reg.length();
		boolean[][] t = new boolean[lstr+1][lreg+1];
		t[0][0] = true;
		// <= not <
		for(int i=1;i<=lstr;i++){
			t[i][0] = false;
		}
		// <= not <
		for(int j=1;j<=lreg;j++){
			if(j > 1 && reg.charAt(j-1) == '*'){
				t[0][j] = t[0][j-1];
			} else { // don't forget else
				t[0][j] = false;
			}
		}
		// i, j start from 1 here
		for(int i=1; i <= lstr; i++){
			for(int j=1; j <= lreg; j++){
				// * match any pattern
				boolean isMatch = t[i-1][j-1] && (reg.charAt(j-1) == '?' || reg.charAt(j-1) == str.charAt(i-1));
				isMatch = isMatch || (reg.charAt(j-1) == '*' && (t[i-1][j]|| t[i][j-1] || t[i-1][j-1] ));
                // Don't forget to assign result
				t[i][j] = isMatch;	
			}
		}
		return t[lstr][lreg];
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch_dp("", "*"));
	}
	

}
