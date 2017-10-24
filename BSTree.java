public class BSTree {

	private Node root;
	
	//constructor
	public BSTree() {
		this.root = root;
	}

	public void insert(Comparable data) {
		root = insert(data, root);
	}

	public Node insert(Comparable data, Node node) {
		//base case
		if (node == null) {
			return new Node(data);
		}
		
		if (node.data.compareTo(data) > 0) {
			node.left = insert(data, node.left);
			return node;
		} else {
			node.right = insert(data, node.right);
			return node;
		}
	}
	
	public boolean find(Comparable data) {
		if (root != null) {
			return find(data, root);
		} else {
			return false;
		}
	}
	
	public boolean find(Comparable data, Node node) {
		if(data.equals(node.data)) {
			return true;
		} else if(data.compareTo(node.data) < 0) {//is smaller //check return
			if (node.left != null) {
				return find(data, node.left);
			} else {
				return false;
			}
		} else { //is larger
			if (node.right != null) {
				return find(data, node.right);
			} else {
				return false;
			}
		}
	}
	
	public void delete(Comparable data) {
		if (root != null) {
			root = delete(data, root);
		}
	}
	
	public Node delete(Comparable data, Node node) {
	
		//base case;
		if(node == null) {
			return null;
		}
		if (node.data.compareTo(data) == 0) {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				if (node.right.left == null) {
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				} else {
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		} else if (data.compareTo(node.data) < 0) {
			node.left = delete(data, node.left);
			return node;
		} else {
			node.right = delete(data, node.right);
			return node;
		}
	}
			
	public Comparable removeSmallest(Node node) {
			if (node.left.left == null) {
				Comparable smallest = node.left.data;
				node.left = node.left.right;
				return smallest;
			} else {
				return removeSmallest(node.left);
			}
	}
	
	public String toStringInOrder() {
		if (root != null) {
			return toStringInOrder(root).trim();
		} else {
			return "";
		}
	}
	
	public String toStringInOrder(Node node) {
		if (node == null) {
			return "";
		}
		return (toStringInOrder(node.left) + " " + node.data + toStringInOrder(node.right));
	}
	
	public String toStringPreOrder() {
		if (root != null) {
			return toStringPreOrder(root).trim();
		} else {
			return "";
		}
	}
	
	public String toStringPreOrder(Node node) {

		if (node == null) {
			return "";
		}
		return (node.data + " " + toStringPreOrder(node.left) + toStringPreOrder(node.right));
	}
	
	public Node findSmallest(Node node) {
		Node temp = node;
		if (temp.right != null) {
			temp = temp.right;
			while(temp.left != null) {
				temp = temp.left;
			}
			return temp;
		} else if (temp.left != null) {
			temp = temp.left;
			while (temp.right != null) {
				temp = temp.right;
			}
		} else {
			return null;
		}
		return null;
	}
	
	public class Node {
		
		private Comparable data;
		private Node left;
		private Node right;
		
		public Node(Comparable data) {
			this.data = data;
		}
		
		public Node(Comparable data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;	
		}
	
	}

}
