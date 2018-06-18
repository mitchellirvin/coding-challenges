import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// 293,409,723 -> "two hundred ninety three million four hundred nine thousand seven hundred twenty three"
public class IntToString {
    static HashMap<Integer, String> levelToUnitMap;
    static HashMap<Integer, String> intToTextMap;

    public static String intToString(int n) {
        String s = "";
        int level = 0;

        while (n > 999) {
            s = tripleToString(n, level) + s;
            n /= 1000;
            level++;
        }

        return tripleToString(n, level) + s;
    }

    public static String tripleToString(int n, int level) {
        StringBuilder sb = new StringBuilder();

        // third digit
        int thirdDigit = (n % 1000) / 100;
        if (thirdDigit > 0) {
            sb.append(intToTextMap.get(thirdDigit) + " hundred");
        }

        // first two digits
        int firstTwoDigits = n % 100;
        if (firstTwoDigits > 19) {
            int zerothColumn = firstTwoDigits % 10;
            int firstColumn = firstTwoDigits - zerothColumn;
            sb.append(intToTextMap.get(firstColumn) + intToTextMap.get(zerothColumn));
        } else {
            sb.append(intToTextMap.get(firstTwoDigits));
        }

        sb.append(levelToUnitMap.get(level));

        return sb.toString();
    }

    public static void populateMaps() {
        intToTextMap = new HashMap<Integer, String>();
        intToTextMap.put(1, " one");
        intToTextMap.put(2, " two");
        intToTextMap.put(3, " three");
        intToTextMap.put(4, " four");
        intToTextMap.put(5, " five");
        intToTextMap.put(6, " six");
        intToTextMap.put(7, " seven");
        intToTextMap.put(8, " eight");
        intToTextMap.put(9, " nine");
        intToTextMap.put(10, " ten");
        intToTextMap.put(11, " eleven");
        intToTextMap.put(12, " twelve");
        intToTextMap.put(13, " thirteen");
        intToTextMap.put(14, " fourteen");
        intToTextMap.put(15, " fifteen");
        intToTextMap.put(16, " sixteen");
        intToTextMap.put(17, " seventeen");
        intToTextMap.put(18, " eighteen");
        intToTextMap.put(19, " nineteen");
        intToTextMap.put(20, " twenty");
        intToTextMap.put(30, " thirty");
        intToTextMap.put(40, " forty");
        intToTextMap.put(50, " fifty");
        intToTextMap.put(60, " sixty");
        intToTextMap.put(70, " seventy");
        intToTextMap.put(80, " eighty");
        intToTextMap.put(90, " ninety");

        levelToUnitMap = new HashMap<Integer, String>();
        levelToUnitMap.put(0, "");
        levelToUnitMap.put(1, " thousand");
        levelToUnitMap.put(2, " million");
        levelToUnitMap.put(3, " billion");
        levelToUnitMap.put(4, " trillion");
        levelToUnitMap.put(5, " quadrillion");
    }

    public static void main(String[] args) {
        populateMaps();
        System.out.println("1,234:" + intToString(1234));
        System.out.println("432,512:" + intToString(432512));
        System.out.println("6:" + intToString(6));
        System.out.println("293,409,723:" + intToString(293409723));
    }
}
