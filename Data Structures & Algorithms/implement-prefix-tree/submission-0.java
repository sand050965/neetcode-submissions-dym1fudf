class PrefixTree {
    class Node {
        Map<Character, Node> childreMap;
        boolean isEndOfWord;

        public Node() {
            childreMap = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.childreMap.containsKey(ch)) 
                curr.childreMap.put(ch, new Node());
            curr = curr.childreMap.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.childreMap.containsKey(ch))
                return false;
            curr = curr.childreMap.get(ch);
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!curr.childreMap.containsKey(ch))
                return false;
            curr = curr.childreMap.get(ch);
        }

        return true;
    }
}
