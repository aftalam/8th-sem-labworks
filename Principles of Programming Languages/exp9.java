//program to display 10 random questions out of 50 questions
//do not display the answers of these questions to the user

import java.io.*;
import java.util.*;

public class RandomQues {
    BufferedReader bufReader;  
    ArrayList<String> listOfLines,randLines;

    public void list() {
        listOfLines = new ArrayList<>();
        randLines = new ArrayList<>();

        try {
            bufReader = new BufferedReader(new FileReader("C:\Users\alama\Aftab7\ques.txt"));
            String line = bufReader.readLine();
            while (line != null) {
                listOfLines.add(line); 
                line = bufReader.readLine(); 
            } 
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < listOfLines.size(); i++) {
            int index = (int)(Math.random() * listOfLines.size());
            randLines.add(listOfLines.get(index));
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(randLines.get(i));
        }
    }
    
    public static void main(String[] args) {
        RandomQues rq = new RandomQues();
        rq.list();
    }
}