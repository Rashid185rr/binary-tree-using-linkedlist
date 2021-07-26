package SinglyLinkedListImp;

// importing necessary classes
import java.util.*;

// A linked list node
class ListNode {
	int data;
	ListNode next;

	ListNode(int d) {
		data = d;
		next = null;
	}
}

// A binary tree node
class Node {
	int data;
	Node left, right = null;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BST {
	ListNode head;
	Node root;

	// Function to insert a node at the beginning of
	// the Linked List
	void push(int new_data) {
		// allocate node and assign data
		ListNode new_node = new ListNode(new_data);

		// link the old list off the new node
		new_node.next = head;

		// move the head to point to the new node
		head = new_node;
	}

	// converts a given linked list representing a
	// complete binary tree into the linked
	// representation of binary tree.
	Node convertList2Binary(Node node) {

		Queue<Node> q = new LinkedList<Node>();

		// Base Case
		if (head == null) {
			node = null;
			return null;
		}

		//  The first node is always the root node, and
		// add it to the queue
		node = new Node(head.data);
		q.add(node);

		// advance the pointer to the next node
		head = head.next;

		// until the end of linked list is reached, do the
		// following steps
		while (head != null) {
			
			//  take the parent node from the q and
			// remove it from q
			Node parent = q.peek();
			Node pp = q.poll();

			//  take next two nodes from the linked list.
			// We will add them as children of the current
			// parent node in step 2.b. Push them into the
			// queue so that they will be parents to the
			// future nodes
			
			Node leftChild = null, rightChild = null;
			leftChild = new Node(head.data);
			q.add(leftChild);
			head = head.next;
			if (head != null) {
				rightChild = new Node(head.data);
				q.add(rightChild);
				head = head.next;
			}

			//  assign the left and right children of
			// parent
			parent.left = leftChild;
			parent.right = rightChild;
		}

		return node;
	}

	// Utility function to traverse the binary tree
	// after conversion
	
	void inorderTraversal(Node node) {
		if (node != null) {
			inorderTraversal(node.left);
			System.out.print(node.data + " ");
			inorderTraversal(node.right);
		}
	}

	        //visit left nodes
			//then visit root node
			//and then right nodes
	
	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			preorderTraverseTree(focusNode.left);

			// Visit the currently focused on node

			System.out.print(focusNode.data + " ");

			// Traverse the right node

			preorderTraverseTree(focusNode.right);

		}

	}
	        //visit root
			//then left nodes
			//and then right nodes
	
	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.print(focusNode.data + " ");

			preorderTraverseTree(focusNode.left);
			preorderTraverseTree(focusNode.right);

		}

	}
	        //visit left nodes
			//then visit right nodes
			//and then visit root node
	
	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			preorderTraverseTree(focusNode.left);
			preorderTraverseTree(focusNode.right);

			System.out.print(focusNode.data + " ");

		}

	}

	// Driver program to test above functions
	
	public static void main(String[] args) {
		BST tree = new BST();
		tree.push(2); /* Last node of Linked List */
		tree.push(3);
		tree.push(11);
		tree.push(16);
		tree.push(19);
		tree.push(21);
		tree.push(40); /* First node of Linked List */
		Node node = tree.convertList2Binary(tree.root);

		System.out.println("\n Inorder Traversal of the" + " constructed Binary Tree is:");
		tree.inorderTraversal(node);

		System.out.println("\n Post order Traversal of the" + " constructed Binary Tree is:");
		tree.postOrderTraverseTree(node);

		System.out.println("\n Pre Order order Traversal of the" + " constructed Binary Tree is:");
		tree.preorderTraverseTree(node);
	}
}
