package sqlite.ktp.id.ktpsqlite.libraries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import sqlite.ktp.id.ktpsqlite.model.Ktp;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "KTP";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
            String query = "Create Table "+Ktp.class.getSimpleName() +" ( " +
                    Ktp.ID+" Integer Primary Key Autoincrement, " +
                    Ktp.NIK+ " Text, " +
                    Ktp.NAMA+" Text, " +
                    Ktp.TANGGAL_LAHIR+" Date, " +
                    Ktp.JENIS_KELAMIN+" Text) ";
            db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("Drop Table IF EXISTS "+Ktp.class.getSimpleName());
            onCreate(db);
    }

    public long InsertKTP(Ktp dataKtp){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Ktp.NIK, dataKtp.getNik());
        contentValues.put(Ktp.NAMA, dataKtp.getNama());
        contentValues.put(Ktp.TANGGAL_LAHIR, dataKtp.getTanggalLahir());
        contentValues.put(Ktp.JENIS_KELAMIN, dataKtp.getJenisKelamin());
        return db.insert(Ktp.class.getSimpleName(),null,contentValues);
    }
    public Ktp GetDataById(int id){
        Cursor cursor = this.getReadableDatabase().rawQuery("Select * From "+
                        Ktp.class.getSimpleName()+" Where id = "+String.valueOf(id),
                        null);
        Ktp mKtp = new Ktp();
        if ((cursor!=null)&&(cursor.moveToFirst())){
                mKtp = bindKeModel(cursor);
        }
        return mKtp;
    }
    public List<Ktp> GetAllKtp(){
        Cursor cursor = this.getReadableDatabase().rawQuery("Select * From "+
                        Ktp.class.getSimpleName(), null);
        List<Ktp> listKtp = new ArrayList<>();
        Ktp mKtp = new Ktp();
        if ((cursor!=null)&&(cursor.moveToFirst())){
            mKtp = bindKeModel(cursor);
            listKtp.add(mKtp);
            while (cursor.moveToNext()){
                mKtp = bindKeModel(cursor);
                listKtp.add(mKtp);
            }
        }
        return listKtp;
    }
    private Ktp bindKeModel(Cursor cursor) {
        Ktp mKtp = new Ktp();
        mKtp.setId(cursor.getInt(0));
        mKtp.setNik(cursor.getString(1));
        mKtp.setNama(cursor.getString(2));
        mKtp.setTanggalLahir(cursor.getString(3));
        mKtp.setJenisKelamin(cursor.getString(4));
        return mKtp;
    }
    public long UpdateKtpByid(Ktp dataKtp){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Ktp.NIK, dataKtp.getNik());
        contentValues.put(Ktp.NAMA, dataKtp.getNama());
        contentValues.put(Ktp.TANGGAL_LAHIR, dataKtp.getTanggalLahir());
        contentValues.put(Ktp.JENIS_KELAMIN, dataKtp.getJenisKelamin());
        return db.update(Ktp.class.getSimpleName(),
                contentValues,"id = "+String.valueOf(dataKtp.getId()),
                null);
    }
    public long DeleteKtpById(int id){
        SQLiteDatabase db =  this.getWritableDatabase();
        return db.delete(Ktp.class.getSimpleName(),
                "id = "+String.valueOf(id),
                null);
    }

}
