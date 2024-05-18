import java.util.*;

public class Template{
		public static boolean go(String s1, String s2){
				return true;
		}

		public static void main(String[] args) {
				// initializing the linked list
				/*
				head.append(2);
				head.append(7);
				head.append(3);
				head.append(8);
				head.append(5);
				head.append(6);
				head.append(4);
				head.append(7);
				head.append(1);
				head.append(5);
				*/

				Node link1 = new Node();
				Node n = null; 
				Node m = null; 
				Node p = null;

				link1.append(1);
				link1.append(2);
				link1.append(3);
				link1.append(3);
				link1.append(3);
				link1.append(3);
				link1.append(3);
				link1.append(3);
				link1.append(3);
				link1.append(3);
				link1.append(3);
				link1.append(4);
				m = link1.append(5);
				link1.append(6);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(7);
				link1.append(8);
				link1.append(9);
				n = link1.append(10);
				n.next = m;


				System.out.println();
				link1 = link1.next;
				Node start = link1;


				int x = 0;
				Node p1 = link1.next;
				Node p2 = link1.next.next;
				x += 1;
				while (p1 != p2 && p2 != null && p2.next != null)
				{
						if (p1 == p2)
						{
								break;
						}

						p1 = p1.next;
						p2 = p2.next.next;
						x += 1;
				}

				if (p2 == null || p2.next == null)
				{
						System.out.println("no loop");
						return;
				}

				int lenOfB = x;

				ReverseResult rr = link1.reverse();
				/* len(a) + len(b) + len(a) = length
				 */
				int length = rr.length;
				start = rr.node;

				/*
				 * l(a) + l(b) + l(a) - l(b) = 2*l(a)
				 * l(a) = 2*l(a)/2
				 */

				int lenOfA = (length - lenOfB)/2;
				
				p = start;

				for (int i = 0; i < lenOfA; ++i)
				{
						p = p.next;
				}
				
				
				System.out.println("loop starts at: " + Node.loopDetection(link1).data);
				System.out.println("loop starts at: " + p.data);
		}
}


class Node
{
		Node next = null;
		int data;
		boolean isHead = false;

		public static Node Head = null;
		public static int len = 0;
		public static int max;
		public static int min;

		public Node(String message)
		{
				if (message == "head")
				{
						isHead = true;
						Head = this;
				}
		}
		public Node()
		{
		}
		public Node(int d)
		{
				data = d;
		}

		static public Node loopDetection(Node n1)
		{
				Node p1 = n1, p2 = n1;
				while (p2 != null && p2.next != null)
				{
						p1 = p1.next;
						p2 = p2.next.next;
						if (p1 == p2)
						{
								break;
						}
				}
				if (p2 == null || p2.next == null)
						return null;

				p1 = n1;
				while ( p1 != p2)
				{
						p1 = p1.next;
						p2 = p2.next;
				}

				return p1;
		}

		public ReverseResult reverse()
		{
				ReverseResult rr = new ReverseResult();
				Node p = this;

				Node prev = null;
				Node next = null;
				int count = 0;
				while (p != null)
				{
						next = p.next;
						p.next = prev;
						prev = p;
						p = next;
						count += 1;
				}


				rr.node = prev;
				rr.length = count - 1;
				return rr;
		}

		static public Node intersection2(Node n1, Node n2)
		{
				int l1 = getLengthOf(n1);
				int l2 = getLengthOf(n2);
				int diff = l1 - l2;
				Node p = n1;
				Node q = n2;
				if (diff > 0)
				{
						for (int i = 0; i < diff; ++i)
						{
								p = p.next;
						}
				}
				else if (diff < 0)
				{
						for (int i = 0; i < -diff; ++i)
						{
								q = q.next;
						}
				}

				while ( p != null)
				{
						if (p.data == q.data)
						{
								if (p == q)
								{
										return p;
								}
								else
								{
										p = p.next;
										q = q.next;
										continue;
								}
						}
						else
						{
								p = p.next;
								q = q.next;
								continue;
						}
				}
				return null;
		}

