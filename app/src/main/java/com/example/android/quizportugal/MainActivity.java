package com.example.android.quizportugal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app is a 12 questions quiz about Portugal with a final score display.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the SUBMIT TO SCORE BUTTON is clicked.
     */
    public void submitToScore(View view) {
        // Get user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        // Question 1: Figure out if the user has consider that Portugal is an European country.
        RadioButton europeanCountry = (RadioButton) findViewById(R.id.yes_radio_button_1);
        boolean isEuropeanCountry = europeanCountry.isChecked();

        // Question 2: Figure out if the user has consider that Lisbon is the capital of Portugal.
        RadioButton capitalLisbon = (RadioButton) findViewById(R.id.lisbon_radio_button_2);
        boolean capitalIsLisbon = capitalLisbon.isChecked();

        // Question 3: Figure out if the user has consider that the foundation of Portugal took place in the year 1143.
        RadioButton foundation1143 = (RadioButton) findViewById(R.id.y1143_radio_button_3);
        boolean foundationIs1143 = foundation1143.isChecked();

        // Question 4: Figure out if the user has consider that the population of Portugal is around 10 million inhabitants.
        RadioButton population10M = (RadioButton) findViewById(R.id.i10m_radio_button_4);
        boolean populationIs10M = population10M.isChecked();

        // Question 5.1: Figure out if the user has consider that Fado is a typical thing in Portugal.
        CheckBox fadoCheckBox = (CheckBox) findViewById(R.id.fado_checkbox);
        boolean fadoIsTypical = fadoCheckBox.isChecked();

        // Question 5.2: Figure out if the user has consider that Golf is a typical thing in Portugal.
        CheckBox golfCheckBox = (CheckBox) findViewById(R.id.golf_checkbox);
        boolean golfIsTypical = golfCheckBox.isChecked();

        // Question 5.3: Figure out if the user has consider that Wine is a typical thing in Portugal.
        CheckBox wineCheckBox = (CheckBox) findViewById(R.id.wine_checkbox);
        boolean wineIsTypical = wineCheckBox.isChecked();

        // Question 5.4: Figure out if the user has consider that Wine is a typical thing in Portugal.
        CheckBox corkCheckBox = (CheckBox) findViewById(R.id.cork_checkbox);
        boolean corkIsTypical = corkCheckBox.isChecked();

        // Question 5.5: Figure out if the user has consider that Wine is a typical thing in Portugal.
        CheckBox pasteryCheckBox = (CheckBox) findViewById(R.id.pastery_checkbox);
        boolean pasteryIsTypical = pasteryCheckBox.isChecked();

        // Question 5.6: Figure out if the user has consider that Fish is a typical thing in Portugal.
        CheckBox fishCheckBox = (CheckBox) findViewById(R.id.fish_checkbox);
        boolean fishIsTypical = fishCheckBox.isChecked();

        // Question 5.7: Figure out if the user has consider that Soccer is a typical thing in Portugal.
        CheckBox soccerCheckBox = (CheckBox) findViewById(R.id.soccer_checkbox);
        boolean soccerIsTypical = soccerCheckBox.isChecked();

        // Question 5.8: Figure out if the user has consider that Cheese is a typical thing in Portugal.
        CheckBox cheeseCheckBox = (CheckBox) findViewById(R.id.cheese_checkbox);
        boolean cheeseIsTypical = cheeseCheckBox.isChecked();

        // Question 6: Figure out if the user has consider that Portugal won one Eurovision music festival.
        RadioButton eurovisionTrue = (RadioButton) findViewById(R.id.true_radio_button_6);
        boolean eurovisionWon = eurovisionTrue.isChecked();

        // Question 7: Figure out if the user has consider that Portugal won one European Soccer Championship.
        RadioButton soccerChampRight = (RadioButton) findViewById(R.id.right_radio_button_7);
        boolean soccerChampWon = soccerChampRight.isChecked();

        // Question 8: Figure out if the user has consider that Portugal a top golf destiny.
        RadioButton topGolfYup = (RadioButton) findViewById(R.id.yup_radio_button_8);
        boolean topGolfDestiny = topGolfYup.isChecked();

        // Question 9: Figure out if the user has consider that portuguese is the 6th spoken language.
        RadioButton portugueseThinkSo = (RadioButton) findViewById(R.id.thinkso_radio_button_9);
        boolean portuguese6thLanguage = portugueseThinkSo.isChecked();

        // Question 10: Figure out if the user has consider that Websummit is taking place in Portugal.
        RadioButton websummitAlright = (RadioButton) findViewById(R.id.alright_radio_button_10);
        boolean websummitInPortugal = websummitAlright.isChecked();

        // Question 11: Figure out if the user has consider that Ponte Vasco da Gama is the bridge with 17 km length.
        RadioButton bridgeVascoDaGama = (RadioButton) findViewById(R.id.vascodagama_radio_button_11);
        boolean ponteVascoDaGama = bridgeVascoDaGama.isChecked();

        // Question 12: Figure out if the user has consider that the number of tourists surpasses population.
        RadioButton averageTourists = (RadioButton) findViewById(R.id.correct_radio_button_12);
        boolean touristsSurpassesPopulation = averageTourists.isChecked();

        // Calculate the score (return of the method "calculateScore").
        int score = calculateScore(fadoIsTypical, isEuropeanCountry, capitalIsLisbon, foundationIs1143
                , populationIs10M, golfIsTypical, wineIsTypical, corkIsTypical, pasteryIsTypical,
                fishIsTypical, soccerIsTypical, cheeseIsTypical, eurovisionWon, soccerChampWon, topGolfDestiny,
                portuguese6thLanguage, websummitInPortugal, ponteVascoDaGama, touristsSurpassesPopulation);

        if (score == 19) {
            // If maximal score is reached then show congratulation message including total score.
            Toast.makeText(this, "Well done! You are a champion! " + "\nYou got " + score +
                    " points in total! That means 100% achievement", Toast.LENGTH_LONG).show();

        } else {
            // If maximal score is NOT reached then show congratulation message including total score.
            Toast.makeText(this, "You got " + score + " points in total!" +
                    "\nReview your answers to reach the maximal score of 19 points!", Toast.LENGTH_LONG).show();
        }

        // Display the score message on the screen (return of the method "createScoreMessage").
        String message = createScoreMessage(name, score);

        displayMessage(message);
    }


    /**
     * Method that calculates the final score (calculateScore).
     *
     * @param addEuropeanCountry is whether Portugal is an European Country
     * @param addLisbonCapital   is whether Lisbon is the portuguese capital
     * @param addFoundation      is whether Portugal was founded in 1143
     * @param addPopulation      is whether Portugal has around 10 million inhabitants
     * @param addFado            is whether Fado is a typical thing in Portugal
     * @param addGolf            is whether Golf is a typical thing in Portugal
     * @param addWine            is whether Wine is a typical thing in Portugal
     * @param addCork            is whether Cork is a typical thing in Portugal
     * @param addPastery         is whether Pastery is a typical thing in Portugal
     * @param addFish            is whether Fish is a typical thing in Portugal
     * @param addSoccer          is whether Soccer is a typical thing in Portugal
     * @param addCheese          is whether Cheese is a typical thing in Portugal
     * @param addEurovision      is whether Portugal has won the Eurovision Music Festival
     * @param addSoccerChamp     is whether Portugal has won the European Soccer Championship
     * @param addTopGolf         is whether Portugal is a Top Golf Destiny
     * @param addPortuguese      is whether portuguese is the 6th Spoken Language
     * @param addWebsummit       is whether Websummit is taking place in Portugal
     * @param addVascoDaGama     is whether the bridge with 17km length in Lisbon is named Ponte Vasco da Gama
     * @param addTourists        is whether the number of tourists exceeds the local population
     * @return final score
     */
    private int calculateScore(boolean addFado, boolean addEuropeanCountry, boolean addLisbonCapital,
                               boolean addFoundation, boolean addPopulation, boolean addGolf,
                               boolean addWine, boolean addCork, boolean addPastery, boolean addFish,
                               boolean addSoccer, boolean addCheese, boolean addEurovision,
                               boolean addSoccerChamp, boolean addTopGolf, boolean addPortuguese,
                               boolean addWebsummit, boolean addVascoDaGama, boolean addTourists) {

        // First calculate the zero base score
        int baseScore = 0;

        // If the user said Fado is a typical thing in Portugal, add 1 point to the score.
        if (addFado) {
            baseScore = baseScore + 1;
        }

        // If the user said that Portugal is an european country, add 1 point to the score.
        if (addEuropeanCountry) {
            baseScore = baseScore + 1;
        }

        // If the user said that Lisbon is the capital, add 1 point to the score.
        if (addLisbonCapital) {
            baseScore = baseScore + 1;
        }

        // If the user said that Portugal was founded in the year of 1143, add 1 point to the score.
        if (addFoundation) {
            baseScore = baseScore + 1;
        }

        // If the user said that the population of Portugal is around 10 million, add 1 point to the score.
        if (addPopulation) {
            baseScore = baseScore + 1;
        }

        // If the user said Golf is a typical thing in Portugal, add 1 point to the score.
        if (addGolf) {
            baseScore = baseScore + 1;
        }

        // If the user said Wine is a typical thing in Portugal, add 1 point to the score.
        if (addWine) {
            baseScore = baseScore + 1;
        }

        // If the user said Cork is a typical thing in Portugal, add 1 point to the score.
        if (addCork) {
            baseScore = baseScore + 1;
        }

        // If the user said Pastery is a typical thing in Portugal, add 1 point to the score.
        if (addPastery) {
            baseScore = baseScore + 1;
        }

        // If the user said Fish is a typical thing in Portugal, add 1 point to the score.
        if (addFish) {
            baseScore = baseScore + 1;
        }

        // If the user said Soccer is a typical thing in Portugal, add 1 point to the score.
        if (addSoccer) {
            baseScore = baseScore + 1;
        }

        // If the user said Cheese is a typical thing in Portugal, add 1 point to the score.
        if (addCheese) {
            baseScore = baseScore + 1;
        }

        // If the user said that Portugal won the Eurovision Music Festival, add 1 point to the score.
        if (addEurovision) {
            baseScore = baseScore + 1;
        }

        // If the user said that Portugal won the European Soccer Championship, add 1 point to the score.
        if (addSoccerChamp) {
            baseScore = baseScore + 1;
        }

        // If the user said that Portugal is a top golf destiny, add 1 point to the score.
        if (addTopGolf) {
            baseScore = baseScore + 1;
        }

        // If the user said that portuguese is the 6th spoken language, add 1 point to the score.
        if (addPortuguese) {
            baseScore = baseScore + 1;
        }

        // If the user said that the Websummit istaking place in Portugal, add 1 point to the score.
        if (addWebsummit) {
            baseScore = baseScore + 1;
        }

        // If the user said that the bridge with 17 km length is Ponte Vasco da Gama, add 1 point to the score.
        if (addVascoDaGama) {
            baseScore = baseScore + 1;
        }

        // If the user said that the average number of tourists surpasses population, add 1 point to the score.
        if (addTourists) {
            baseScore = baseScore + 1;
        }

        // Calculate the final score by adding all points.
        return baseScore;
    }


    /**
     * Method to create a short message stating the player's name and final the score.
     *
     * @param name  of the user playing the quiz
     * @param score number of points reached
     * @return short text message with player's name and score
     */
    private String createScoreMessage(String name, int score) {
        String scoreMessage = "PLAYER: " + name;
        scoreMessage += "\nSCORE: " + score + " POINTS";
        return scoreMessage;
    }


    /**
     * This method displays the given short text on the screen.
     */
    private void displayMessage(String message) {
        TextView scoreMessageTextView = (TextView) findViewById(R.id.score_message_text_view);
        scoreMessageTextView.setText(message);
    }

}
