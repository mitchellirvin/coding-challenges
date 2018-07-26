/*
Write an algorithm to justify text. Given a sequence of words and an integer
line length k, return a list of strings which represents each line,
fully justified.

More specifically, you should have as many words as possible in each line.
There should be at least one space between each word. Pad extra spaces when
necessary so that each line has exactly length k. Spaces should be distributed
as equally as possible, with the extra spaces, if any, distributed starting
from the left.

If you can only fit one word on a line, then you should pad the right-hand
side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words
["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
and k = 16, you should return the following:

[
"the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog" # 4 extra spaces distributed evenly
]

Runtime Efficiency: O(n + m)
where n is number of words in input, and m is number of white spaces
Space Efficiency: O(l + w + k)
where l is the number of lines in your justified text,
and w is max number of words in a line,
and k is the length of the line
*/

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class JustifyText {

    public static ArrayList<String> justifyText(ArrayList<String> textToJustify, int maxLineLength) {
        if (textToJustify.size() == 0) {
            return new ArrayList<String>();
        }

        ArrayList<String> justifiedText = new ArrayList<>();
        ArrayList<String> nextLineWords = new ArrayList<>();
        int count = 0;

        for (String s : textToJustify) {
            if (count == 0) {
                count = s.length();
            } else if (count + s.length() + 1 <= maxLineLength) {
                count += s.length() + 1;
            } else {
                String nextLine = createLine(nextLineWords, count, maxLineLength);
                justifiedText.add(nextLine);
                nextLineWords.clear();
                count = s.length();
            }

            nextLineWords.add(s);
        }

        if (nextLineWords.size() > 0) {
            String nextLine = createLine(nextLineWords, count, maxLineLength);
            justifiedText.add(nextLine);
        }

        return justifiedText;
    }

    public static String createLine(ArrayList<String> nextLineWords, int minLengthOfGivenWords, int maxLineLength) {
        int extraSpaces = maxLineLength - minLengthOfGivenWords;

        if (nextLineWords.size() == 1) {
            return createLineForSingleWord(nextLineWords.get(0), extraSpaces);
        }

        return createLineForMultipleWords(nextLineWords, extraSpaces);
    }

    public static String createLineForSingleWord(String word, int extraSpaces) {
        StringBuilder nextLine = new StringBuilder();
        nextLine.append(word);

        while (extraSpaces > 0) {
            nextLine.append(" ");
            extraSpaces--;
        }

        return nextLine.toString();
    }

    public static String createLineForMultipleWords(ArrayList<String> nextLineWords, int extraSpaces) {
        StringBuilder nextLine = new StringBuilder();
        int gapsToFill = nextLineWords.size() - 1;
        int spacesPerGap = (extraSpaces / gapsToFill) + 1;  // 1 is min value
        int leftoverSpaces = extraSpaces % gapsToFill;

        for (int j = 0; j < nextLineWords.size() - 1; j++) {
            String word = nextLineWords.get(j);
            nextLine.append(word);

            if (leftoverSpaces > 0) {
                nextLine.append(" ");
                leftoverSpaces--;
            }

            for (int i = 0; i < spacesPerGap; i++) {
                nextLine.append(" ");
            }
        }

        nextLine.append(nextLineWords.get(nextLineWords.size() - 1));
        return nextLine.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> textToJustify = new ArrayList<String>(asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"));

        System.out.println("Text to justify: ");
        System.out.println(textToJustify);

        System.out.println("Justified Text, line length 16: ");
        System.out.println(justifyText(textToJustify, 16));

        System.out.println("Justified Text, line length 10: ");
        System.out.println(justifyText(textToJustify, 10));
    }

}
