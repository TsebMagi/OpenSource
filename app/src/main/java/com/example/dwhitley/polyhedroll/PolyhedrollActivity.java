package com.example.dwhitley.polyhedroll;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class PolyhedrollActivity extends AppCompatActivity {
    final int numDice = 6;
    final int[] diceLookUp = {4, 6, 8, 10, 12, 20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polyhedroll);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_polyhedroll, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void rollDice(View v) {

        //setup an array to old the input boxes from the GUI
        TextView[] diceInput;
        diceInput = new TextView[numDice];

        //array to hold the converted values captured from the GUI
        int[] diceToRoll;
        diceToRoll = new int[numDice];

        //setup the output variable
        TextView output;
        output = (TextView) this.findViewById(R.id.rollOutput);

        //initialize the array.
        diceInput[0] = (TextView) this.findViewById(R.id.d4_Num);
        diceInput[1] = (TextView) this.findViewById(R.id.d6_Num);
        diceInput[2] = (TextView) this.findViewById(R.id.d8_Num);
        diceInput[3] = (TextView) this.findViewById(R.id.d10_Num);
        diceInput[4] = (TextView) this.findViewById(R.id.d12_Num);
        diceInput[5] = (TextView) this.findViewById(R.id.d20_Num);

        for (int i = 0; i < numDice; ++i) {
            {
                String toConvert = diceInput[i].getText().toString();
                try{
                    diceToRoll[i] = Integer.parseInt(toConvert);
                    diceInput[i].setText("");
                }
                catch(NumberFormatException gotIt) {
                    diceToRoll[i] = 0;
                }
                if(diceToRoll[i] > 0)
                    diceRoll(diceLookUp[i],diceToRoll[i],output);
            }


        }
    }


    //calculate and output the dice results.
    private void diceRoll(int diceSides, int numToRoll, TextView output) {
        int total = 0;
        int rand;
        Random randGen = new Random(SystemClock.currentThreadTimeMillis());


        output.append("D"+diceSides +"'s" +" Rolled: ");
        for (int i = 0; i < numToRoll; ++i) {
            rand = (((Math.abs(randGen.nextInt()))%diceSides) +1);
            total += rand;
            if(i == (numToRoll-1))
            output.append("" + rand + "\n");
            else
                output.append(rand + ", ");
        }

        output.append("Total for D"+diceSides+"'s: "+total + "\n");
    }

    public void clearOutput(View v) {
        TextView toClear = (TextView) this.findViewById(R.id.rollOutput);
        toClear.setText("");
    }
}