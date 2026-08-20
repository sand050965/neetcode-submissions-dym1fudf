class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: hand)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for (int num : hand) {
            int start = num;

            while (map.getOrDefault(start - 1, 0) > 0)
                start--;
            
            while (start <= num) {
                while (map.getOrDefault(start, 0) > 0) {
                    for (int i = start; i < start + groupSize; i++) {
                        if (map.getOrDefault(i, 0) == 0)
                            return false;
                            
                        map.put(i, map.get(i) - 1);
                    }
                }
                start++;
            }
        }

        return true;
    }
}
