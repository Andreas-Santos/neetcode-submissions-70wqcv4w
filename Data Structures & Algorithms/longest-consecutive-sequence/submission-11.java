class Solution {

    class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public void union(int x1, int x2) {
            int rootX1 = find(x1);
            int rootX2 = find(x2);

            if(rootX1 == rootX2) return;

            if(size[rootX1] > size[rootX2]) {
                parent[rootX2] = rootX1;
                size[rootX1] += size[rootX2];
            }
            else {
                parent[rootX1] = rootX2;
                size[rootX2] += size[rootX1];
            }
        }

        public int getMax() {
            int max = 0;
            for(int s : size) {
                max = Math.max(max, s);
            }

            return max;
        }
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, index);
                index++;
            }
        }

        UnionFind uf = new UnionFind(map.size());

        for(int num : map.keySet()) {
            if(map.containsKey(num + 1)) {
                uf.union(map.get(num), map.get(num + 1));
            }
        }

        return uf.getMax();
    }
}
