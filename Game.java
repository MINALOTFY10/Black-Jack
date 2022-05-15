package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
    
    Scanner in = new Scanner(System.in);
    
    Player playerinf[] = new Player[4];  
    
    Card cardsdeck[] = new Card[52];

    int highscore[]= new int[4];
    
    
//    s for suit // r for rank // v for value
    public void generates_card_deck(){
        int i=0;
        for(int s=0;s<=3;s++)
        {
            for(int r = 0, v = 1; r <= 12 ;r++ ,v++)
            {
                if(r >= 10)
                {
                    v = 10;
                }
                
               cardsdeck[i] = new Card(s,r,v);
                i++;
            }
        }
    }    
    
    
    public Card draw_card_randomly(){
        Random rand = new Random();
           Card card = null;
    
            while(true)
            {
                int randomchoice = rand.nextInt(51);

                card=cardsdeck[randomchoice];
                cardsdeck[randomchoice] = null;
                
                if(card != null)
                {
                    break;
                }
            }
            return card;
    }
    
    
    public void sets_info_player(){
        
        for(int i = 0; i < 3; i++)
        {
            System.out.println("Enter name of player(" + (i+1) + ") : "); 
            String n = in.next();
            
              playerinf[i] = new Player();
              playerinf[i].setName(n); 
        
                for(int j = 0; j < 2; j++)
                {
                    playerinf[i].cardswithplayer[j] = draw_card_randomly();
                    playerinf[i].setScore(playerinf[i].getScore() + playerinf[i].cardswithplayer[j].getValue());
                }
        
        }
        
            playerinf[3] = new Player();
            playerinf[3].setName("dealer");
            
            for(int i = 0; i < 2; i++)
            {
                playerinf[3].cardswithplayer[i] = draw_card_randomly();
                playerinf[3].setScore(playerinf[3].getScore() + playerinf[3].cardswithplayer[i].getValue()); 
            }
                 
    }

    int highscore3=0;
    public void updatemaxscore(){
       
        for(int i = 0; i < 4; i++)
        {    
            if(playerinf[i].getScore() > highscore[i] )
            {
                highscore[i] = playerinf[i].getScore();
            }
            if( playerinf[i].getScore() > 21){
                highscore[i]= -(i+1) ;
            }
        }   
        
//       if(playerinf[3].getScore()  > highscore && playerinf[3].getScore() <= 21)
//       {
//           highscore3++;
//           highscore = playerinf[3].getScore();
//       }
//        
//        int count=0; 
//        for(int i = 0; i < 3; i++)
//        {
//            if(playerinf[i].getScore() > 21)
//            {
//                count++;
//            }   
//        }
//        if(count == 3)
//        {
//            highscore = 0;
//        }
    }
    
}
