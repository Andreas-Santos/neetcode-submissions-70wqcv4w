class HitCounter {
    private int[] times;
    private int[] hits;

    public HitCounter() {
        this.times = new int[300];
        this.hits = new int[300];
    }
    
    public void hit(int timestamp) {
        
        int index = timestamp % 300;

        if(times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        }
        else {
            hits[index]++;
        }

    }
    
    public int getHits(int timestamp) {
        
        int diff = timestamp - 300;
        int hitsSum = 0;
        for(int i = 0; i < 300; i++) {

            if(diff <= 0 || times[i] > diff) {
                hitsSum += hits[i];
            }

        }

        return hitsSum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
