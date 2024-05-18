import java.util.Hashtable;

public class ListOfDepths {

    static Hashtable<Integer, LinkedNode> nodeLists = new Hashtable<>();

    public static void main(String[] args) {

        ListOfDepths listOfDepths = new ListOfDepths();
        // initialize a tree
        BinNode root = listOfDepths.initializeTree();

        listOfDepths.dfs(0, root);

        listOfDepths.printNodeLists();
    }

    void printNodeLists() {
        int key = 0;
        while (nodeLists.containsKey(key)) {
            LinkedNode linkedNode = nodeLists.get(key);
            while (linkedNode != null) {
                System.out.print(linkedNode.data);
                System.out.print(' ');
                linkedNode = linkedNode.next;
            }
            key += 1;
            System.out.print('\n');
        }
    }

    public void dfs(int level, BinNode root) {
        if (nodeLists.containsKey(level)) {
            // append this new node to the linked list
            LinkedNode node = new LinkedNode();
            node.data = root.data;
            LinkedNode p = nodeLists.get(level);
            while (p.next != null){
                p = p.next;
            }
            p.next = node;
        } else {
            // create this new linked list
            LinkedNode node = new LinkedNode();
            node.data = root.data;
            nodeLists.put(level, node);
        }

        if (root.left != null) {
            dfs(level + 1, root.left);
        }
        if (root.right != null) {
            dfs(level + 1, root.right);
        }
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

        n1.setLeft(n2);
        n1.setRight(n3);

        n2.setLeft(n4);
        n2.setRight(n5);

        n3.setLeft(n6);
        n3.setRight(n7);

        n4.setLeft(n8);
        n4.setRight(n9);

        n6.setLeft(n10);
        n6.setRight(n11);


        return n1;
    }
}
