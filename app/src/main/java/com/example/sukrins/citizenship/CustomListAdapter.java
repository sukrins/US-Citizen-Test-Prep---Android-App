package com.example.sukrins.citizenship;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {
    ArrayList<String> vocab;
    Context context;

    public CustomListAdapter(Activity context, ArrayList<String> text) {
        super(context, R.layout.vocab_list, text);
        this.vocab = text;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.vocab_list, null,
                true);
        TextView textView = (TextView) row.findViewById(R.id.vocab_text);
        textView.setText(vocab.get(position));
        return row;

    }


}