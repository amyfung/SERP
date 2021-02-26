
public class CountingThread3 extends java.lang.Thread{
    String filename;
    ByFirstLetterFreq table;

    public CountingThread3(String filename, ByFirstLetterFreq table) { 
        this.filename = filename; 
        this.table = table;
    }

    public void run(){
        table.count(filename);
    }
}