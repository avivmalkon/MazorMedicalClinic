package com.example.mazormedicalclinic;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TimePicker;
import java.util.Calendar;

public class Book extends Activity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener
{
    int day, month, year, hour, minute;
    int day_x, month_x, year_x, hour_x, minute_x;
    String dr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Button back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent back_intent = new Intent(Book.this, MainActivity.class);
                startActivity(back_intent);

            }
        });


        ImageButton dr1_book_btn = findViewById(R.id.dr1_book_btn);
        dr1_book_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dr = getResources().getString(R.string.dr1);
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, Book.this, year, month, day);
                datePickerDialog.show();


            }
        });


        ImageButton dr2_book_btn = findViewById(R.id.dr2_book_btn);
        dr2_book_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dr = getResources().getString(R.string.dr2);
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, Book.this, year, month, day);
                datePickerDialog.show();


            }
        });


        ImageButton dr3_book_btn = findViewById(R.id.dr3_book_btn);
        dr3_book_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dr = getResources().getString(R.string.dr3);
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, Book.this, year, month, day);
                datePickerDialog.show();


            }
        });


        ImageButton dr4_book_btn = findViewById(R.id.dr4_book_btn);
        dr4_book_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dr = getResources().getString(R.string.dr4);
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, Book.this, year, month, day);
                datePickerDialog.show();


            }
        });


        ImageButton dr5_book_btn = findViewById(R.id.dr5_book_btn);
        dr5_book_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dr = getResources().getString(R.string.dr5);
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, Book.this, year, month, day);
                datePickerDialog.show();


            }
        });


        ImageButton dr6_book_btn = findViewById(R.id.dr6_book_btn);
        dr6_book_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dr = getResources().getString(R.string.dr6);
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, Book.this, year, month, day);
                datePickerDialog.show();


            }
        });


        ImageButton dr7_book_btn = findViewById(R.id.dr7_book_btn);
        dr7_book_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dr = getResources().getString(R.string.dr7);
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, Book.this, year, month, day);
                datePickerDialog.show();


            }
        });


        ImageButton dr8_book_btn = findViewById(R.id.dr8_book_btn);
        dr8_book_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dr = getResources().getString(R.string.dr8);
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, Book.this, year, month, day);
                datePickerDialog.show();


            }
        });


        ImageButton dr9_book_btn = findViewById(R.id.dr9_book_btn);
        dr9_book_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dr = getResources().getString(R.string.dr9);
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Book.this, Book.this, year, month, day);
                datePickerDialog.show();


            }
        });



    }

    @Override
    public void onDateSet(DatePicker view, int y, int m, int d)
    {
        year_x = y;
        month_x = m + 1;
        day_x = d;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(Book.this, Book.this, hour, minute, true);
        timePickerDialog.show();


    }

    @Override
    public void onTimeSet(TimePicker view, int h, int m)
    {
        hour_x = h;
        minute_x = m;

        Intent tank_intent = new Intent(Book.this, TankYou.class);


        tank_intent.putExtra("doctor_name", dr);

        tank_intent.putExtra("year", year_x);
        tank_intent.putExtra("month", month_x);
        tank_intent.putExtra("day", day_x);

        tank_intent.putExtra("hour", hour_x);
        tank_intent.putExtra("minute", minute_x);



        startActivity(tank_intent);

    }
}
