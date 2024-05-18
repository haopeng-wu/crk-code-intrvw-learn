import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class PathsWithSum {

    static public void main(String[] args){
        PathsWithSum pathsWithSum = new PathsWithSum();
        ValidateBST.BinNode root = initializeTree();

//        pathsWithSum.certainSumFromRoot(root, 0, 11);
//        pathsWithSum.toCertainSum(root, pathsWithSum.new Balance(0, null, null), 6);
//        ArrayList<ValidateBST.BinNode[]> arrayLists = new ArrayList<>();
        pathsWithSum.toCertainSum2(root, 9);
        System.out.println(pathsWithSum.getCount());
    }

    public int getCount() {
        return count;
    }

    int count = 0;
    public void toCertainSum(ValidateBST.BinNode root, int balance, int sum){
        if (root == null) return;

        System.out.println(balance+" "+root.data);
        // balance so far with current node
        if (balance + root.data == sum) count++;

        // check the left path through current node(inclusive)
        if (balance + root.data <= sum)
            toCertainSum(root.left, balance + root.data, sum);

        // check the right path through current node(inclusive)
        if (balance + root.data <= sum)
            toCertainSum(root.right, balance + root.data, sum);

        // check the left path starting from current node(exclusive)
        toCertainSum(root.left, 0, sum);

        // check the right path starting from current node(exclusive)
        toCertainSum(root.right, 0, sum);
    }
    class Balance{
        int balance;
        ValidateBST.BinNode from;
        ValidateBST.BinNode to;

        public Balance(int balance, ValidateBST.BinNode from, ValidateBST.BinNode to) {
            this.balance = balance;
            this.from = from;
            this.to = to;
        }
    }
    class Route{
        ValidateBST.BinNode from;
        ValidateBST.BinNode to;

        public Route(ValidateBST.BinNode from, ValidateBST.BinNode to) {
            this.from = from;
            this.to = to;
        }
    }
    class Paths{
        public ArrayList<Route> paths = new ArrayList<>();

        public void add(Route route){
            if (route != null && !this.contains(route)) paths.add(route);
        }

        public boolean contains(Route route){
            for( Route path: paths){
                if (path.from == route.from && path.to == route.to) return true;
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String string = "";
            string += "Paths:\n";
            for( Route route: paths){

                if (route.from != null){
                    string += route.from.data;
                }else{
                    string += "null";
                }
                string += " ";

                if (route.to != null) {
                    string += route.to.data;
                }
                else{
                    string += "null";
                }
                string += "\n";
            }
            return string;
        }
    }
    public void toCertainSum2(ValidateBST.BinNode root, int sum){
        if (root == null) return;
        toCertainSum2(root.left, sum);
        certainSumFromRoot(root, 0, sum);
        toCertainSum2(root.right, sum);
    }

    public void certainSumFromRoot(ValidateBST.BinNode root, int balance, int sum){
        if (root == null) return;

        if (balance + root.data == sum) count++;
        certainSumFromRoot(root.left, balance + root.data, sum);
        certainSumFromRoot(root.right, balance + root.data, sum);
    }

    Paths paths = new Paths();
    public void toCertainSum(ValidateBST.BinNode root, Balance balance,  int sum){
        if (root == null) return;

//        System.out.println(balance+" "+root.data);
        // balance so far with current node
        if (balance.balance + root.data == sum) {
            count++;
            paths.add(new Route(balance.from, root));
        }

        // check the left path through current node(inclusive)
        if (balance.balance + root.data <= sum)
            toCertainSum(root.left, new Balance(balance.balance + root.data, balance.from, root), sum);

        // check the right path through current node(inclusive)
        if (balance.balance + root.data <= sum)
            toCertainSum(root.right, new Balance(balance.balance + root.data, balance.from, root), sum);

        // check the left path starting from current node(exclusive)
        toCertainSum(root.left, new Balance(0, root, root), sum);

        // check the right path starting from current node(exclusive)
        toCertainSum(root.right, new Balance(0, root, root), sum);
    }


    static public ValidateBST.BinNode initializeTree() {
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
