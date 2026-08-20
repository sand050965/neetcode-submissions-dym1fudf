class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        Queue<Character> dq = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                adj.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        for (int i = 1; i < n; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            int minLen = Math.min(w1.length(), w2.length());
            String prefix1 = w1.substring(0, minLen);
            String prefix2 = w2.substring(0, minLen);

            if (w1.length() > w2.length() && prefix1.equals(prefix2)) {
                return "";
            }

            if (prefix1.equals(prefix2)) {
                continue;
            }

            for (int j = 0; j < minLen; j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);

                if (ch1 != ch2) {
                    if (!adj.get(ch1).contains(ch2)) {
                        adj.get(ch1).add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                    }

                    break;
                }
            }
        }

        for (Character ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                dq.offer(ch);
            }
        }

        while (!dq.isEmpty()) {
            char ch = dq.poll();
            result.append(ch);

            for (char nei : adj.get(ch)) {
                indegree.put(nei, indegree.get(nei) - 1);

                if (indegree.get(nei) == 0) {
                    dq.offer(nei);
                }
            }
        }

        return result.length() == indegree.size() ? result.toString() : "";
    }
}
