public class Successor {

    public static void main(String[] args){
        Successor su = new Successor();
        BinNode node = su.initializeTree();
        BinNode sc = su.successor(node);
        if (sc != null)
            System.out.println(node.data + "'s successor is " + sc.data);
        else
            System.out.println("This is the last one.");
    }


    /*
    suppose there is no repeated data
     */
    public BinNode successor(BinNode node){
        if (node == null) return null;
        /*
        upwards; only one case, where the current node is a left child
         */
        BinNode sc = null;
        BinNode parent = node.parent;
        if (parent != null)
        {
            if (parent.data < node.data) {
                if (parent.parent != null)
                    if (parent.parent.data > parent.data)
                        sc = parent.parent;
            }else if(parent.data > node.data){
                sc = parent;
            }
        }

        /*
        downwards;
         */
        BinNode left = null;
        if (node.right != null){
            left = node.right;
            while (left.left != null) left = left.left;
        }
        if (sc == null) return left;
        if (left == null) return sc;
        if (sc.data > left.data) sc = left;

        return sc;
    }

    public BinNode initializeTree() {
        BinNode n1 = new BinNode(1);
        BinNode n2 = new BinNode(2);
        BinNode n3 = new BinNode(3);
        BinNode n4 = new BinNode(4);
        BinNode n5 = new BinNode(5);
        BinNode n6 = new BinNode(6);
        BinNode n7 = new BinNode(7);
        BinNode n8 = new BinNode(8);
        BinNode n9 = new BinNode(9);
        BinNode n10 = new BinNode(10);
        BinNode n11 = new BinNode(11);


        n6.setLeft(n3); n3.setParent(n6);

        n2.setLeft(n1); n1.setParent(n2);
        n3.setLeft(n2); n2.setParent(n3);
        n3.setRight(n5); n5.setParent(n3);

        n5.setLeft(n4); n4.setParent(n5);
//        n3.setLeft(n4); n4.setParent(n3);

        n6.setRight(n8); n8.setParent(n6);
        n8.setLeft(n7); n7.setParent(n8);
        n8.setRight(n9); n9.setParent(n8);
        n9.setRight(n10); n10.setParent(n9);
        n10.setRight(n11); n11.setParent(n10);


        return n11;
    }

    public static class BinNode {
        public BinNode left;
        public BinNode right;
        public BinNode parent;
        public int data;

        public BinNode() {
            left = null;
            right = null;
            parent = null;
        }
        public BinNode(int data) {
            left = null;
            right = null;
            parent = null;
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
        public void setParent(BinNode parent){
            if (parent == null) throw new AssertionError("Parent node is null");
            this.parent = parent;
        }
    }
}