		static public Node intersection(Node n1, Node n2)
		{
				Node copyOf2 = n2.copyLink();
				Node intersection = null;
				/*
				 * mark
				 */
				Node p = n1;
				while (p != null)
				{
						p.data += 1;
						p = p.next;
				}

				p = n2;
				Node c = copyOf2;
				/*
				 * check
				 */
				while (p != null)
				{
						if (p.data != c.data)
						{
								intersection = p;
								break;
						}
						p = p.next;
						c = c.next;
				}

				/*
				 * erase the marks
				 */
				p = n1;
				while (p != null)
				{
						p.data -= 1;
						p = p.next;
				}
				return intersection;
		}

		public void appendThisNode(Node node)
		{
				if (node == null)
						return;
				Node p = this;
				while (p.next != null)
				{
						p = p.next;
				}
				p.next = node;
		}

		public Node copyLink()
		{

				Node copy = new Node();
				Node p = copy;
				Node m = this;
				while (m != null)
				{
						Node _new = new Node(m.data);
						p.next = _new;
						p = p.next;
						m = m.next;
				}
				p = null;
				return copy.next;
		}


		/*
		 * revursive version
		 */
		static public boolean isPalindrome3(Node link)
		{
				if (link == null)
						return false;
				int length = getLengthOf(link);
				if (length < 1)
						return false;
				Result result = isPalindromeRe(link, length);
				return result.result;
		}

		static public Result isPalindromeRe(Node n, int length)
		{
				Result result = new Result();
				if (length == 2)
				{
						if (n.data == n.next.data)
						{
								result.result = true;
								result.node = n.next.next; 
								return result;
						}
						else
						{
								result.result = false;
								return result;
						}
				}
				if (length == 1)
				{
						result.result = true;
						result.node = n.next;
						return result;
				}

				Result formerResult = isPalindromeRe(n.next, length-2);

				if (formerResult.result == true && n.data == formerResult.node.data)
				{
						result.result = true;
						result.node = formerResult.node.next;
						return result;
				}
				else
				{
						result.result = false;
						return result;
				}
		}

		static public int getLengthOf(Node n)
		{
				int length = 0;
				Node p = n;
				while (p != null)
				{
						length += 1;
						p = p.next;
				}
				return length;
		}

		/*
		 * link is not head and contains data
		 */
		static public boolean isPalindrome2(Node link)
		{
				Node reverse = createReverseOf(link);
				Node i = link;
				Node j = reverse;
				while (i != null)
				{
						if (i.data != j.data)
								return false;
						i = i.next;
						j = j.next;
				}
				return true;
		}

		/*
		 * link is not head and contains data
		 */
		static public boolean isPalindrome(Node link)
		{
				if (link == null)
						return false;
				if (link.next == null)
						return true;
				if (link.next.next == null && link.data == link.next.data)
						return true;
				else if (link.next.next == null && link.data != link.next.data)
						return false;

				int stepCount = 1;
				Node middle = link;
				Node end = link;
				Node stack = new Node();
				while (end != null && end.next!= null)
				{
						stack = middle.copyToStack(stack);
						middle = middle.next;
						end = end.next.next;
						stepCount += 1;
				}

				stack.printLink();

				Node p = null;
				if (end == null)
				{
						// even number of nodes
						// iterate from m
						p = stack;
						while (middle != null)
						{
								if (middle.data != p.data)
								{
										return false;
								}
								middle = middle.next;
								p = p.next;
						}
						return true;
				}
				else
				{
						// odd number of nodes
						// iterate from m.next
						middle = middle.next;
						p = stack;
						while (middle != null)
						{
								if (middle.data != p.data)
								{
										return false;
								}
								middle = middle.next;
								p = p.next;
						}
						return true;
				}
		}

		public static Node createReverseOf(Node n)
		{
				Node p = n;
				Node reverse = null;
				while (p != null)
				{
						reverse = p.copyToStack(reverse);
						p = p.next;
				}
				return reverse;
		}

		/*
		 * return the first node
		 */
		public Node copyToStack(Node stack)
		{
				Node _new = new Node();
				_new.data = this.data;
				if (stack == null)
				{
						_new.next = null;
						return _new;
				}
				else
				{
						_new.next = stack;
						return _new;
				}
		}

