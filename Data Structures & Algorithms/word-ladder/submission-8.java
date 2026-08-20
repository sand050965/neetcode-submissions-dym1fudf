class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adj = new HashMap<>();
        Set<String> visit = new HashSet<>();
        Queue<String> dq = new ArrayDeque<>();
        int result = 0;

        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        dq.offer(beginWord);

        while (!dq.isEmpty()) {
            result++;
            for (int i = dq.size(); i > 0; i--) {
                String word = dq.poll();

                if (word.equals(endWord)) {
                    return result;
                }

                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    if (visit.contains(pattern)) {
                        continue;
                    }

                    for (String nei : adj.get(pattern)) {
                        dq.offer(nei);
                    }

                    visit.add(pattern);
                }
            }
        }

        return 0;
    }
}
