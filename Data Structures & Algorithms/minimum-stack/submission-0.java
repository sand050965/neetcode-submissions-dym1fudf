class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minimumStack;

    public MinStack() {
        stack = new Stack<>();
        minimumStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        int minValue = minimumStack.isEmpty() ? 
            val : 
            Math.min(minimumStack.peek(), val);

        minimumStack.push(minValue);
    }
    
    public void pop() {
        stack.pop();
        minimumStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimumStack.peek();
    }
}
