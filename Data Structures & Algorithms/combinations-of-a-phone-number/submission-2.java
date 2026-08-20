class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Map<Character, String> map = new HashMap<>();
    int n;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }

        n = digits.length();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits, 0);

        return result;
    }

    private void backtrack(String digits, int idx) {
        if (idx >= n) {
            result.add(sb.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String characters = map.get(digit);
        for (int i = 0; i < characters.length(); i++) {
            char ch = characters.charAt(i);
            sb.append(ch);
            backtrack(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
