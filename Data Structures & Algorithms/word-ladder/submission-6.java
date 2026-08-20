class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adj = new HashMap<>();
        Queue<String> dq = new ArrayDeque<>();
        Set<String> visit = new HashSet<>();
        int result = 0;

        wordList.add(beginWord);        
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        dq.offer(beginWord);
        visit.add(beginWord);
        
        while (!dq.isEmpty()) {
            result++;

            for (int i = dq.size(); i > 0; i--) {
                String word = dq.poll();

                if (endWord.equals(word)) {
                    return result;
                }

                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                    for (String nei : adj.get(pattern)) {
                        if (visit.contains(nei)) {
                            continue;
                        }

                        dq.offer(nei);
                        visit.add(nei);
                    }
                }   
            }
        }

        return 0;
    }
}
