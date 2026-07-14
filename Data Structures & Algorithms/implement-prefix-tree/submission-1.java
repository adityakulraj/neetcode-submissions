class PrefixTree {


    class TrieNode {

        public TrieNode [] children;
        public boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    public PrefixTree() {
        

      root = new TrieNode();
         
    }

    public void insert(String word) {

        TrieNode start = root;

        for(char c : word.toCharArray()) {

            int i =  c - 'a';

            if(start.children[i] == null) {
                start.children[i] = new TrieNode();
            }

            start = start.children[i];
        }
        
        start.isEnd = true;

    }

    public boolean search(String word) {

        TrieNode start = root;

        for(int i=0;i<word.length(); i++) {

             int idx =  word.charAt(i) - 'a';

             TrieNode [] children = start.children;

             if(children[idx] == null)
               return false;

            start = children[idx];   
        }

        return start.isEnd;

    }

    public boolean startsWith(String prefix) {


        TrieNode start = root;

        for(int i=0;i<prefix.length(); i++) {

             int idx =  prefix.charAt(i) - 'a';

             TrieNode [] children = start.children;

             if(children[idx] == null)
               return false;

            start = children[idx];   
        }

        return true;

    }
}
