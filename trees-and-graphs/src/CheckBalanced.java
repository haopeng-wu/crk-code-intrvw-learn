import org.jetbrains.annotations.NotNull;

public class CheckBalanced {
    static public void main(String [] args)
    {
        // initializing the tree
        ListOfDepths lod = new ListOfDepths();
        BinNode tree = lod.initializeTree();

        // create subtree
        CheckBalanced.subTree left = new CheckBalanced.subTree(tree.left);
        CheckBalanced.subTree right = new CheckBalanced.subTree(tree.right);

        // check is balanced
        CheckBalanced cb = new CheckBalanced();
        System.out.println(cb.ifBalanced(left, right));
    }

    public boolean ifBalanced(CheckBalanced.subTree left, CheckBalanced.subTree right){
        left.setMaxHeight();
        right.setMaxHeight();

        return left.maxHeight == right.maxHeight + 1 | left.maxHeight == right.maxHeight + 1 | left.maxHeight == right.maxHeight;
    }

    private static class subTree{
        public int maxHeight = 0;
        BinNode subRoot = null;

        subTree(BinNode subTree){
            this.subRoot = subTree;
            maxHeight = 0;
        }

        public void setMaxHeight(){
            dfs(this.subRoot, 0);
        }

        private void dfs(BinNode node, int level){
            if (node == null)
                return;

            /*
            check this one
             */
            if (level > this.maxHeight)
            {
                this.maxHeight = level;
            }

            dfs(node.left, level + 1);
            dfs(node.right, level + 1);
        }
    }
}
