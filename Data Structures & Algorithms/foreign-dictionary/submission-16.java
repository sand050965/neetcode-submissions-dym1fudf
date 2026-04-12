class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        Queue<Character> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                adj.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int l1 = word1.length();
            int l2 = word2.length();

            int minLen = Math.min(l1, l2);

            String prefix1 = word1.substring(0, minLen);
            String prefix2 = word2.substring(0, minLen);
            if (l1 > l2 && prefix1.equals(prefix2)) {
                return "";
            }

            int i1 = 0, i2 = 0;
            while (i1 < l1 && i2 < l2) {
                char ch1 = word1.charAt(i1);
                char ch2 = word2.charAt(i2);

                if (ch1 != ch2) {
                    if (!adj.get(ch1).contains(ch2)) {
                        adj.get(ch1).add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                    }

                    break;
                }

                i1++;
                i2++;
            }
        }

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                dq.offer(ch);
            }
        }

        while (!dq.isEmpty()) {
            char ch = dq.poll();
            sb.append(ch);

            for (char neiCh : adj.get(ch)) {
                indegree.put(neiCh, indegree.get(neiCh) - 1);

                if (indegree.get(neiCh) == 0) {
                    dq.offer(neiCh);
                }
            }
        }

        return (sb.length() == indegree.size()) ? sb.toString() : "";
    }
}
