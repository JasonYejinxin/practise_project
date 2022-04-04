public class Tree {

    private class TreeNode{
        private int root;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int root, TreeNode l, TreeNode r) {
            this.root = root;
            this.left = l;
            this.right = r;
        }
    }


    private int size;
    public Tree(){

    }
}
