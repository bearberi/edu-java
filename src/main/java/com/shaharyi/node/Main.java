public class Main {	
	
	public static void main(String[] args) {
		Node<Integer> check = buildList(41);
		josephus(check,41,2);
	}
	
	
	public static Node<Integer> buildList(int n) {
		Node<Integer> h = new Node<Integer>(-1);
		Node<Integer> p = h;
		Node<Integer> x = null;
		for (int i = 1; i <= n; i++) {
			x = new Node<Integer>(i);
			p.setNext(x);
			p = p.getNext();
		}
		x.setNext(h.getNext());
		return h.getNext();
	}
	
	public static Node<Integer> delSingle(Node<Integer> h, int target) {
		h = new Node<Integer>(-1, h);
		Node<Integer> p = h;
		boolean done = false;
		while (!done && p.hasNext()) {
			if (p.getNext().getValue() == target) {
				p.setNext(p.getNext().getNext());
				done = true;
			} else {
				p = p.getNext();
			}
		}
		return h.getNext();
	}
	
	public static void josephus(Node<Integer> p, int n, int m) {
		Node <Integer> cur = p;
		Node <Integer> prev = null;
		while(n>1) {
			for(int i=0; m>i; i++) {
				prev = cur;
				cur = cur.getNext();
			}
			prev.setNext(cur.getNext());
			cur = cur.getNext();
			n--;
		}
		System.out.println(cur.getValue());
	} 
}
