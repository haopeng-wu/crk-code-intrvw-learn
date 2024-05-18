public class CheckSubtress {

    static public void main(String[] args){
        Successor.BinNode n1 = new Successor.BinNode(1);
        Successor.BinNode n2 = new Successor.BinNode(2);
        Successor.BinNode n3 = new Successor.BinNode(3);
        Successor.BinNode n4 = new Successor.BinNode(4);
        Successor.BinNode n5 = new Successor.BinNode(5);
        Successor.BinNode n6 = new Successor.BinNode(6);
        Successor.BinNode n7 = new Successor.BinNode(7);
        Successor.BinNode n8 = new Successor.BinNode(8);
        Successor.BinNode n9 = new Successor.BinNode(9);
        Successor.BinNode n10 = new Successor.BinNode(10);
        Successor.BinNode n11 = new Successor.BinNode(11);


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

        CheckSubtress checkSubtress = new CheckSubtress();

        Successor.BinNode n20 = new Successor.BinNode(9);

        BuildOrder.print(checkSubtress.checkSubtree(n6, n20));
    }

    /*
    check if @subtree is a subtree of @root
     */
    public boolean checkSubtree(Successor.BinNode root, Successor.BinNode subtree){
        // if subtree is null, return false since it's empty
        if (subtree == null){
            return false;
        }
        // when subtree is not empty and root is empty, return false
        if (root == null){
            return false;
        }
        // if this node matches, check further whether it's identical
        if (root.data == subtree.data){
            boolean isIdentical = checkIdentical(root, subtree);
            if (isIdentical) return true;
        }
        // return true of any if subtree found in either child
        return checkSubtree(root.left, subtree) || checkSubtree(root.right, subtree);
    }

    /*
    check whether root1 and root2 are identical
     */
    public boolean checkIdentical(Successor.BinNode root1, Successor.BinNode root2){
        // identical null trees
        if (root1 == null && root2 == null){
            return true;
        }
        // only one is null means not being identical
        if (root1 == null || root2 == null) return false;

        // check whether the data matches in this level
        if (root1.data == root2.data){
            // go further
            return checkIdentical(root1.left, root2.left) && checkIdentical(root1.right, root2.right);
        }else{
            // if this level doesn't match, return false immediately
            return false;
        }
    }




}
