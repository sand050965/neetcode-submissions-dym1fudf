class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        Deque<Character> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                adj.putIfAbsent(ch, new ArrayList<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
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
                    indegree.put(ch2, indegree.get(ch2) + 1);
                    break;
                }

                i1++;
                i2++;
            }
        }

        for (char ch : adj.keySet()) {
            if (indegree.get(ch) == 0) {
                dq.offer(ch);
            }
        }

        while (!dq.isEmpty()) {
            char ch = dq.poll();
            sb.append(ch);

            for (char nei : adj.get(ch)) {
                indegree.put(nei, indegree.get(nei) - 1);

                if (indegree.get(nei) == 0) {
                    dq.offer(nei);
                }
            }
        }

        return (sb.length() != indegree.size()) ? "" : sb.toString();
    }
}
