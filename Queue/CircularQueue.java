package Queue;



class CircularQueue
{
   private NodeLL ref;
   private NodeLL last;

   CircularQueue()
   {
      ref = null;
      last = null;
   }
   
   public void enqueue(int in)
   {
      // put the data into a node
      NodeLL temp = new NodeLL(in);
      
      // if the queue is empty, make sure the node points to itself
      if (isEmpty())
      {
         temp.next = temp;
         ref = temp;
         last = temp;
      }
      // otherwise, insert the node at the reference point and ensure the
      // references ensure a circular structure
      else
      {
         // insert the new node at the reference point
         temp.next = ref;
         last.next = temp;
         ref = temp;
         //size++;
      }
   }

   public void rotate()
   {
      // if the queue isn't empty, shift the reference and end
      // points across by one node
      if (!isEmpty())
      {
         ref = ref.next;
         last = last.next;
      }
   }
   
   public int dequeue()
   {
      // work from the reference point
      if (!isEmpty())
      {
         // store the data to return
         int temp = ref.data;
         
         // if there is only one data item, clear the entire
         // queue structure
         if (ref.next == ref)
         {
            ref = null;
            last = null;
         }
         // otherwise, remove the node
         else
         {
            ref = ref.next;
            last.next = ref;
         }
         
         return temp;
      }
      else
         return -1;
   }

   public int peek()
   {
      if (!isEmpty())
         return ref.data;
      else
         return -1;
   }
   
   public boolean isEmpty()
   {
      return (ref == null);
   }
   
   public static void main(String[] args)
   {

      CircularQueue cq = new CircularQueue();
      
//create a circular queue


      for (int i = 1; i <= 3; i++)
      {
         cq.enqueue(i);
      }
      
//add three data items


      for (int i = 0; i < 5; i++)
      {
         cq.rotate();
         System.out.println("at: " + cq.peek());
      }
      
//rotate and print reference point data 5 times


      System.out.println("Removing ref: " +
                         cq.dequeue());
      System.out.println("Rotating...");
      cq.rotate();
      
//dequeue a piece of data and rotate


      System.out.println("Adding Latecomer");
      cq.enqueue(100);
      
//enqueue another piece of data


      for (int i = 0; i < 5; i++)
      {
         System.out.println("at: " + cq.peek());
         cq.rotate();
      }
      
//rotate and print reference point data 5 times


      System.out.println("Removing all...");
      while (!cq.isEmpty())
      {
         System.out.println("Removing " +
                            cq.dequeue());
      }
      
//empty out the queue


      for (int i = 0; i < 5; i++)
      {
         System.out.println("at: " + cq.peek());
         cq.rotate();
      }
   }
}