class MinStack {
    Integer min;
    Stack<int[]> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        min = stack.isEmpty() ? val : Math.min(stack.peek()[1], val);
        stack.push(new int[] {val, min});
    }
    
    public void pop() {
        int[] pop = stack.pop();
        min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek()[1];
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return min;
    }
}
