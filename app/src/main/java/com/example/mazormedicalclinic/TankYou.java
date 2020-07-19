package com.example.mazormedicalclinic;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.util.TimeZone;

public class TankYou extends Activity
{
    String dr;

    int year;
    int month;
    int day;
    int hour;
    int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tank_you);

        final EditText search_editText = findViewById(R.id.editText);
        Button search_btn = findViewById(R.id.search_btn);
        search_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String search = search_editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
                intent.putExtra(SearchManager.QUERY, search);
                startActivity(intent);
            }
        });

        Button add_to_calendar_btn = findViewById(R.id.add_to_calendar_btn);
        add_to_calendar_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(year, month-1, day, hour, minute);
                Calendar endTime = Calendar.getInstance();
                endTime.set(year, month-1, day, hour, minute+30);
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE, getResources().getString(R.string.calendar_name)+dr)
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, getResources().getString(R.string.address))
                        .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                        .putExtra(Intent.EXTRA_EMAIL, "avivmalkon@gmail.com");
                startActivity(intent);
            }
        });

        dr = getIntent().getStringExtra("doctor_name");
        search_editText.setText(dr);
        TextView app_approve = findViewById(R.id.appointment_approveTv);
        String app_approve_new_text = app_approve.getText().toString();
        app_approve.setText(app_approve_new_text + dr);

        year = getIntent().getIntExtra("year", -1);
        month = getIntent().getIntExtra("month", -1);
        day = getIntent().getIntExtra("day", -1);
        hour = getIntent().getIntExtra("hour", -1);
        minute = getIntent().getIntExtra("minute", -1);

        TextView dateTv = findViewById(R.id.dateTv);
        TextView timeTv = findViewById(R.id.timeTv);

        String on = dateTv.getText().toString();
        String at = timeTv.getText().toString();

        dateTv.setText(on + day + "/" + month + "/" + year);


        if (hour <= 9 || minute <= 9)
        {
            if (hour <= 9 && minute <= 9)
            {
                timeTv.setText(at + "0" + hour +":" + "0" + minute);
            }
            else if (hour <= 9)
            {
                timeTv.setText(at + "0" + hour +":" + minute);
            }
            else if (minute <= 9)
            {
                timeTv.setText(at + hour +":" + "0" + minute);
            }
        }else
        {
            timeTv.setText(at + hour +":" + minute);
        }


        Button back_to_main_menu_btn = findViewById(R.id.back_to_main_menu_btn);
        back_to_main_menu_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent main_menu_intent = new Intent(TankYou.this, MainActivity.class);
                startActivity(main_menu_intent);
            }
        });

        Button exit_btn = findViewById(R.id.exit_btn);
        exit_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finishAffinity();
                System.exit(0);
            }
        });

        Calendar curr = Calendar.getInstance();
        int curr_year = curr.get(Calendar.YEAR);
        int curr_month = curr.get(Calendar.MONTH);
        int curr_day = curr.get(Calendar.DAY_OF_MONTH);
        int curr_hour = curr.get(Calendar.HOUR_OF_DAY);

        Button alarm_btn = findViewById(R.id.alarm_btn);
        alarm_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent alarm_intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarm_intent.putExtra(AlarmClock.EXTRA_HOUR, hour-1);
                alarm_intent.putExtra(AlarmClock.EXTRA_MINUTES, minute);
                alarm_intent.putExtra(AlarmClock.EXTRA_MESSAGE, getResources().getString(R.string.reminder_msg));
                startActivity(alarm_intent);
            }
        });




    }
}
