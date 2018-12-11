package teddy.aula.br.a05_controle_abastecimento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final int databaseVersion = 1;

    public DbHelper(Context context)
    {
        super(context, "DataBase", null,  DbHelper.databaseVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String SQLCreatingTable = "CREATE TABLE fillUp (" + "ID INTEGER PRIMARY KEY AUTOINCREMENT," + "KM REAL,"
                + "LITROS REAL," + "LATITUDE REAL," + "LONGITUDE REAL," + "DATE TEXT," + "POSTO TEXT "
                + ");";
        db.execSQL(SQLCreatingTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE fillup");
        this.onCreate(db);
    }
}
