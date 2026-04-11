class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        while (idx < n) {
            String token = tokens[idx];
            if ("+-*/".contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();

                switch(token) {
                    case "+" -> stack.push(num1 + num2);
                    case "-" -> stack.push(num1 - num2);
                    case "*" -> stack.push(num1 * num2);
                    case "/" -> stack.push(num1 / num2);
                };
            } else {
                stack.push(Integer.parseInt(token));
            }

            idx++;
        }

        return stack.pop();
    }
}
