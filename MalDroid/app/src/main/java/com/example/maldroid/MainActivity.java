package com.example.maldroid;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.ComponentName;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button maliciousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maliciousButton = (Button) findViewById(R.id.maliciousButton);

        maliciousButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        beMalicious();
                    }
                }
        );
    }

    private void beMalicious(){
        Intent mal = new Intent();
        ComponentName cn = new ComponentName("com.example.hellocwru", "com.example.hellocwru.MainActivity");
        mal.setComponent(cn);
        mal.setAction("android.intent.action.MAIN");
        mal.addCategory("android.intent.action.Launcher");
        startActivity(mal);
    }
}
