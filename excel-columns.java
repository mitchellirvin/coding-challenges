public class Solution {
    static HashMap<Character, Integer> letterToValueMap = new HashMap<>();

    public void fillLetterMap() {
        letterToValueMap.put('A', 1);
        letterToValueMap.put('B', 2);
        letterToValueMap.put('C', 3);
        letterToValueMap.put('D', 4);
        letterToValueMap.put('E', 5);
        letterToValueMap.put('F', 6);
        letterToValueMap.put('G', 7);
        letterToValueMap.put('H', 8);
        letterToValueMap.put('I', 9);
        letterToValueMap.put('J', 10);
        letterToValueMap.put('K', 11);
        letterToValueMap.put('L', 12);
        letterToValueMap.put('M', 13);
        letterToValueMap.put('N', 14);
        letterToValueMap.put('O', 15);
        letterToValueMap.put('P', 16);
        letterToValueMap.put('Q', 17);
        letterToValueMap.put('R', 18);
        letterToValueMap.put('S', 19);
        letterToValueMap.put('T', 20);
        letterToValueMap.put('U', 21);
        letterToValueMap.put('V', 22);
        letterToValueMap.put('W', 23);
        letterToValueMap.put('X', 24);
        letterToValueMap.put('Y', 25);
        letterToValueMap.put('Z', 26);
    }

    public int titleToNumber(String A) {
        fillLetterMap();

        int number = 0;
        for(int i = A.length() - 1; i >= 0; i--) {
            number += (Math.pow(26, A.length() - (i + 1)) *
                letterToValueMap.get(A.charAt(i)));
        }

        return number;
    }
}
