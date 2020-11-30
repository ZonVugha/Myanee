package com.example.myanee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer Player00,Player98,Player99,Player94,Player95,Player91;
    private ImageView imageView;
    private TextView tvnumber;
    int number;
    MySQLiteOpenHelper openHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Player();
        open();
        openHelper=new MySQLiteOpenHelper(this,MySQLiteOpenHelper.DATABAENAME,null,1);
        database=openHelper.getReadableDatabase();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int num = (int) (Math.random() * 6);
                Log.i("TAG", "onClick: num"+num);
                ContentValues values=new ContentValues();
                values.put(MySQLiteOpenHelper.COLNUM,number++);
                database.insert(MySQLiteOpenHelper.TABLENAME,null,values);
                Cursor cursor=database.query(MySQLiteOpenHelper.TABLENAME,null,null,null,null,null,null);

                if (cursor.moveToFirst()) {
                    do {
                        int id = cursor.getInt(cursor.getColumnIndex(MySQLiteOpenHelper.COLID));
                        tvnumber.setText(String.valueOf(id));
                        Log.i("TAG", "onCreate: number" + number);
                        Log.i("TAG", "onCreate: num" + id);
                    }while (cursor.moveToNext());
                }
                switch (num) {

                    case 0:
                        Player91.start();
                        imageView.setImageResource(R.drawable.file_5454091);
                        Toast.makeText(getApplicationContext(), "Mya～↗nee～→",
                                Toast.LENGTH_SHORT).show();

                        break;
                    case 1:
                        Player94.start();
                        imageView.setImageResource(R.drawable.file_5450094);
                        Toast.makeText(getApplicationContext(), "Mya～↘nee～↗",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Player95.start();
                        imageView.setImageResource(R.drawable.file_5450095);
                        Toast.makeText(getApplicationContext(), "Mya～↗nee～↗",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Player99.start();
                        imageView.setImageResource(R.drawable.file_5454099);
                        Toast.makeText(getApplicationContext(), "Mya～～nee～～",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Player98.start();
                        imageView.setImageResource(R.drawable.file_5454098);
                        Toast.makeText(getApplicationContext(), "Mya～↘nee～↗",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Player00.start();
                        imageView.setImageResource(R.drawable.file_5454100);
                        Toast.makeText(getApplicationContext(), "Mya→nee～→",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
    private void open(){
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0f, 1.0f);
        alphaanimation.setDuration(1000);
        alphaanimation.setFillAfter(true);
        imageView.startAnimation(alphaanimation);

    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.imageView);
        tvnumber = (TextView) findViewById(R.id.tvnumber);
    }
    //Play sound
    private void Player(){
        Player00 =MediaPlayer.create(this,R.raw.lingling);
        Player98 =MediaPlayer.create(this,R.raw.jiuba);
        Player99 =MediaPlayer.create(this,R.raw.jiujiu);
        Player94 =MediaPlayer.create(this,R.raw.jiusi);
        Player95 =MediaPlayer.create(this,R.raw.jiuwubg);
        Player91 =MediaPlayer.create(this,R.raw.jiuyi);
    }

}