class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // nodes 1 to N
        // n-1 edges
        // no cycles

        UnionFind uf = new UnionFind(edges.length + 1);

        for(int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];

            if(!uf.union(a, b)) {
                return new int[]{a, b};
            }

        }

        return new int[0];
    }
}

class UnionFind {

    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {

        this.parent = new int[n];
        this.rank = new int[n];

        for(int i = 1; i < n; i++) {
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

        if(rootA == rootB) return false;

        if(rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        }
        else if(rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        }
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        return true;

    }
}
