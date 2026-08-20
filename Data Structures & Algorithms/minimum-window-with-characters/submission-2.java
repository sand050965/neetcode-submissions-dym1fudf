class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || t.length() > s.length()) 
            return "";

        Map<Character, Integer> window = new HashMap<>(), countT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }
        int have = 0, need = countT.size();
        int[] result = {-1, -1};
        int minLen = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightCh = s.charAt(right);
            window.put(rightCh, window.getOrDefault(rightCh, 0) + 1);

            if (countT.containsKey(rightCh) && window.get(rightCh) == countT.get(rightCh)) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result[0] = left;
                    result[1] = right;
                }

                char leftCh = s.charAt(left);
                window.put(leftCh, window.get(leftCh) - 1);
                left++;

                if (countT.containsKey(leftCh) && window.get(leftCh) < countT.get(leftCh)) {
                    have--;
                }
            }
        }

        return (minLen == Integer.MAX_VALUE) ?
            "" :
            s.substring(result[0], result[1] + 1);
    }
}
