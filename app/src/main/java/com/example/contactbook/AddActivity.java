package com.example.contactbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText name_input, contact_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //getting the elements from view into variables
        name_input = findViewById(R.id.name_input);
        contact_input = findViewById(R.id.contact_input);

        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);

                //calling the addPerson function with name and contact as parameters
                myDB.addPerson(name_input.getText().toString().trim(), contact_input.getText().toString().trim());
            }
        });
    }
}
