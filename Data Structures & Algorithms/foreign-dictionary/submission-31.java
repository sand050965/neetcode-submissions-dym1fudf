class Solution {
    Map<Character, List<Character>> adj = new HashMap<>();
    Set<Character> visit = new HashSet<>();
    Set<Character> cycle = new HashSet<>();
    StringBuilder sb = new StringBuilder();

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
                    adj.get(ch2).add(ch1);
                    break;
                }
            }
        }

        for (char ch : adj.keySet()) {
            if (!dfs(ch)) {
                return "";
            }
        }

        return sb.toString();
    }

    private boolean dfs(char node) {
        if (visit.contains(node)) {
            return true;
        }

        if (cycle.contains(node)) {
            return false;
        }

        cycle.add(node);

        for (char nei : adj.get(node)) {
            if (!dfs(nei)) {
                return false;
            }
        }

        cycle.remove(node);
        visit.add(node);
        sb.append(node);

        return true;
    }
}
