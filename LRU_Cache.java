class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Integer> cache;
    private final LinkedHashSet<Integer> usage;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache = new HashMap<>();
        this.usage = new LinkedHashSet<>();
        
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }
        usage.remove(key);
        usage.add(key); // Moving the accessed key to end to show it was LRU
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            usage.remove(key);
        }else if (cache.size()>=capacity){
            int key1=usage.iterator().next();
            usage.remove(key1);
            cache.remove(key1);
        }
        cache.put(key, value);
        usage.add(key);
        
    }
}
