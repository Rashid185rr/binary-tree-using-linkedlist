package SinglyLinkedListImp;



class Singly
{
    Node head;  // head of list
 
    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    /* Inserts a new Node at front of the list. */
    public void Insert(int element)
    {
        /* 1 & 2: Allocate the Node & Put in the data*/
        Node new_node = new Node(element);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    /* Given a reference (pointer to pointer) to the head of a list
       and a position, deletes the node at the given position */
    void Remove(int position)
    {
        // If linked list is empty
        if (head == null)
            return;
 
        // Store head node
        Node temp = head;
 
        // If head needs to be removed
        if (position == 0)
        {
            head = temp.next;   // Change head
            return;
        }
 
        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;
 
        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
 
        temp.next = next;  // Unlink the deleted node from list
    
        
        System.out.println("The mentioned position : "+ position + " : Has been removed");
    }
 
    /* This function prints contents of linked list starting from
        the given node */
    public void Print()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }
 
    public int Counter() {    
        //Node current will point to head 
    	int counter=0;
        Node current = head;    
            
        if(head == null) {    
            System.out.println("List is empty");    
              
        }    
       // System.out.println("Nodes of singly linked list: ");    
        while(current != null) {    
            //Prints each node by incrementing pointer    
            System.out.print(current.data + " ");    
            current = current.next;    
            counter ++;
        }    
        System.out.println(); 
        
        return counter;
    }    
    /* Driver program to test above functions. Ideally this function
       should be in a separate user class.  It is kept here to keep
       code compact */
    public static void main(String[] args)
    {
        // Start with the empty list.
    	// Object 
        Singly singlyLinkedList = new Singly();
        
        System.out.println("Inserted data ");
        
        // inserting the data
        singlyLinkedList.Insert(185);
        singlyLinkedList.Insert(191);
        singlyLinkedList.Insert(27);
        singlyLinkedList.Insert(55);
        singlyLinkedList.Insert(67);
      
        // counting the total inserted, numbers printing it
        System.out.println("Total Inserted Values are: "+singlyLinkedList.Counter());
       
        // Removing the inserted element based on the index 3,1 will be removed
        singlyLinkedList.Remove(1);
        singlyLinkedList.Remove(3);
 
       // counting total numbers after deletion of some elements
        System.out.println("Total values are after deletion: "+singlyLinkedList.Counter());
        singlyLinkedList.Print();
        
    }
}