class Solution {
    public int[] plusOne(int[] digits) {
        int one = 1;
        List<Integer> result = new ArrayList<>();

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit == 9 && one == 1) {
                one = 1;
                digit = 0;
            } else {
                digit += one;
                one = 0;
            }

            result.add(0, digit);
        }
        
        if (one == 1)
            result.add(0, one);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
