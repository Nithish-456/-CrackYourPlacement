class MyQueue {
    private Stack<Integer> en;
    private Stack<Integer> de;

    public MyQueue() {
        en=new Stack<>();
        de=new Stack<>();
        
    }
    public void push(int x) {
        while(en.size()>0){
            de.push(en.pop());
        }
        en.push(x);
        while(de.size()>0){
            en.push(de.pop());
                    }
        
    }
    public int pop() {
        return en.pop();
        
    }
    
    public int peek() {
        return en.peek();
        
    }
    
    public boolean empty() {
        return en.size()==0;
        
    }
}
