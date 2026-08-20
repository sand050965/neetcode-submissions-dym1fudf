class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 != 0)
            return false;

        int n = s.length();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.values().contains(ch)) {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty() || !map.containsKey(ch) || !map.get(ch).equals(stack.peek()))
                return false;

            stack.pop();
        }

        return stack.isEmpty();
    }
}