		/*
		 * return the first node
		 */
		public Node insertToFrontOf(Node n)
		{
				if (n == null)
				{
						return this;
				}
				else
				{
						this.next = n;
						return this;
				}
		}

		static public int sumListReverse(Node list1, Node list2)
		{
				Node p = list1.next;
				int sum1 = 0;
				String s = "";
				while (p != null)
				{

						s += String.valueOf(p.data);
						p = p.next;
				}
				sum1 = Integer.valueOf(s);

				p = list2.next;
				int sum2 = 0;
				s = "";
				while (p != null)
				{

						s += String.valueOf(p.data);
						p = p.next;
				}
				sum2 = Integer.valueOf(s);

				return sum1 + sum2;
		}

		static public int sumList(Node list1, Node list2)
		{
				Node p = list1.next;
				int sum1 = 0;
				int scale = 1;
				while (p != null)
				{
						sum1 += p.data * scale;

						scale *= 10;
						p = p.next;
				}

				p = list2.next;
				int sum2 = 0;
				scale = 1;
				while (p != null)
				{
						sum2 += p.data * scale;
						scale *= 10;
						p = p.next;
				}
				return sum1 + sum2;
		}

		static public void partition(int x)
		{
				Node less = new Node();
				Node greater= new Node();

				Node p = Head.next;

				while (p!= null)
				{
						if (p.data < x)
						{
								less.append(p.data);
						}
						else
						{
								greater.append(p.data);
						}
						p = p.next;
				}

				Node l = less.next;
				Node g = greater.next;

				if (l != null)
				{
						Head.next = l;
				}

				p = Head;
				while(p.next != null)
				{
						p = p.next;
				}
				p.next = g;
		}

		public void deleteMiddleNode()
		{
				Node p = this;
				p.data = p.next.data;
				p.next = p.next.next;
		}

		static public Node kthToLast(int k)
		{
				if (len <= k)
				{
						System.out.println("error! len is not greater than k");
						System.exit(0);
				}
				int steps = 0;
				Node p = Head.next;
				Node temp = p;
				Node kth = null;
				while (p != null)
				{
						if (kth != null)
						{
								kth = kth.next;
						}
						if (kth == null && steps == k)
						{
								kth = temp;
						}
						else if (steps < k)
						{
								steps += 1;
						}
						p = p.next;
				}
				return kth;
		}

		static private void prepareForNew(Node _new)
		{
				len += 1;
				if (_new.data > max)
				{
						max = _new.data;
				}
				if (_new.data < min)
				{
						min = _new.data;
				}
				
		}

		public Node append(int d)
		{
				Node _new = new Node(d);

				Node p = this;
				while(p.next != null)
				{
						p = p.next;
				}
				p.next = _new;

				prepareForNew(_new);
				return _new;
		}

		void removeNext()
		{
				if (this.next == null)
				{
						System.out.println("removeNext error! this.next is null.");
						return;
				}
				this.next = this.next.next;
		}

		public void removeDup()
		{
				Node h = Head;

				Hashtable<Integer, String> dict = new Hashtable<Integer, String>();
				while (h.next != null)
				{
						if (dict.getOrDefault(h.next.data, "Not Found") == "Not Found")
						{
								// put it in
								dict.put(h.next.data, "exist");
								h = h.next;
						}
						else
						{
								// remove this duplicated one
								h.removeNext();
						}
				}
		}

		public void printNode()
		{
				Node p = this;
				while (p != null)
				{
						System.out.println(p);
						p = p.next;
				}
		}

		public void printLink()
		{

				if (this == Head)
				{
						Node p = this;
						while (p.next != null)
						{
								System.out.println(p.next.data);
								p = p.next;
						}
				}
				else
				{
						int count = 0;
						Node p = this;
						while (p != null && count < 15)
						{
								System.out.println(p.data);
								p = p.next;
								// count += 1;
						}
				}
		}
}

class ReverseResult
{
		int length;
		Node node;
}

class Result
{
		boolean result;
		Node node;
}
