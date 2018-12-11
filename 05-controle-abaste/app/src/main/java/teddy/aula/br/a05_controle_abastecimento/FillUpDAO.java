package teddy.aula.br.a05_controle_abastecimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import java.util.ArrayList;


public class FillUpDAO {

    private static ArrayList<FillUp> Cache = new ArrayList<FillUp>();

    public static boolean save (Context context, FillUp object)
    {
        DbHelper helper = new DbHelper (context);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues data = new ContentValues();
        data.put("km" , object.getKilometers());
        data.put("litros" , object.getLiters());
        data.put("latitude" , object.getLatitude());
        data.put("longitude" , object.getLongitude());
        data.put("date" , object.getDate());
        data.put("posto" , object.getGasStation());
        long id = db.insert("fillup", null, data);
        object.setId(id);

        Cache.add(object);
        return true;
    }

    public static boolean delete (Context context, FillUp Del)
    {
        DbHelper db = new DbHelper(context);
        SQLiteDatabase database = db.getWritableDatabase();

        String[] whereID = {String.valueOf(Del.getId())};
        database.delete("fillup", "id = ?", whereID);
        getList(context);
        return true;
    }

    public static ArrayList <FillUp> getList (Context context)
    {
        Cache = new ArrayList<FillUp>();

        DbHelper db = new DbHelper(context);
        SQLiteDatabase database = db.getReadableDatabase();

        String lookUp = "SELECT km, litros, latitude, longitude, date, posto, id FROM fillup";
        Cursor cursor = database.rawQuery(lookUp, null);

        while (cursor.moveToNext())
        {
            FillUp next = new FillUp();
            next.setKilometers(cursor.getDouble(0));
            next.setLiters(cursor.getDouble(1));
            next.setLatitude(cursor.getDouble(2));
            next.setLongitude(cursor.getDouble(3));
            next.setDate(cursor.getString(4));
            next.setGasStation(cursor.getString(5));
            next.setId(cursor.getLong(6));

            Cache.add(next);
        }
        return Cache;
    }
}
