class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for (String token : tokens) {
            if (!set.contains(token)) {
                stack.push(token);
                continue;
            }

            int num2 = Integer.parseInt(stack.pop());
            int num1 = Integer.parseInt(stack.pop());

            switch(token) {
                case "+":
                    stack.push(String.valueOf(num1 + num2));
                    break;
                case "-":
                    stack.push(String.valueOf(num1 - num2));
                    break;
                case "*":
                    stack.push(String.valueOf(num1 * num2));
                    break;
                case "/":
                    stack.push(String.valueOf(num1 / num2));
                    break;
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
