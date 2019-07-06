class MinStack {

    private List<Integer> data = null;
    private List<Integer> mins = null;
    /** initialize your data structure here. */
    public MinStack() {
        this.data = new ArrayList<>();
        this.mins = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
        if (mins.size() == 0){
            mins.add(0);
        } else {
            int min = getMin();
            if (x < min) {
                mins.add(data.size() - 1);
            }
        }
    }

    public void pop() {
        int popIndex = data.size() - 1;
        int minIndex = mins.get(mins.size() - 1);
        if (popIndex == minIndex)
            mins.remove(mins.size() - 1);
        data.remove(data.size() - 1);
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return data.get(mins.get(mins.size() - 1));
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */