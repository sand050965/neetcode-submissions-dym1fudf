class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = Set.of("+", "-", "*", "/");

        for (String token : tokens) {
            int num = 0;

            if (set.contains(token)) {
                int num2 = stack.pop(), num1 = stack.pop();
                num = calculate(num1, num2, token);
            } else {
                num = Integer.parseInt(token);
            }

            stack.push(num);
        }

        return stack.pop();
    }

    private int calculate(int num1, int num2, String operand) {
        return switch(operand) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
    }
}
