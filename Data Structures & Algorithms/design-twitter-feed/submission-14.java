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
        Set<Integer> followeeIds = followMap.getOrDefault(userId, new HashSet<>());
        followeeIds.add(userId);

        for (int followeeId : followeeIds) {
            List<int[]> tweets = tweetMap.getOrDefault(followeeId, new ArrayList<>());
            if (tweets.isEmpty()) {
                continue;
            }
            int[] tweet = tweets.getLast();
            maxHeap.offer(new int[] {tweet[0], followeeId, tweets.size() - 1, tweet[1]});
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
            maxHeap.offer(new int[] {nextTweet[0], followeeId, tweetIdx, nextTweet[1]});
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
