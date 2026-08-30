class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Map<Character, List<Character>> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }

        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        backtrack(digits, 0);

        return result;
    }

    private void backtrack(String digits, int idx) {
        if (idx >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        char ch = digits.charAt(idx);
        List<Character> list = map.get(ch);
        for (char c : list) {
            sb.append(c);
            backtrack(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
