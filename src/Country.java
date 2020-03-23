import java.util.*;

public class Country {

    private String name;
    private String medal;
    private Set<String> medals = new HashSet<String>();
    private int counterBronze , counterSilver, counterGold = 0;

    public Country(String name,String medal){
        this.name= name;
        this.medal = medal;
        addTheMedal(medal);
    }


    public String getMedal() {
        return medal;
    }

    public String getName() {
        return name;
    }

    public void addTheMedal(String medal){
            if(medal.equals("Bronze")){
                counterBronze +=1;
                medals.add(medal);
            }
            if(medal.equals("Silver")){
                counterSilver++;
                medals.add(medal);
            }
            if(medal.equals("Gold")){
                counterGold++;
                medals.add(medal);
            }
        }

    public int getCounterBronze() {
        return counterBronze;
    }

    public int getCounterSilver() {
        return counterSilver;
    }

    public int getCounterGold() {
        return counterGold;
    }

    public Set<String> getAllTheMedals(){
        return medals;
    }
}
