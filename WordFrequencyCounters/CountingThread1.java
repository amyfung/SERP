
public class CountingThread1 extends java.lang.Thread{
    String filename;
    BasicThreadedFreq table;

    CountingThread1(String filename, BasicThreadedFreq table) { 
        this.filename = filename; 
        this.table = table;
    }

    public void run(){
        table.count(filename);
    }
}
