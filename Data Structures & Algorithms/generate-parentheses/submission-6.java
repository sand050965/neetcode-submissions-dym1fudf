class Solution {
    int left = 0, right = 0;
    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recurse(n);

        return result;
    }

    private void recurse(int n) {
        if (left == n && right == n) {
            result.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            left++;
            recurse(n);
            sb.deleteCharAt(sb.length() - 1);
            left--;
        }

        if (right < left) {
            right++;
            sb.append(')');
            recurse(n);
            sb.deleteCharAt(sb.length() - 1);
            right--;
        }
    }
}
