public class Medals {
    private String medal;
//    private int counterBronze = 0;
//    private int counterSilver = 0;
    private int counterGold = 0;


    public Medals(String medal){
        if(medal.equals("Bronze")){
            this.medal = medal;
        }
        if(medal.equals("Silver")){
            this.medal = medal;
        }
        if(medal.equals("Gold")){
            this.medal = medal;
        }
    }

    public String getMedal() {
        return medal;
    }
//    public void addBronzeMedal(){
//        counterBronze++;
//    }
//    public void addSilverMedal(){
//        counterSilver++;
//    }
    public void addGoldMedal(){
        counterGold++;
    }



}
