package sqlite.ktp.id.ktpsqlite;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import sqlite.ktp.id.ktpsqlite.libraries.DatabaseHelper;
import sqlite.ktp.id.ktpsqlite.model.Ktp;

public class HomeActivity extends AppCompatActivity {

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new DatabaseHelper(getApplicationContext());

        long index = db.InsertKTP(new Ktp(0,
                            "1010101001010",
                            "Arie",
                            "2000-12-12",
                            "laki-laki"
                            ));
        Log.i("Insert", String.valueOf(index));
        Log.i("get", db.GetDataById((int)index).toString());
    }
}
