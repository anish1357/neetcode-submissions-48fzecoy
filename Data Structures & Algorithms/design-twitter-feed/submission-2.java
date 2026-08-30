class Twitter {
    public record Tweet(int tweetId, int time){};
    public int time ;
    Map<Integer,Set<Integer>> following;
    Map<Integer, List<Tweet>> tweets;
    PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> a.time-b.time);
    public Twitter() {
        time = 0;
        this.following = new HashMap<>();
        this.tweets = new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        tweets.computeIfAbsent(userId, k -> new ArrayList()).add(new Tweet(tweetId, time));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet>  entireFeed = new ArrayList<>();
        entireFeed.addAll(tweets.getOrDefault(userId, new ArrayList<>()));
        Set<Integer> followingList = following.getOrDefault(userId, new HashSet<>());
        for(Integer following : followingList){
            entireFeed.addAll(tweets.getOrDefault(following, new ArrayList<>()));
        }
        for( Tweet post :  entireFeed){
            if(pq.size() < 10){
                pq.offer(post);
            }else {
                if(post.time > pq.peek().time){
                    pq.poll();
                    pq.offer(post);
                }
            }
        }
        List<Integer> newsFeed = new ArrayList<>();
        Set<Integer> uniqueNews = new HashSet<>();
        while(!pq.isEmpty()){
            newsFeed.add(pq.poll().tweetId);
        }
        Collections.reverse(newsFeed);
        return newsFeed;
        }
    
    public void follow(int followerId, int followeeId) {

        following.computeIfAbsent(followerId, k -> new
        HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {

                following.computeIfPresent( followerId, (k, list) -> {
            list.remove(Integer.valueOf(followeeId));
            return list.isEmpty() ? null : list;        
            }
        );
    }
}
