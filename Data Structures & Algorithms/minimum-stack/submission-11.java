class MinStack {
    Stack<int[]> minStack;
    int min;

    public MinStack() {
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = minStack.isEmpty()? Math.min(min, val) : Math.min(minStack.peek()[1], val);
        minStack.push(new int[] {val, min});
    }
    
    public void pop() {
        minStack.pop();
        min = (minStack.isEmpty()) ? Integer.MAX_VALUE : minStack.peek()[1];
    }
    
    public int top() {
        return minStack.peek()[0];
    }
    
    public int getMin() {
        return min;
    }
}
