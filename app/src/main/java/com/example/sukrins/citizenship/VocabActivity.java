package com.example.sukrins.citizenship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VocabActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<String>();
    ListView lv;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocab_activity);

        list.add("Advocate: support");
        list.add("Alimony: money paid to ex-spouse");
        list.add("Allegiance: loyalty");
        list.add("Arrested: police taking someone to jail");
        list.add("Bear arms: carry guns/weapons");
        list.add("Claim: to say/declare");
        list.add("Communist: government of North Korea or Cuba");
        list.add("Controlled substance: illegal drugs, cocaine, heroin, or marijuana");
        list.add("Convicted: be declared guilty");
        list.add("Crime: break a law");
        list.add("Dependent: children");
        list.add("Deported: must leave the country");
        list.add("Form of government of the United States: democracy; democratic republic");
        list.add("Gamble: play games for moeny");
        list.add("Habitual drunkard: someone who drinks too much");
        list.add("Incompetent: unable to do something");
        list.add("Lie: to not tell the truth");
        list.add("Mental institution: mental hospital");
        list.add("Misleading: not true");
        list.add("Noncombatant: not fighting");
        list.add("Oath: promise");
        list.add("Overthrow: remove");
        list.add("Perjury: lie");
        list.add("Persecute: to hurt someone");
        list.add("Prostitute: sell sex for moeny");
        list.add("Register: to sign up");
        list.add("Removal: taken out of the country");
        list.add("Terrorism: Use of violence to control government and people; Al-Qaeda");
        list.add("Title of nobility: king, queen, prince, princess");
        list.add("Totalitarianism: One political party controls the government");
        list.add("Vote: choose");
        list.add("Work of national importance: help the country during disasters (fires, floods, hurricanes, earthquakes)");


        listView();

    }

    public void listView() {

        adapter = new CustomListAdapter(this, list);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) lv.getItemAtPosition(position);
                Toast.makeText(VocabActivity.this, value, Toast.LENGTH_LONG).show();
            }
        });

    }


}
