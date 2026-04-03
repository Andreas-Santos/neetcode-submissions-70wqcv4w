class TreeNode {
    int key;
    int value;
    TreeNode right;
    TreeNode left;

    public TreeNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.right = null;
        this.left = null;
    }
}

class TreeMap {
    TreeNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        TreeNode newNode = new TreeNode(key, val);

        if(root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root;
        while(true) {
            if(key < current.key) {
                if(current.left == null) {
                    current.left = newNode;
                    return;
                }

                current = current.left;
            }
            else if(key > current.key) {
                if(current.right == null) {
                    current.right = newNode;
                    return;
                }

                current = current.right;
            }
            else {
                current.value = val;
                return;
            }
        }
        
    }

    public int get(int key) {
        TreeNode current = root;

        while(current != null) {
            if(key < current.key) {
                current = current.left;
            }
            else if(key > current.key) {
                current = current.right;
            }
            else {
                return current.value;
            }
        }

        return -1;
    }

    public int getMin() {
        TreeNode current = findMin(root);

        if(current == null) return -1; 

        return current.value;
    }

    private TreeNode findMin(TreeNode node) {
        while(node != null && node.left != null) {
            node = node.left;
        }

        return node;
    }

    public int getMax() {
        TreeNode current = root;

        while(current != null && current.right != null) {
            current = current.right;
        }

        if(current == null) return -1;

        return current.value;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    public TreeNode removeHelper(TreeNode curr, int key) {
        if(curr == null) return null;

        if(key < curr.key) {
            curr.left = removeHelper(curr.left, key);
        }
        else if(key > curr.key) {
            curr.right = removeHelper(curr.right, key);
        }
        else {
            if(curr.left == null) return curr.right;

            if(curr.right == null) return curr.left;

            TreeNode minNode = findMin(curr.right);
            curr.key = minNode.key;
            curr.value = minNode.value;
            curr.right = removeHelper(curr.right, minNode.key);
        }

        return curr;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> inOrder = new ArrayList<>();

        inorderTraversal(root, inOrder);

        return inOrder;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root != null) {
            inorderTraversal(root.left, list);
            list.add(root.key);
            inorderTraversal(root.right, list);
        }
    }
}
