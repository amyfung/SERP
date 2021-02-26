
public class MergeFreqThread extends java.lang.Thread{
    String filename;
    MergeFreq table;

    public MergeFreqThread(String filename) { 
        this.filename = filename;
        table = new MergeFreq();
    }

    public void run(){
        table.count(filename);
    }
}
