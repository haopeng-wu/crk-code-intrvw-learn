import java.util.Random;

/*
implement a binary search tree here
 */
public class RandomNode {
    static public void main(String[] args){
        RandomNode randomNode = new RandomNode();
        int[] array = {6, 8, 3, 9, 7, 5, 2, 10, 4, 1};
        for( int i: array){
            randomNode.insert(i);
        }
        ValidateBST validateBST = new ValidateBST();
        BuildOrder.print(validateBST.validateBST(randomNode.getRoot()));

//        randomNode.printTree();
//        System.out.println(randomNode.getNodeAt(6).data);
        System.out.println(randomNode.getRandomNode().data);
    }
    private ValidateBST.BinNode root = null;
    private int count = 0;

    public ValidateBST.BinNode getRoot() {
        return root;
    }

    public void printTree(){
        doPrintTree(this.root);
    }

    private void doPrintTree(ValidateBST.BinNode root){
        if (root==null) return;

        doPrintTree(root.left);
        System.out.print(root.data);
        doPrintTree(root.right);
    }

    public void insert(int data) {
        if (root == null) {
            ValidateBST.BinNode node = new ValidateBST.BinNode();
            node.data = data;
            this.root = node;
            this.count ++;
        } else {
            doInsert(this.root, data);
        }
    }

    public void doInsert(ValidateBST.BinNode root, int data) {
        if (root.data == data) {
            // no need to insert, already has it. quietly do nothing
            return;
        }
        if (data > root.data) {
            // insert into the right
            if (root.right != null)
                doInsert(root.right, data);
            else{
                root.right = new ValidateBST.BinNode(data);
                this.count++;
            }
        } else {
            // insert into the left
            if (root.left != null)
                doInsert(root.left, data);
            else{
                root.left = new ValidateBST.BinNode(data);
                this.count++;
            }
        }
    }

    public boolean find(int data) {
        if (root == null) return false;
        if (root.data == data) return true;
        return doFind(root, data) == null;
    }

    private FindingResult doFind(ValidateBST.BinNode root, int data) {
        if (root == null) return null;
        if (root.data == data) return new FindingResult(root, null);

        if (data > root.data) {
            if (root.right.data == data) {
                return new FindingResult(root.right, root);
            } else {
                return doFind(root.right, data);
            }
        } else {
            if (root.left.data == data) {
                return new FindingResult(root.left, root);
            } else {
                return doFind(root.left, data);
            }
        }
    }

    public void delete(int data) {
        /*
         delete the node and restructure
         */
        // find this node first
        FindingResult result = doFind(this.root, data);
        if (result == null) return;
        this.count--;

        ValidateBST.BinNode leftChildToAttach = null;
        if (result.target.left != null)
            leftChildToAttach = result.target.left;
        else
            leftChildToAttach = null;

        ValidateBST.BinNode rightChildToAttach = null;
        if (result.target.right != null)
            rightChildToAttach = result.target.right;
        else
            rightChildToAttach = null;

        // restructure by replacing it with the right child and appending the left child to the right's very left node or vice versa
        if (result.targetParent != null) {
            if (result.target.left == null && result.target.right == null) {
                // just delete it
                if (result.targetParent.left == result.target) {
                    // delete from the left
                    result.targetParent.left = null;
                } else {
                    // delete from the right
                    result.targetParent.right = null;
                }
                return;
            }
            if (result.target.left == null) {
                // let the right child take its place and that's it
                if (result.targetParent.left == result.target) {
                    // delete from the left
                    result.targetParent.left = rightChildToAttach;
                } else {
                    // delete from the right
                    result.targetParent.right = rightChildToAttach;
                }
                return;
            }
            if (result.target.right == null) {
                // let the left child take its place and that's it
                if (result.targetParent.left == result.target) {
                    // delete from the left
                    result.targetParent.left = leftChildToAttach;
                } else {
                    // delete from the right
                    result.targetParent.right = leftChildToAttach;
                }
                return;
            }

            // replacing it with the right child and appending the left child to the right's very left node
            if (result.targetParent.left == result.target) {
                // delete from the left
                result.targetParent.left = rightChildToAttach;
            } else {
                // delete from the right
                result.targetParent.right = rightChildToAttach;
            }
            // attach the left child to its leftest node
            ValidateBST.BinNode leftest = getLeftestNode(result.target.right);
            leftest.left = leftChildToAttach;
            return;
        } else {
            if (result.target.left == null && result.target.right == null) {
                this.root = null;
                return;
            }
            if (result.target.left == null) {
                // let the right child take its place and that's it
                this.root = rightChildToAttach;
                return;
            }
            if (result.target.right == null) {
                // let the left child take its place and that's it
                this.root = leftChildToAttach;
                return;
            }

            // replacing it with the right child and appending the left child to the right's very left node
            this.root = rightChildToAttach;
            // attach the left child to its leftest node
            ValidateBST.BinNode leftest = getLeftestNode(result.target.right);
            leftest.left = leftChildToAttach;
            return;
        }
    }

