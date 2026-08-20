class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;
    int count;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {tweetId, count++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> followeeIds = followMap.getOrDefault(userId, new HashSet<>());

        if (!followeeIds.contains(userId)) {
            followeeIds.add(userId);
        }

        for (int followeeId : followeeIds) {
            List<int[]> tweets = tweetMap.getOrDefault(followeeId, new ArrayList<>());
            for (int[] tweet : tweets) {
                minHeap.offer(tweet);

                if (minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
        }

        Stack<Integer> stack = new Stack<>();

        while (!minHeap.isEmpty()) {
            stack.push(minHeap.poll()[0]);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
