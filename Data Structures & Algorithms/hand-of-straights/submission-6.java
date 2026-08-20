class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int h : hand) {
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }


        
        while (!freq.isEmpty()) {
            int min = freq.keySet().iterator().next();
            while (freq.containsKey(min - 1)) {
                min--;
            }

            for (int i = min; i < min + groupSize; i++) {
                if (!freq.containsKey(i)) {
                    return false;
                }

                freq.put(i, freq.get(i) - 1);

                if (freq.get(i) == 0) {
                    freq.remove(i);
                }
            }
        }

        return true;
    }
}
