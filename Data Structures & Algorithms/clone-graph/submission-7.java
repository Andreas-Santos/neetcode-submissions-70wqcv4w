/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()) {

            Node current = q.poll();

            for(Node neigh : current.neighbors) {

                if(!map.containsKey(neigh)) {
                    map.put(neigh, new Node(neigh.val));
                    q.add(neigh);
                }

                map.get(current).neighbors.add(map.get(neigh));
            }
        }

        return map.get(node);
    }
}