package trees;


public class Node {
	// class - NODES
	/** Node for a binary tree **/
		public Object data;
		public Node l;
		public Node r;
		
		public Node (Object o) {
			this (o, null, null);
		}
		
		public Node (Object data, Node l, Node r) {
			this.data = data;
			this.l = l;
			this.r = r;
		}
		
		public String toString() {
			return data.toString();
		}

}
