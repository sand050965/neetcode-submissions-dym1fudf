class Solution {
    Map<Character, List<Character>> adj = new HashMap<>();
    Set<Character> cycle = new HashSet<>();
    Set<Character> visit = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    public String foreignDictionary(String[] words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                adj.putIfAbsent(word.charAt(i), new ArrayList<>());
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

        return (visit.size() < adj.size()) ? "" : sb.toString();
    }

    private boolean dfs(char ch) {
        if (visit.contains(ch)) {
            return true;
        }

        if (cycle.contains(ch)) {
            return false;
        }

        cycle.add(ch);

        for (char nei : adj.get(ch)) {
            if (!dfs(nei)) {
                return false;
            }
        }

        cycle.remove(ch);
        visit.add(ch);
        sb.append(ch);

        return true;
    }
}
