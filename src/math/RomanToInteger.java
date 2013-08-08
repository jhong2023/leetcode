package math;

import java.util.HashMap;
import java.util.Random;

public class RomanToInteger {
    
    private static int[] bases = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    static HashMap<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    public String intToRoman(int num) {
        String result = new String();
        for (int i : bases) {
            while (num >= i) {
                result += map.get(i);
                num -= i;
            }
        }
        return result;

    }
    
    static HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }
    public int romanToInt(String roman) {
        int num = 0;
        int preBase = Integer.MAX_VALUE;
        for (int i = roman.length() -1; i >= 0; i--) {
            int base = romanMap.get(roman.charAt(i));
            if (base < preBase) {
                num -= base;
            } else {
                num += base;
            }
            preBase = base;
        }
        return num;
    }

    public static void main(String[] args) {
    	Random r = new Random();
    	System.out.println(r.nextInt(100));
//        RomanToInteger r = new RomanToInteger();
//        System.out.println(r.intToRoman(4425));
    }

}
