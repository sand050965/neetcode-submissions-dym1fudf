class Solution {
    Map<Character, List<Character>> adj = new HashMap<>();
    Map<Character, Boolean> visited = new HashMap<>();
    List<Character> result = new LinkedList<>();
    public String foreignDictionary(String[] words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                adj.putIfAbsent(ch, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            String prefix1 = w1.substring(0, minLen), prefix2 = w2.substring(0, minLen);
            if (w1.length() > w2.length() && prefix1.equals(prefix2)) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                char ch1 = w1.charAt(j), ch2 = w2.charAt(j);
                if (ch1 != ch2) {
                    adj.get(ch1).add(ch2);
                    break;
                }
            }
        }

        for (char ch : adj.keySet()) {
            if (dfs(ch)) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            char ch = result.get(i);
            sb.append(ch);
        }

        return sb.toString();
    }

    private boolean dfs(char ch) {
        if (visited.containsKey(ch)) {
            return visited.get(ch);
        }

        visited.put(ch, true);

        for (char nei : adj.getOrDefault(ch, new ArrayList<>())) {
            if (dfs(nei)) {
                return true;
            }
        }
        
        result.addFirst(ch);
        visited.put(ch, false);

        return false;
    }
}
