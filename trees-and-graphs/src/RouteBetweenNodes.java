import java.util.ArrayList;

public class RouteBetweenNodes {
    public static void main(String[] args){
        Graph graph = new Graph();

        Node n1 = graph.addVertex();
        Node n2 = graph.addVertex();
        Node n3 = graph.addVertex();
        Node n4 = graph.addVertex();
        Node n5 = graph.addVertex();
        Node n6 = graph.addVertex();
        Node n7 = graph.addVertex();

        graph.addEdge(n1,n5);
        graph.addEdge(n5,n4);
        graph.addEdge(n7,n5);
        graph.addEdge(n4,n2);
        graph.addEdge(n2,n7);
        graph.addEdge(n2,n3);
//        graph.addEdge(n3,n6);

        RouteBetweenNodes r = new RouteBetweenNodes();
        boolean route = r.dfsVisit(n3, n6);
        System.out.println(route);
    }

    boolean dfs(Graph graph, Node from, Node target)
    {
        ArrayList<Node> vertices = graph.vertices;
        for (Node vertex : vertices)
        {
            if(dfsVisit(vertex, target)) return true;
        }
        return false;
    }

    boolean dfsVisit(Node from, Node target)
    {
        if(from == null) return false;
        if(from.isVisited) return false;
        if(from == target){
            return true;
        }
        from.isVisited = true;
        for (Node node : from.adjacents){
            if(dfsVisit(node, target)) return true;
        }
        return false;
    }
}
