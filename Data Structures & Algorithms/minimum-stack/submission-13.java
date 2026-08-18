class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack() {
        min = 0L;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        long push = (stack.isEmpty()) ? 0L : (val - min);
        stack.push(push);
        min = (push <= 0) ? val : min;
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        long pop = stack.pop();
        min = (pop < 0) ? (min - pop) : min;
    }
    
    public int top() {
        return (stack.peek() < 0) ? (int) min : (int) (stack.peek() + min);
    }
    
    public int getMin() {
        return (int) min;
    }
}
