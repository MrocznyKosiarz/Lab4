import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by szpar on 27.04.2016.
 */
public class MySQLite extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    public MySQLite(Context context) {
        super(context, "braniaDB", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String DATABASE_CREATE = "CREATE TABLE brania (" +
                "id INTEGER PROMARY_KEY AUTOINCREMENT" +
                "gatunek TEXT NOT NULL" +
                "nazwa TEXT NOT NULL);";
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS brania");
        onCreate(db);
    }

    public void dodaj(Brania rybka) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("gatunek", rybka.getGatunek());
        values.put("nazwa", rybka.getNazwa());

        db.insert("brania", null, values);
        db.close();
    }

    public void usun(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("brania", " id = ?", new String[]{id});
        db.close();
    }

    public int aktualizuj(Brania rybka) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("gatunek", rybka.getGatunek());
        values.put("nazwa", rybka.getNazwa());
        int i = db.update("brania", values, " id = ?", new String[]{String.valueOf(rybka.getId())});
        db.close();
        return i;
    }

    public Brania pobierz(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("brania", //a. table name
                new String[]{"_id", "gatunek", "nazwa"}, // b.column names
                " id = ?", // c. selections
                new String[]{String.valueOf(id)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null);// h. limit

        if (cursor != null)
            cursor.moveToFirst();

        Brania rybka = new Brania(cursor.getString(1), cursor.getString(2));
        rybka.setId(Integer.parseInt(cursor.getString(0)));

        return rybka;
    }

    public Cursor lista() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM brania", null);
    }
}