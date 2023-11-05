package com.trodev.careermatcherpro.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.trodev.careermatcherpro.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PackageBuyActivity extends AppCompatActivity {

    TextInputEditText nameEt, emailEt, phoneEt, transactionEt;
    private MaterialButton uploadBtn;
    private DatabaseReference databaseReference;
    AutoCompleteTextView autoCompleteTextView, payment;
    TextView statusTv;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_buy);

        getSupportActionBar().setTitle("Package Confirmation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] type = {"Basic", "Gold", "Platinum", "Master"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.drop_down_list, type
        );

        autoCompleteTextView = findViewById(R.id.filled_exposed);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PackageBuyActivity.this, "আপনি " + autoCompleteTextView.getText().toString() + "  সিলেক্ট করেছেন", Toast.LENGTH_SHORT).show();
            }
        });

        String[] type_payment = {"Bkash", "Nogod", "Rocket"};
        ArrayAdapter<String> adapter_payment = new ArrayAdapter<>(
                this, R.layout.drop_down_list, type_payment
        );

        payment = findViewById(R.id.payment);
        payment.setAdapter(adapter_payment);

        payment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PackageBuyActivity.this, payment.getText().toString() + " সিলেক্ট করেছেন", Toast.LENGTH_SHORT).show();
            }
        });

        /*init views*/
        nameEt = findViewById(R.id.nameEt);
        emailEt = findViewById(R.id.emailEt);
        phoneEt = findViewById(R.id.phoneEt);
        transactionEt = findViewById(R.id.transactionEt);
        statusTv = findViewById(R.id.statusTv);
        uploadBtn = findViewById(R.id.upload_btn);

        databaseReference = FirebaseDatabase
                .getInstance()
                .getReference("package_payment")
                .child("package");

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {

        String name = nameEt.getText().toString().trim();
        String email = emailEt.getText().toString().trim();
        String phone = phoneEt.getText().toString().trim();
        String payments = payment.getText().toString().trim();
        String transactions = transactionEt.getText().toString().trim();
        String packages = autoCompleteTextView.getText().toString();
        String status = statusTv.getText().toString();

        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        String date = currentDate.format(calForDate.getTime());

        Calendar calForTime = Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("hh:mm a");
        String time = currentTime.format(calForTime.getTime());


        String Key = databaseReference.push().getKey();

        if (Key != null) {
            PackageModel emailModel = new PackageModel(Key, name, email, phone, payments, transactions, packages, status, date, time, FirebaseAuth.getInstance().getCurrentUser().getUid());

            /*these data save on new uid and also user id*/
            // reference.child(Key).setValue(emailModel);

            /*these data save on user id*/
            databaseReference.child(Key).setValue(emailModel);

            Toast.makeText(this, "save successful", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "un-successful", Toast.LENGTH_SHORT).show();
        }
    }

}