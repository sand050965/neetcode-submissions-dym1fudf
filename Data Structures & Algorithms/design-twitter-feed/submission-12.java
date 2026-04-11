class Twitter {
    int timestamp;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        timestamp = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {tweetId, timestamp++});
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
            int[] tweet = tweets.get(tweets.size() - 1);
            int tweetId = tweet[0], tweetTimestamp = tweet[1];
            maxHeap.offer(new int[] {tweetId, tweetTimestamp, followeeId, tweets.size() - 1});
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] tweet = maxHeap.poll();
            int tweetId = tweet[0];
            int tweetTimestamp = tweet[1];
            int followeeId = tweet[2];
            int tweetIdx = tweet[3];
            result.add(tweetId);

            tweetIdx--;
            if (tweetIdx >= 0) {
                int[] nextTweet = tweetMap.get(followeeId).get(tweetIdx);
                int nextTweetId = nextTweet[0];
                int nextTweetTimestamp = nextTweet[1];
                maxHeap.offer(new int[] {nextTweetId, nextTweetTimestamp, followeeId, tweetIdx});
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
