package com.example.mastermind.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mastermind.GameActivity_Numbers.GameActivity_Numbers;
import com.example.mastermind.GameActivity_Words.GameActivity_Words;
import com.example.mastermind.R;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout main_page_ConstraintLayout;//no use right now
    MaterialButton btnCHallenge_Words, btnCHallenge_Numbers;
    MaterialButton btn4units, btn5units, btn6units, btn7units;
    MaterialButton btnBackMiddle; // back button in the middle of the screen
    Animation scale_13_to_1, scale_13_to_0, scale_0_to_13, scale_1_to_13, scale_0_to_1;
    Animation translate_top_left, translate_top_right, translate_bottom_left, translate_bottom_right;
    Animation fadeIn, fadeOut, fadeIn2, fadeOut2;
    ImageView imgWordBackground, imgNumberBackground;//background will change according to the category selected
    int layout_stage;
    TextView txtChooseTitle;
    int backButtonCount = 0;//for exiting the game
    Intent SWITCH_ACTIVITY_INTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindViews();
        AnimationFindViews();
        onClick_Init();
        backGround_Init();
    }

    void FindViews() {
        btnCHallenge_Words = findViewById(R.id.main_btn_words_challenge);
        btnCHallenge_Numbers = findViewById(R.id.main_btn_numbers_challenge);

        main_page_ConstraintLayout = findViewById(R.id.main_page_layout);

        imgWordBackground = findViewById(R.id.main_word_background);
        imgNumberBackground = findViewById(R.id.main_number_background);


        layout_stage = 0;

        txtChooseTitle = findViewById(R.id.main_txt_choose_title);

        btn4units = findViewById(R.id.main_btn_4_numbers);
        btn5units = findViewById(R.id.main_btn_5_numbers);
        btn6units = findViewById(R.id.main_btn_6_numbers);
        btn7units = findViewById(R.id.main_btn_7_numbers);
        btnBackMiddle = findViewById(R.id.main_btn_back_from_number_list);

        btn4units.setEnabled(false);
        btn5units.setEnabled(false);
        btn6units.setEnabled(false);
        btn7units.setEnabled(false);
        btnBackMiddle.setEnabled(false);


    }

    void AnimationFindViews() {
        scale_0_to_1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_0_to_1);
        scale_0_to_13 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_0_to_1_3);
        scale_1_to_13 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_1_to_1_3);
        scale_13_to_0 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_13_to_0);
        scale_13_to_1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_13_to_1);


        translate_top_left = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_top_left);
        translate_top_right = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_top_right);
        translate_bottom_left = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_bottom_left);
        translate_bottom_right = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_bottom_right);


        fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_fade_in);
        fadeOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_fade_out);

        fadeIn2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in_layout);
        fadeOut2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out_layout);
    }

    void onClick_Init() {
        btnCHallenge_Words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handler init
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        layout_stage = 1;
                        imgWordBackground.setVisibility(View.VISIBLE);
                        imgWordBackground.startAnimation(fadeIn2);

                        btnCHallenge_Words.setEnabled(false);
                        btnCHallenge_Words.setVisibility(View.GONE);
                        btnCHallenge_Numbers.setEnabled(false);
                        btnCHallenge_Numbers.setVisibility(View.GONE);

                        txtChooseTitle.startAnimation(fadeOut2);
                        txtChooseTitle.setVisibility(View.GONE);

                        btnBackMiddle.setEnabled(true);
                        btnBackMiddle.setVisibility(View.VISIBLE);
                        btnBackMiddle.startAnimation(fadeIn2);

                        btn4units.setEnabled(true);
                        btn4units.setVisibility(View.VISIBLE);
                        btn4units.startAnimation(translate_top_left);

                        btn5units.setEnabled(true);
                        btn5units.setVisibility(View.VISIBLE);
                        btn5units.startAnimation(translate_top_right);

                        btn6units.setEnabled(true);
                        btn6units.setVisibility(View.VISIBLE);
                        btn6units.startAnimation(translate_bottom_left);

                        btn7units.setEnabled(true);
                        btn7units.setVisibility(View.VISIBLE);
                        btn7units.startAnimation(translate_bottom_right);
                    }
                }, 500);
            }
        });

        btnCHallenge_Numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handler init
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        layout_stage = 2;
                        imgNumberBackground.setVisibility(View.VISIBLE);
                        imgNumberBackground.startAnimation(fadeIn);

                        btnCHallenge_Words.setEnabled(false);
                        btnCHallenge_Words.setVisibility(View.GONE);
                        btnCHallenge_Numbers.setEnabled(false);
                        btnCHallenge_Numbers.setVisibility(View.GONE);

                        txtChooseTitle.startAnimation(fadeOut);
                        txtChooseTitle.setVisibility(View.GONE);

                        btnBackMiddle.setEnabled(true);
                        btnBackMiddle.setVisibility(View.VISIBLE);
                        btnBackMiddle.startAnimation(fadeIn2);

                        btn4units.setEnabled(true);
                        btn4units.setVisibility(View.VISIBLE);
                        btn4units.startAnimation(translate_top_left);

                        btn5units.setEnabled(true);
                        btn5units.setVisibility(View.VISIBLE);
                        btn5units.startAnimation(translate_top_right);

                        btn6units.setEnabled(true);
                        btn6units.setVisibility(View.VISIBLE);
                        btn6units.startAnimation(translate_bottom_left);

                        btn7units.setEnabled(true);
                        btn7units.setVisibility(View.VISIBLE);
                        btn7units.startAnimation(translate_bottom_right);
                    }
                }, 500);
            }
        });

        btnBackMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (layout_stage) {
                    case 1:
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                imgWordBackground.startAnimation(fadeOut);
                                imgWordBackground.setVisibility(View.INVISIBLE);

                                btnCHallenge_Words.setEnabled(true);
                                btnCHallenge_Words.setVisibility(View.VISIBLE);
                                btnCHallenge_Numbers.setEnabled(true);
                                btnCHallenge_Numbers.setVisibility(View.VISIBLE);

                                txtChooseTitle.startAnimation(fadeIn);
                                txtChooseTitle.setVisibility(View.VISIBLE);

                                btnBackMiddle.startAnimation(fadeOut);
                                btnBackMiddle.setVisibility(View.INVISIBLE);

                                btn4units.setVisibility(View.INVISIBLE);
                                btn5units.setVisibility(View.INVISIBLE);
                                btn6units.setVisibility(View.INVISIBLE);
                                btn7units.setVisibility(View.INVISIBLE);

                                btn4units.setEnabled(false);
                                btn5units.setEnabled(false);
                                btn6units.setEnabled(false);
                                btn7units.setEnabled(false);
                            }
                        }, 500);
                        //button animation handle here
                        break;


                    case 2:

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                imgNumberBackground.startAnimation(fadeOut);
                                imgNumberBackground.setVisibility(View.INVISIBLE);

                                btnCHallenge_Words.setEnabled(true);
                                btnCHallenge_Words.setVisibility(View.VISIBLE);
                                btnCHallenge_Numbers.setEnabled(true);
                                btnCHallenge_Numbers.setVisibility(View.VISIBLE);

                                txtChooseTitle.startAnimation(fadeIn);
                                txtChooseTitle.setVisibility(View.VISIBLE);

                                btnBackMiddle.startAnimation(fadeOut);
                                btnBackMiddle.setVisibility(View.INVISIBLE);

                                btn4units.setVisibility(View.INVISIBLE);
                                btn5units.setVisibility(View.INVISIBLE);
                                btn6units.setVisibility(View.INVISIBLE);
                                btn7units.setVisibility(View.INVISIBLE);

                                btn4units.setEnabled(false);
                                btn5units.setEnabled(false);
                                btn6units.setEnabled(false);
                                btn7units.setEnabled(false);
                            }
                        }, 500);
                        //button animation handle here
                        break;
                }
            }
        });


    }

    public void missionClicks(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.main_btn_4_numbers:
                switch (layout_stage) {
                    case 1:
                        SWITCH_ACTIVITY_INTENT = new Intent(MainActivity.this, GameActivity_Words.class);
                        SWITCH_ACTIVITY_INTENT.putExtra("count", 4);
                        startActivity(SWITCH_ACTIVITY_INTENT);
                        break;

                    case 2:
                        SWITCH_ACTIVITY_INTENT = new Intent(MainActivity.this, GameActivity_Numbers.class);
                        SWITCH_ACTIVITY_INTENT.putExtra("count", 4);
                        startActivity(SWITCH_ACTIVITY_INTENT);
                        break;

                }

                break;

            case R.id.main_btn_5_numbers:
                switch (layout_stage) {
                    case 1:
                        SWITCH_ACTIVITY_INTENT = new Intent(MainActivity.this, GameActivity_Words.class);
                        SWITCH_ACTIVITY_INTENT.putExtra("count",5);
                        startActivity(SWITCH_ACTIVITY_INTENT);
                        break;

                    case 2:
                        SWITCH_ACTIVITY_INTENT = new Intent(MainActivity.this, GameActivity_Numbers.class);
                        SWITCH_ACTIVITY_INTENT.putExtra("count", 5);
                        startActivity(SWITCH_ACTIVITY_INTENT);
                        break;

                }

                break;

            case R.id.main_btn_6_numbers:
                switch (layout_stage) {
                    case 1:
                        SWITCH_ACTIVITY_INTENT = new Intent(MainActivity.this, GameActivity_Words.class);
                        SWITCH_ACTIVITY_INTENT.putExtra("count", 6);
                        startActivity(SWITCH_ACTIVITY_INTENT);
                        break;

                    case 2:
                        SWITCH_ACTIVITY_INTENT = new Intent(MainActivity.this, GameActivity_Numbers.class);
                        SWITCH_ACTIVITY_INTENT.putExtra("count", 6);
                        startActivity(SWITCH_ACTIVITY_INTENT);
                        break;

                }
                break;

            case R.id.main_btn_7_numbers:
                switch (layout_stage) {
                    case 1:
                        SWITCH_ACTIVITY_INTENT = new Intent(MainActivity.this, GameActivity_Words.class);
                        SWITCH_ACTIVITY_INTENT.putExtra("count", 7);
                        startActivity(SWITCH_ACTIVITY_INTENT);
                        break;

                    case 2:
                        SWITCH_ACTIVITY_INTENT = new Intent(MainActivity.this, GameActivity_Numbers.class);
                        SWITCH_ACTIVITY_INTENT.putExtra("count", 7);
                        startActivity(SWITCH_ACTIVITY_INTENT);
                        break;

                }

                break;
        }
    }

    void backGround_Init() {
        imgWordBackground.setImageResource(R.drawable.words_bg);
        imgNumberBackground.setImageResource(R.drawable.numbers_bg);
    }

    @Override
    public void onBackPressed() {
        switch (layout_stage) {
            case 0:
                if (backButtonCount == 1) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
                    backButtonCount = 1;
                }
                break;

            case 1:

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        imgWordBackground.startAnimation(fadeOut);
                        imgWordBackground.setVisibility(View.INVISIBLE);

                        btnCHallenge_Words.setEnabled(true);
                        btnCHallenge_Words.setVisibility(View.VISIBLE);
                        btnCHallenge_Numbers.setEnabled(true);
                        btnCHallenge_Numbers.setVisibility(View.VISIBLE);

                        txtChooseTitle.startAnimation(fadeIn);
                        txtChooseTitle.setVisibility(View.VISIBLE);

                        btnBackMiddle.startAnimation(fadeOut);
                        btnBackMiddle.setVisibility(View.INVISIBLE);

                        btn4units.setVisibility(View.INVISIBLE);
                        btn5units.setVisibility(View.INVISIBLE);
                        btn6units.setVisibility(View.INVISIBLE);
                        btn7units.setVisibility(View.INVISIBLE);

                        btn4units.setEnabled(false);
                        btn5units.setEnabled(false);
                        btn6units.setEnabled(false);
                        btn7units.setEnabled(false);

                        layout_stage = 0;
                    }
                }, 500);
                break;


            case 2:

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        imgNumberBackground.startAnimation(fadeOut);
                        imgNumberBackground.setVisibility(View.INVISIBLE);

                        btnCHallenge_Words.setEnabled(true);
                        btnCHallenge_Words.setVisibility(View.VISIBLE);
                        btnCHallenge_Numbers.setEnabled(true);
                        btnCHallenge_Numbers.setVisibility(View.VISIBLE);

                        txtChooseTitle.startAnimation(fadeIn);
                        txtChooseTitle.setVisibility(View.VISIBLE);

                        btnBackMiddle.startAnimation(fadeOut);
                        btnBackMiddle.setVisibility(View.INVISIBLE);

                        btn4units.setVisibility(View.INVISIBLE);
                        btn5units.setVisibility(View.INVISIBLE);
                        btn6units.setVisibility(View.INVISIBLE);
                        btn7units.setVisibility(View.INVISIBLE);

                        btn4units.setEnabled(false);
                        btn5units.setEnabled(false);
                        btn6units.setEnabled(false);
                        btn7units.setEnabled(false);

                        layout_stage = 0;
                    }
                }, 500);
                break;
        }

//        super.onBackPressed();
    }
}