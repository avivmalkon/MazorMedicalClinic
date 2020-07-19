package com.example.mazormedicalclinic;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contact extends Activity
{
    Button dial_btn;
    final int CALL_PERMISSION_REQ = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        final EditText subject_et = findViewById(R.id.subjectEt);
        final EditText body_et = findViewById(R.id.bodyEt);

        Button add_to_contacts_btn = findViewById(R.id.add_to_contacts_btn);
        add_to_contacts_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent contacts_intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                contacts_intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                contacts_intent
                        .putExtra(ContactsContract.Intents.Insert.EMAIL, "avivmalkon@gmail.com")
                        .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                        .putExtra(ContactsContract.Intents.Insert.PHONE, "039668572")
                        .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                        .putExtra(ContactsContract.Intents.Insert.PHONETIC_NAME, getResources().getString(R.string.app_name));

                startActivity(contacts_intent);


            }
        });

        Button waze_btn = findViewById(R.id.waze_btn);
        waze_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String lat = "32.053090";
                String lng = "34.932870";

                try
                {
                    String url = "waze://?ll=" + lat + "," + lng + "&navigate=yes";
                    Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity( intent );
                }
                catch (ActivityNotFoundException ex)
                {
                    Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "market://details?id=com.waze" ) );
                    startActivity(intent);
                }
            }
        });


        Button send_btn = findViewById(R.id.send_btn);
        send_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /*Intent send_mail_intent = new Intent(Intent.ACTION_SENDTO);
                send_mail_intent.putExtra(Intent.EXTRA_TEXT, body_et.getText().toString());
                send_mail_intent.putExtra(Intent.EXTRA_SUBJECT, subject_et.getText().toString());
                send_mail_intent.setData(Uri.parse("mailto:avivmalkon@gmail.com"));
                startActivity(Intent.createChooser(send_mail_intent, getResources().getString(R.string.send_with)));*/

                Uri uri = Uri.parse("mailto:avivmalkon@gmail.com").buildUpon()
                        .appendQueryParameter("subject", subject_et.getText().toString())
                        .appendQueryParameter("body", body_et.getText().toString()).build();
                Intent send_mail_intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(Intent.createChooser(send_mail_intent, getResources().getString(R.string.send_with)));
            }
        });



        Button back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_intent = new Intent(Contact.this, MainActivity.class);
                startActivity(back_intent);
            }
        });


        dial_btn = findViewById(R.id.dial_btn);
        dial_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String number = dial_btn.getText().toString();

                Intent dial_intent = new Intent(Intent.ACTION_DIAL);
                dial_intent.setData(Uri.parse("tel:" + number));
                startActivity(dial_intent);
            }
        });


        final Button call_btn = findViewById(R.id.call_btn);
        call_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (Build.VERSION.SDK_INT >= 23)
                {
                    int hasCallPer = checkSelfPermission(Manifest.permission.CALL_PHONE);

                    if (hasCallPer == PackageManager.PERMISSION_GRANTED)
                    {
                        callPhone();
                    }
                    else
                    {
                        requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, CALL_PERMISSION_REQ);
                    }


                } else
                {
                    callPhone();
                }
            }
        });



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == CALL_PERMISSION_REQ)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callPhone();
            }
            else
            {
                Toast.makeText(this, getResources().getString(R.string.pls_grant_call_per), Toast.LENGTH_LONG).show();

                Intent send_to_settings_intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                send_to_settings_intent.setData(Uri.parse("package:"+getPackageName()));
                startActivity(send_to_settings_intent);


            }
        }

    }

    private void callPhone()
    {
        String number = dial_btn.getText().toString();

        Intent call_intent = new Intent(Intent.ACTION_CALL);
        call_intent.setData(Uri.parse("tel:" + number));
        startActivity(call_intent);
    }
}


