
public class CountingThread2 extends java.lang.Thread{
    String filename;
    MergeFreq table;

    public CountingThread2(String filename) { 
        this.filename = filename;
        table = new MergeFreq();
    }

    public void run(){
        table.count(filename);
    }
}
