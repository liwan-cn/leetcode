class LRUCache {
    class BiLinkedNode{
        int key, value;
        BiLinkedNode pre = null, next = null;
        public BiLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
        public BiLinkedNode(int key, int value, BiLinkedNode pre, BiLinkedNode next){
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    private int size, capacity;
    private BiLinkedNode head, tail;
    private Map<Integer, BiLinkedNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            BiLinkedNode hit = map.get(key);
            if (hit == tail){
                head = head.pre;
                tail = tail.pre;
            } else if (hit != head){
                hit.next.pre = hit.pre;
                hit.pre.next = hit.next;
                hit.next = head; head.pre = hit;
                hit.pre = tail; tail.next = hit;
                head = hit;
            }
            return hit.value;
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
            head = head.pre; tail = tail.pre;
            head.key = key; head.value = value;
        } else {
            if (size == 0){
                BiLinkedNode add = new BiLinkedNode(key, value);
                head = add; tail = add;
                head.pre = tail; tail.next = head;
            } else {
                BiLinkedNode add = new BiLinkedNode(key, value, tail, head);
                head.pre = add; tail.next = add;
                head = add;
            }
            ++size;
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