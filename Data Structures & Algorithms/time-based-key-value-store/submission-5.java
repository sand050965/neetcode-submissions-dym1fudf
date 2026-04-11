class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair<Integer, String>> list = map.get(key);
        int idx = binarySearch(list, timestamp);

        return (idx == -1) ? "" : list.get(idx).getValue();
    }

    private int binarySearch(List<Pair<Integer, String>> list, int timestamp) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid).getKey() > timestamp) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l - 1;
    }
}
