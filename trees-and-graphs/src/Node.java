import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Node {
    int id;
    boolean isVisited;
    ArrayList<Node> adjacents = new ArrayList<>();

    static int counter = 1;

    Node()
    {
        this.id = counter++;
    }
    Node(int n){
        this.id = n;
    }

    public void addAdjacent(Node adjacent)
    {
        if (adjacent == null)
            return;
        adjacents.add(adjacent);
    }

    static ArrayList<Integer> bfs(Node tree){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<>();
        if (tree != null)
        {
            queue.add(tree);
        }

        Node node = null;
        int max = 40;
        int count = 0;
        while(!queue.isEmpty()){

            count += 1;
            node = queue.remove();
//            System.out.println(node.id);
            if (node == null) continue;
            arr.add(node.id);

            if(node.adjacents != null){
                if (node.adjacents.size() > 0)
                queue.add(node.adjacents.get(0));
                if (node.adjacents.size() > 1)
                queue.add(node.adjacents.get(1));
            }
        }
        return arr;
    }
}
