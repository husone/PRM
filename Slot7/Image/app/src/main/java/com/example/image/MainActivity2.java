package com.example.image;

import static com.squareup.picasso.Picasso.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
public class MainActivity2 extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView ivPicture = (ImageView)
                findViewById(R.id.ivPicture2);
        String url = "https://scontent.fsgn2-9.fna.fbcdn.net/v/t39.30808-6/336439459_744188434021533_8003211980009344766_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=eEcGQG7XEwcAX8nce1U&_nc_ht=scontent.fsgn2-9.fna&oh=00_AfBVC46MbWrhfbi1_qygkn94IQw8N9UMABws3VxluGtyuw&oe=647CDEBA";
        if (url == null || url.equals("")) {
            Toast.makeText(MainActivity2.this, "Error",
                    Toast.LENGTH_LONG).show();
        } else {

            Picasso.with(MainActivity2.this).load(url).into(ivPicture);
        }
    }
}