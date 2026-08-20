class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();    
        for (String str : strs) {
            int len = str.length();
            sb.append(len).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        int l = 0, r = 0;
        List<String> result = new ArrayList<>();

        while (r < n) {
            while (str.charAt(r) != '#') {
                r++;
            }

            int len = Integer.parseInt(str.substring(l, r));
            l = r + 1;
            r = l + len;
            result.add(str.substring(l, r));
            l = r;
        }

        return result;
    }
}
