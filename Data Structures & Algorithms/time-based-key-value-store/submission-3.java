class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<>());
        int n = list.size();
        int l = 0, r = n - 1;
        String result = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid).getKey() <= timestamp) {
                result = list.get(mid).getValue();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
