class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if (!map.containsKey(key)) {
            return res;
        }

        List<Pair<Integer, String>> values = map.get(key);

        int l = 0, r = values.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (values.get(mid).getKey() <= timestamp) {
                res = values.get(mid).getValue();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}
