class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<Integer, String> pair = new Pair<>(timestamp, value);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(pair);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<>());
        list.sort((a, b) -> Integer.compare(a.getKey(), b.getKey()));

        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid).getKey() > timestamp) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return (l == 0) ? "" : list.get(l - 1).getValue();
    }
}
