import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FirstCommonAncestor {

    static public void main(String[] strings){
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

        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor(n1);
        firstCommonAncestor.run(n8, n9);
    }

    private BinNode root = null;

    Stack<BinNode> stack1 = new Stack<>();
    Stack<BinNode> stack2 = new Stack<>();

    public FirstCommonAncestor(BinNode root){
        this.root = root;
    }

    public BinNode run(BinNode node1, BinNode node2){

        setOneRouteTo(node1);
        setAnotherRouteTo(node2);

        BuildOrder.print(stack1);
        BuildOrder.print(stack2);

        BinNode ancestor = findFirstCommonAncestor();

        BuildOrder.print(ancestor.data);
        return null;
    };

    BinNode findFirstCommonAncestor(){
        BinNode ancestor = null;
        Stack<BinNode> oneRoute = new Stack<>();
        Stack<BinNode> anotherRoute = new Stack<>();

        while (!stack1.isEmpty()) oneRoute.push(stack1.pop());
        while (!stack2.isEmpty()) anotherRoute.push(stack2.pop());

        while(!oneRoute.isEmpty()){
            ancestor = oneRoute.pop();
            if (ancestor != anotherRoute.pop()) break;
        }
        return ancestor;
    }

    void setOneRouteTo(BinNode node){
        routeTo(root, node, stack1);
    }

    void setAnotherRouteTo(BinNode node){
        routeTo(root, node, stack2);
    }

    boolean routeTo(BinNode root, BinNode node, Stack<BinNode> stack){
        if (root == null) return false;
        stack.push(root);
        if (root == node){
            return true;
        }else{
            if (routeTo(root.left, node, stack)) return true;
            if (routeTo(root.right, node, stack)) return true;
            stack.pop();
            return false;
        }
    }
}
