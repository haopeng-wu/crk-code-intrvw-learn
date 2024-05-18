import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinimalTre {

    public static void main(String []args){
        int arr[] =  {1,2,4,5,7,9,10,11};

        MinimalTre minimalTre = new MinimalTre();

        Node tree = minimalTre.buildTree(arr);
//        System.out.println(tree.id);
//        System.out.println(tree.adjacents.get(0).id);
//        System.out.println(tree.adjacents.get(1).id);
//        System.out.println(tree.adjacents.get(0).adjacents.get(0).id);
//        System.out.println(tree.adjacents.get(0).adjacents.get(1).id);

        ArrayList<Integer> nodes = Node.bfs(tree);
    }

    Node buildTree(int [] arr){
        int end = arr.length - 1;
        Queue<Pair> queue = new LinkedList<>();
        Node root = null;
        boolean flag = true;

        Pair pair1 = new Pair(0, end);
        queue.add(pair1);

        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            // if the pair is null continue
            if (pair == null) {
                continue;
            }

            Node node = new Node();
            if (flag){
                // the node is the root of the tree then save it to root
                root = node;
                flag = false;
            }

            // if there is a root of the current node, make a link for them
            if(pair.root != null){
                pair.root.addAdjacent(node);
            }

            // first save the mid element in the current node(root) of this tree
            int mid = (pair.start + pair.end)/2;
            node.id = mid;
//            System.out.println(mid);

            if (pair.start < pair.end)
            {
                // resolve the descendants
                //if (pair.start != mid)
                queue.add(new Pair(node, pair.start, mid));
                queue.add(new Pair(node, mid+1, pair.end));
            }
        }
        return root;
    }
}
//int arr[] =  {0,1,2,3,4,5,6,7};