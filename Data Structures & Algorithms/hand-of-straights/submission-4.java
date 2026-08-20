class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        while (!map.isEmpty()) {
            int start = map.keySet().iterator().next();

            while (map.containsKey(start - 1)) {
                start--;
            }

            while (map.containsKey(start)) {
                for (int i = start; i < start + groupSize; i++) {
                    if (!map.containsKey(i)) {
                        return false;
                    }

                    map.put(i, map.get(i) - 1);

                    if (map.get(i) == 0) {
                        map.remove(i);
                    }
                }
            }
        }

        return true;
    }
}
