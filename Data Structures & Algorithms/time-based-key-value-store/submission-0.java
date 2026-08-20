class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String result = "";

        if (!map.containsKey(key)) {
            return result;
        }

        List<Pair<String, Integer>> values = map.get(key);

        if (values.size() == 0) {
            return result;
        }

        int l = 0, r = values.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (values.get(m).getValue() <= timestamp) {
                result = values.get(m).getKey();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair (K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
