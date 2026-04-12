class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adj = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> dq = new ArrayDeque<>();
        wordList.add(beginWord);

        for (String word : wordList) {
            int n = word.length();
            for (int i = 0; i < n; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1, n);
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        int result = 0;
        dq.offer(beginWord);
        while (!dq.isEmpty()) {
            result++;
            for (int i = dq.size(); i > 0; i--) {
                String word = dq.poll();
                visited.add(word);

                if (word.equals(endWord)) {
                    return result;
                }

                int n = word.length();
                for (int j = 0; j < n; j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1, n);

                    for (String nei : adj.get(pattern)) {
                        if (visited.contains(nei)) {
                            continue;
                        }

                        dq.offer(nei);
                    }
                }
            }
        }

        return 0;
    }
}
