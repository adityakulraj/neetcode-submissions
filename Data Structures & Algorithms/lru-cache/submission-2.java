class LRUCache {


    class Node {

        public int val;
        public Node prev;
        public Node next;
        public int key;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
            this.prev = null;
            this.next = null; 
        } 
    }

    Node left;
    Node right;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {

        left = new Node(-1, -1);
        right = new Node(-1, -1);
        left.next = right;
        right.prev = left;
        this.capacity = capacity;
        map = new HashMap<>();

        
        
    }
    
    public int get(int key) {

        if(map.containsKey(key)) {

            Node n = map.get(key);
            int val = n.val;
            remove(n);
            insert(n);
        
            return val;

        }

        else return -1;

       
        
    }
    
    public void put(int key, int value) {

         if(map.containsKey(key)) {
             Node n = map.get(key);
             remove(n);
             Node n1 = new Node(key,value);
             insert(n1);
             map.put(key,n1);
        }

        else {
            Node n = new Node(key, value);
            insert(n);
            map.put(key, n);
        }

        if(map.size() > capacity) {
            Node n = remove(right.prev);
            map.remove(n.key);
            
        }   
    }


    public Node insert(Node n) {

        if(n == null)
        return null;

        Node tmp = left.next;
        left.next = n;
        n.prev = left;
        n.next = tmp;
        tmp.prev = n;

        return n;
    }

    public Node remove(Node node) {

         Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;

        return node;



    }
}
