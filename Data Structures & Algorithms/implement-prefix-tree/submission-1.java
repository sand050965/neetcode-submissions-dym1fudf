public class TreeNode {
        Map<Character, TreeNode> childreMap;
        boolean isEndOfWord;

        public TreeNode() {
            childreMap = new HashMap<>();
            isEndOfWord = false;
        }
    }

public class PrefixTree {
    private TreeNode root;

    public PrefixTree() {
         root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.childreMap.containsKey(ch)) 
                curr.childreMap.put(ch, new TreeNode());
            curr = curr.childreMap.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.childreMap.containsKey(ch))
                return false;
            curr = curr.childreMap.get(ch);
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!curr.childreMap.containsKey(ch))
                return false;
            curr = curr.childreMap.get(ch);
        }

        return true;
    }
}
