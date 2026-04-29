class UnionFind {

    int[] rank;
    int[] parent;

    public UnionFind(int n) {
        this.rank = new int[n];
        this.parent = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }

    public boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) {
            return false;
        }

        if(rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        }
        else if(rank[rootB] > rank[rootA]) {
            parent[rootA] = rootB;
        }
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        return true;
    }
}

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        
        UnionFind uf = new UnionFind(n);

        int count = n - 1;

        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        for(int[] log : logs) {

            int timestamp = log[0];
            int a = log[1];
            int b = log[2];

            if(uf.union(a, b)) {
                count--;
            }

            if(count == 0) {
                return timestamp;
            }
        }

        return -1;
    }
}
