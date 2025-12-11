class MinStack {
	Stack<Integer> stac;
	Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
        stac = new Stack<>();
    }
    
    public void push(int val) {
        stac.push(val);
        if(minStack.empty()){
            minStack.push(val);
        }
        else if(val<minStack.peek()){
            minStack.push(val);
        }
        else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        stac.pop();
        minStack.pop();
    }
    
    public int top() {
        return stac.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
