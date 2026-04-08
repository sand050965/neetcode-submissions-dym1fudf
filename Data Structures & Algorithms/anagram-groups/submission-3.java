class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] key = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                key[ch - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(key), k -> new ArrayList<>()).add(str);
        }

        for (List<String> list : map.values()) {
            result.add(list);
        }

        return result;
    }
}
