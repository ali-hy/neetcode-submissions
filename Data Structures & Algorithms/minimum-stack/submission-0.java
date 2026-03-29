class MinStack {
    class Node {
        int value;
        int min;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
            this.min = next == null ? this.value : Math.min(next.min, this.value);
        }
    }

    int size = 0;
    Node top;
    
    public MinStack() {
        size = 0;
    }
    
    public void push(int val) {
        top = new Node(val, top);
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.value;
    }
    
    public int getMin() {
        return top.min;
    }
}
