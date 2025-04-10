// Optimal approach
class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> map = new HashMap();
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node ans = map.get(key);
        delete(ans);
        add(ans);
        return ans.val;
    }

    public void delete(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    public void add(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    public void put(int key, int val) {
        if(map.containsKey(key)) {
            Node ans = map.get(key);
            delete(ans);
            add(ans);
            ans.val = val;
        }

        else {
            if(map.size() == capacity) {
                Node leastRecentlyUsed = tail.prev;
                delete(leastRecentlyUsed);
                map.remove(leastRecentlyUsed.key);
            }

            Node newNode = new Node(key, val);
            add(newNode);
            map.put(key, newNode);
        }
    }
}

// my version


// class LRUCache {
//     static int capacity;
//     static Queue<Integer> q;
//     static Map<Integer,Integer> map;
//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         q=new LinkedList<>();
//         map=new HashMap<>();
//     }
    
//     public int get(int key) {
//         if (map.containsKey(key)){
//             q.remove(key);
//             q.offer(key);
//             return map.get(key);
//         } 
//         else 
//             return -1;
//     }
    
//     public void put(int key, int value) {
//         if (map.containsKey(key)) {
//             q.remove(key);
//             q.offer(key);
//             map.put(key,value);
//         } else {
//             if(q.size() != capacity) {
//                 q.offer(key);
//             } else {
//                 map.remove(q.poll());
//                 q.offer(key);
//             }
//                 map.put(key,value);
//         }
//     }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */