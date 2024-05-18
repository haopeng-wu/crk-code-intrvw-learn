public class BinNode {
    public BinNode left;
    public BinNode right;
    public int data;

    public BinNode() {
        left = null;
        right = null;
    }
    public BinNode(int data) {
        left = null;
        right = null;
        this.data = data;
    }
    public void setLeft(BinNode left){
        if (left == null) throw new AssertionError("Left node is null");
        this.left = left;
    }
    public void setRight(BinNode right){
        if (right == null) throw new AssertionError("Right node is null");
        this.right = right;
    }
}
