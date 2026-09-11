class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        
        int result = 1;
        Map<String, List<String>> adj = new HashMap<>();
        Set<String> visit = new HashSet<>();
        Deque<String> dq = new LinkedList<>();

        for (String word : wordList) {
            int n = word.length();
            for (int i = 0; i < n; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1, n);

                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        dq.offer(beginWord);
        visit.add(beginWord);

        while (!dq.isEmpty()) {
            for (int i = dq.size(); i > 0; i--) {
                String word = dq.poll();

                if (endWord.equals(word)) {
                    return result;
                }

                int n = word.length();

                for (int j = 0; j < n; j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1, n);

                    for (String nei : adj.getOrDefault(pattern, new ArrayList<>())) {
                        if (visit.contains(nei)) {
                            continue;
                        }
                        
                        dq.offer(nei);
                        visit.add(nei);
                    }
                }
            }

            result++;
        }

        return !visit.contains(endWord) ? 0 : result;
    }
}
