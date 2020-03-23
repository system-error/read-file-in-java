import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class test {


    public void read() {

        HashMap<String, Integer> countries = new HashMap<>();

        int counter = 0;
        try {
            FileReader file = new FileReader("Summer-Olympic-medals-1976-to-2008.csv");
            BufferedReader reader = new BufferedReader(file);
            String line;
            while((line = reader.readLine()) != null) {

                String [] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if(tokens[7].equals("Country_Code")) {
                    continue;
                }
                if(countries.containsKey(tokens[7])) {
                    countries.put(tokens[7], countries.get(tokens[7]) + 1);
                }
                else {
                    countries.put(tokens[7], 1);
                }
            }

            Set<String> codes = countries.keySet();
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("result.txt")));

            for (String code : codes) {
                System.out.println(code + ": " + countries.get(code));
                writer.println(code + ": " + countries.get(code));
            }
            writer.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(IOException ie) {
            System.out.println("Cannot read from file");
        }
    }

    public static void main(String[] args) {
        test f = new test();
        f.read();
    }
}
