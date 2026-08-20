class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> substr = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        backtrack(s, 0, 0);

        return result;
    }

    private void backtrack(String s, int startIdx, int endIdx) {
        if (endIdx >= n) {
            if (startIdx == endIdx) {
                result.add(new ArrayList<>(substr));
            }
            return;
        }

        if (isValid(s, startIdx, endIdx)) {
            substr.add(s.substring(startIdx, endIdx + 1));
            backtrack(s, endIdx + 1, endIdx + 1);
            substr.remove(substr.size() - 1);
        }

        backtrack(s, startIdx, endIdx + 1);
    }

    private boolean isValid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
