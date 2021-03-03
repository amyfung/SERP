
import java.util.*;
public class BoundedBufferTable {
    Hashtable<String,Integer> table = new Hashtable<String,Integer>();
    //private BoundedBuffer in;

    public void count(String word) {
        if (table.containsKey(word)) {
            //increment frequency
            int freq = (int)table.get(word);
            table.put(word, (Integer)(freq + 1));
        } else {
            table.put(word, (Integer)1);
        }
    }

    public void print() {
		System.out.println("Word Table call");
		Set<String> set = table.keySet();
		Object[] words = set.toArray();
		Arrays.sort(words);
        System.out.println("Word Table call here:" + words.length);
		for (Object s:words) {
			int freq = (int)table.get(s);
			System.out.println(s + ": " + freq);
		}
	}

    public static void main(String[] args){
        System.out.println("program starting");
        BoundedBuffer buffer = new BoundedBuffer(5);
        if (args.length < 1) {
            System.out.println("usage: WordFreq <filename>");
            System.exit(1);
        }
        //Producer first;
        BoundedBufferTable table = new BoundedBufferTable();
		
        Producer prod = new Producer(buffer, args);
        Consumer cons = new Consumer(buffer, table);
        System.out.println("param");
        prod.start();
        System.out.println("param1");
        cons.start();
        System.out.println("param2");
        try {
            prod.join();
            System.out.println("param2");
            cons.join();
        } catch (InterruptedException e) {}
        
        table.print();
    }
}
