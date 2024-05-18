import java.util.*;

public class Template1
{
		public static void main(String args[])
		{
				SetOfStacks q = new SetOfStacks();
				q.push(6);
				q.push(7);
				q.push(8);
				q.push(5);
				q.push(4);
				q.push(3);
				q.push(2);
				q.push(1);
				q.pop();
				q.pop();
				q.pop();
				q.pop();
				q.pop();
				q.pop();
				q.pop();
				q.pop();
		}
}

class SetOfStacks
{
		private int threshold = 3;
		private int currentLength= 0;
		private Stacks currentStack;

		class Stacks
		{
				public Stacks next;
				public StackNode top;
		}

		class StackNode
		{
				public StackNode next;
				public int data;
				StackNode(int data)
				{
						this.data = data;
				}
				StackNode()
				{
				}
		}

		public void push(int data)
		{
				StackNode n = new StackNode(data);
				if (currentStack == null)
				{
						/*
						 * first node pushed into stack
						 */
						Stacks s = new Stacks();
						s.top = n;
						currentStack = s;
						currentLength = 1;
						return;
				}

				if (currentLength < threshold)
				{
						/*
						 * there is space, push into the current stack
						 */ 
						n.next = currentStack.top;
						currentStack.top = n;
						currentLength += 1;
						return;
				}
				else
				{
						/*
						 * the current stack is full. make a new stack
						 */
						Stacks s = new Stacks();
						s.next = currentStack;
						currentStack = s;
						currentStack.top = n;
						currentLength = 1;
				}
		}

		public int pop()
		{
				if (currentStack == null)
				{
						// error! empty stack
						return -1;
				}
				if (currentStack.top == null)
				{
						// the currentStack is empty, go to the next one
						currentStack = currentStack.next;
				}
				// pop
				int data = currentStack.top.data;
				currentStack.top = currentStack.top.next;
				System.out.println(data);
				return data;
		}
}

class Stack1
{
		private static int[] store =  new int[10]; 
		int top = -1;

		public int pop()
		{
				if (top == -1)
						throw new NoSuchElementException();
				top -= 1;
				return store[top+1];
		}
		public void push(int data)
		{
				store[top+1] = data;
				top += 1;
		}
		public boolean isEmpty()
		{
				return top == -1;
		}
		public int peek()
		{
				return store[top];
		}
}

class StackAndMin
{
		private static class StackNode
		{
				private int data;
				private int min;
				public StackNode next;

				public StackNode(int d)
				{
						data = d;
				}
		}

		private StackNode top;

		public int min()
		{
				if (top != null)
						return top.min;
				throw new NoSuchElementException();
		}

		public StackNode pop()
		{
				if (top != null)
				{
						StackNode n = top;
						top = top.next;
						return n;
				}
				throw new NoSuchElementException();
		}

		public void push(int item)
		{
				StackNode n = new StackNode(item);
				if (top == null)
				{
						n.min = item;
				}
				else
				{
						if (item < top.min)
						{
								n.min = item;
						}
						else
						{
								n.min = top.min;
						}
				}
				n.next = top;
				top = n;
		}

		public int peek()
		{
				if (top == null)
						throw new NoSuchElementException();
				return top.data;
		}

		public boolean isEmpty()
		{
				return top == null;
		}
}

class Stack<T>
{
}

class Queue<T>
{
		private static class QueueNode<T>
		{
				private T data;
				public QueueNode<T> next;

				public QueueNode(T d)
				{
						data = d;
				}
		}

		private QueueNode<T> first;
		private QueueNode<T> last;

		public T remove()
		{
				if (first == null)
						return null;
				T data = first.data;
				first = first.next;
				return data;
		}

		public void add(T data)
		{
				QueueNode<T> n = new QueueNode<T>(data);
				if (first == null)
				{
						first = n;
						last = n;
						return;
				}
				last.next = n;
				last = n;
		}

		public T peek()
		{
				if (first == null)
						return null;
				return first.data;
		}

		public boolean isEmpty()
		{
				return first == null;
		}
}
