package com.example.mastermind.GameActivity_Numbers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameActivity_Numbers extends AppCompatActivity {

    int missionDifficulty;

    Random rnd;

    int input1 = 0, input2 = 0, input3 = 0, input4 = 0, input5 = 0, input6 = 0, input7 = 0;

    Intent GET_DATA_INTENT;

    TextView txtCurrentNumber;

    EditText edt1_1, edt1_2, edt1_3, edt1_4, edt1_5, edt1_6, edt1_7;
    EditText edt2_1, edt2_2, edt2_3, edt2_4, edt2_5, edt2_6, edt2_7;
    EditText edt3_1, edt3_2, edt3_3, edt3_4, edt3_5, edt3_6, edt3_7;
    EditText edt4_1, edt4_2, edt4_3, edt4_4, edt4_5, edt4_6, edt4_7;
    EditText edt5_1, edt5_2, edt5_3, edt5_4, edt5_5, edt5_6, edt5_7;
    EditText edt6_1, edt6_2, edt6_3, edt6_4, edt6_5, edt6_6, edt6_7;

    Button btnCheckRow1, btnCheckRow2, btnCheckRow3, btnCheckRow4, btnCheckRow5, btnCheckRow6;

    Button btnReset;

    View includeRow2, includeRow3, includeRow4, includeRow5, includeRow6;

    Integer[] array4Index;
    Integer[] array5Index;
    Integer[] array6Index;
    Integer[] array7Index;

    Integer[] array4IndexUserInputs;
    Integer[] array5IndexUserInputs;
    Integer[] array6IndexUserInputs;
    Integer[] array7IndexUserInputs;

    TextView txtScoreBoard;


    public static final String PREF_SETTINGS_KEY = "com.example.mastermind.GameActivity_Numbers";
    public static final String PREF_MISSION_DIFFICULTY = "missionDifficulty";
    public static final String IF_PAGE_GOT_RESET = "page_reset";
    int missionModeSaved;
    int pageReset;

//    git init
//    git add .
//    git commit -m "Message"
//    git push

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__numbers);

        SharedPreferences sharedPreferences = getSharedPreferences(PREF_SETTINGS_KEY, MODE_PRIVATE);
        missionModeSaved = sharedPreferences.getInt(PREF_MISSION_DIFFICULTY, 4);
        pageReset = sharedPreferences.getInt(IF_PAGE_GOT_RESET, 0);
        if (pageReset == 0) {
            intentHandling();
        } else {
            missionDifficulty = missionModeSaved;
        }
        findViews();
        createRandomNumbers();
        resetButton();

    }

    private void findViews() {
        txtCurrentNumber = findViewById(R.id.game_numbers_txt_currectNumber);


        edt1_1 = findViewById(R.id.game_numbers_edt_txt_row_1_try_1);
        edt1_2 = findViewById(R.id.game_numbers_edt_txt_row_1_try_2);
        edt1_3 = findViewById(R.id.game_numbers_edt_txt_row_1_try_3);
        edt1_4 = findViewById(R.id.game_numbers_edt_txt_row_1_try_4);
        edt1_5 = findViewById(R.id.game_numbers_edt_txt_row_1_try_5);
        edt1_6 = findViewById(R.id.game_numbers_edt_txt_row_1_try_6);
        edt1_7 = findViewById(R.id.game_numbers_edt_txt_row_1_try_7);

        edt2_1 = findViewById(R.id.game_numbers_edt_txt_row_2_try_1);
        edt2_2 = findViewById(R.id.game_numbers_edt_txt_row_2_try_2);
        edt2_3 = findViewById(R.id.game_numbers_edt_txt_row_2_try_3);
        edt2_4 = findViewById(R.id.game_numbers_edt_txt_row_2_try_4);
        edt2_5 = findViewById(R.id.game_numbers_edt_txt_row_2_try_5);
        edt2_6 = findViewById(R.id.game_numbers_edt_txt_row_2_try_6);
        edt2_7 = findViewById(R.id.game_numbers_edt_txt_row_2_try_7);

        edt3_1 = findViewById(R.id.game_numbers_edt_txt_row_3_try_1);
        edt3_2 = findViewById(R.id.game_numbers_edt_txt_row_3_try_2);
        edt3_3 = findViewById(R.id.game_numbers_edt_txt_row_3_try_3);
        edt3_4 = findViewById(R.id.game_numbers_edt_txt_row_3_try_4);
        edt3_5 = findViewById(R.id.game_numbers_edt_txt_row_3_try_5);
        edt3_6 = findViewById(R.id.game_numbers_edt_txt_row_3_try_6);
        edt3_7 = findViewById(R.id.game_numbers_edt_txt_row_3_try_7);

        edt4_1 = findViewById(R.id.game_numbers_edt_txt_row_4_try_1);
        edt4_2 = findViewById(R.id.game_numbers_edt_txt_row_4_try_2);
        edt4_3 = findViewById(R.id.game_numbers_edt_txt_row_4_try_3);
        edt4_4 = findViewById(R.id.game_numbers_edt_txt_row_4_try_4);
        edt4_5 = findViewById(R.id.game_numbers_edt_txt_row_4_try_5);
        edt4_6 = findViewById(R.id.game_numbers_edt_txt_row_4_try_6);
        edt4_7 = findViewById(R.id.game_numbers_edt_txt_row_4_try_7);

        edt5_1 = findViewById(R.id.game_numbers_edt_txt_row_5_try_1);
        edt5_2 = findViewById(R.id.game_numbers_edt_txt_row_5_try_2);
        edt5_3 = findViewById(R.id.game_numbers_edt_txt_row_5_try_3);
        edt5_4 = findViewById(R.id.game_numbers_edt_txt_row_5_try_4);
        edt5_5 = findViewById(R.id.game_numbers_edt_txt_row_5_try_5);
        edt5_6 = findViewById(R.id.game_numbers_edt_txt_row_5_try_6);
        edt5_7 = findViewById(R.id.game_numbers_edt_txt_row_5_try_7);

        edt6_1 = findViewById(R.id.game_numbers_edt_txt_row_6_try_1);
        edt6_2 = findViewById(R.id.game_numbers_edt_txt_row_6_try_2);
        edt6_3 = findViewById(R.id.game_numbers_edt_txt_row_6_try_3);
        edt6_4 = findViewById(R.id.game_numbers_edt_txt_row_6_try_4);
        edt6_5 = findViewById(R.id.game_numbers_edt_txt_row_6_try_5);
        edt6_6 = findViewById(R.id.game_numbers_edt_txt_row_6_try_6);
        edt6_7 = findViewById(R.id.game_numbers_edt_txt_row_6_try_7);


        switch (missionDifficulty) {
            case 4:
                Toast.makeText(this, "Guess 4 Digits", Toast.LENGTH_SHORT).show();
                edt1_5.setVisibility(View.GONE);
                edt1_6.setVisibility(View.GONE);
                edt1_7.setVisibility(View.GONE);
                edt2_5.setVisibility(View.GONE);
                edt2_6.setVisibility(View.GONE);
                edt2_7.setVisibility(View.GONE);
                edt3_5.setVisibility(View.GONE);
                edt3_6.setVisibility(View.GONE);
                edt3_7.setVisibility(View.GONE);
                edt4_5.setVisibility(View.GONE);
                edt4_6.setVisibility(View.GONE);
                edt4_7.setVisibility(View.GONE);
                edt5_5.setVisibility(View.GONE);
                edt5_6.setVisibility(View.GONE);
                edt5_7.setVisibility(View.GONE);
                edt6_5.setVisibility(View.GONE);
                edt6_6.setVisibility(View.GONE);
                edt6_7.setVisibility(View.GONE);

                break;

            case 5:
                Toast.makeText(this, "Guess 5 Digits", Toast.LENGTH_SHORT).show();
                edt1_6.setVisibility(View.GONE);
                edt1_7.setVisibility(View.GONE);
                edt2_6.setVisibility(View.GONE);
                edt2_7.setVisibility(View.GONE);
                edt3_6.setVisibility(View.GONE);
                edt3_7.setVisibility(View.GONE);
                edt4_6.setVisibility(View.GONE);
                edt4_7.setVisibility(View.GONE);
                edt5_6.setVisibility(View.GONE);
                edt5_7.setVisibility(View.GONE);
                edt6_6.setVisibility(View.GONE);
                edt6_7.setVisibility(View.GONE);

                break;

            case 6:
                Toast.makeText(this, "Guess 6 Digits", Toast.LENGTH_SHORT).show();
                edt1_7.setVisibility(View.GONE);
                edt2_7.setVisibility(View.GONE);
                edt3_7.setVisibility(View.GONE);
                edt4_7.setVisibility(View.GONE);
                edt5_7.setVisibility(View.GONE);
                edt6_7.setVisibility(View.GONE);

                break;

            case 7:
                Toast.makeText(this, "Guess 7 Digits", Toast.LENGTH_SHORT).show();
                break;
        }

        includeRow2 = findViewById(R.id.game_numbers_table_row_2);
        includeRow3 = findViewById(R.id.game_numbers_table_row_3);
        includeRow4 = findViewById(R.id.game_numbers_table_row_4);
        includeRow5 = findViewById(R.id.game_numbers_table_row_5);
        includeRow6 = findViewById(R.id.game_numbers_table_row_6);

        btnCheckRow1 = findViewById(R.id.game_numbers_row_1_btn_check);
        btnCheckRow2 = findViewById(R.id.game_numbers_row_2_btn_check);
        btnCheckRow3 = findViewById(R.id.game_numbers_row_3_btn_check);
        btnCheckRow4 = findViewById(R.id.game_numbers_row_4_btn_check);
        btnCheckRow5 = findViewById(R.id.game_numbers_row_5_btn_check);
        btnCheckRow6 = findViewById(R.id.game_numbers_row_6_btn_check);

        btnReset = findViewById(R.id.game_numbers_retry_btn);

        array4IndexUserInputs = new Integer[4];
        array5IndexUserInputs = new Integer[5];
        array6IndexUserInputs = new Integer[6];
        array7IndexUserInputs = new Integer[7];

        txtScoreBoard = findViewById(R.id.game__numbers_showScoreAndResult);
    }

    private void intentHandling() {
        GET_DATA_INTENT = getIntent();
        missionDifficulty = GET_DATA_INTENT.getIntExtra("count", 4);
    }

    private void createRandomNumbers() {

        ArrayList<Integer> array4IndexCollection = new ArrayList<Integer>();
        for (int i = 1; i <= 9; ++i) array4IndexCollection.add(i);
        Collections.shuffle(array4IndexCollection);


        array4Index = new Integer[4];
        array5Index = new Integer[5];
        array6Index = new Integer[6];
        array7Index = new Integer[7];

        rnd = new Random();

        switch (missionDifficulty) {
            case 4:
                for (int i = 0; i < 4; i++) {
                    array4Index[i] = array4IndexCollection.get(i);
                    txtCurrentNumber.append(String.valueOf(array4Index[i]));
                }
                break;
            case 5:
                for (int i = 0; i < 5; i++) {
                    array5Index[i] = array4IndexCollection.get(i);
                    txtCurrentNumber.append(String.valueOf(array5Index[i]));
                }
                break;
            case 6:
                for (int i = 0; i < 6; i++) {
                    array6Index[i] = array4IndexCollection.get(i);
                    txtCurrentNumber.append(String.valueOf(array6Index[i]));
                }
                break;
            case 7:
                for (int i = 0; i < 7; i++) {
                    array7Index[i] = array4IndexCollection.get(i);
                    txtCurrentNumber.append(String.valueOf(array7Index[i]));
                }
                break;
        }
        Log.d("Main Activity", "createRandomNumbers: Random Numbers Created");
        //getRandomNum = rnd.nextInt(8999)+1000;

    }

    @SuppressLint("SetTextI18n")
    public void checkNumbers4Index(@NotNull View view) {
        int correctAnswers = 0;
        int placeCheck = 0;
        int id = view.getId();
        switch (id) {
            case R.id.game_numbers_row_1_btn_check:
                formatNumbers(1);
                for (int i = 0; i < array4Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 0) {
                                    edt1_1.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt1_1.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt1_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 1) {
                                    edt1_2.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt1_2.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt1_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 2) {
                                    edt1_3.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt1_3.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt1_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 3) {
                                    edt1_4.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt1_4.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt1_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow1.setEnabled(false);
                includeRow2.setVisibility(View.VISIBLE);
                edt1_1.setEnabled(false);
                edt1_2.setEnabled(false);
                edt1_3.setEnabled(false);
                edt1_4.setEnabled(false);
                if (correctAnswers >= 4) {
                    correctAnswers = 4;
                }
                txtScoreBoard.setText("Your Score out of 4 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_2_btn_check:
                formatNumbers(2);
                for (int i = 0; i < array4Index.length; i++) {
                    switch (i) {
                        case 0:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 0) {
                                    edt2_1.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt2_1.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt2_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 1) {
                                    edt2_2.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt2_2.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt2_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 2) {
                                    edt2_3.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt2_3.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt2_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 3) {
                                    edt2_4.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt2_4.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt2_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow2.setEnabled(false);
                includeRow3.setVisibility(View.VISIBLE);
                edt2_1.setEnabled(false);
                edt2_2.setEnabled(false);
                edt2_3.setEnabled(false);
                edt2_4.setEnabled(false);
                if (correctAnswers >= 4) {
                    correctAnswers = 4;
                }
                txtScoreBoard.setText("Your Score out of 4 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_3_btn_check:
                formatNumbers(3);
                for (int i = 0; i < array4Index.length; i++) {
                    switch (i) {
                        case 0:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 0) {
                                    edt3_1.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt3_1.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt3_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 1) {
                                    edt3_2.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt3_2.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt3_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 2) {
                                    edt3_3.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt3_3.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt3_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i].equals(array4Index[j]) && placeCheck == 3) {
                                    edt3_4.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array4IndexUserInputs[i].equals(array4Index[j])) {
                                    edt3_4.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (!array4IndexUserInputs[i].equals(array4Index[j])) {
                                    if (placeCheck >= 3) {
                                        edt3_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow3.setEnabled(false);
                edt3_1.setEnabled(false);
                edt3_2.setEnabled(false);
                edt3_3.setEnabled(false);
                edt3_4.setEnabled(false);
                if (correctAnswers >= 4) {
                    correctAnswers = 4;
                }
                txtScoreBoard.setText("Your Score out of 4 is " + correctAnswers);
                break;

            default:
                Toast.makeText(this, "Error in Loading Game", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void checkNumbers5Index(@NotNull View view) {
        int correctAnswers = 0;
        int placeCheck = 0;
        int id = view.getId();
        switch (id) {
            case R.id.game_numbers_row_1_btn_check:
                formatNumbers(1);

                for (int i = 0; i < array5Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 0) {
                                    edt1_1.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt1_1.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt1_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 1) {
                                    edt1_2.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt1_2.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt1_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 2) {
                                    edt1_3.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt1_3.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt1_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 3) {
                                    edt1_4.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt1_4.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt1_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 4) {
                                    edt1_5.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt1_5.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt1_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow1.setEnabled(false);
                includeRow2.setVisibility(View.VISIBLE);
                edt1_1.setEnabled(false);
                edt1_2.setEnabled(false);
                edt1_3.setEnabled(false);
                edt1_4.setEnabled(false);
                edt1_5.setEnabled(false);
                if (correctAnswers >= 5) {
                    correctAnswers = 5;
                }
                txtScoreBoard.setText("Your Score out of 5 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_2_btn_check:
                formatNumbers(2);

                for (int i = 0; i < array5Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 0) {
                                    edt2_1.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt2_1.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt2_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 1) {
                                    edt2_2.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt2_2.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt2_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 2) {
                                    edt2_3.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt2_3.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt2_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 3) {
                                    edt2_4.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt2_4.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt2_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 4) {
                                    edt2_5.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt2_5.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt2_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow2.setEnabled(false);
                includeRow3.setVisibility(View.VISIBLE);
                edt2_1.setEnabled(false);
                edt2_2.setEnabled(false);
                edt2_3.setEnabled(false);
                edt2_4.setEnabled(false);
                edt2_5.setEnabled(false);
                if (correctAnswers >= 5) {
                    correctAnswers = 5;
                }
                txtScoreBoard.setText("Your Score out of 5 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_3_btn_check:
                formatNumbers(3);

                for (int i = 0; i < array5Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 0) {
                                    edt3_1.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt3_1.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt3_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 1) {
                                    edt3_2.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt3_2.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt3_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 2) {
                                    edt3_3.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt3_3.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt3_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 3) {
                                    edt3_4.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt3_4.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt3_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 4) {
                                    edt3_5.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt3_5.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt3_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow3.setEnabled(false);
                includeRow4.setVisibility(View.VISIBLE);
                edt3_1.setEnabled(false);
                edt3_2.setEnabled(false);
                edt3_3.setEnabled(false);
                edt3_4.setEnabled(false);
                edt3_5.setEnabled(false);
                if (correctAnswers >= 5) {
                    correctAnswers = 5;
                }
                txtScoreBoard.setText("Your Score out of 5 is " + correctAnswers);
                break;


            case R.id.game_numbers_row_4_btn_check:
                formatNumbers(4);

                for (int i = 0; i < array5Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 0) {
                                    edt4_1.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt4_1.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt4_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 1) {
                                    edt4_2.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt4_2.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt4_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 2) {
                                    edt4_3.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt4_3.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt4_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 3) {
                                    edt4_4.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt4_4.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt4_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array5IndexUserInputs.length; j++) {
                                if (array5IndexUserInputs[i].equals(array5Index[j]) && placeCheck == 4) {
                                    edt4_5.setBackgroundColor(Color.GREEN);
                                    j = array5IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array5IndexUserInputs[i].equals(array5Index[j])) {
                                    edt4_5.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array5IndexUserInputs[i].equals(array5Index[j])) {
                                    if (placeCheck >= 4) {
                                        edt4_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow4.setEnabled(false);
                edt4_1.setEnabled(false);
                edt4_2.setEnabled(false);
                edt4_3.setEnabled(false);
                edt4_4.setEnabled(false);
                edt4_5.setEnabled(false);
                if (correctAnswers >= 5) {
                    correctAnswers = 5;
                }
                txtScoreBoard.setText("Your Score out of 5 is " + correctAnswers);
                break;

            default:
                Toast.makeText(this, "Error in Loading Game", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void checkNumbers6Index(@NotNull View view) {
        int correctAnswers = 0;
        int placeCheck = 0;
        int id = view.getId();
        switch (id) {
            case R.id.game_numbers_row_1_btn_check:
                formatNumbers(1);

                for (int i = 0; i < array6Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 0) {
                                    edt1_1.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt1_1.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt1_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 1) {
                                    edt1_2.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt1_2.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt1_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 2) {
                                    edt1_3.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt1_3.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt1_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 3) {
                                    edt1_4.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt1_4.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt1_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 4) {
                                    edt1_5.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt1_5.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt1_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 5) {
                                    edt1_6.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt1_6.setBackgroundColor(Color.YELLOW);
                                    j = array5IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt1_6.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow1.setEnabled(false);
                includeRow2.setVisibility(View.VISIBLE);
                edt1_1.setEnabled(false);
                edt1_2.setEnabled(false);
                edt1_3.setEnabled(false);
                edt1_4.setEnabled(false);
                edt1_5.setEnabled(false);
                edt1_6.setEnabled(false);
                if (correctAnswers >= 6) {
                    correctAnswers = 6;
                }
                txtScoreBoard.setText("Your Score out of 6 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_2_btn_check:
                formatNumbers(2);

                for (int i = 0; i < array6Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 0) {
                                    edt2_1.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt2_1.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt2_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 1) {
                                    edt2_2.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt2_2.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt2_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 2) {
                                    edt2_3.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt2_3.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt2_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 3) {
                                    edt2_4.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt2_4.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt2_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 4) {
                                    edt2_5.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt2_5.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt2_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 5) {
                                    edt2_6.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt2_6.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt2_6.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow2.setEnabled(false);
                includeRow3.setVisibility(View.VISIBLE);
                edt2_1.setEnabled(false);
                edt2_2.setEnabled(false);
                edt2_3.setEnabled(false);
                edt2_4.setEnabled(false);
                edt2_5.setEnabled(false);
                edt2_6.setEnabled(false);
                if (correctAnswers >= 6) {
                    correctAnswers = 6;
                }
                txtScoreBoard.setText("Your Score out of 6 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_3_btn_check:
                formatNumbers(3);

                for (int i = 0; i < array6Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 0) {
                                    edt3_1.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt3_1.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt3_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 1) {
                                    edt3_2.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt3_2.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt3_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 2) {
                                    edt3_3.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt3_3.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt3_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 3) {
                                    edt3_4.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt3_4.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt3_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 4) {
                                    edt3_5.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt3_5.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt3_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 5) {
                                    edt3_6.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt3_6.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt3_6.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow3.setEnabled(false);
                edt3_1.setEnabled(false);
                edt3_2.setEnabled(false);
                edt3_3.setEnabled(false);
                edt3_4.setEnabled(false);
                edt3_5.setEnabled(false);
                edt3_6.setEnabled(false);
                if (correctAnswers >= 6) {
                    correctAnswers = 6;
                }
                txtScoreBoard.setText("Your Score out of 6 is " + correctAnswers);
                break;


            case R.id.game_numbers_row_4_btn_check:
                formatNumbers(4);

                for (int i = 0; i < array6Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 0) {
                                    edt4_1.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt4_1.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt4_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 1) {
                                    edt4_2.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt4_2.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt4_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 2) {
                                    edt4_3.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt4_3.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt4_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 3) {
                                    edt4_4.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt4_4.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt4_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 4) {
                                    edt4_5.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt4_5.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt4_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 4) {
                                    edt5_5.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt5_5.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt5_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow4.setEnabled(false);
                edt4_1.setEnabled(false);
                edt4_2.setEnabled(false);
                edt4_3.setEnabled(false);
                edt4_4.setEnabled(false);
                edt4_5.setEnabled(false);
                edt4_6.setEnabled(false);
                if (correctAnswers >= 6) {
                    correctAnswers = 6;
                }
                txtScoreBoard.setText("Your Score out of 5 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_5_btn_check:
                formatNumbers(5);

                for (int i = 0; i < array6Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 0) {
                                    edt5_1.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt5_1.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt5_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 1) {
                                    edt5_2.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt5_2.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt5_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 2) {
                                    edt5_3.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt5_3.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt5_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 3) {
                                    edt5_4.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt5_4.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt5_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 4) {
                                    edt5_5.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt5_5.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt5_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array6IndexUserInputs.length; j++) {
                                if (array6IndexUserInputs[i].equals(array6Index[j]) && placeCheck == 4) {
                                    edt5_6.setBackgroundColor(Color.GREEN);
                                    j = array6IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array6IndexUserInputs[i].equals(array6Index[j])) {
                                    edt5_6.setBackgroundColor(Color.YELLOW);
                                    j = array6IndexUserInputs.length;
                                } else if (!array6IndexUserInputs[i].equals(array6Index[j])) {
                                    if (placeCheck >= 5) {
                                        edt5_6.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow5.setEnabled(false);
                edt5_1.setEnabled(false);
                edt5_2.setEnabled(false);
                edt5_3.setEnabled(false);
                edt5_4.setEnabled(false);
                edt5_5.setEnabled(false);
                edt5_6.setEnabled(false);
                if (correctAnswers >= 6) {
                    correctAnswers = 6;
                }
                txtScoreBoard.setText("Your Score out of 5 is " + correctAnswers);
                break;

            default:
                Toast.makeText(this, "Error in Loading Game", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void checkNumbers7Index(@NotNull View view) {

        int correctAnswers = 0;
        int placeCheck = 0;
        int id = view.getId();
        switch (id) {
            case R.id.game_numbers_row_1_btn_check:
                formatNumbers(1);

                for (int i = 0; i < array7Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 0) {
                                    edt1_1.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt1_1.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt1_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 1) {
                                    edt1_2.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt1_2.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt1_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 2) {
                                    edt1_3.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt1_3.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt1_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 3) {
                                    edt1_4.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt1_4.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt1_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 4) {
                                    edt1_5.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt1_5.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt1_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 5) {
                                    edt1_6.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt1_6.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt1_6.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 6:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 6) {
                                    edt1_7.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt1_7.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt1_7.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow1.setEnabled(false);
                includeRow2.setVisibility(View.VISIBLE);
                edt1_1.setEnabled(false);
                edt1_2.setEnabled(false);
                edt1_3.setEnabled(false);
                edt1_4.setEnabled(false);
                edt1_5.setEnabled(false);
                edt1_6.setEnabled(false);
                edt1_7.setEnabled(false);
                if (correctAnswers >= 7) {
                    correctAnswers = 7;
                }
                txtScoreBoard.setText("Your Score out of 7 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_2_btn_check:
                formatNumbers(2);

                for (int i = 0; i < array7Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 0) {
                                    edt2_1.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt2_1.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt2_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 1) {
                                    edt2_2.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt2_2.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt2_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 2) {
                                    edt2_3.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt2_3.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt2_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 3) {
                                    edt2_4.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt2_4.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt2_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 4) {
                                    edt2_5.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt2_5.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt2_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 5) {
                                    edt2_6.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt2_6.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt2_6.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 6:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 6) {
                                    edt2_7.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt2_7.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt2_7.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow2.setEnabled(false);
                includeRow3.setVisibility(View.VISIBLE);
                edt2_1.setEnabled(false);
                edt2_2.setEnabled(false);
                edt2_3.setEnabled(false);
                edt2_4.setEnabled(false);
                edt2_5.setEnabled(false);
                edt2_6.setEnabled(false);
                edt2_7.setEnabled(false);
                if (correctAnswers >= 7) {
                    correctAnswers = 7;
                }
                txtScoreBoard.setText("Your Score out of 6 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_3_btn_check:
                formatNumbers(3);

                for (int i = 0; i < array7Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 0) {
                                    edt3_1.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt3_1.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt3_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 1) {
                                    edt3_2.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt3_2.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt3_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 2) {
                                    edt3_3.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt3_3.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt3_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 3) {
                                    edt3_4.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt3_4.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt3_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 4) {
                                    edt3_5.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt3_5.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt3_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 5) {
                                    edt3_6.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt3_6.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt3_6.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 6:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 6) {
                                    edt3_7.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt3_7.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt3_7.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow3.setEnabled(false);
                edt3_1.setEnabled(false);
                edt3_2.setEnabled(false);
                edt3_3.setEnabled(false);
                edt3_4.setEnabled(false);
                edt3_5.setEnabled(false);
                edt3_6.setEnabled(false);
                edt3_7.setEnabled(false);
                if (correctAnswers >= 7) {
                    correctAnswers = 7;
                }
                txtScoreBoard.setText("Your Score out of 6 is " + correctAnswers);
                break;


            case R.id.game_numbers_row_4_btn_check:
                formatNumbers(4);

                for (int i = 0; i < array7Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 0) {
                                    edt4_1.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt4_1.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt4_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 1) {
                                    edt4_2.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt4_2.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt4_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 2) {
                                    edt4_3.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt4_3.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt4_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 3) {
                                    edt4_4.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt4_4.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt4_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 4) {
                                    edt4_5.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt4_5.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt4_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 5) {
                                    edt4_6.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt4_6.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt4_6.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 6:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 6) {
                                    edt4_7.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt4_7.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt4_7.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow4.setEnabled(false);
                edt4_1.setEnabled(false);
                edt4_2.setEnabled(false);
                edt4_3.setEnabled(false);
                edt4_4.setEnabled(false);
                edt4_5.setEnabled(false);
                edt4_6.setEnabled(false);
                edt4_7.setEnabled(false);
                if (correctAnswers >= 7) {
                    correctAnswers = 7;
                }
                txtScoreBoard.setText("Your Score out of 7 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_5_btn_check:
                formatNumbers(5);

                for (int i = 0; i < array7Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 0) {
                                    edt5_1.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt5_1.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt5_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 1) {
                                    edt5_2.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt5_2.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt5_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 2) {
                                    edt5_3.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt5_3.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt5_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 3) {
                                    edt5_4.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt5_4.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt5_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 4) {
                                    edt5_5.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt5_5.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt5_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 5) {
                                    edt5_6.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt5_6.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt5_6.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 6:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 6) {
                                    edt5_7.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt5_7.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt5_7.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow5.setEnabled(false);
                edt5_1.setEnabled(false);
                edt5_2.setEnabled(false);
                edt5_3.setEnabled(false);
                edt5_4.setEnabled(false);
                edt5_5.setEnabled(false);
                edt5_6.setEnabled(false);
                edt5_7.setEnabled(false);
                if (correctAnswers >= 7) {
                    correctAnswers = 7;
                }
                txtScoreBoard.setText("Your Score out of 7 is " + correctAnswers);
                break;

            case R.id.game_numbers_row_6_btn_check:
                formatNumbers(6);

                for (int i = 0; i < array7Index.length; i++) {
                    switch (i) {
                        case 0:
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 0) {
                                    edt6_1.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt6_1.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt6_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 1) {
                                    edt6_2.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt6_2.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt6_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 2) {
                                    edt6_3.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt6_3.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt6_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 3) {
                                    edt6_4.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt6_4.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt6_4.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 4:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 4) {
                                    edt6_5.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt6_5.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt6_5.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 5:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 5) {
                                    edt6_6.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt6_6.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt6_6.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 6:
                            placeCheck = 0;
                            for (int j = 0; j < array7IndexUserInputs.length; j++) {
                                if (array7IndexUserInputs[i].equals(array7Index[j]) && placeCheck == 6) {
                                    edt6_7.setBackgroundColor(Color.GREEN);
                                    j = array7IndexUserInputs.length;
                                    correctAnswers++;
                                } else if (array7IndexUserInputs[i].equals(array7Index[j])) {
                                    edt6_7.setBackgroundColor(Color.YELLOW);
                                    j = array7IndexUserInputs.length;
                                } else if (!array7IndexUserInputs[i].equals(array7Index[j])) {
                                    if (placeCheck >= 6) {
                                        edt6_7.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;
                    }

                }
                btnCheckRow5.setEnabled(false);
                edt5_1.setEnabled(false);
                edt5_2.setEnabled(false);
                edt5_3.setEnabled(false);
                edt5_4.setEnabled(false);
                edt5_5.setEnabled(false);
                edt5_6.setEnabled(false);
                edt5_7.setEnabled(false);
                if (correctAnswers >= 7) {
                    correctAnswers = 7;
                }
                txtScoreBoard.setText("Your Score out of 7 is " + correctAnswers);
                break;

            default:
                Toast.makeText(this, "Error in Loading Game", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void resetButton() {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(PREF_SETTINGS_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(PREF_MISSION_DIFFICULTY, missionDifficulty);
                editor.putInt(IF_PAGE_GOT_RESET, 1);
                editor.apply();

                Intent intent = new Intent(GameActivity_Numbers.this, GameActivity_Numbers.class);
                finish();
                startActivity(intent);
            }
        });
    }

    public void ALL_ONCLICK_METHODS(View view) {
        switch (missionDifficulty) {
            case 4:
                checkNumbers4Index(view);
                break;
            case 5:
                checkNumbers5Index(view);
                break;
            case 6:
                checkNumbers6Index(view);
                break;
            case 7:
                checkNumbers7Index(view);
                break;
        }
    }

    public void formatNumbers(int row) {
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";

        switch (missionDifficulty) {
            case 4:
                switch (row) {
                    case 1:
                        str1 = edt1_1.getText().toString();
                        if (str1.matches("")) {
                            array4IndexUserInputs[0] = 0;
                        } else {
                            array4IndexUserInputs[0] = Integer.parseInt(edt1_1.getText().toString());
                        }

                        str2 = edt1_2.getText().toString();
                        if (str2.matches("")) {
                            array4IndexUserInputs[1] = 0;
                        } else {
                            array4IndexUserInputs[1] = Integer.parseInt(edt1_2.getText().toString());
                        }


                        str3 = edt1_3.getText().toString();
                        if (str3.matches("")) {
                            array4IndexUserInputs[2] = 0;
                        } else {
                            array4IndexUserInputs[2] = Integer.parseInt(edt1_3.getText().toString());
                        }


                        str4 = edt1_4.getText().toString();
                        if (str4.matches("")) {
                            array4IndexUserInputs[3] = 0;
                        } else {
                            array4IndexUserInputs[3] = Integer.parseInt(edt1_4.getText().toString());
                        }
                        break;
                    case 2:
                        str1 = edt2_1.getText().toString();
                        if (str1.matches("")) {
                            array4IndexUserInputs[0] = 0;
                        } else {
                            array4IndexUserInputs[0] = Integer.parseInt(edt2_1.getText().toString());
                        }

                        str2 = edt2_2.getText().toString();
                        if (str2.matches("")) {
                            array4IndexUserInputs[1] = 0;
                        } else {
                            array4IndexUserInputs[1] = Integer.parseInt(edt2_2.getText().toString());
                        }


                        str3 = edt2_3.getText().toString();
                        if (str3.matches("")) {
                            array4IndexUserInputs[2] = 0;
                        } else {
                            array4IndexUserInputs[2] = Integer.parseInt(edt2_3.getText().toString());
                        }


                        str4 = edt2_4.getText().toString();
                        if (str4.matches("")) {
                            array4IndexUserInputs[3] = 0;
                        } else {
                            array4IndexUserInputs[3] = Integer.parseInt(edt2_4.getText().toString());
                        }
                        break;
                    case 3:


                        if (edt3_1.getText().toString().equals("")) {
                            array4IndexUserInputs[0] = 0;
                        } else {
                            array4IndexUserInputs[0] = Integer.parseInt(edt3_1.getText().toString());
                        }


                        if (edt3_2.getText().toString().equals("")) {
                            array4IndexUserInputs[1] = 0;
                        } else {
                            array4IndexUserInputs[1] = Integer.parseInt(edt3_2.getText().toString());
                        }


                        if (edt3_3.getText().toString().equals("")) {
                            array4IndexUserInputs[2] = 0;
                        } else {
                            array4IndexUserInputs[2] = Integer.parseInt(edt3_3.getText().toString());
                        }


                        if (edt3_4.getText().toString().equals("")) {
                            array4IndexUserInputs[3] = 0;
                        } else {
                            array4IndexUserInputs[3] = Integer.parseInt(edt3_4.getText().toString());
                        }
                        break;
                }
                break;

            case 5:
                switch (row) {
                    case 1:
                        if (edt1_1.getText().toString().equals("")) {
                            array5IndexUserInputs[0] = 0;
                        } else {
                            array5IndexUserInputs[0] = Integer.parseInt(edt1_1.getText().toString());
                        }


                        if (edt1_2.getText().toString().equals("")) {
                            array5IndexUserInputs[1] = 0;
                        } else {
                            array5IndexUserInputs[1] = Integer.parseInt(edt1_2.getText().toString());
                        }


                        if (edt1_3.getText().toString().equals("")) {
                            array5IndexUserInputs[2] = 0;
                        } else {
                            array5IndexUserInputs[2] = Integer.parseInt(edt1_3.getText().toString());
                        }


                        if (edt1_4.getText().toString().equals("")) {
                            array5IndexUserInputs[3] = 0;
                        } else {
                            array5IndexUserInputs[3] = Integer.parseInt(edt1_4.getText().toString());
                        }


                        if (edt1_5.getText().toString().equals("")) {
                            array5IndexUserInputs[4] = 0;
                        } else {
                            array5IndexUserInputs[4] = Integer.parseInt(edt1_5.getText().toString());
                        }
                        break;
                    case 2:

                        if (edt2_1.getText().toString().equals("")) {
                            array5IndexUserInputs[0] = 0;
                        } else {
                            array5IndexUserInputs[0] = Integer.parseInt(edt2_1.getText().toString());
                        }


                        if (edt2_2.getText().toString().equals("")) {
                            array5IndexUserInputs[1] = 0;
                        } else {
                            array5IndexUserInputs[1] = Integer.parseInt(edt2_2.getText().toString());
                        }


                        if (edt2_3.getText().toString().equals("")) {
                            array5IndexUserInputs[2] = 0;
                        } else {
                            array5IndexUserInputs[2] = Integer.parseInt(edt2_3.getText().toString());
                        }


                        if (edt2_4.getText().toString().equals("")) {
                            array5IndexUserInputs[3] = 0;
                        } else {
                            array5IndexUserInputs[3] = Integer.parseInt(edt2_4.getText().toString());
                        }


                        if (edt2_5.getText().toString().equals("")) {
                            array5IndexUserInputs[4] = 0;
                        } else {
                            array5IndexUserInputs[4] = Integer.parseInt(edt2_5.getText().toString());
                        }
                        break;
                    case 3:


                        if (edt3_1.getText().toString().equals("")) {
                            array5IndexUserInputs[0] = 0;
                        } else {
                            array5IndexUserInputs[0] = Integer.parseInt(edt3_1.getText().toString());
                        }


                        if (edt3_2.getText().toString().equals("")) {
                            array5IndexUserInputs[1] = 0;
                        } else {
                            array5IndexUserInputs[1] = Integer.parseInt(edt3_2.getText().toString());
                        }


                        if (edt3_3.getText().toString().equals("")) {
                            array5IndexUserInputs[2] = 0;
                        } else {
                            array5IndexUserInputs[2] = Integer.parseInt(edt3_3.getText().toString());
                        }


                        if (edt3_4.getText().toString().equals("")) {
                            array5IndexUserInputs[3] = 0;
                        } else {
                            array5IndexUserInputs[3] = Integer.parseInt(edt3_4.getText().toString());
                        }


                        if (edt3_5.getText().toString().equals("")) {
                            array5IndexUserInputs[4] = 0;
                        } else {
                            array5IndexUserInputs[4] = Integer.parseInt(edt3_5.getText().toString());
                        }
                        break;
                    case 4:

                        if (edt4_1.getText().toString().equals("")) {
                            array5IndexUserInputs[0] = 0;
                        } else {
                            array5IndexUserInputs[0] = Integer.parseInt(edt4_1.getText().toString());
                        }


                        if (edt4_2.getText().toString().equals("")) {
                            array5IndexUserInputs[1] = 0;
                        } else {
                            array5IndexUserInputs[1] = Integer.parseInt(edt4_2.getText().toString());
                        }


                        if (edt4_3.getText().toString().equals("")) {
                            array5IndexUserInputs[2] = 0;
                        } else {
                            array5IndexUserInputs[2] = Integer.parseInt(edt4_3.getText().toString());
                        }


                        if (edt4_4.getText().toString().equals("")) {
                            array5IndexUserInputs[3] = 0;
                        } else {
                            array5IndexUserInputs[3] = Integer.parseInt(edt4_4.getText().toString());
                        }


                        if (edt4_5.getText().toString().equals("")) {
                            array5IndexUserInputs[4] = 0;
                        } else {
                            array5IndexUserInputs[4] = Integer.parseInt(edt4_5.getText().toString());
                        }
                        break;
                }
                break;

            case 6:
                switch (row) {
                    case 1:
                        if (edt1_1.getText().toString().equals("")) {
                            array6IndexUserInputs[0] = 0;
                        } else {
                            array6IndexUserInputs[0] = Integer.parseInt(edt1_1.getText().toString());
                        }


                        if (edt1_2.getText().toString().equals("")) {
                            array6IndexUserInputs[1] = 0;
                        } else {
                            array6IndexUserInputs[1] = Integer.parseInt(edt1_2.getText().toString());
                        }


                        if (edt1_3.getText().toString().equals("")) {
                            array6IndexUserInputs[2] = 0;
                        } else {
                            array6IndexUserInputs[2] = Integer.parseInt(edt1_3.getText().toString());
                        }


                        if (edt1_4.getText().toString().equals("")) {
                            array6IndexUserInputs[3] = 0;
                        } else {
                            array6IndexUserInputs[3] = Integer.parseInt(edt1_4.getText().toString());
                        }


                        if (edt1_5.getText().toString().equals("")) {
                            array6IndexUserInputs[4] = 0;
                        } else {
                            array6IndexUserInputs[4] = Integer.parseInt(edt1_5.getText().toString());
                        }


                        if (edt1_6.getText().toString().equals("")) {
                            array6IndexUserInputs[5] = 0;
                        } else {
                            array6IndexUserInputs[5] = Integer.parseInt(edt1_6.getText().toString());
                        }
                        break;
                    case 2:

                        if (edt2_1.getText().toString().equals("")) {
                            array6IndexUserInputs[0] = 0;
                        } else {
                            array6IndexUserInputs[0] = Integer.parseInt(edt2_1.getText().toString());
                        }


                        if (edt2_2.getText().toString().equals("")) {
                            array6IndexUserInputs[1] = 0;
                        } else {
                            array6IndexUserInputs[1] = Integer.parseInt(edt2_2.getText().toString());
                        }


                        if (edt2_3.getText().toString().equals("")) {
                            array6IndexUserInputs[2] = 0;
                        } else {
                            array6IndexUserInputs[2] = Integer.parseInt(edt2_3.getText().toString());
                        }


                        if (edt2_4.getText().toString().equals("")) {
                            array6IndexUserInputs[3] = 0;
                        } else {
                            array6IndexUserInputs[3] = Integer.parseInt(edt2_4.getText().toString());
                        }


                        if (edt2_5.getText().toString().equals("")) {
                            array6IndexUserInputs[4] = 0;
                        } else {
                            array6IndexUserInputs[4] = Integer.parseInt(edt2_5.getText().toString());
                        }


                        if (edt2_6.getText().toString().equals("")) {
                            array6IndexUserInputs[5] = 0;
                        } else {
                            array6IndexUserInputs[5] = Integer.parseInt(edt2_6.getText().toString());
                        }
                        break;
                    case 3:


                        if (edt3_1.getText().toString().equals("")) {
                            input1 = 0;
                        } else {
                            input1 = Integer.parseInt(edt3_1.getText().toString());
                            array6IndexUserInputs[0] = input1;
                        }


                        if (edt3_2.getText().toString().equals("")) {
                            array6IndexUserInputs[1] = 0;
                        } else {
                            array6IndexUserInputs[1] = Integer.parseInt(edt3_2.getText().toString());
                        }


                        if (edt3_3.getText().toString().equals("")) {
                            array6IndexUserInputs[2] = 0;
                        } else {
                            array6IndexUserInputs[2] = Integer.parseInt(edt3_3.getText().toString());
                        }


                        if (edt3_4.getText().toString().equals("")) {
                            array6IndexUserInputs[3] = 0;
                        } else {
                            array6IndexUserInputs[3] = Integer.parseInt(edt3_4.getText().toString());
                        }


                        if (edt3_5.getText().toString().equals("")) {
                            array6IndexUserInputs[4] = 0;
                        } else {
                            array6IndexUserInputs[4] = Integer.parseInt(edt3_5.getText().toString());
                        }


                        if (edt3_6.getText().toString().equals("")) {
                            array6IndexUserInputs[5] = 0;
                        } else {
                            array6IndexUserInputs[5] = Integer.parseInt(edt3_6.getText().toString());
                        }
                        break;
                    case 4:


                        if (edt4_1.getText().toString().equals("")) {
                            array6IndexUserInputs[0] = 0;
                        } else {
                            array6IndexUserInputs[0] = Integer.parseInt(edt4_1.getText().toString());
                        }


                        if (edt4_2.getText().toString().equals("")) {
                            array6IndexUserInputs[1] = 0;
                        } else {
                            array6IndexUserInputs[1] = Integer.parseInt(edt4_2.getText().toString());
                        }


                        if (edt4_3.getText().toString().equals("")) {
                            array6IndexUserInputs[2] = 0;
                        } else {
                            array6IndexUserInputs[2] = Integer.parseInt(edt4_3.getText().toString());
                        }


                        if (edt4_4.getText().toString().equals("")) {
                            array6IndexUserInputs[3] = 0;
                        } else {
                            array6IndexUserInputs[3] = Integer.parseInt(edt4_4.getText().toString());
                        }


                        if (edt4_5.getText().toString().equals("")) {
                            array6IndexUserInputs[4] = 0;
                        } else {
                            array6IndexUserInputs[4] = Integer.parseInt(edt4_5.getText().toString());
                        }


                        if (edt4_6.getText().toString().equals("")) {
                            array6IndexUserInputs[5] = 0;
                        } else {
                            array6IndexUserInputs[5] = Integer.parseInt(edt4_6.getText().toString());
                        }
                        break;
                    case 5:


                        if (edt5_1.getText().toString().equals("")) {
                            array6IndexUserInputs[0] = 0;
                        } else {
                            array6IndexUserInputs[0] = Integer.parseInt(edt5_1.getText().toString());
                        }


                        if (edt5_2.getText().toString().equals("")) {
                            array6IndexUserInputs[1] = 0;
                        } else {
                            array6IndexUserInputs[1] = Integer.parseInt(edt5_2.getText().toString());
                        }


                        if (edt5_3.getText().toString().equals("")) {
                            array6IndexUserInputs[2] = 0;
                        } else {
                            array6IndexUserInputs[2] = Integer.parseInt(edt5_3.getText().toString());
                        }


                        if (edt5_4.getText().toString().equals("")) {
                            array6IndexUserInputs[3] = 0;
                        } else {
                            array6IndexUserInputs[3] = Integer.parseInt(edt5_4.getText().toString());
                        }


                        if (edt5_5.getText().toString().equals("")) {
                            array6IndexUserInputs[4] = 0;
                        } else {
                            array6IndexUserInputs[4] = Integer.parseInt(edt5_5.getText().toString());
                        }


                        if (edt5_6.getText().toString().equals("")) {
                            array6IndexUserInputs[5] = 0;
                        } else {
                            array6IndexUserInputs[5] = Integer.parseInt(edt5_6.getText().toString());
                        }
                        break;
                }
                break;

            case 7:
                switch (row) {
                    case 1:
                        if (edt1_1.getText().toString().equals("")) {
                            array7IndexUserInputs[0] = 0;
                        } else {
                            array7IndexUserInputs[0] = Integer.parseInt(edt1_1.getText().toString());
                        }


                        if (edt1_2.getText().toString().equals("")) {
                            array7IndexUserInputs[1] = 0;
                        } else {
                            array7IndexUserInputs[1] = Integer.parseInt(edt1_2.getText().toString());
                        }


                        if (edt1_3.getText().toString().equals("")) {
                            array7IndexUserInputs[2] = 0;
                        } else {
                            array7IndexUserInputs[2] = Integer.parseInt(edt1_3.getText().toString());
                        }


                        if (edt1_4.getText().toString().equals("")) {
                            array7IndexUserInputs[3] = 0;
                        } else {
                            array7IndexUserInputs[3] = Integer.parseInt(edt1_4.getText().toString());
                        }


                        if (edt1_5.getText().toString().equals("")) {
                            array7IndexUserInputs[4] = 0;
                        } else {
                            array7IndexUserInputs[4] = Integer.parseInt(edt1_5.getText().toString());
                        }


                        if (edt1_6.getText().toString().equals("")) {
                            array7IndexUserInputs[5] = 0;
                        } else {
                            array7IndexUserInputs[5] = Integer.parseInt(edt1_6.getText().toString());
                        }


                        if (edt1_7.getText().toString().equals("")) {
                            array7IndexUserInputs[6] = 0;
                        } else {
                            array7IndexUserInputs[6] = Integer.parseInt(edt1_7.getText().toString());
                        }
                        break;
                    case 2:

                        if (edt2_1.getText().toString().equals("")) {
                            array7IndexUserInputs[0] = 0;
                        } else {
                            array7IndexUserInputs[0] = Integer.parseInt(edt2_1.getText().toString());
                        }


                        if (edt2_2.getText().toString().equals("")) {
                            array7IndexUserInputs[1] = 0;
                        } else {
                            array7IndexUserInputs[1] = Integer.parseInt(edt2_2.getText().toString());
                        }


                        if (edt2_3.getText().toString().equals("")) {
                            array7IndexUserInputs[2] = 0;
                        } else {
                            array7IndexUserInputs[2] = Integer.parseInt(edt2_3.getText().toString());
                        }


                        if (edt2_4.getText().toString().equals("")) {
                            array7IndexUserInputs[3] = 0;
                        } else {
                            array7IndexUserInputs[3] = Integer.parseInt(edt2_4.getText().toString());
                        }


                        if (edt2_5.getText().toString().equals("")) {
                            array7IndexUserInputs[4] = 0;
                        } else {
                            array7IndexUserInputs[4] = Integer.parseInt(edt2_5.getText().toString());
                        }


                        if (edt2_6.getText().toString().equals("")) {
                            array7IndexUserInputs[5] = 0;
                        } else {
                            array7IndexUserInputs[5] = Integer.parseInt(edt2_6.getText().toString());
                        }


                        if (edt2_7.getText().toString().equals("")) {
                            array7IndexUserInputs[6] = 0;
                        } else {
                            array7IndexUserInputs[6] = Integer.parseInt(edt2_7.getText().toString());
                        }
                        break;
                    case 3:


                        if (edt3_1.getText().toString().equals("")) {
                            array7IndexUserInputs[0] = 0;
                        } else {
                            array7IndexUserInputs[0] = Integer.parseInt(edt3_1.getText().toString());
                        }


                        if (edt3_2.getText().toString().equals("")) {
                            array7IndexUserInputs[1] = 0;
                        } else {
                            array7IndexUserInputs[1] = Integer.parseInt(edt3_2.getText().toString());
                        }


                        if (edt3_3.getText().toString().equals("")) {
                            array7IndexUserInputs[2] = 0;
                        } else {
                            array7IndexUserInputs[2] = Integer.parseInt(edt3_3.getText().toString());
                        }


                        if (edt3_4.getText().toString().equals("")) {
                            array7IndexUserInputs[3] = 0;
                        } else {
                            array7IndexUserInputs[3] = Integer.parseInt(edt3_4.getText().toString());
                        }


                        if (edt3_5.getText().toString().equals("")) {
                            array7IndexUserInputs[4] = 0;
                        } else {
                            array7IndexUserInputs[4] = Integer.parseInt(edt3_5.getText().toString());
                        }


                        if (edt3_6.getText().toString().equals("")) {
                            array7IndexUserInputs[5] = 0;
                        } else {
                            array7IndexUserInputs[5] = Integer.parseInt(edt3_6.getText().toString());
                        }

                        if (edt3_7.getText().toString().equals("")) {
                            array7IndexUserInputs[6] = 0;
                        } else {
                            array7IndexUserInputs[6] = Integer.parseInt(edt3_7.getText().toString());
                        }
                        break;


                    case 4:

                        if (edt4_1.getText().toString().equals("")) {
                            array7IndexUserInputs[0] = 0;
                        } else {
                            array7IndexUserInputs[0] = Integer.parseInt(edt4_1.getText().toString());
                        }


                        if (edt4_2.getText().toString().equals("")) {
                            array7IndexUserInputs[1] = 0;
                        } else {
                            array7IndexUserInputs[1] = Integer.parseInt(edt4_2.getText().toString());
                        }


                        if (edt4_3.getText().toString().equals("")) {
                            array7IndexUserInputs[2] = 0;
                        } else {
                            array7IndexUserInputs[2] = Integer.parseInt(edt4_3.getText().toString());
                        }


                        if (edt4_4.getText().toString().equals("")) {
                            array7IndexUserInputs[3] = 0;
                        } else {
                            array7IndexUserInputs[3] = Integer.parseInt(edt4_4.getText().toString());
                        }


                        if (edt4_5.getText().toString().equals("")) {
                            array7IndexUserInputs[4] = 0;
                        } else {
                            array7IndexUserInputs[4] = Integer.parseInt(edt4_5.getText().toString());
                        }


                        if (edt4_6.getText().toString().equals("")) {
                            array7IndexUserInputs[5] = 0;
                        } else {
                            array7IndexUserInputs[5] = Integer.parseInt(edt4_6.getText().toString());
                        }


                        if (edt4_7.getText().toString().equals("")) {
                            array7IndexUserInputs[6] = 0;
                        } else {
                            array7IndexUserInputs[6] = Integer.parseInt(edt4_7.getText().toString());
                        }
                        break;
                    case 5:


                        if (edt5_1.getText().toString().equals("")) {
                            array7IndexUserInputs[0] = 0;
                        } else {
                            array7IndexUserInputs[0] = Integer.parseInt(edt5_1.getText().toString());
                        }


                        if (edt5_2.getText().toString().equals("")) {
                            array7IndexUserInputs[1] = 0;
                        } else {
                            array7IndexUserInputs[1] = Integer.parseInt(edt5_2.getText().toString());
                        }


                        if (edt5_3.getText().toString().equals("")) {
                            array7IndexUserInputs[2] = 0;
                        } else {
                            array7IndexUserInputs[2] = Integer.parseInt(edt5_3.getText().toString());
                        }


                        if (edt5_4.getText().toString().equals("")) {
                            array7IndexUserInputs[3] = 0;
                        } else {
                            array7IndexUserInputs[3] = Integer.parseInt(edt5_4.getText().toString());
                        }


                        if (edt5_5.getText().toString().equals("")) {
                            array7IndexUserInputs[4] = 0;
                        } else {
                            array7IndexUserInputs[4] = Integer.parseInt(edt5_5.getText().toString());
                        }


                        if (edt5_6.getText().toString().equals("")) {
                            array7IndexUserInputs[5] = 0;
                        } else {
                            array7IndexUserInputs[5] = Integer.parseInt(edt5_6.getText().toString());
                        }


                        if (edt5_7.getText().toString().equals("")) {
                            array7IndexUserInputs[6] = 0;
                        } else {
                            array7IndexUserInputs[6] = Integer.parseInt(edt5_7.getText().toString());
                        }
                        break;

                    case 6:

                        if (edt6_1.getText().toString().equals("")) {
                            array7IndexUserInputs[0] = 0;
                        } else {
                            array7IndexUserInputs[0] = Integer.parseInt(edt6_1.getText().toString());
                        }


                        if (edt6_2.getText().toString().equals("")) {
                            array7IndexUserInputs[1] = 0;
                        } else {
                            array7IndexUserInputs[1] = Integer.parseInt(edt6_2.getText().toString());
                        }


                        if (edt6_3.getText().toString().equals("")) {
                            array7IndexUserInputs[2] = 0;
                        } else {
                            array7IndexUserInputs[2] = Integer.parseInt(edt6_3.getText().toString());
                        }


                        if (edt6_4.getText().toString().equals("")) {
                            array7IndexUserInputs[3] = 0;
                        } else {
                            array7IndexUserInputs[3] = Integer.parseInt(edt6_4.getText().toString());
                        }


                        if (edt6_5.getText().toString().equals("")) {
                            array7IndexUserInputs[4] = 0;
                        } else {
                            array7IndexUserInputs[4] = Integer.parseInt(edt6_5.getText().toString());
                        }


                        if (edt6_6.getText().toString().equals("")) {
                            array7IndexUserInputs[5] = 0;
                        } else {
                            array7IndexUserInputs[5] = Integer.parseInt(edt6_6.getText().toString());
                        }


                        if (edt6_7.getText().toString().equals("")) {
                            array7IndexUserInputs[6] = 0;
                        } else {
                            array7IndexUserInputs[6] = Integer.parseInt(edt6_7.getText().toString());
                        }
                        break;
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        SharedPreferences sharedPreferences = getSharedPreferences(PREF_SETTINGS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit().clear();
        editor.apply();

    }
}