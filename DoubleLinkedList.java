class Node {
    int data;
    Node next;
    Node prev;
};

class LinkedList {
  Node head;
  
  LinkedList(){
    head = null;
  }
  
  void push_Last(int newElement) {
    Node newNode = new Node();
    newNode.data = newElement;
    newNode.next = null;
    newNode.prev = null; 
    if(head == null) {
      head = newNode;
    } else {
      Node temp = new Node();
      temp = head;
      while(temp.next != null)
        temp = temp.next;
      temp.next = newNode;
      newNode.prev = temp;
    }    
  }
  
  void pop_at(int pos) {     
    if(pos < 1) {
      System.out.print("\nposition should be >= 1.");
    } else if (pos == 1 && head != null) {
      Node nodeToDelete = head;
      head = head.next;
      nodeToDelete = null;
      if (head != null)
        head.prev = null;
    } else {
      Node temp = new Node();
      temp = head;
      for(int i = 1; i < pos-1; i++) {
        if(temp != null) {
          temp = temp.next;
        }
      }
      if(temp != null && temp.next != null) {
        Node nodeToDelete = temp.next;
        temp.next = temp.next.next; 
        if(temp.next.next != null)
          temp.next.next.prev = temp.next;  
        nodeToDelete = null; 
      } else {
        System.out.print("\nThe node is already null.");
      }       
    }
  } 

  void pop_Last() {
    if(this.head != null) {
      if(this.head.next == null) {
        this.head = null;
      } else {
        Node temp = new Node();
        temp = this.head;
        while(temp.next.next != null)
          temp = temp.next;
        Node lastNode = temp.next;
        temp.next = null; 
        lastNode = null;
      }
    }
  }

  void SearchElement(int searchValue) {
    Node temp = new Node();
    temp = this.head;

    int found = 0;
    int i = 0;

    if(temp != null) {
      while(temp != null) {
        i++;
        if(temp.data == searchValue) {
          found++;
          break;
        }
        temp = temp.next;
      }
      if (found == 1) {
        System.out.println(searchValue + " is found at index = " + i +".");
      } else {
        System.out.println(searchValue + " is not found in the list");
      }
    } 
    }   

  void ShowList() {
    Node temp = new Node();
    temp = this.head;
    if(temp != null) {
      System.out.print("The list contains: ");
      while(temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
      }
      System.out.println();
    } else {
      System.out.println("The list is empty.....");
    }
  }    
};

public class DoubleLinkedList {
  public static void main(String[] args) {
    LinkedList MyList = new LinkedList();

    MyList.push_Last(10);
    MyList.push_Last(20);
    MyList.push_Last(30);
    MyList.ShowList(); 
    
    MyList.SearchElement(10);
    MyList.SearchElement(15);
    MyList.SearchElement(20);
    
    MyList.pop_at(2);
    MyList.ShowList();

    MyList.pop_at(1);
    MyList.ShowList();  
    
    MyList.pop_Last();
    MyList.ShowList(); 
    
    MyList.SearchElement(10);
  }
}