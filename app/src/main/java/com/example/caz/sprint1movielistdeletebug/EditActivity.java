package com.example.caz.sprint1movielistdeletebug;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    public static final String EDIT_CHECK_KEY = "edit_movie";
    public static final int EDIT_CODE = 99;

    private Context         context1;


    EditText editTitle;
    Movie movie;
    CheckBox watched_checkbox;
    Movie watchedMovie;
    Button save, delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editTitle = findViewById(R.id.edit_title);
        watched_checkbox = findViewById(R.id.watched_checkbox);
        save = findViewById(R.id.save_button);
        delete = findViewById(R.id.delete_button);

        movie = (Movie) getIntent().getSerializableExtra(EDIT_CHECK_KEY);
        if(movie == null) {
            movie = new Movie(Movie.NO_ID);
        }
        editTitle.setText(movie.getTitle());

        // if statement - if movie was previously checked in MainActivity, starting EditActivity already shows checkbox checked on start
        if(movie.isWatchedMovie()){
            watched_checkbox.setChecked(true);
        }


        watched_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(watched_checkbox.isChecked()) {
                    movie.setWatchedMovie(true);

                    //    Log.d("caz", "justine CHECK");
                } else {
                    movie.setWatchedMovie(false);
                    //    Log.d("caz", "justine UNCHECK");
                }


            }

        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    Log.d("caz", "justine SAVE PRESSED");

                prepResult();

                finish();   // Unlike onBackPressed Override, button needs finish() to continue back to MainActivity

            }
        });

        //STOP HERE
        //STOP HERE
        //STOP HERE
        //STOP HERE
        //STOP HERE

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //        movie = null;
//                Intent deleteIntent = new Intent();
//                setResult(Activity.RESULT_OK, deleteIntent);
//
//                finish();

//                Intent intent = new Intent(EditActivity.this, MainActivity.class);
//                intent.putExtra(EDIT_CHECK_KEY, movie);
//                startActivityForResult(intent, EDIT_CODE);
                //    finish();
/*
            //    movie.setTitle(editTitle.getText().toString());
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EDIT_CHECK_KEY, movie);
            //    resultIntent.removeExtra(EDIT_CHECK_KEY);
             //   setResult(Activity.RESULT_CANCELED, resultIntent);
                setResult(Activity.RESULT_OK,resultIntent);
*/

                deleteMethod();
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        // must set result here
        prepResult();
        super.onBackPressed();
    }


    private void prepResult() {
        movie.setTitle(editTitle.getText().toString());

        Intent resultIntent = new Intent();
        resultIntent.putExtra(EDIT_CHECK_KEY, movie);
        setResult(1, resultIntent);                             //don't forget to deal with magic numbers later
        //   setResult(Activity.RESULT_OK, resultIntent);
    }


    private void deleteMethod() {
        movie.setTitle(editTitle.getText().toString());
        movie.setMovieDelete(true);
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EDIT_CHECK_KEY, movie);


        //    resultIntent.removeExtra(EDIT_CHECK_KEY);
        //   setResult(Activity.RESULT_CANCELED, resultIntent);
        setResult(2,resultIntent);                               //don't forget to deal with magic numbers later
    }
}
