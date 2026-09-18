class Solution {
    int n;
    List<String> partition = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        recurse(s, 0);

        return result;    
    }

    private void recurse(String s, int idx) {
        if (idx >= n) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!isPalindrome(s, idx, i)) {
                continue;
            }

            partition.add(s.substring(idx, i + 1));
            recurse(s, i + 1);
            partition.removeLast();
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
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
