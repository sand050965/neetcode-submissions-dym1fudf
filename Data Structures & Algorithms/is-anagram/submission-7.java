class Solution {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS != lenT) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < lenS; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < lenT; i++) {
            char ch = t.charAt(i);

            if (!map.containsKey(ch)) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        return map.isEmpty();
    }
}
