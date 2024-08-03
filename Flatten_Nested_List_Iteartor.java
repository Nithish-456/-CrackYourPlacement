public class NestedIterator implements Iterator<Integer> {
    List<Integer> res;
    int idx;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.res = new ArrayList<Integer>();
        for (NestedInteger item:nestedList){
            if (item.isInteger()) this.res.add(item.getInteger());
            else{
                this.res.addAll(flat(item.getList()));
                            }
        }
        this.idx=0;        
    }
    private List<Integer> flat(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<Integer>();
        for(NestedInteger item : nestedList){
            if(item.isInteger()){
                res.add(item.getInteger());
            }           
            else{
                res.addAll(flat(item.getList()));
            }
        }
        return res;
    }
    @Override
    public Integer next() {
        return res.get(this.idx++);
    }
    @Override
    public boolean hasNext() {
        return this.idx < this.res.size();        
    }
}
