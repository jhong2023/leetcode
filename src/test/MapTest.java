package test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		System.out.println(m.containsKey("aa")); // false
		System.out.println(m.get("aa")); // null
	}

}
