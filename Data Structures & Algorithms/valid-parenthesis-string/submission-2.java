class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int minLeft = 0, maxLeft = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                minLeft++;
                maxLeft++;
            } else if (ch == ')') {
                minLeft--;
                maxLeft--;
            } else if (ch == '*') {
                minLeft--;
                maxLeft++;
            }

            if (maxLeft < 0) {
                return false;
            }

            if (minLeft < 0) {
                minLeft = 0;
            }
        }

        return minLeft == 0;
    }
}
