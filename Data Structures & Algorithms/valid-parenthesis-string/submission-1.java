class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>(), star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (left.isEmpty() && star.isEmpty())
                    return false;

                if (!left.isEmpty()) {
                    left.pop();
                } else {
                    star.pop();
                }
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop())
                return false;
        }

        return left.isEmpty();
    }
}
