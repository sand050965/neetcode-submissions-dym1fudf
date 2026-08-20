class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer cnt = map.get(c);
            if (cnt == null) {
                map.put(c, 1);
                continue;
            }
            map.put(c, cnt+1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer cnt = map.get(c);
            if (cnt == null) {
                return false;
            }
            cnt-=1;
            if (cnt == 0) {
                map.remove(c);
                continue;
            }
            map.put(c, cnt);
        }

        return map.size() == 0;
    }
}
