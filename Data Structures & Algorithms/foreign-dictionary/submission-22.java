class Solution {
    Map<Character, List<Character>> adj = new HashMap<>();
    Set<Character> visit = new HashSet<>();
    Set<Character> cycle = new HashSet<>();
    LinkedList<Character> result = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public String foreignDictionary(String[] words) {
        int n = words.length;

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                adj.putIfAbsent(ch, new ArrayList<>());
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            String prefix1 = w1.substring(0, minLen), prefix2 = w2.substring(0, minLen);
            if (prefix1.equals(prefix2) && w1.length() > w2.length()) {
                return "";
            }

            int i1 = 0, i2 = 0;
            while (i1 < minLen && i2 < minLen) {
                char ch1 = w1.charAt(i1), ch2 = w2.charAt(i2);
                if (ch1 != ch2) {
                    adj.get(ch1).add(ch2);
                    break;
                }

                i1++;
                i2++;
            }
        }

        for (char ch : adj.keySet()) {
            if (!dfs(ch)) {
                return "";
            }
        }

        for (char ch : result) {
            sb.append(ch);
        }

        return sb.toString();
    }

    private boolean dfs(char node) {
        if (cycle.contains(node)) {
            return false;
        }

        if (visit.contains(node)) {
            return true;
        }

        cycle.add(node);

        for (char nei : adj.get(node)) {
            if (!dfs(nei)) {
                return false;
            }
        }

        cycle.remove(node);
        visit.add(node);
        result.addFirst(node);

        return true;
    }
}
