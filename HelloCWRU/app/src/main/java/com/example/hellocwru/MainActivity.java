package com.example.hellocwru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    Button callButton;
    EditText phoneNumber;

    Button textButton;
    EditText textMessage;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callButton = (Button) findViewById(R.id.callButton);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);

        textButton = (Button) findViewById(R.id.sendText);
        textMessage = (EditText) findViewById(R.id.textMessage);

        callButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callPhone(phoneNumber.getText().toString());
                    }
                }
        );
        textButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(MainActivity.class.getName());
                        sendText(phoneNumber.getText().toString(), textMessage.getText().toString());
                    }
                }
        );


    }

    private void callPhone(String number){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+number));
        startActivity(callIntent);
    }

    private void sendText(String number, String text){
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.putExtra("address", number);
        sendIntent.putExtra("sms_body", text);
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);
    }
}
