class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;

        Map<String, List<String>> adj = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> dq = new ArrayDeque<>();
        int n = wordList.size(), m = beginWord.length();
        wordList.add(beginWord);
        for (String word: wordList) {
            for (int i = 0; i < m; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        dq.offer(beginWord);
        visited.add(beginWord);
        int cnt = 1;
        while (!dq.isEmpty()) {
            for (int i = dq.size() - 1; i >= 0; i--) {
                String word = dq.poll();
                if (endWord.equals(word)) return cnt;

                for (int j = 0; j < m; j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String nei: adj.get(pattern)) {
                        if (visited.contains(nei)) continue;
                        visited.add(nei);
                        dq.offer(nei);
                    }
                }
            }
            cnt++;
        }

        return 0;
    }
}
