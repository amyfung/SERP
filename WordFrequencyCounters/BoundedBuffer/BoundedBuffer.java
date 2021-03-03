import java.util.*;

public class BoundedBuffer {
    protected int numSlots; 
    private List<String> buffer;
    Boolean readingFinished = false;
 
    public BoundedBuffer(int numSlots) { 
       if(numSlots <= 0) {
          throw new IllegalArgumentException("numSlots <= 0");
       } 
       this.numSlots = numSlots; 
       buffer = new ArrayList<String>(numSlots);
    }
  
      /**
       * produce an item in the bounded buffer.  Block if full.
       * @param word the thing to add to the rear of the buffer
       * @throws InterruptedException
       */
    public synchronized void produce(String word) throws InterruptedException {
      //synchronized(buffer){
         while (buffer.size() == numSlots) {
            wait();
            System.out.println("Producer got notification from consumer");
         }
         buffer.add(word);
         notifyAll();
      //} 
    }
 
      /** 
       * Remove an item from a bounded buffer.  Block if empty
       * @return the item removed
       * @throws InterruptedException
       */
    public synchronized String consume() throws InterruptedException {
      notifyAll();
      while (buffer.size() == 0 || !readingFinished) {
         wait();
      }
       
      String word = buffer.get(0);
      buffer.remove(word);
      return word;
    }
 }