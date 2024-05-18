class QueueOfStack {
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
        int pop(){
            if(top == null)
            {
                return -1;
            }
            int data = top.data;
            top = top.next;
            return data;
        }

        boolean isEmpty()
        {
            return top == null;
        }
    }

    Stack inStack = new Stack();
    Stack outStack = new Stack();

    void in(int data){
        if (inStack.isEmpty())
        {
            shiftToOther();
        }
        inStack.push(data);
    }
    int out(){
        if (outStack.isEmpty())
        {
            shiftToOther();
        }
        return outStack.pop();
    }

    void shiftToOther()
    {
        int data;
        if (!inStack.isEmpty())
        {
            /*
            shift inStack to outStack
             */
            while(!inStack.isEmpty())
            {
                data = inStack.pop();
                outStack.push(data);
            }
        }
        else{
            if (!outStack.isEmpty())
            {
                /*
                shift outStack to inStack
                 */
                while(!outStack.isEmpty())
                {
                    data = outStack.pop();
                    inStack.push(data);
                }
            }else
            {
                /*
                both of them are empty, the whole queue is empty, do nothing
                 */
            }
        }
    }

    public static void main(String args[]){
        QueueOfStack queue = new QueueOfStack();
        queue.in(1);
        queue.in(2);
        queue.in(3);
        queue.in(4);
        queue.in(5);
        queue.in(6);
        queue.in(7);
        System.out.println(queue.out());
        System.out.println(queue.out());
        System.out.println(queue.out());
        System.out.println(queue.out());
        System.out.println(queue.out());
        System.out.println(queue.out());
        System.out.println(queue.out());
    }
}
