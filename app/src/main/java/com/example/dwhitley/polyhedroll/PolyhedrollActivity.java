package com.example.dwhitley.polyhedroll;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PolyhedrollActivity extends AppCompatActivity {
    final int numDice = 6;
    final int[] diceLookUp = {4,6,8,10,12,20};

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

    public void rollDice(View view){

        //setup an array to old the input boxes from the GUI
        TextView[] diceInput;
        diceInput = new TextView[numDice];

        //array to hold the converted values captured from the GUI
        int[] diceToRoll;
        diceToRoll = new int[numDice];

        //setup the output variable
        TextView output = (TextView) view.findViewById(R.id.rollOutput);

        //initialize the array.
        diceInput[0] = (TextView)  view.findViewById(R.id.d4_Num);
        diceInput[1] = (TextView) view.findViewById(R.id.d6_Num);
        diceInput[2] = (TextView) view.findViewById(R.id.d8_Num);
        diceInput[3] = (TextView) view.findViewById(R.id.d10_Num);
        diceInput[4] = (TextView) view.findViewById(R.id.d12_Num);
        diceInput[5] = (TextView) view.findViewById(R.id.d20_Num);

        for(int i = 0; i < numDice; ++i) {
            if(diceInput[i] != null) {
                diceToRoll[i] = Integer.getInteger(diceInput[i].toString());
                diceInput[i].setText("");
            }
            else
                diceToRoll[i] = 0;
        }

        for(int i = 0; i< numDice; ++i) {
            output.append("hi");
        }


    }
}
