class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        Map<Character, List<Character>> adj = new HashMap<>();
        int[] indegree = new int[26];
        Deque<Character> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                adj.putIfAbsent(word.charAt(i), new ArrayList<>());
            }
        }

        for (int i = 0; i < n - 1; i++) {
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
                    indegree[ch2 - 'a']++;
                    break;
                }
            }
        }

        for (char ch : adj.keySet()) {
            if (indegree[ch - 'a'] == 0) {
                dq.offer(ch);
            }
        }

        while (!dq.isEmpty()) {
            char ch = dq.poll();
            sb.append(ch);

            for (char nei : adj.get(ch)) {
                indegree[nei - 'a']--;

                if (indegree[nei - 'a'] == 0) {
                    dq.offer(nei);
                }
            }
        }

        return Arrays.stream(indegree).max().getAsInt() > 0 ? "" : sb.toString();
    }
}
