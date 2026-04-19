class Solution {
    public int earliestAcq(int[][] logs, int n) {
        
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        int groupCount = n;
        UnionFind uf = new UnionFind(n);

        for(int[] log : logs) {
            int timestamp = log[0];
            int friend1 = log[1];
            int friend2 = log[2];

            if(uf.union(friend1, friend2)) {
                groupCount--;
            }

            if(groupCount == 1) {
                return timestamp;
            }
        }

        return -1;

    }
}

class UnionFind {

    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {

        this.parent = new int[n];
        this.rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

    }

    public int find(int person) {
        
        if(parent[person] != person) {
            parent[person] = find(parent[person]);
        }

        return parent[person];

    }

    public boolean union(int p1, int p2) {

        int rootP1 = find(p1);
        int rootP2 = find(p2);

        if(rootP1 == rootP2) return false;

        if(rank[rootP1] > rank[rootP2]) {
            parent[rootP2] = rootP1;
        }
        else if(rank[rootP1] < rank[rootP2]) {
            parent[rootP1] = rootP2;
        }
        else {
            parent[rootP2] = rootP1;
            rank[rootP1]++;
        }

        return true;

    }
}
