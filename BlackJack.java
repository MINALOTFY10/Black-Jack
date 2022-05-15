package blackjack;

import java.util.Scanner;


public class BlackJack {
    
    static Game gameobj =new Game();
    
    public static void main(String []args){
        
      GUI gui = new GUI();
      
       gameobj.generates_card_deck();
       gameobj.sets_info_player();
       
       gui.runGUI( gameobj.cardsdeck,
                   gameobj.playerinf[0].cardswithplayer,
                    gameobj.playerinf[1].cardswithplayer,
                    gameobj.playerinf[2].cardswithplayer,
                    gameobj.playerinf[3].cardswithplayer );
    
       
        gameobj.updatemaxscore(); 
        playerturn(gui);
        gameobj.updatemaxscore(); 
        dealerteurn(gui);
        gameobj.updatemaxscore();
           checkwinner();
   }
       
   
   
    public static void playerturn(GUI gui){
        
        for(int i=0;i<3;i++)
        {
            int x;
            int j=2;
            do{
                
            System.out.println("total score with " + gameobj.playerinf[i].getName() + " : " + gameobj.playerinf[i].getScore());
                if(gameobj.playerinf[i].getScore() >= 21)
                {
                    break;
                }
                
            System.out.println( gameobj.playerinf[i].getName() + " turn , choose a number \n 1) hit \n 2) stand  ");
            Scanner in = new Scanner(System.in);
            x = in.nextInt();
                
            if(x == 1)
                {
                        
                gameobj.playerinf[i].cardswithplayer[j] = gameobj.draw_card_randomly();
                gameobj.playerinf[i].setScore(gameobj.playerinf[i].getScore() + gameobj.playerinf[i].cardswithplayer[j].getValue());
                        
                gui.updatePlayerHand(gameobj.playerinf[i].cardswithplayer[j],i);
                j++;
                  
                if(j > 10)
                {
                    break;
                }
                }
            }while(x == 1);
        }
    }
    
    
    public static void dealerteurn(GUI gui){
        
        int x=0;
        int j=2;
      
        System.out.println("the dealer total score : " +  gameobj.playerinf[3].getScore() );
        do
        {
            int k=0;
            
            for(int i = 0; i < 3; i++)
            {
            if( gameobj.playerinf[3].getScore() > gameobj.highscore[i])
            {
                k++;
            } 
            
            }
            if(k==3){
                break;
            }
            
           if(gameobj.playerinf[3].getScore() >= 21)
            {
                break;
            }
    
            
            System.out.println("the dealer Hit");
   
            gameobj.playerinf[3].cardswithplayer[j] = gameobj.draw_card_randomly();
            gameobj.playerinf[3].setScore(gameobj.playerinf[3].getScore() + gameobj.playerinf[3].cardswithplayer[j].getValue());
            
            gui.updateDealerHand(gameobj.playerinf[3].cardswithplayer[j],gameobj.cardsdeck);
            
            j++;
            gameobj.updatemaxscore();
            
            System.out.println("the dealer total score : " +  gameobj.playerinf[3].getScore() );
        } while(true);
    }
    
    public static void checkwinner(){
        int highscore1=0;
        int index=0;
        int count = 0;
        int arr[] = new int [4];
 
        for(int i = 0; i < 4; i++)
        {         
            for(int j = 0; j < 4; j++)
            {   
                if(gameobj.highscore[i] == gameobj.highscore[j] && i != j)
                {
                    count++;
                }
            }
        }    
            if(count > 1)
            {
                System.out.println("PUSH");
            }
            else
            {
                for(int i = 0; i < 4; i++)
                {
                    if(gameobj.highscore[i] > highscore1 ){
                        highscore1=gameobj.highscore[i];
                        index=i;
                    }
                }
                    
                System.out.println("=======================================================================================");
                System.out.println("the winner is " + gameobj.playerinf[index].getName() + " with socre: "+gameobj.playerinf[index].getScore());
                System.out.println("=======================================================================================");
                    
                }
            }
}
    


