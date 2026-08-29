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
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);
        Set<Integer> followeeIds = followMap.get(userId);
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[3], a[3]));

        for (int followeeId : followeeIds) {
            List<int[]> tweets = tweetMap.getOrDefault(followeeId, new ArrayList<>());
            if (tweets.isEmpty()) {
                continue;
            }

            int[] tweet = tweets.getLast();
            int tweetId = tweet[0], count = tweet[1];
            maxHeap.offer(new int[] {tweetId, followeeId, tweets.size() - 1, count});
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
            int nextTweetId = nextTweet[0], nextTweetCount = nextTweet[1];
            maxHeap.offer(new int[] {nextTweetId, followeeId, tweetIdx, nextTweetCount});
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
