import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class BSTSequences {

    public static void main(String[] args) {
//        MethodOne methodOne = new MethodOne();
//        BuildOrder.print(methodOne.run());

//        MethodTwo methodTwo = new MethodTwo();
//        BuildOrder.print(methodTwo.run().size());

        MethodThree methodThree = new MethodThree();
//        BuildOrder.print(methodThree.run());
        methodThree.run();
        BuildOrder.print(methodThree.countTriesWidth());
        methodThree.printResults();
    }

    ValidateBST.BinNode tree = null;

    BSTSequences(){
        this.tree = initializeTree();
    }

    static class MethodThree extends BSTSequences{
        private Hashtable<ValidateBST.BinNode, ArrayList<ValidateBST.BinNode>> hashtable;
        public Tries tries = null;
        MethodThree(){
            super();
            hashtable = new Hashtable<>();
        }

        public void run(){
            initChildrenHashTable();
            tries = new Tries(tree);
            build(tries, null);
        }

        void build(Tries root, Tries parent){
            /*
            add to its children
             */
            // first, add the node's children
            for(ValidateBST.BinNode child: getTreeChildren(root.data)){
                root.addChild(new Tries(child));
            }
            // second, add its siblings
            if(parent != null){
                for(Tries sibling: parent.children){
                    if(sibling == root) continue;
                    root.addChild(new Tries(sibling));
                }
            }
            /*
            recurse through every child of this node of type Tries
             */
            for( Tries child: root.children){
                build(child, root);
            }
        }

        private Stack<Integer> stack = new Stack<>();
        void printResults(){
            dfsTries(this.tries, stack);
        }

        void dfsTries(Tries node, Stack<Integer> printArray){
            if (node.children.size() == 0){
                BuildOrder.print(printArray);
            }else{
                printArray.push(node.data.data);
                for(Tries child: node.children){
                    dfsTries(child, printArray);
                }
                printArray.pop();
            }
        }

        public int countTriesWidth(){
            if (tries == null) return -1;
            count = 0;
            dfsTries(this.tries);
            return count;
        }

        private int count = 0;
        void dfsTries(Tries node){
            if (node.children.size() == 0){
                count += 1;
            }else{
                for(Tries child: node.children){
                    dfsTries(child);
                }
            }
        }


        /*
        return an arrayList of its children
         */
        ArrayList<ValidateBST.BinNode> getTreeChildren(ValidateBST.BinNode tree){
            return hashtable.get(tree);
        }

        void initChildrenHashTable(){
            dfs(tree);
        }

        void dfs(ValidateBST.BinNode tree){
            ArrayList<ValidateBST.BinNode> children = new ArrayList<>();
            if(tree.left != null){
                dfs(tree.left);
                children.add(tree.left);
            }
            if(tree.right != null){
                dfs(tree.right);
                children.add(tree.right);
            }
            hashtable.put(tree, children);
        }

        class Tries{
            public Tries parent;
            private ArrayList<Tries> children;
            public ValidateBST.BinNode data;

            public Tries(){
                parent = null;
                children = new ArrayList<>();
                data = null;
            }

            public Tries(Tries node){
                parent = null;
                children = new ArrayList<>();
                data = node.data;
            }

            public Tries(ValidateBST.BinNode tree){
                parent = null;
                children = new ArrayList<>();
                data = tree;
            }

            public void addChild(Tries child){
                this.children.add(child);
            }
            public void removeChild(Tries child){
                this.children.remove(child);
            }
        }
    }

    static class MethodTwo extends BSTSequences{

        MethodTwo(){
            super();
        }

        public ArrayList<LinkedList<ValidateBST.BinNode>> run(){
            ArrayList<LinkedList<ValidateBST.BinNode>> results = new ArrayList<>();
            allSequences(tree, results);
            return results;
        }

        void allSequences(ValidateBST.BinNode root, ArrayList<LinkedList<ValidateBST.BinNode>> results){

            if (root == null) return;

            LinkedList<ValidateBST.BinNode> prefix = new LinkedList<>();
            prefix.addLast(root);
            ArrayList<LinkedList<ValidateBST.BinNode>> rightResults = null;
            ArrayList<LinkedList<ValidateBST.BinNode>> leftResults = null;

            if (root.left == null && root.right == null){
                results.add(prefix);
                return;
            }

            if (root.left != null){
                leftResults = new ArrayList<>();
                allSequences(root.left, leftResults);
            }

            if (root.right != null){
                rightResults = new ArrayList<>();
                allSequences(root.right, rightResults);
            }

            if(root.right == null || root.left == null){
                if(root.right ==null){
                    for (LinkedList<ValidateBST.BinNode> list: leftResults){
                        list.addFirst(root);
                    }
                    results.addAll(leftResults);
                    return;
                }else{
                    for (LinkedList<ValidateBST.BinNode> list: rightResults){
                        list.addFirst(root);
                    }
                    results.addAll(rightResults);
                    return;
                }
            }

            // merge left and right
            for (LinkedList<ValidateBST.BinNode> left : leftResults){
                for (LinkedList<ValidateBST.BinNode> right : rightResults){
                    results.addAll(merge(left, right, prefix));
                }
            }
        }

        ArrayList<LinkedList<ValidateBST.BinNode>> merge(LinkedList<ValidateBST.BinNode> left,
                                                         LinkedList<ValidateBST.BinNode> right,
                                                         LinkedList<ValidateBST.BinNode> prefix)
        {
            ArrayList<LinkedList<ValidateBST.BinNode>> results = new ArrayList<>();
            if (left.isEmpty() || right.isEmpty()){
                LinkedList<ValidateBST.BinNode> result = (LinkedList<ValidateBST.BinNode>) prefix.clone();
                result.addAll(left);
                result.addAll(right);
                results.add(result);
                return results;
            }

            ValidateBST.BinNode leftFirst = left.removeFirst();
            prefix.addLast(leftFirst);
            results.addAll(merge(left, right, prefix));
            left.addFirst(leftFirst);

            prefix.removeLast();

            ValidateBST.BinNode rightFirst = right.removeFirst();
            prefix.addLast(leftFirst);
            results.addAll(merge(left, right, prefix));
            right.addFirst(rightFirst);

            prefix.removeLast();

            return results;
        }
    }

    static class MethodOne extends BSTSequences{
        MethodOne(){
            super();
        }

        public Result run(){
            return numberOfNodes(tree);
        }

        Result numberOfNodes(ValidateBST.BinNode tree) {
            if (tree == null) return null;
            int length = 1;
            int leftLength = 0;
            int rightLength = 0;
            int noCombinations = 1;
            if (tree.left != null) {
                Result leftRe = numberOfNodes(tree.left);
                leftLength += leftRe.length;
                noCombinations *= leftRe.count;
            }
            if (tree.right != null) {
                Result rightRe = numberOfNodes(tree.right);
                rightLength += rightRe.length;
                noCombinations *= rightRe.count;
            }
            length += leftLength;
            length += rightLength;
            if (leftLength >= 1 & rightLength >= 1)
                noCombinations *= merge(leftLength, rightLength + 1);
            return new Result(length, noCombinations);
        }

        /*
        @param m
        @param n = n + 1
        */
        int merge(int m, int n) {
            if (m == 1) return n;
            int sum = 0;
            while (n > 0) {
                sum += merge(m - 1, n);
                n -= 1;
            }
            return sum;
        }
    }

    class Result {
        public int length = 0;
        public int count = 0;

        Result(int length, int count) {
            this.length = length;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "length=" + length +
                    ", count=" + count +
                    '}';
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
//        n3.setLeft(n4); n4.setParent(n3);

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
