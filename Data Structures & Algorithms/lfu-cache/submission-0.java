class LFUCache {


    class ListNode {
        int key, value, freq;
        ListNode prev,next;

        public ListNode(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = 1;
            prev = null;
            next = null;
        }
    }

    class DLL {

        ListNode left, right;
        int size;

        public DLL() {
            this.left = new ListNode(0,0, 1);
            this.right = new ListNode(0,0, 1);
            this.left.next = this.right;
            this.right.prev = this.left;
            this.size = 0;
        }

        public void pushR(ListNode node) {
            ListNode prev = this.right.prev;
            prev.next = node;
            node.prev = prev;
            node.next = this.right;
            this.right.prev = node;
            size++;
        }

        public void pop(ListNode node) {
            ListNode prev = node.prev;
            ListNode next = node.next;
            node.next = null;
            node.prev = null;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        public ListNode popLeft() {
            ListNode node = this.left.next;
            pop(node);
            return node;
        }

        public int length() {
            return size;
        }

        
    }

    int capacity;
    int lfuCount;
    Map<Integer, ListNode> nodeMap;
    Map<Integer, DLL> listMap;

    

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfuCount = 0;
        this.nodeMap = new HashMap<>();
        this.listMap = new HashMap<>();
        
    }

    public void counter(ListNode node) {

        int count = node.freq;
        listMap.get(count).pop(node);

        if(count == lfuCount && listMap.get(count).length()==0) {
            lfuCount++;
        }

        node.freq++;
        listMap.putIfAbsent(node.freq, new DLL());
        listMap.get(node.freq).pushR(node);
    }
    
    public int get(int key) {

        if(!nodeMap.containsKey(key)) {
            return -1;
        }

        ListNode n = nodeMap.get(key);
        counter(n);
        return n.value;
        
    }
    
    public void put(int key, int value) {

        if(capacity == 0)
         return;

         if(nodeMap.size() == capacity) {
            ListNode toRem = listMap.get(lfuCount).popLeft();
            nodeMap.remove(toRem.key);
         }

         ListNode node = new ListNode(key,value,1);
         nodeMap.put(key, node);
         listMap.putIfAbsent(1, new DLL());
         listMap.get(1).pushR(node);
         lfuCount = 1;
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */