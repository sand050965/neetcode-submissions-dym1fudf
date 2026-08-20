class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int minOpenCnt = 0, maxOpenCnt = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                minOpenCnt++;
                maxOpenCnt++;
            } else if (ch == ')') {
                minOpenCnt--;
                maxOpenCnt--;
            } else if (ch == '*') {
                minOpenCnt--;
                maxOpenCnt++;
            }

            if (maxOpenCnt < 0) {
                return false;
            }

            if (minOpenCnt < 0) {
                minOpenCnt = 0;
            }
        }
        
        return minOpenCnt == 0;
    }
}
