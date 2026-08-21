class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int n = str.length(), idx = 0;
        StringBuilder sb = new StringBuilder();

        while (idx < n) {
            while (idx < n && str.charAt(idx) != '#') {
                sb.append(str.charAt(idx));
                idx++;
            }

            int len = Integer.parseInt(sb.toString());
            int startIdx = idx + 1;
            int endIdx = startIdx + len;
            sb.setLength(0);
            result.add(str.substring(startIdx, endIdx));
            idx = endIdx;
        }

        return result;
    }
}
