class Solution {
    int n;
    Map<Character, List<Character>> adj = new HashMap<>();
    Map<Character, Boolean> visit = new HashMap<>();
    List<Character> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public String foreignDictionary(String[] words) {
        n = words.length;

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                adj.putIfAbsent(ch, new ArrayList<>());
            }
        }

        for (int i = 1; i < n; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if (ch1 != ch2) {
                    adj.get(ch1).add(ch2);
                    break;
                }
            }
        }

        for (char ch : adj.keySet()) {
            if (dfs(ch)) {
                return "";
            }
        }

        Collections.reverse(result);
        for (char ch : result) {
            sb.append(ch);
        }
        
        return sb.toString();
    }

    private boolean dfs(char ch) {
        if (visit.containsKey(ch)) {
            return visit.get(ch);
        }

        visit.put(ch, true);
        for (char nei : adj.get(ch)) {
            if (dfs(nei)) {
                return true;
            }
        }
        visit.put(ch, false);
        result.add(ch);

        return false;
    }
}
