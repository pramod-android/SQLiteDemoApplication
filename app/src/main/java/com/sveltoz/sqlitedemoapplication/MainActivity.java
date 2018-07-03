package com.sveltoz.sqlitedemoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db;
    Button btnView,btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd=(Button)findViewById(R.id.buttonAdd);
        btnView=(Button)findViewById(R.id.buttonView);

        db=new DatabaseHandler(this);



       btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Visitor visitor=new Visitor();
               visitor.setName("name");
               visitor.setLanguage("JAVA");
               visitor.setEmail("abc@gmail.com");
               visitor.setNumber("99999999");
               visitor.setDate("03-07-2018");
               Long result=db.insertVisitor(visitor);
               Log.i("result :",String.valueOf(result));
           }
       });

       btnView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ArrayList<Visitor> visitorsList=db.getAllVisitors();
               Toast.makeText(getApplicationContext(),visitorsList.get(0).name,Toast.LENGTH_SHORT).show();
              // Log.i("Visitors :",visitorsList.get(0).name);
           }
       });






    }
}
