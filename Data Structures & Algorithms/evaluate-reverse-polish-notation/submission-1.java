class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for (String token : tokens) {
            if (!set.contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }

            int num2 = stack.pop();
            int num1 = stack.pop();

            switch(token) {
                case "+":
                    stack.push(num1 + num2);
                    break;
                case "-":
                    stack.push(num1 - num2);
                    break;
                case "*":
                    stack.push(num1 * num2);
                    break;
                case "/":
                    stack.push(num1 / num2);
                    break;
            }
        }

        return stack.pop();
    }
}
