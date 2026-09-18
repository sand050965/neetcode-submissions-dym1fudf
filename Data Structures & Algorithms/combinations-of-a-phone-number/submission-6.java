class Solution {
    int n;
    Map<Character, String> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
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

        recurse(digits, 0);

        return result;
    }

    private void recurse(String digits, int idx) {
        if (idx >= n) {
            result.add(sb.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String characters = map.get(digit);

        for (int i = 0; i < characters.length(); i++) {
            sb.append(characters.charAt(i));
            recurse(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
