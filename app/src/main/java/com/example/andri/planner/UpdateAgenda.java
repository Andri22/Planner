package com.example.andri.planner;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andri.planner.MainActivity;
import com.example.andri.planner.R;
import com.example.andri.planner.TambahAgenda;
import com.example.andri.planner.db.DataHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UpdateAgenda extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    protected static TextView displayCurrentTime;
    protected static TextView displayCurrentTime1;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private TextView dateView1;
    private int year, month, day;
    Button btnSave, btnCancel;

    com.example.andri.planner.db.DataHelper sqLiteHelper = new DataHelper(this);


    protected Cursor cursor;
    DataHelper DataHelper;

    EditText edtTitle, edtLokasi, edtNo;

    Button btnTmAwal, btnTmAkhir, btnTglAwal, btnTglAkhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_agenda);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update Agenda");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        edtTitle = findViewById(R.id.edit_title);
        edtLokasi = findViewById(R.id.edit_lokasi);

        btnTmAwal = findViewById(R.id.select_time);
        btnTmAkhir = findViewById(R.id.select_time1);

        btnTglAwal = findViewById(R.id.date_button_awal);
        btnTglAkhir = findViewById(R.id.date_button_akhir);


        final Intent intent = getIntent();
        Bundle bd = intent.getExtras();


        if(bd!=null){
            String getJudul = (String) bd.get("judul");
            edtTitle.setText(getJudul);
            String getLokasi = (String) bd.get("subtitle");
            edtLokasi.setText(getLokasi);
            String getWm = (String) bd.get("Wmulai");
            btnTmAwal.setText(getWm);
            String getWs = (String) bd.get("Wselesai");
            btnTmAkhir.setText(getWs);
            String getTm = (String) bd.get("Tmulai");
            btnTglAwal.setText(getTm);
            String getTs = (String) bd.get("Tselesai");
            btnTglAkhir.setText(getTs);
        }


        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View arg0) {

                Bundle idb = intent.getExtras();

                String id = (String) idb.get("id");
                String judul = edtTitle.getText().toString();
                String lokasi = edtLokasi.getText().toString();
                String waktu_mulai = dateView.getText().toString() + " " + displayCurrentTime.getText().toString().replace(" ", "");
                String waktu_selesai = dateView1.getText().toString() + " " + displayCurrentTime1.getText().toString().replace(" ", "");

                ((Button) arg0).getText().toString();

                System.out.println(waktu_mulai + " " + waktu_selesai);

                sqLiteHelper.update_biodata(id, judul, lokasi, waktu_mulai, waktu_selesai);
                        /* restart acrtivity */
                finish();

                Intent tambahagenda = new Intent(UpdateAgenda.this, MainActivity.class);
                startActivity(tambahagenda);

            }
        });

        btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        //Date

        dateView = (TextView) findViewById(R.id.date_button_awal);
        dateView1 = (TextView) findViewById(R.id.date_button_akhir);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //showDate(year, month + 1, day);
        //showDate1(year, month + 1, day);


        //Current Time Awal

        displayCurrentTime = (TextView) findViewById(R.id.select_time);
        Button displayTimeButton = (Button) findViewById(R.id.select_time);
        assert displayTimeButton != null;
        displayTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateAgenda.TimePicker mTimePicker = new UpdateAgenda.TimePicker();
                mTimePicker.show(getFragmentManager(), "Select time");
            }
        });


        //Curent Time Akhir

        displayCurrentTime1 = (TextView) findViewById(R.id.select_time1);
        Button displayTimeButton1 = (Button) findViewById(R.id.select_time1);
        assert displayTimeButton1 != null;
        displayTimeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateAgenda.TimePicker1 mTimePicker1 = new UpdateAgenda.TimePicker1();
                mTimePicker1.show(getFragmentManager(), "Select time");
            }
        });


        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Education");
        categories.add("Work");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home){
            finish();

        }
        return super.onOptionsItemSelected(item);
    }


    //Time Picker
    public static class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
            displayCurrentTime.setText(String.valueOf(hourOfDay) + " : " + String.valueOf(minute));
        }


    }

    public static class TimePicker1 extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
            displayCurrentTime1.setText(String.valueOf(hourOfDay) + " : " + String.valueOf(minute));
        }


    }

    //Date Picker
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        //akan menampilkan teks ketika kalendar muncul setelah menekan tombol
        Toast.makeText(getApplicationContext(), "Pilih Tangal", Toast.LENGTH_SHORT)
                .show();
    }

    public void setDate1(View view) {
        showDialog(998);
        //akan menampilkan teks ketika kalendar muncul setelah menekan tombol
        Toast.makeText(getApplicationContext(), "Pilih Tangal", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        } else if(id == 998){
            return new DatePickerDialog(this, myDateListener1, year, month, day);
        }
        return null;
    }



    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }



    private DatePickerDialog.OnDateSetListener myDateListener1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate1(arg1, arg2+1, arg3);
        }
    };

    private void showDate1(int year, int month, int day) {
        dateView1.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }



    //SPinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    @Override
    public void onBackPressed() {
        finish();
    }


    private void scheduleNotification(Notification notification, int delay) {

        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;

        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private Notification getNotification(String content) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("MAM IKI DIDANDANI :v");
        builder.setContentText(content);
        Notification.Builder builder1 = builder.setSmallIcon(R.drawable.ic_launcher_background);
        return builder.build();
    }



}