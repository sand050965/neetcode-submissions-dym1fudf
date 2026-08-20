class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack <Integer> leftStack = new Stack<>();
        Stack <Integer> starStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else {
                if (leftStack.isEmpty() && starStack.isEmpty()) {
                    return false;
                }

                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else {
                    starStack.pop();
                }
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.pop() > starStack.pop()) {
                return false;
            }
        }

        return leftStack.isEmpty();
    }
}
