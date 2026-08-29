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
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[3], a[3]));
        followMap.putIfAbsent(userId, new HashSet<>());
        Set<Integer> followeeIds = followMap.get(userId);
        followeeIds.add(userId);
        for (int followeeId : followeeIds) {
            List<int[]> tweets = tweetMap.getOrDefault(followeeId, new ArrayList<>());
            if (tweets.isEmpty()) {
                continue;
            }

            int[] tweet = tweets.getLast();
            int tweetId = tweet[0], tweetTimestamp = tweet[1], tweetIdx = tweets.size() - 1;
            maxHeap.offer(new int[] {tweetId, followeeId, tweetIdx, tweetTimestamp});
        }

        while (result.size() < 10 && !maxHeap.isEmpty()) {
            int[] tweet = maxHeap.poll();
            int tweetId = tweet[0], followeeId = tweet[1], tweetIdx = tweet[2];
            result.add(tweetId);
            
            if (tweetIdx == 0) {
                continue;
            }

            tweetIdx--;
            int[] nextTweet = tweetMap.get(followeeId).get(tweetIdx);
            int nextTweetId = nextTweet[0], nextTweetTimestamp = nextTweet[1];
            maxHeap.offer(new int[] {nextTweetId, followeeId, tweetIdx, nextTweetTimestamp});
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
