class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        Map<String, List<String>> adj = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> dq = new ArrayDeque<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = getPattern(word, i, word.length());
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        dq.offer(beginWord);
        visited.add(beginWord);

        while (!dq.isEmpty()) {
            for (int i = dq.size(); i > 0; i--) {
                String word = dq.poll();

                if (endWord.equals(word)) {
                    return result;
                }

                for (int j = 0; j < word.length(); j++) {
                    String pattern = getPattern(word, j, word.length());
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

    private String getPattern(String word, int idx, int n) {
        return word.substring(0, idx) + "*" + word.substring(idx + 1, n);
    }
}
