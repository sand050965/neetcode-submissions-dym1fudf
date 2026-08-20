class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;

        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        Set<String> operands = new HashSet<>();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");

        for (String token : tokens) {
            if (!operands.contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            
            int num2 = stack.pop(), num1 = stack.pop();
            if (token.equals("+")) {
                stack.push(num1 + num2);
            } else if (token.equals("-")) {
                stack.push(num1 - num2);
            } else if (token.equals("*")) {
                stack.push(num1 * num2);
            } else {
                stack.push(num1 / num2);
            }
        }

        return stack.peek();
    }
}
