class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        if (n % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                stack.push(map.get(ch));
                continue;
            }

            if (stack.isEmpty() || !map.values().contains(ch) || ch != stack.peek()) {
                return false;
            }

            stack.pop();
        }

        return stack.isEmpty();
    }
}
