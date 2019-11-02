import java.io.*;
import java.util.*;

public class DuplicateRemover {

    private List stringList = new ArrayList();
    private String stringHolder = "";
    private boolean uniqueWord = true;
    private String uniqueWords[] = new String[100];
    private int counter = 0;
    private FileInputStream reader = null;
    private FileOutputStream fileByteStream = null;
    private PrintWriter outFS = null;


    public void remove(File dataFile) throws IOException {
        try{
            dataFile = new File("problem1.txt");
            reader = new FileInputStream(dataFile);
            int r = 0;
            while((r=reader.read())!=-1) {
                if(!Character.isLetter(r)){
                    stringList.add(stringHolder);
                    stringHolder = "";
                }else{
                    stringHolder += (char)r;
                }
            }

            stringHolder += (char)r;
            stringHolder = stringHolder.substring(0,stringHolder.length() - 1);
            stringList.add(stringHolder);


            int j;
            String compare = null;
            for(int i = 0; i < stringList.size(); i++){
                stringHolder = (String)stringList.get(i);
                stringHolder = stringHolder.toLowerCase();
                j = i + 1;
                uniqueWord = true;
                while(j < stringList.size()){
                    compare = (String)stringList.get(j);
                    compare = compare.toLowerCase();
                    if(stringHolder.equals(compare)){
                        stringList.remove(j);
                        uniqueWord = false;
                        continue;
                    }
                    j++;
                }
                if(uniqueWord == true){
                    uniqueWords[counter] = stringHolder;
                    counter++;
                }
            }

            String stringArr[] = new String[stringList.size()];
            stringHolder = "";
            for(int i = 0; i < stringArr.length; i++){
                stringArr[i] = (String)stringList.get(i);
                stringHolder = stringHolder + stringArr[i] + " ";
            }


        }catch(Exception IOException){
            System.out.println("file name: problem1.txt, Does not exist on local folder");
        }finally {
            reader.close();
        }


        try{
            fileByteStream = new FileOutputStream(dataFile);
            outFS = new PrintWriter(fileByteStream);
            outFS.print(stringHolder);
            outFS.flush();

        }catch (Exception IOException){
            System.out.print("Error while writing the file");
        }finally {
            fileByteStream.close();
        }



    }

    public void write(File outputFile ) throws IOException {

        try {
            outputFile = new File("unique_words.txt");
            fileByteStream = new FileOutputStream(outputFile);
            outFS = new PrintWriter(fileByteStream);
            String uniqueWordsFound = "";

            for(int i = 0; i < counter; i++){
                uniqueWordsFound = uniqueWordsFound + uniqueWords[i] + " ";
            }

            outFS.print(uniqueWordsFound);
            outFS.flush();

        }catch(Exception IOException){

        }finally{
            fileByteStream.close();
        }

    }



}
