/*
input:
char[][]: keypad (distinct chars)
int: len (length of code)

output:
int: # of all possible codes with length = len

code:
next char: up, down, left, right, same
* ^: illegal, cannot exist in the code.

a b c
d e f
g h i
^ 2 *

valid code: aaa, adg, ade, abc
invalid code: aeh, ^2h, acb

len = 1: 10
len = 2: 34
*/

public class NumericKeypad {
    public static int possibleNumbers(int n) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Testing 2: " + possibleNumbers(2));
    }
}
