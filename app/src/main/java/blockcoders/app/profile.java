package blockcoders.app;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.view.menu.*;
import android.view.Menu;
import android.view.MenuItem;
import android.preference.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ScrollView;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        Bitmap bm = imagePlace(R.drawable.totoro, 150, 150);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageBitmap(bm);
        image.setImageResource(R.drawable.totoro);


        LinearLayout name = (LinearLayout) findViewById(R.id.name);

        OnClickListener nameListen = new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, Click_field1.class);
                startActivity(intent);
            }
        };

        name.setOnClickListener(nameListen);

        //LinearLayout field1 = (LinearLayout) scroll.findViewById(R.id.field1);
        //OnClickListener field1Listen = new OnClickListener() {
        //    public void onClick(View v)
        //    {
        //        Intent intent = new Intent(profile.this, Click_field1.class);
        //        startActivity(intent);
        //    }
        //};
        //field1.setOnClickListener(field1Listen);


        //field1.setOnClickListener(new View.OnClickListener(){
        //    @Override
        //    public void onClick(View v)
        //    {
   //             Intent intent = new Intent(this, Click_field1.class);
   //             startActivity(intent);
        //    }
        //});
    }
//    public void click_field2(View view){
//        Intent intent = new Intent(this, Click_field2.class);
//        StartActivity(intent);
//    }
//    public void click_field3(View view){
//        Intent intent = new Intent(this, Click_field3.class);
//        StartActivity(intent);
//    }
//    public void click_field4(View view){
//        Intent intent = new Intent(this, Click_field4.class);
//        StartActivity(intent);
//    }
//    public void click_field5(View view){
//        Intent intent = new Intent(this, Click_field5.class);
//        StartActivity(intent);
//    }

    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.preferences);
        }
    }



    private Bitmap imagePlace(int resId, int reqWidth, int reqHeight)
    {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(getResources(), resId, options);

    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}