    private ValidateBST.BinNode getLeftestNode(ValidateBST.BinNode root) {
        if (root == null) return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    class FindingResult {
        ValidateBST.BinNode target;
        ValidateBST.BinNode targetParent;

        FindingResult(ValidateBST.BinNode target, ValidateBST.BinNode targetParent) {
            this.target = target;
            this.targetParent = targetParent;
        }
    }

    /*
    use a random variable to represent the position in an in-order traversal
     */
    public ValidateBST.BinNode getRandomNode() {
        Random random = new Random();
        int position = random.nextInt(this.count) + 1;
        GetNodeAt getNodeAt = new GetNodeAt(this.root, position);
        return getNodeAt.run();
    }

    class GetNodeAt{
        public void setPosition(int position) {
            this.position = position;
        }

        private int position;
        private final ValidateBST.BinNode root;
        private ValidateBST.BinNode target;

        GetNodeAt(ValidateBST.BinNode root, int position){
            this.root = root;
            this.position = position;
        }
        GetNodeAt(ValidateBST.BinNode root){
            this.root = root;
        }

        public ValidateBST.BinNode getTarget() {
            return target;
        }

        public ValidateBST.BinNode run() {
            this.getNodeAt(this.root);
            return this.getTarget();
        }

        boolean getNodeAt(ValidateBST.BinNode root){
            if (root == null) return false;

            if (getNodeAt(root.left)) return true;
            this.position -= 1;
            if (this.position == 0){
                this.target = root;
                return true;
            }
            return getNodeAt(root.right);
        }
    }


    private ValidateBST.BinNode initializeTree() {
        ValidateBST.BinNode n1 = new ValidateBST.BinNode(1);
        ValidateBST.BinNode n2 = new ValidateBST.BinNode(2);
        ValidateBST.BinNode n3 = new ValidateBST.BinNode(3);
        ValidateBST.BinNode n4 = new ValidateBST.BinNode(4);
        ValidateBST.BinNode n5 = new ValidateBST.BinNode(5);
        ValidateBST.BinNode n6 = new ValidateBST.BinNode(6);
        ValidateBST.BinNode n7 = new ValidateBST.BinNode(7);
        ValidateBST.BinNode n8 = new ValidateBST.BinNode(8);
        ValidateBST.BinNode n9 = new ValidateBST.BinNode(9);
        ValidateBST.BinNode n10 = new ValidateBST.BinNode(10);
        ValidateBST.BinNode n11 = new ValidateBST.BinNode(11);


        n6.setLeft(n3);
        n3.setParent(n6);

        n2.setLeft(n1);
        n1.setParent(n2);
        n3.setLeft(n2);
        n2.setParent(n3);
        n3.setRight(n5);
        n5.setParent(n3);

        n5.setLeft(n4);
        n4.setParent(n5);

        n6.setRight(n8);
        n8.setParent(n6);
        n8.setLeft(n7);
        n7.setParent(n8);
        n8.setRight(n9);
        n9.setParent(n8);
        n9.setRight(n10);
        n10.setParent(n9);
        n10.setRight(n11);
        n11.setParent(n10);


        return n6;
    }
}
