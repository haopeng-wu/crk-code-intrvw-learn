import java.util.ArrayList;

public class Graph {
    ArrayList<Node> vertices = new ArrayList<>();

    public Node addVertex()
    {
        Node n = new Node();
        this.addVertex(n);
        return n;
    }

    public void addVertex(Node vertex)
    {
        if(vertex != null)
            vertices.add(vertex);
    }

    public void addEdge(Node from, Node to)
    {
        if (from != null && to != null)
        {
            from.addAdjacent(to);
        }
    }

    public void addEdge(int from, int to)
    {
        if (from <= vertices.size() && to <= vertices.size())
        {
            from -= 1;
            to -= 1;
            vertices.get(from).addAdjacent(vertices.get(to));
        }
    }
}
