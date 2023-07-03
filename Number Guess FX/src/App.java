import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class App extends Application {
    @FXML
    private Button GuessBtn;
    private Button clear;
    private Button giveup;

    @FXML
    private TextField inputNumber;

    @FXML
    private Label message;

    @FXML
    private Label guess;


    static int randomNumber = (int) (Math.random() * 100) + 1;
    public void setrandom()
    {
        randomNumber  = (int) (Math.random() * 100) + 1;
    }
    public int getrandom()
    {
        return randomNumber;
    }
    static int attempts = 0;

    

    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Number Gussing Game");
        stage.show();
    }

    public void clear(){
        attempts = 0;
        message.setTextFill(Color.BLACK);
        message.setText("Restart Game");
        setrandom();
        guess.setText("");
    }

    public void giveup()
    {
        message.setTextFill(Color.BLACK);
        message.setText("No. of Guesses : " + attempts + "\n Correct Number : " + getrandom());
        attempts = 0;
        guess.setText("");
        setrandom();
    }

    public void checkGuess() {

        String input = inputNumber.getText();
        int Number;
        try {
            Number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            message.setTextFill(Color.valueOf("#972833"));
            message.setText("Invalid input!");
            guess.setText("Guesses : " + attempts);
            return;
        }
        attempts++;
        if(Number>100 || Number<1)
        {
            message.setTextFill(Color.valueOf("#972833"));
            message.setText("Enter the Value between 1 to 100");
            attempts--;
            guess.setText("Guesses : " + attempts);
        }
        else if (Number == randomNumber) {
            message.setTextFill(Color.valueOf("#064840"));
            message.setText("You guessed the number in " + attempts + " attempts.");
            guess.setText("");
            attempts=0;
            //clear();
            setrandom();
        } else if (Number < randomNumber) {
            message.setTextFill(Color.BLACK);
            message.setText("Please Enter the Higher Value");
            guess.setText("Guesses : " + attempts);
        } else {
            message.setTextFill(Color.BLACK);
            message.setText("Please Enter the Lower Value");
            guess.setText("Guesses : " + attempts);
        }
        inputNumber.clear();

    }

}
