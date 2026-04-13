class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        List<Integer> result = new ArrayList<>();
        int l = 0, r = 0;
        int max = 0;
        while (r < n) {
            char ch = s.charAt(r);
            max = Math.max(max, map.get(ch));

            if (r == max) {
                result.add(r - l + 1);
                l = r + 1;
            }

            r++;
        }

        return result;
    }
}
