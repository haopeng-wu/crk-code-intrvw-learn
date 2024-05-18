public class Pair{
    Pair(){
    }
    Pair(int start, int end){

        this.start = start;
        this.end = end;
    }
    Pair(Node n, int start, int end){
        this.root = n;
        this.start = start;
        this.end = end;
    }
    public int start, end;
    Node root;
}
