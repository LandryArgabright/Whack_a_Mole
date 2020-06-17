package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    //region buttons, texts, an image, a global boolean and a global int
    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;
    @FXML
    Button b6;
    @FXML
    Button b7;
    @FXML
    Button b8;
    @FXML
    public Text countdownTimer;
    @FXML
    public Text scoreTitle;
    @FXML
    public Text score;
    @FXML
    Image theImage;
    @FXML
    public boolean process;
    @FXML
    public int scoreAmount;
//endregion  //butt buttonbuttons

    @FXML
    public void initialize() { //all buttons are disabled before the start button is pressed
        b1.setDisable(true);
        b2.setDisable(true);
        b3.setDisable(true);
        b4.setDisable(true);
        b5.setDisable(true);
        b6.setDisable(true);
        b7.setDisable(true);
        b8.setDisable(true);
    }

    @FXML
    private void startButton(ActionEvent e) { // Timer for how long the game of whack-a-mole will last along with
        // a boolean to set how how long the buttons images will change
        b1.setDisable(false);
        b2.setDisable(false);
        b3.setDisable(false);
        b4.setDisable(false);
        b5.setDisable(false);
        b6.setDisable(false);
        b7.setDisable(false);
        b8.setDisable(false);
        e.getSource();
        moleOrHole();
        process = true;
        countdownTimer.setText(String.valueOf(10));
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            private final int end = 0;
            private int start = 10;

            @Override
            public void run() {
                if (start > end) {
                    countdownTimer.setText(Integer.toString(
                            Integer.parseInt(countdownTimer.getText()) - 1));
                    start = start - 1;
                    process = true;

                } else {
                    scoreTitle.setText("Final Score:");
                    process = false;
                    cancel();

                }
            }
        };
        timer.schedule(task, 0, 1000);
    }


    @FXML
    public void moleOrHole() {  //this uses the run(); object as a loop to go through two if statements
        //the first if statement sets all the images to holes if anyone of the buttons' image is a mole
        //once all the buttons are set to hole images the second if statement checks this then sets a random button to a mole image
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        if (b1.getTooltip().getText().equals("baby_Mole") || b2.getTooltip().getText().equals("baby_Mole")
                                || b3.getTooltip().getText().equals("baby_Mole")
                                || b4.getTooltip().getText().equals("baby_Mole") || b5.getTooltip().getText().equals("baby_Mole")
                                || b6.getTooltip().getText().equals("baby_Mole")
                                || b7.getTooltip().getText().equals("baby_Mole") || b8.getTooltip().getText().equals("baby_Mole")) {
                            theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
                            b1.setGraphic(new ImageView(theImage));
                            b1.getTooltip().setText("mole_Hole");
                            b2.setGraphic(new ImageView(theImage));
                            b2.getTooltip().setText("mole_Hole");
                            b3.setGraphic(new ImageView(theImage));
                            b3.getTooltip().setText("mole_Hole");
                            b4.setGraphic(new ImageView(theImage));
                            b4.getTooltip().setText("mole_Hole");
                            b5.setGraphic(new ImageView(theImage));
                            b5.getTooltip().setText("mole_Hole");
                            b6.setGraphic(new ImageView(theImage));
                            b6.getTooltip().setText("mole_Hole");
                            b7.setGraphic(new ImageView(theImage));
                            b7.getTooltip().setText("mole_Hole");
                            b8.setGraphic(new ImageView(theImage));
                            b8.getTooltip().setText("mole_Hole");
                        }
                        int whichButton;
                        Random rand = new Random();
                        whichButton = rand.nextInt(7);
                        if (b1.getTooltip().getText().equals("mole_Hole") && b2.getTooltip().getText().equals("mole_Hole")
                                && b3.getTooltip().getText().equals("mole_Hole")
                                && b4.getTooltip().getText().equals("mole_Hole") && b5.getTooltip().getText().equals("mole_Hole")
                                && b6.getTooltip().getText().equals("mole_Hole")
                                && b7.getTooltip().getText().equals("mole_Hole") && b8.getTooltip().getText().equals("mole_Hole")) {

                            //region switch
                            switch (whichButton) {
                                case 0:
                                    theImage = new Image(getClass().getResourceAsStream("baby_Mole.png"));
                                    b1.setGraphic(new ImageView(theImage));
                                    b1.getTooltip().setText("baby_Mole");
                                    break;

                                case 1:
                                    theImage = new Image(getClass().getResourceAsStream("baby_Mole.png"));
                                    b2.setGraphic(new ImageView(theImage));
                                    b2.getTooltip().setText("baby_Mole");
                                    break;

                                case 2:
                                    theImage = new Image(getClass().getResourceAsStream("baby_Mole.png"));
                                    b3.setGraphic(new ImageView(theImage));
                                    b3.getTooltip().setText("baby_Mole");
                                    break;

                                case 3:
                                    theImage = new Image(getClass().getResourceAsStream("baby_Mole.png"));
                                    b4.setGraphic(new ImageView(theImage));
                                    b4.getTooltip().setText("baby_Mole");
                                    break;

                                case 4:
                                    theImage = new Image(getClass().getResourceAsStream("baby_Mole.png"));
                                    b5.setGraphic(new ImageView(theImage));
                                    b5.getTooltip().setText("baby_Mole");
                                    break;

                                case 5:
                                    theImage = new Image(getClass().getResourceAsStream("baby_Mole.png"));
                                    b6.setGraphic(new ImageView(theImage));
                                    b6.getTooltip().setText("baby_Mole");
                                    break;

                                case 6:
                                    theImage = new Image(getClass().getResourceAsStream("baby_Mole.png"));
                                    b7.setGraphic(new ImageView(theImage));
                                    b7.getTooltip().setText("baby_Mole");
                                    break;

                                case 7:
                                    theImage = new Image(getClass().getResourceAsStream("baby_Mole.png"));
                                    b8.setGraphic(new ImageView(theImage));
                                    b8.getTooltip().setText("baby_Mole");
                                    break;

                            }
                            //endregion} //

                        }

                        if (process != true) {
                            scoreAmount = 0;
                            cancel();
                        }

                    }
                });

            }
        };
        timer.schedule(task, 500, 1250);

    }


    @FXML
    public void clicker(ActionEvent e) {        //Button 1 if the the timer is still counting down and a button with the mole image is pressed
                                                // the slap sound is played, 10 points are awarded to total score and
                                                //if a button without the mole image is pressed the whoosh sound is played

        e.getSource();
        if (b1.getTooltip().getText().equals("baby_Mole") && process != false) {

            theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
            playWhackedMole("slap.wav");
            b1.setGraphic(new ImageView(theImage));
            b1.getTooltip().setText("mole_Hole");
            scoreAmount = scoreAmount + 10;
            score.setText(String.valueOf(scoreAmount));
        } else if (process != false) {
            playWhackedMole("whoosh.wav");
        }
    }

    @FXML
    public void clicker1(ActionEvent e) {           // Button 2 if the the timer is still counting down and a button with the mole image is pressed
                                                    // the slap sound is played, 10 points are awarded to total score and the
                                                    //if a button without the mole image is pressed the whoosh sound is played
        e.getSource();
        if (b2.getTooltip().getText().equals("baby_Mole") && process != false) {

            theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
            playWhackedMole("slap.wav");
            b2.setGraphic(new ImageView(theImage));
            b2.getTooltip().setText("mole_Hole");
            scoreAmount = scoreAmount + 10;
            score.setText(String.valueOf(scoreAmount));
        } else if (process != false) {
            playWhackedMole("whoosh.wav");
        }
    }

    @FXML
    public void clicker2(ActionEvent e) { //Button 3 if the the timer is still counting down and a button with the mole image is pressed
        // the slap sound is played, 10 points are awarded to total score and the
        //if a button without the mole image is pressed the whoosh sound is played
        e.getSource();
        if (b3.getTooltip().getText().equals("baby_Mole") && process != false) {

            theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
            playWhackedMole("slap.wav");
            b3.setGraphic(new ImageView(theImage));
            b3.getTooltip().setText("mole_Hole");
            scoreAmount = scoreAmount + 10;
            score.setText(String.valueOf(scoreAmount));
        } else if (process != false) {
            playWhackedMole("whoosh.wav");
        }
    }

    @FXML
    public void clicker3(ActionEvent e) {//Button 4 if the the timer is still counting down and a button with the mole image is pressed
        // the slap sound is played, 10 points are awarded to total score and the
        //if a button without the mole image is pressed the whoosh sound is played
        e.getSource();
        if (b4.getTooltip().getText().equals("baby_Mole") && process != false) {

            theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
            playWhackedMole("slap.wav");
            b4.setGraphic(new ImageView(theImage));
            b4.getTooltip().setText("mole_Hole");
            scoreAmount = scoreAmount + 10;
            score.setText(String.valueOf(scoreAmount));
        } else if (process != false) {
            playWhackedMole("whoosh.wav");
        }
    }

    @FXML
    public void clicker4(ActionEvent e) {//Button 5 if the the timer is still counting down and a button with the mole image is pressed
        // the slap sound is played, 10 points are awarded to total score and the
        //if a button without the mole image is pressed the whoosh sound is played
        e.getSource();

        if (b5.getTooltip().getText().equals("baby_Mole") && process != false) {

            theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
            playWhackedMole("slap.wav");
            b5.setGraphic(new ImageView(theImage));
            b5.getTooltip().setText("mole_Hole");
            scoreAmount = scoreAmount + 10;
            score.setText(String.valueOf(scoreAmount));
        } else if (process != false) {
            playWhackedMole("whoosh.wav");
        }
    }

    @FXML
    public void clicker5(ActionEvent e) { //Button 6 if the the timer is still counting down and a button with the mole image is pressed
        // the slap sound is played, 10 points are awarded to total score and the
        //if a button without the mole image is pressed the whoosh sound is played
        e.getSource();
        if (b6.getTooltip().getText().equals("baby_Mole") && process != false) {

            theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
            playWhackedMole("slap.wav");
            b6.setGraphic(new ImageView(theImage));
            b6.getTooltip().setText("mole_Hole");
            scoreAmount = scoreAmount + 10;
            score.setText(String.valueOf(scoreAmount));
        } else if (process != false) {
            playWhackedMole("whoosh.wav");
        }
    }

    @FXML
    public void clicker6(ActionEvent e) { //Button 7 if the the timer is still counting down and a button with the mole image is pressed
        // the slap sound is played, 10 points are awarded to total score and the
        //if a button without the mole image is pressed the whoosh sound is played
        e.getSource();
        if (b7.getTooltip().getText().equals("baby_Mole") && process != false) {

            theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
            playWhackedMole("slap.wav");
            b7.setGraphic(new ImageView(theImage));
            b7.getTooltip().setText("mole_Hole");
            scoreAmount = scoreAmount + 10;
            score.setText(String.valueOf(scoreAmount));
        } else if (process != false) {
            playWhackedMole("whoosh.wav");
        }
    }

    @FXML
    public void clicker7(ActionEvent e) { //Button 8 if the the timer is still counting down and a button with the mole image is pressed
        // the slap sound is played, 10 points are awarded to total score and the
        //if a button without the mole image is pressed the whoosh sound is played
        e.getSource();
        if (b8.getTooltip().getText().equals("baby_Mole") && process != false) {

            theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
            playWhackedMole("slap.wav");
            b8.setGraphic(new ImageView(theImage));
            b8.getTooltip().setText("mole_Hole");
            scoreAmount = scoreAmount + 10;
            score.setText(String.valueOf(scoreAmount));
        } else if (process != false) {
            playWhackedMole("whoosh.wav");
        }
    }

    @FXML
    private void resetAction(ActionEvent e) { //Resets timer, score, each button and disables all buttons


        e.getSource();
        b1.setDisable(true);
        b2.setDisable(true);
        b3.setDisable(true);
        b4.setDisable(true);
        b5.setDisable(true);
        b6.setDisable(true);
        b7.setDisable(true);
        b8.setDisable(true);
        score.setText("---");
        scoreTitle.setText("Score:");
        countdownTimer.setText("10");

        Image theImage;

        theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
        b1.setGraphic(new ImageView(theImage));
        b1.getTooltip().setText("mole_Hole");

        theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
        b2.setGraphic(new ImageView(theImage));
        b2.getTooltip().setText("mole_Hole");

        theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
        b3.setGraphic(new ImageView(theImage));
        b3.getTooltip().setText("mole_Hole");

        theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
        b4.setGraphic(new ImageView(theImage));
        b4.getTooltip().setText("mole_Hole");

        theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
        b5.setGraphic(new ImageView(theImage));
        b5.getTooltip().setText("mole_Hole");

        theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
        b6.setGraphic(new ImageView(theImage));
        b6.getTooltip().setText("mole_Hole");

        theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
        b7.setGraphic(new ImageView(theImage));
        b7.getTooltip().setText("mole_Hole");

        theImage = new Image(getClass().getResourceAsStream("mole_Hole.png"));
        b8.setGraphic(new ImageView(theImage));
        b8.getTooltip().setText("mole_Hole");
    } //resetAction disables buttons once again and sets all buttons' images to the mole holes

    public void playWhackedMole(String audioFile) {
//how the audio is grabbed from ideaprojects folder and played
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(
                    this.getClass().getResource("sounds/" + audioFile));
            Clip c = AudioSystem.getClip();
            c.open(stream);
            c.start();

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}