package com.sveltoz.sqlitedemoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class VisitorsListActivity extends AppCompatActivity {
    DatabaseHandler db;
    ArrayList<Visitor> visitorsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitors_list);
        db=new DatabaseHandler(this);
        visitorsList=db.getAllVisitors();

        ListView listView=(ListView)findViewById(R.id.listview);
        CustomAdaptor customAdaptor=new CustomAdaptor();
        listView.setAdapter(customAdaptor);


    }
    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return visitorsList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.list_item,null);

            // ImageView imageView=(ImageView)view.findViewById(R.id.image);
            TextView textViewName=(TextView)view.findViewById(R.id.name);
            TextView textViewDesc=(TextView)view.findViewById(R.id.desc);

            //imageView.setImageResource(visitorsList.get(position).getName());
            textViewName.setText(visitorsList.get(position).getName());
            textViewDesc.setText(visitorsList.get(position).getLanguage());


            return view;
        }
    }

}
