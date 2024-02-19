package etc;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuessingGame extends JFrame implements ActionListener {
    private int secretNumber;
    private int numGuesses;
    private int maxNumber;
    private int score;
    private int cntRound;
    private int cnttry;
    private int highScore = -1;
    private JLabel yourHighscore;
    private JLabel messageLabel;
    private JLabel levelLabel;
    private JLabel YourScore;
    private JLabel textScore;
    private JLabel numtry;
    private JTextField inputField;
    private JButton guessButton;
    private JButton nextRoundButton;
    private JButton newGameButton;

    public GuessingGame() {
        super("Guessing Game");// Set up the GUI components
        setLayout(new FlowLayout());
        messageLabel = new JLabel("Guess a number ");
        add(messageLabel);
        inputField = new JTextField(10);
        add(inputField);
        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        add(guessButton);
        nextRoundButton = new JButton("Next");
        nextRoundButton.addActionListener(this);  
        add(nextRoundButton);
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(this);
        add(newGameButton);
        levelLabel = new JLabel("");
        add(levelLabel);
        YourScore = new JLabel("Your Score");
        textScore = new JLabel("0");
        add(YourScore);
        add(textScore);
        numtry = new JLabel("| you can guess it 3 time ");
        add(numtry);
        // Set the default level to 1 and generate a random number between 1 and 10
        yourHighscore = new JLabel("| high score: 0");
        add(yourHighscore);
        maxNumber = 10;
        newGame();

        // Set the size and show the GUI
        setSize(600, 100);
        setVisible(true);
    }
    public void nextRound(){
        secretNumber = (int) (Math.random() * (maxNumber*2));
        cntRound += 2;
        cnttry = cntRound;
        maxNumber *= 2; 
        numGuesses = 0;
        messageLabel.setText("Guess a number between 1 and " + maxNumber + ":");
        numtry.setText("| you can guess it "+cnttry+" time");
        nextRoundButton.setEnabled(false);
        inputField.setText("");
    }
    public void newGame() {
        maxNumber = 10;
        secretNumber = (int) (Math.random() * maxNumber);
        cntRound = 3;
        cnttry = cntRound;
        numGuesses = 0;
        score = 0;
        textScore.setText(""+score);
        messageLabel.setText("Guess a number between 1 and " + maxNumber + ":");
        numtry.setText("| you can guess it "+cnttry+" time");
        nextRoundButton.setEnabled(false);
        inputField.setText("");
    }
    public void loseRound(){
        cnttry = 0;
        messageLabel.setText("you can't play right now");
        numtry.setText("| you can guess it "+cnttry+" time");
        guessButton.setEnabled(false);
        nextRoundButton.setEnabled(false);
    }
    public int highscore(int inputscore){
        if(highScore <= inputscore){
            highScore = inputscore;
        }
        return highScore;
    }  
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            try {
                int guess = Integer.parseInt(inputField.getText());
                numGuesses++;
                cnttry -= 1;
                if(numGuesses <= cntRound){
                    if (guess < secretNumber) {
                        messageLabel.setText("Too low! Guess again. between 1 and " + maxNumber + ":" );
                        numtry.setText("| you can guess it "+cnttry+" time");
                        nextRoundButton.setEnabled(false);
                        if(cnttry == 0){
                            loseRound();
                        }
                    } else if (guess > secretNumber) {
                        messageLabel.setText("Too high! Guess again. between 1 and " + maxNumber + ":");
                        numtry.setText("| you can guess it "+cnttry+" time");
                        nextRoundButton.setEnabled(false);
                        if(cnttry == 0){
                            loseRound();
                        }
                    } else {
                        messageLabel.setText("You win! It took you " + numGuesses + " guesses.");
                        score++;
                        textScore.setText(""+score);
                        highscore(score);
                        yourHighscore.setText("| high score: "+ score);
                        guessButton.setEnabled(false);
                        nextRoundButton.setEnabled(true);
                    }
                    inputField.setText("");//when you ans your old ans will disappear
                } else {
                    loseRound();
                }
            } catch (NumberFormatException ex) {//catch everything except int
                messageLabel.setText("Invalid input. Please enter a number.");
                inputField.setText("");
            }
        } else if (e.getSource() == newGameButton) {
            guessButton.setEnabled(true);
            newGame();
        } else if (e.getSource() == nextRoundButton) {
            guessButton.setEnabled(true);
            nextRound();
        } 
    }

    public static void main(String[] args) {
        new GuessingGame();
    }
}