class HitCounter {
    Queue<Integer> hits;

    public HitCounter() {
        this.hits = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        hits.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        
        if(timestamp <= 300) {
            return hits.size();
        }

        int time = timestamp - 300;

        while(!hits.isEmpty() && hits.peek() <= time) {
            hits.poll();
        }
        
        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
