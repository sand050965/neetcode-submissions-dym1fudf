class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) return false;

            if (!stack.isEmpty() && stack.pop() != map.get(ch)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
