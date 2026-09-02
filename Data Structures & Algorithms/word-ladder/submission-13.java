class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        Map<String, List<String>> adj = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> dq = new ArrayDeque<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        dq.offer(beginWord);
        visited.add(beginWord);

        while (!dq.isEmpty()) {
            for (int i = dq.size(); i > 0; i--) {
                String word = dq.poll();

                if (word.equals(endWord)) {
                    return result;
                }

                for (int idx = 0; idx < word.length(); idx++) {
                    String pattern = word.substring(0, idx) + "*" + word.substring(idx + 1, word.length());

                    for (String nei : adj.getOrDefault(pattern, new ArrayList<>())) {
                        if (visited.contains(nei)) {
                            continue;
                        }

                        dq.offer(nei);
                        visited.add(nei);
                    }
                }
            }
            result++;
        }

        return 0;
    }
}
