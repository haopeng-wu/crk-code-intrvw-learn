public class SortQueue {
    class Node
    {
        Node(int data){
            this.data = data;
        }
        int data;
        Node next = null;
    }
    class Stack
    {
        private Node top = null;

        void push(int data) {
            Node n = new Node(data);
            n.next = top;
            top = n;
        }

        int pop()
        {
            if(top == null)
            {
                return -1;
            }
            int data = top.data;
            top = top.next;
            return data;
        }

        int peek(){
            return top.data;
        }

        boolean isEmpty()
        {
            return top == null;
        }
    }

    Stack stack = new Stack();
    Stack tempStack = new Stack();

    int pop()
    {
        return stack.pop();
    }
    void push(int data)
    {
        while(!stack.isEmpty() && stack.peek() < data)
        {
            tempStack.push(stack.pop());
        }

        stack.push(data);

        while (!tempStack.isEmpty())
        {
            stack.push(tempStack.pop());
        }
    }
    int peek()
    {
        return stack.peek();
    }

    public static void main(String args[])
    {
        SortQueue queue = new SortQueue();
        queue.push(4);
        queue.push(3);
        queue.push(6);
        queue.push(1);
        queue.push(2);
        queue.push(5);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
