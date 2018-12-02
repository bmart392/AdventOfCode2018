import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class adventCode {
    public static void main(String[] args) {
        //calcCheckSum();

        ArrayList<String> allBoxIDs = importFromFile();
        /*ArrayList<String> allBoxIDs = new ArrayList<>();
        allBoxIDs.add("abcde");
        allBoxIDs.add("fghij");
        allBoxIDs.add("klmno");
        allBoxIDs.add("pqrst");
        allBoxIDs.add("fguij");
        allBoxIDs.add("axcye");
        allBoxIDs.add("wvxyz");*/
        while(allBoxIDs.size() != 0) {
            for (int j = 0; j < (allBoxIDs.size()); j++) {
                if(compareTwoStrings(allBoxIDs.get(0), allBoxIDs.get(j)) == 1){
                    System.out.println(allBoxIDs.get(0));
                    System.out.println(allBoxIDs.get(j));
                }
            }
            allBoxIDs.remove(0);
        }

    }

    public static void calcCheckSum(){
        ArrayList<String> allBoxIDs = importFromFile();
        /*ArrayList<String> allBoxIDs = new ArrayList<>();
        allBoxIDs.add("abcdef");
        allBoxIDs.add("bababc");
        allBoxIDs.add("abbcde");
        allBoxIDs.add("abcccd");
        allBoxIDs.add("aabcdd");
        allBoxIDs.add("abcdee");
        allBoxIDs.add("ababab");*/
        int numWordsWithTwoCharacters = 0;
        int numWordsWithThreeCharacters = 0;
        int i = 0;

        for (int j = 0; j < (allBoxIDs.size()); j++) {
            String currentString = allBoxIDs.get(j);


            StringBuilder tempString = new StringBuilder(currentString);
            boolean stringHasTwoOfSame = true;
            boolean stringHasThreeOfSame = true;

            boolean status = tempString.length() != 0;
            while ((status) && (stringHasThreeOfSame || stringHasTwoOfSame)) {


                char currentChar = new String(tempString).charAt(i);
                ArrayList<Integer> indecesOfChar = getNumOfChar(tempString, currentChar);

                tempString = deleteAllChar(tempString, indecesOfChar);

                int numChar = indecesOfChar.size();

                if (numChar == 2) {
                    stringHasTwoOfSame = false;
                } else if (numChar == 3) {
                    stringHasThreeOfSame = false;
                }

                status = tempString.length() != 0;
            }
            if (!stringHasThreeOfSame) {
                numWordsWithThreeCharacters++;
            }
            if (!stringHasTwoOfSame) {
                numWordsWithTwoCharacters++;
            }

        }
        System.out.println(numWordsWithThreeCharacters * numWordsWithTwoCharacters);
    }


    public static ArrayList<Integer> getNumOfChar(StringBuilder s, char c){
        ArrayList<Integer> isItThere = new ArrayList<>();
        for(int i=0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                isItThere.add(i);
            }
        }
        return isItThere;
    }

    public static StringBuilder deleteAllChar(StringBuilder s, ArrayList<Integer> indeces){
        int numDeleted = 0;
        for(int i = 0; i < indeces.size(); i++){
            s.deleteCharAt((indeces.get(i)-numDeleted));
            numDeleted++;
        }
        return s;
    }

    public static int compareTwoStrings(String s1, String s2){
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);

        int numDiffChars = 0;
        for(int h = 0; h < sb1.length(); h++){
            char sb1Char = sb1.charAt(h);
            char sb2Char = sb2.charAt(h);
            if(sb1Char != sb2Char){
                numDiffChars++;
            }
        }
        return numDiffChars;
    }


    public static ArrayList<String> importFromFile() {
        String csvFile = "C:\\Users\\Ben\\Documents\\IMPORTANT_THINGS\\WPI\\Folders by Year\\4 - Senior Year (2018 - 2019)\\B Term\\CS 3733\\AdventOfCode\\Day2\\input.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        ArrayList<String> allBoxIDs = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                allBoxIDs.add(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return allBoxIDs;
    }
}



