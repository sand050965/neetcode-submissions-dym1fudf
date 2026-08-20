class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length < 2)
            return false;

        int[] orderArr = new int[26];
        for (int i = 0; i < 26; i++)
            orderArr[order.charAt(i) - 'a'] = i;
        
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            for (int j = 0; j < curr.length(); j++) {
                if (j >= next.length())
                    return false;

                if (curr.charAt(j) != next.charAt(j)) {
                    int currOrder = orderArr[curr.charAt(j) - 'a'];
                    int nextOrder = orderArr[next.charAt(j) - 'a'];
                    if (currOrder > nextOrder)
                        return false;

                    break;
                }
            }
        }

        return true;
    }
}