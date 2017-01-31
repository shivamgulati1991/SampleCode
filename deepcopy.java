package amazon;

class RandomListNode{
	public RandomListNode(int label1) {
		// TODO Auto-generated constructor stub
		label=label1;
	}
	int label;
	RandomListNode next,random;
}
public class DeepCopy {
	public RandomListNode copyRandomList(RandomListNode head) {
		 
		if (head == null)
			return null;
	 
		RandomListNode p = head;
	 
		// copy every node and insert to list
		while (p != null) {
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
	 
		// copy random pointer for each new node
		p = head;
		while (p != null) {
			if (p.random != null)
				p.next.random = p.random.next;
			p = p.next.next;
		}
	 
		// break list to two
		p = head;
		RandomListNode newHead = head.next;
		while (p != null) {
			RandomListNode temp = p.next;
			p.next = temp.next;
			if (temp.next != null)
				temp.next = temp.next.next;
			p = p.next;
		}
	 
		return newHead;
	}
}
