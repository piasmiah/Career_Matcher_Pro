package com.trodev.careermatcherpro.cv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.trodev.careermatcherpro.R;


public class CVActivity extends AppCompatActivity {

    ImageView imageIv;
    Uri imageUri;
    private MaterialButton upload_btn;
    private FirebaseDatabase database;
    private FirebaseStorage storage;

    TextInputEditText payment_methodET, transactionEt;
    TextInputEditText nameEt, parentsEt, addressEt, gmailEt, mobileEt, skillEt, eduEt, nationalityEt,
            genderEt, religion_married_bloodET, langugae_skillET, extra_curriculmnET,
            training_certificateET, experienceET, social_mediaET, templateEt;

    TextView statusTv;
    ProgressDialog progressDialog;

    LinearLayout templateLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvactivity);

        /*action bar and title name*/
        getSupportActionBar().setTitle("CV Maker System");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*##################################################################################################################*/
        /*show alert dialog*/
        CardView cardView = findViewById(R.id.cardView);
        View view = LayoutInflater.from(CVActivity.this).inflate(R.layout.alert_dialog, cardView);
        Button yes = view.findViewById(R.id.yes);

        AlertDialog.Builder builder = new AlertDialog.Builder(CVActivity.this);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
                Toast.makeText(CVActivity.this, "সম্মতি দেওয়ার জন্য আপনাকে ধন্যবাদ", Toast.LENGTH_SHORT).show();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
        /*###############################################################################################################*/

        /*image and button views*/
        imageIv = findViewById(R.id.imageIv);
        upload_btn = findViewById(R.id.upload_btn);
        templateLl = findViewById(R.id.templateLl);

        /*init all widget*/
        payment_methodET = findViewById(R.id.payment_method);
        transactionEt = findViewById(R.id.transactionEt);
        templateEt = findViewById(R.id.templateEt);
        nameEt = findViewById(R.id.nameEt);
        parentsEt = findViewById(R.id.parentsEt);
        addressEt = findViewById(R.id.addressEt);
        mobileEt = findViewById(R.id.mobileEt);
        gmailEt = findViewById(R.id.gmailEt);
        skillEt = findViewById(R.id.skillEt);
        eduEt = findViewById(R.id.eduEt);
        nationalityEt = findViewById(R.id.nationalityEt);
        genderEt = findViewById(R.id.genderEt);
        religion_married_bloodET = findViewById(R.id.religion_married_blood);
        langugae_skillET = findViewById(R.id.langugae_skill);
        extra_curriculmnET = findViewById(R.id.extra_curriculmn);
        training_certificateET = findViewById(R.id.training_certificate);
        experienceET = findViewById(R.id.experience);
        social_mediaET = findViewById(R.id.social_media);
        statusTv = findViewById(R.id.statusTv);

        // #######################################
        /*set on click listener*/
        imageIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadImage();

            }
        });

        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadData();

            }
        });

        templateLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CVActivity.this, TemplateCVActivity.class));
            }
        });


        /*firebase setup*/
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

        // #######################################
        /*progressDialog*/
        progressDialog = new ProgressDialog(CVActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);

        progressDialog = ProgressDialog
                .show(this,
                        "আপনার আবেদনটি আপলোড হচ্ছে",
                        "অপেক্ষা করুন");
        progressDialog.hide();

    }

    private void uploadData() {

        progressDialog.show();

        final StorageReference reference = storage.getReference().child("user_cv").child(System.currentTimeMillis() + "");
        reference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        UserModel userModel = new UserModel();
                        userModel.setImage(uri.toString());

                        /*user payment method*/
                        userModel.setPayment_method(payment_methodET.getText().toString().trim());
                        userModel.setTransaction_id(transactionEt.getText().toString().trim());

                        /*user payment and transaction information*/
                        userModel.setName(nameEt.getText().toString().trim());
                        userModel.setParents(parentsEt.getText().toString().trim());
                        userModel.setTemplate(templateEt.getText().toString().trim());

                        /*personal information*/
                        userModel.setAddress(addressEt.getText().toString().trim());
                        userModel.setGmail(gmailEt.getText().toString().trim());
                        userModel.setMobile(mobileEt.getText().toString().trim());
                        userModel.setSkills(skillEt.getText().toString().trim());
                        userModel.setEducations(eduEt.getText().toString().trim());
                        userModel.setNationality(nationalityEt.getText().toString().trim());
                        userModel.setGender(genderEt.getText().toString().trim());
                        userModel.setReligion_married_blood(religion_married_bloodET.getText().toString().trim());
                        userModel.setLanguages(langugae_skillET.getText().toString().trim());
                        userModel.setExtra_curriculmn(extra_curriculmnET.getText().toString().trim());
                        userModel.setTraining_certificate(training_certificateET.getText().toString().trim());
                        userModel.setExperience(experienceET.getText().toString().trim());
                        userModel.setSocial_media(social_mediaET.getText().toString().trim());
                        userModel.setStatustv(statusTv.getText().toString().trim());


                        database.getReference().child("user_cv").push().setValue(userModel)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {

                                        progressDialog.hide();
                                        Toast.makeText(CVActivity.this, "আপলোড সম্পূর্ণ হয়েছে !!!", Toast.LENGTH_SHORT).show();

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        progressDialog.hide();
                                        Toast.makeText(CVActivity.this, "আপলোড সম্পূর্ণ হয় নাই\nআবার চেষ্টা করুন", Toast.LENGTH_SHORT).show();

                                    }
                                });

                    }
                });

            }
        });


    }


    private void uploadImage() {

        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        //  intent.setType("pdf/docs/ppt/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, 101);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(CVActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();

                    }
                }).check();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == RESULT_OK) {
            imageUri = data.getData();
            imageIv.setImageURI(imageUri);
        }

    }
}