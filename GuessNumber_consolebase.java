import java.util.Random;
import java.util.Scanner;
class Game{

    int randomnumber;
    int noofguesses=0;
    int userinput;

    Game(){
        Random r = new Random();
        this.randomnumber = r.nextInt(100);
    }

    void RandomNumber(){
        System.out.println("Correct Number : " +randomnumber);
    }

    void setinput(int x){
        this.userinput = x;
    }

    void getinput(){
        System.out.println("Your Entered Number is " + userinput);
    }

    boolean iscorrectNumber(){
        if(userinput==randomnumber){
            System.out.println("\nYee...You Gusse Correct Number ");
            noofguesses();
            return true;
        }
        else if(userinput > randomnumber){
            System.out.print("Enter smaller Number : ");
            noofguesses++;
            return false;
        }
        else //if(userinput < randomnumber)
        {   System.out.print("Enter bigger Number : ");
            noofguesses++;
            return false;
        }
    }

    void noofguesses(){
        System.out.println("\nNumber of Try : " + noofguesses) ;
    }

}

public class GuessNumber_consolebase{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\033[33m" );
        System.out.println("Number Gussing Game ");
        System.out.println("\033[0m");;

        Game g = new Game();
        System.out.print("Enter a Number : ");
        do{
            int number = sc.nextInt();
            g.setinput(number);
        }while(!g.iscorrectNumber());
        g.RandomNumber();
        sc.close();
        

        
    }
}
