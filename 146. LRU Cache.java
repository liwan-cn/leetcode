class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre, next;
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
        public DLinkedNode(int key, int value, DLinkedNode pre, DLinkedNode next){
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }
    private int size, capacity;
    private DLinkedNode head, tail;
    private Map<Integer, DLinkedNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode temp = map.get(key);
            if (temp == tail){
                head = head.pre;
                tail = tail.pre;
            } else if (temp != head){
                temp.next.pre = temp.pre;
                temp.pre.next = temp.next;
                temp.next = head;
                temp.pre = tail;
                head.pre = temp;
                tail.next = temp;
                head = temp;
            }
            return temp.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            get(key);
            head.value = value;
            return;
        }
        if (size == capacity){
            map.remove(tail.key);
            head = head.pre;
            tail = tail.pre;
            head.key = key;
            head.value = value;
        } else {
            size ++;
            if (size == 1){
                DLinkedNode temp = new DLinkedNode(key, value);
                head = temp; tail = temp;
                head.pre = tail;
                tail.next = head;
            } else {
                DLinkedNode temp = new DLinkedNode(key, value, tail, head);
                head.pre = temp;
                tail.next = temp;
                head = temp;
            }
        }
        map.put(key, head);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */