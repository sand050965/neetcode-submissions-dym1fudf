class Twitter {
    int count;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;


    public Twitter() {
        count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {tweetId, count++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Queue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        Set<Integer> followeeIds = followMap.get(userId);
        
        for (int followeeId : followeeIds) {
            if (!tweetMap.containsKey(followeeId)) {
                continue;
            }

            List<int[]> tweets = tweetMap.get(followeeId);
            int idx = tweets.size() - 1;
            int[] tweet = tweets.get(idx);
            int tweetId = tweet[0], count = tweet[1];
            maxHeap.offer(new int[] {tweetId, count, followeeId, idx});
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] curr = maxHeap.poll();
            int tweetId = curr[0], count = curr[1], followeeId = curr[2], idx = curr[3];
            result.add(tweetId);

            idx--;
            if (idx < 0) {
                continue;
            }

            int[] tweet = tweetMap.get(followeeId).get(idx);
            tweetId = tweet[0];
            count = tweet[1];
            maxHeap.offer(new int[] {tweetId, count, followeeId, idx});
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
