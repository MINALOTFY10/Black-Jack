package blackjack;


public class Player {
    
    private String Name;
    private int score=0;

    Card cardswithplayer[]=new Card[11];

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    

}
