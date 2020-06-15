package com.example.mastermind.GameActivity_Numbers;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.IllegalFormatCodePointException;
import java.util.Random;

public class GameActivity_Numbers extends AppCompatActivity {

    int missionDifficulty;

    Random rnd;

    int digit1, digit2, digit3, digit4, digit5, digit6, digit7;
    int input1 = 0, input2 = 0, input3 = 0, input4 = 0, input5 = 0, input6 = 0, input7 = 0;

    Intent GET_DATA_INTENT;

    int BTN_ID_AND_EDITTEXT_NUMBERS = 0;

    TextView txtCurrentNumber;

    EditText edt1_1, edt1_2, edt1_3, edt1_4, edt1_5, edt1_6, edt1_7;
    EditText edt2_1, edt2_2, edt2_3, edt2_4, edt2_5, edt2_6, edt2_7;
    EditText edt3_1, edt3_2, edt3_3, edt3_4, edt3_5, edt3_6, edt3_7;
    EditText edt4_1, edt4_2, edt4_3, edt4_4, edt4_5, edt4_6, edt4_7;
    EditText edt5_1, edt5_2, edt5_3, edt5_4, edt5_5, edt5_6, edt5_7;
    EditText edt6_1, edt6_2, edt6_3, edt6_4, edt6_5, edt6_6, edt6_7;

    int number = 0;

    Button btnCheckRow1, btnCheckRow2, btnCheckRow3, btnCheckRow4, btnCheckRow5, btnCheckRow6;

    Button btnReset;

    int rowCount = 1;

    View includeRow2, includeRow3, includeRow4, includeRow5, includeRow6;

    Integer[] array4Index;
    Integer[] array5Index;
    Integer[] array6Index;
    Integer[] array7Index;

    Integer[] array4IndexUserInputs;
    Integer[] array5IndexUserInputs;
    Integer[] array6IndexUserInputs;
    Integer[] array7IndexUserInputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__numbers);

        intentHandling();
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
    }

    private void intentHandling() {
        GET_DATA_INTENT = getIntent();
        missionDifficulty = GET_DATA_INTENT.getIntExtra("count", 4);
    }

    private void createRandomNumbers() {

        ArrayList<Integer> array4IndexCollection = new ArrayList<Integer>();
        for (int i = 1; i <= 10; ++i) array4IndexCollection.add(i);
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

    public void checkNumbers4Index(View view) {
        int placeCheck = 0;
        int id = view.getId();
        switch (id) {
            case R.id.game_numbers_row_1_btn_check:

                input1 = Integer.parseInt(edt1_1.getText().toString());
                array4IndexUserInputs[0] = input1;

                input2 = Integer.parseInt(edt1_2.getText().toString());
                array4IndexUserInputs[1] = input2;

                input3 = Integer.parseInt(edt1_3.getText().toString());
                array4IndexUserInputs[2] = input3;

                input4 = Integer.parseInt(edt1_4.getText().toString());
                array4IndexUserInputs[3] = input4;

                for (int i = 0; i < array4Index.length; i++) {
                    switch (i) {
                        case 0:
                            placeCheck=0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i] == array4Index[j] && placeCheck == 0) {
                                    edt1_1.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                } else if (array4IndexUserInputs[i] == array4Index[j] ) {
                                    edt1_1.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (array4IndexUserInputs[i] != array4Index[j] ) {
                                    if (placeCheck >= 3) {
                                        edt1_1.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;

                        case 1:
                            placeCheck=0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++)
                            {
                                if (array4IndexUserInputs[i] == array4Index[j] && placeCheck == 1) {
                                    edt1_2.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                } else if (array4IndexUserInputs[i] == array4Index[j]) {
                                    edt1_2.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (array4IndexUserInputs[i] != array4Index[j]) {
                                    if (placeCheck >= 3) {
                                        edt1_2.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }
                            break;


                        case 2:
                            placeCheck=0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i] == array4Index[j] && placeCheck == 2) {
                                    edt1_3.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                } else if (array4IndexUserInputs[i] == array4Index[j]) {
                                    edt1_3.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (array4IndexUserInputs[i] != array4Index[j]) {
                                    if ( placeCheck >= 3)
                                    {
                                        edt1_3.setBackgroundColor(Color.RED);
                                    }
                                }
                                placeCheck++;
                            }

                            break;


                        case 3:
                            placeCheck=0;
                            for (int j = 0; j < array4IndexUserInputs.length; j++) {
                                if (array4IndexUserInputs[i] == array4Index[j] && placeCheck == 3) {
                                    edt1_4.setBackgroundColor(Color.GREEN);
                                    j = array4IndexUserInputs.length;
                                } else if (array4IndexUserInputs[i] == array4Index[j]) {
                                    edt1_4.setBackgroundColor(Color.YELLOW);
                                    j = array4IndexUserInputs.length;
                                } else if (array4IndexUserInputs[i] != array4Index[j]) {
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
                break;

            case R.id.game_numbers_row_2_btn_check:
                btnCheckRow2.setEnabled(false);
                includeRow3.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_3_btn_check:
                btnCheckRow3.setEnabled(false);
                includeRow4.setVisibility(View.VISIBLE);
                break;

            default:
                Toast.makeText(this, "Error in Loading Game", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void checkNumbers5Index(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.game_numbers_row_1_btn_check:

                btnCheckRow1.setEnabled(false);
                includeRow2.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_2_btn_check:
                btnCheckRow2.setEnabled(false);
                includeRow3.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_3_btn_check:
                btnCheckRow3.setEnabled(false);
                includeRow4.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_4_btn_check:
                btnCheckRow4.setEnabled(false);
                includeRow5.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_5_btn_check:
                btnCheckRow5.setEnabled(false);
                includeRow6.setVisibility(View.VISIBLE);
                break;

            case R.id.game_numbers_row_6_btn_check:
                Toast.makeText(this, "You Died", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void checkNumbers6Index(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.game_numbers_row_1_btn_check:

                btnCheckRow1.setEnabled(false);
                includeRow2.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_2_btn_check:
                btnCheckRow2.setEnabled(false);
                includeRow3.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_3_btn_check:
                btnCheckRow3.setEnabled(false);
                includeRow4.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_4_btn_check:
                btnCheckRow4.setEnabled(false);
                includeRow5.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_5_btn_check:
                btnCheckRow5.setEnabled(false);
                includeRow6.setVisibility(View.VISIBLE);
                break;

            case R.id.game_numbers_row_6_btn_check:
                Toast.makeText(this, "You Died", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void checkNumbers7Index(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.game_numbers_row_1_btn_check:

                btnCheckRow1.setEnabled(false);
                includeRow2.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_2_btn_check:
                btnCheckRow2.setEnabled(false);
                includeRow3.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_3_btn_check:
                btnCheckRow3.setEnabled(false);
                includeRow4.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_4_btn_check:
                btnCheckRow4.setEnabled(false);
                includeRow5.setVisibility(View.VISIBLE);
                break;
            case R.id.game_numbers_row_5_btn_check:
                btnCheckRow5.setEnabled(false);
                includeRow6.setVisibility(View.VISIBLE);
                break;

            case R.id.game_numbers_row_6_btn_check:
                Toast.makeText(this, "You Died", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void resetButton() {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                recreate();
            }
        });
    }

}


