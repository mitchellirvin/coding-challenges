public class Solution {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> operands = new Stack<>();
        String operators = "+-*/";

        for(String s : A) {
            if(!operators.contains(s)) {
                operands.push(Integer.parseInt(s));
            } else {
                int a = operands.pop();
                int b = operands.pop();

                switch(operators.indexOf(s)) {
                    case 0:
                        operands.push(a + b);
                        break;
                    case 1:
                        operands.push(b - a);
                        break;
                    case 2:
                        operands.push(a * b);
                        break;
                    case 3:
                        operands.push(b / a);
                        break;
                }
            }
        }

        return operands.pop();
    }
}
