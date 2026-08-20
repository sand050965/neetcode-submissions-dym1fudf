class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;

        int m = beginWord.length();
        Deque<String> qb = new ArrayDeque<>(), qe = new ArrayDeque<>();
        Map<String, Integer> mb = new HashMap<>(), me = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        qb.offer(beginWord);
        qe.offer(endWord);
        mb.put(beginWord, 1);
        me.put(endWord, 1);

        while (!qb.isEmpty() && !qe.isEmpty()) {
            if (qb.size() > qe.size()) {
                Deque<String> tempQ = qb;
                qb = qe;
                qe = tempQ;

                Map<String, Integer> tempM = mb;
                mb = me;
                me = tempM;
            }

            for (int i = qb.size() - 1; i >= 0; i--) {
                String word = qb.poll();
                int steps = mb.get(word);

                for (int j = 0; j < m; j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (word.charAt(j) == c) continue;

                        String nei = word.substring(0, j) + c + word.substring(j + 1);

                        if (!wordSet.contains(nei)) continue;
                        if (me.containsKey(nei)) return steps + me.get(nei);
                        if (!mb.containsKey(nei)) {
                            qb.offer(nei);
                            mb.put(nei, steps + 1);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
