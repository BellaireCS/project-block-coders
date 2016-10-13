package blockcoders.app;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_profile);
        goToProfileActivity();
//        setContentView(R.layout.activity_main);
    }
    public void goToProfileActivity() {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }

}

