class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;
    int cnt;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        cnt = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{cnt++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                maxHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] curr = maxHeap.poll();
            int tweetId = curr[1], followeeId = curr[2], index = curr[3];
            result.add(tweetId);
            if (index > 0) {
                int[] tweet = tweetMap.get(followeeId).get(index - 1);
                maxHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index - 1});
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}
