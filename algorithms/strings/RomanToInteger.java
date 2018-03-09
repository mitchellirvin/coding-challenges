import java.util.*;

public class RomanToInteger {
    // I == 1
    // V == 5
    // X == 10
    // L == 50
    // C == 100
    // D == 500
    // M == 1000
    public static int romanToInt(String A) {
        System.out.println(A);
        HashMap<Character, Integer> romanNumeralMap = getRomanNumeralMap();
        int number = romanNumeralMap.get(A.charAt(A.length() - 1));

        for(int i = A.length() - 2; i >= 0; i--) {
            if(romanNumeralMap.get(A.charAt(i)) < romanNumeralMap.get(A.charAt(i + 1))) {
                number -= romanNumeralMap.get(A.charAt(i));
            } else number += romanNumeralMap.get(A.charAt(i));
            System.out.println("Comparing " + romanNumeralMap.get(A.charAt(i)) +
                " to " + romanNumeralMap.get(A.charAt(i + 1)) + ": " + number);
        }

        return number;
    }

    public static HashMap<Character, Integer> getRomanNumeralMap() {
        HashMap<Character, Integer> romanNumeralMap = new HashMap<>();
        romanNumeralMap.put('I', 1);
        romanNumeralMap.put('V', 5);
        romanNumeralMap.put('X', 10);
        romanNumeralMap.put('L', 50);
        romanNumeralMap.put('C', 100);
        romanNumeralMap.put('D', 500);
        romanNumeralMap.put('M', 1000);
        return romanNumeralMap;
    }

    public static void main(String[] args) {
      romanToInt("MDCCCIV");
    }
}
