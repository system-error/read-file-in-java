import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


public class ReadFile {

    private String theFile;
    private FileReader fr;
    private BufferedReader br;
    private String line;

    private HashMap<String , Country> countriesAndMedals = new HashMap<>();

    public void readTheFile()  {
        theFile = "Summer-Olympic-medals-1976-to-2008.csv";
        int counter = 0;
        String [] theColumns;
        try {
            fr = new FileReader(theFile);
            br = new BufferedReader(fr);


            while ((line = br.readLine()) != null){
                if(line.equals(",,,,,,,,,,") || line.equals("City,Year,Sport,Discipline,Event,Athlete,Gender,Country_Code,Country,Event_gender,Medal")){
//                    System.out.println(counter+ " ");
                    counter++;
                    continue;
                }else{
                    theColumns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//                    System.out.print(counter+ " ");
//                    System.out.println(theColumns[8]);

                    if(countriesAndMedals.containsKey(theColumns[8])){
                        countriesAndMedals.get(theColumns[8]).addTheMedal(theColumns[10]);
                    }else{
                        countriesAndMedals.put(theColumns[8],new Country(theColumns[8],theColumns[10]));
                    }
                    counter++;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File Not Found!");
        }catch (IOException e) {
            System.out.println("Cannot Read The file!");
        }

        for(Country theCountry: countriesAndMedals.values()){
                int gold = theCountry.getCounterGold();
                int silver = theCountry.getCounterSilver();
                int bronze = theCountry.getCounterBronze();
                System.out.println("Country: "+ theCountry.getName());
                for (String medal : theCountry.getAllTheMedals()){
                    if(gold>0 && medal.equals("Gold")){
                        System.out.println("Has won the: "+ medal + " " + gold +" "+ (gold == 1 ? "time" :"times"));
                    }else if(silver>0 && medal.equals("Silver")){
                        System.out.println("Has won the: "+ medal + " " + silver + " " + (silver == 1 ? "time" :"times"));
                    }else if(bronze>0 && medal.equals("Bronze")){
                        System.out.println("Has won the: "+ medal + " " + bronze + " " + (bronze == 1 ? "time" :"times"));
                    }
                }
            System.out.println("----------------------------------------------");
            System.out.println("Total results : "+ counter);
        }


        /*Set<String> test = countriesAndMedals.keySet();
        for (String tests: test){
            if (tests.)

        }*/

    }

}












//                    countries.add(country);

//                    medals.add(country.getMedal().toString());
//                    for(int i=0; i<medal.length; i++){
//                        if(country.getMedal().equals(medal[i])){
//                            List<String> theMedals = new ArrayList<>();
//                            theMedals.add(country.getMedal());
//                            country.addTheMedal();
//                            countriesAndMedals.put(country.getName(),country);
//                        }
//                    }