class TimeMap {


    class Pair {

        public int time;
        public String value;

        public Pair(int time, String val) {
            this.time = time;
            this.value = val;
        }
    }


    Map<String, List<Pair>> map;



    public TimeMap() {

        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {


        if(map.containsKey(key)) {
            List<Pair> list = map.get(key);
            list.add(new Pair(timestamp, value));
        }
        else {
            List<Pair> val = new ArrayList<>();

            map.put(key, val);
            val.add(new Pair(timestamp,value));
        }
        
    }
    
    public String get(String key, int timestamp) {

        List<Pair> ll = map.get(key);

        if(ll == null)
        return "";


        int l = 0;
        int r = ll.size() - 1;

        int mid = (l+r)/2;
        int ans = -1;


        while( l <= r) {

            mid = (l+r)/2;

            if(ll.get(mid).time <= timestamp) {
                ans = mid;
                System.out.println("timestamp: " + timestamp + " l :" + l + " : r "+ r + " :m" + mid);

                System.out.println("timestamp: " + timestamp + " l :" + l + " : r "+ r + " :m" + mid);
                l = mid + 1;  
            }

            else {
                r = mid - 1;
            }


        }

        if(ans == -1)
        return "";

        return ll.get(ans).value;
    }
}
