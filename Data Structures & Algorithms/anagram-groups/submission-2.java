class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int m = strs.length;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int n = str.length();
            int[] freq = new int[26];
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                freq[ch - 'a']++;
            }
            String key = Arrays.toString(freq);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
