class MinStack {
    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push((long) val - min);
            if ((long) val < min)
                min = (long) val;
        }
    }
    
    public void pop() {
        long top = stack.pop();

        if (top < 0)
            min -= top;
    }
    
    public int top() {
        long top = stack.peek();
        return (top < 0) ? (int) min : (int) (top + min);
    }
    
    public int getMin() {
        return (int) min;
    }
}
