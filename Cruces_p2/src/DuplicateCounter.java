import java.io.*;
import java.util.*;

public class DuplicateCounter {

    private FileInputStream reader = null;
    private FileOutputStream fileByteStream = null;
    private PrintWriter outFS = null;
    private String stringHolder = "";
    private Map<String, Integer> wordCounter = new HashMap<>();

    public void count(File dataFile) throws IOException {

        List stringsOnFile = new ArrayList();
        try{
            dataFile = new File("problem2.txt");
            reader = new FileInputStream(dataFile);
            int r = 0;
            while((r=reader.read())!=-1) {
                if(!Character.isLetter(r)){
                    stringsOnFile.add(stringHolder);
                    stringHolder = "";
                }else{
                    stringHolder += (char)r;
                }
            }

            stringHolder += (char)r;
            stringHolder = stringHolder.substring(0,stringHolder.length() - 1);
            stringsOnFile.add(stringHolder);

            String compare;
            int counter = 0;
            int j;
            for(int i = 0; i < stringsOnFile.size(); i++){
                stringHolder = (String)stringsOnFile.get(i);
                stringHolder = stringHolder.toLowerCase();
                j = i + 1;
                counter++;
                while(j < stringsOnFile.size()){
                    compare = (String)stringsOnFile.get(j);
                    compare = compare.toLowerCase();
                    if(stringHolder.equals(compare)){
                        stringsOnFile.remove(j);
                        counter++;
                        continue;
                    }
                    j++;
                }
                wordCounter.put(stringHolder, counter);
                counter = 0;
            }

            for (String key : wordCounter.keySet()) {
                System.out.println(key + " - " + wordCounter.get(key));
            }


        }catch (Exception e){
            System.out.println("file name: problem2.txt, Does not exist on local folder");
        }finally {
            reader.close();
        }
    }

    public void write(File outputFile ) throws IOException {

        try {
            outputFile = new File("unique_word_counts.txt");
            fileByteStream = new FileOutputStream(outputFile);
            outFS = new PrintWriter(fileByteStream);

            for (String key : wordCounter.keySet()) {
                outFS.print(key + " - " + wordCounter.get(key) + "\n");

            }
            outFS.flush();

        }catch(Exception IOException){

        }finally{
            fileByteStream.close();
        }

    }

}
