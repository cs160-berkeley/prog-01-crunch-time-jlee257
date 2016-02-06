package com.example.aspire.crunchtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;


public class MainActivity extends AppCompatActivity {

    static double weight = 150;
    static double global_value = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout calorie_layout = (RelativeLayout) findViewById(R.id.calorie_button_layout);
        RelativeLayout pushup_layout = (RelativeLayout) findViewById(R.id.pushup_button_layout);
        RelativeLayout situp_layout = (RelativeLayout) findViewById(R.id.situp_button_layout);
        RelativeLayout squats_layout = (RelativeLayout) findViewById(R.id.squats_button_layout);
        RelativeLayout leglift_layout = (RelativeLayout) findViewById(R.id.leglift_button_layout);
        RelativeLayout plank_layout = (RelativeLayout) findViewById(R.id.plank_button_layout);
        RelativeLayout jumpingjacks_layout = (RelativeLayout) findViewById(R.id.jumpingjacks_button_layout);
        RelativeLayout pullup_layout = (RelativeLayout) findViewById(R.id.pullup_button_layout);
        RelativeLayout cycling_layout = (RelativeLayout) findViewById(R.id.cycling_button_layout);
        RelativeLayout walking_layout = (RelativeLayout) findViewById(R.id.walking_button_layout);
        RelativeLayout jogging_layout = (RelativeLayout) findViewById(R.id.jogging_button_layout);
        RelativeLayout swimming_layout = (RelativeLayout) findViewById(R.id.swimming_button_layout);
        RelativeLayout stairclimbing_layout = (RelativeLayout) findViewById(R.id.stairclimbing_button_layout);

        final TextView calorie_value = (TextView) findViewById(R.id.calorie_value_textview);
        final TextView pushup_value = (TextView) findViewById(R.id.pushup_value_textview);
        final TextView situp_value = (TextView) findViewById(R.id.situp_value_textview);
        final TextView squats_value = (TextView) findViewById(R.id.squats_value_textview);
        final TextView leglift_value = (TextView) findViewById(R.id.leglift_value_textview);
        final TextView plank_value = (TextView) findViewById(R.id.plank_value_textview);
        final TextView jumpingjacks_value = (TextView) findViewById(R.id.jumpingjacks_value_textview);
        final TextView pullup_value = (TextView) findViewById(R.id.pullup_value_textview);
        final TextView cycling_value = (TextView) findViewById(R.id.cycling_value_textview);
        final TextView walking_value = (TextView) findViewById(R.id.walking_value_textview);
        final TextView jogging_value = (TextView) findViewById(R.id.jogging_value_textview);
        final TextView swimming_value = (TextView) findViewById(R.id.swimming_value_textview);
        final TextView stairclimbing_value = (TextView) findViewById(R.id.stairclimbing_value_textview);

        final EditText weight_text = (EditText) findViewById(R.id.editWeight);
        weight_text.setText("150");
        Button update_button = (Button) findViewById(R.id.update_button);




        class Helps {
            public void helps(double val) {
                global_value = val;
                calorie_value.setText(String.format("%.1f cal", val*weight/150));
                pushup_value.setText(String.format("%.1f reps", val * 3.5));
                situp_value.setText(String.format("%.1f reps", val * 2));
                squats_value.setText(String.format("%.1f reps", val * 2.25));
                leglift_value.setText(String.format("%.1f min", val * 0.25));
                plank_value.setText(String.format("%.1f min", val * 0.25));
                jumpingjacks_value.setText(String.format("%.1f min", val * 0.1));
                pullup_value.setText(String.format("%.1f reps", val));
                cycling_value.setText(String.format("%.1f min", val * 0.12));
                walking_value.setText(String.format("%.1f min", val * 0.2));
                jogging_value.setText(String.format("%.1f min", val * 0.12));
                swimming_value.setText(String.format("%.1f min", val * 0.13));
                stairclimbing_value.setText(String.format("%.1f min", val * 0.15));

            }

            public void helps_calorie(double val) {
                global_value = val*150/weight;
                calorie_value.setText(String.format("%.1f cal", val));
                pushup_value.setText(String.format("%.1f reps", val * 3.5*150/weight));
                situp_value.setText(String.format("%.1f reps", val * 2*150/weight));
                squats_value.setText(String.format("%.1f reps", val * 2.25*150/weight));
                leglift_value.setText(String.format("%.1f min", val * 0.25*150/weight));
                plank_value.setText(String.format("%.1f min", val * 0.25*150/weight));
                jumpingjacks_value.setText(String.format("%.1f min", val * 0.1*150/weight));
                pullup_value.setText(String.format("%.1f reps", val*150/weight));
                cycling_value.setText(String.format("%.1f min", val * 0.12*150/weight));
                walking_value.setText(String.format("%.1f min", val * 0.2*150/weight));
                jogging_value.setText(String.format("%.1f min", val * 0.12*150/weight));
                swimming_value.setText(String.format("%.1f min", val * 0.13*150/weight));
                stairclimbing_value.setText(String.format("%.1f min", val * 0.15*150/weight));
            }
        }


        update_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = Double.parseDouble(String.valueOf(weight_text.getText()));
                Helps h = new Helps();
                h.helps(global_value);
            }
        });


        calorie_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.calorie_text));
                alertUnit.setText(getResources().getString(R.string.calorie));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()));
                        Helps h = new Helps();
                        h.helps_calorie(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        pushup_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.pushup_text));
                alertUnit.setText(getResources().getString(R.string.rep_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText())) / 3.5;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });



        situp_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.situp_text));
                alertUnit.setText(getResources().getString(R.string.rep_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()))/2;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        squats_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.squats_text));
                alertUnit.setText(getResources().getString(R.string.rep_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()))/2.25;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        leglift_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.leglift_text));
                alertUnit.setText(getResources().getString(R.string.min_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()))/0.25;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        plank_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.plank_text));
                alertUnit.setText(getResources().getString(R.string.min_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()))/0.25;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        jumpingjacks_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.jumpingjacks_text));
                alertUnit.setText(getResources().getString(R.string.min_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()))/0.1;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        pullup_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.pullup_text));
                alertUnit.setText(getResources().getString(R.string.rep_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()));
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        cycling_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.cycling_text));
                alertUnit.setText(getResources().getString(R.string.min_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()))/0.12;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        walking_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.walking_text));
                alertUnit.setText(getResources().getString(R.string.min_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()))/0.2;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        jogging_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.jogging_text));
                alertUnit.setText(getResources().getString(R.string.min_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()))/0.12;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        swimming_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.swimming_text));
                alertUnit.setText(getResources().getString(R.string.min_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()))/0.13;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


        stairclimbing_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (LayoutInflater.from(MainActivity.this)).inflate(R.layout.user_input, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.editText);
                TextView alertTitle = (TextView) view.findViewById(R.id.alert_title);
                TextView alertUnit = (TextView) view.findViewById(R.id.alert_unit);

                alertTitle.setText(getResources().getString(R.string.stairclimbing_text));
                alertUnit.setText(getResources().getString(R.string.min_text));

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        double val = Double.parseDouble(String.valueOf(userInput.getText()))/0.15;
                        Helps h = new Helps();
                        h.helps(val);
                    }
                });
                Dialog dialog = alertBuilder.create();
                dialog.show();
            }

        });


    }
}
