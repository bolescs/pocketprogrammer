package cameron.boles.android.pocketprogrammer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cameron.boles.android.pocketprogrammer.database.NoteDbSchema.NoteTable;

/**
 * Created by Cameron Boles on 11/25/16.
 *
 * Creates the SQLite table.  Option of upgrade.
 */

public class NoteBaseHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "noteBase.db";

    public NoteBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + NoteTable.NAME + "(" + " _id integer primary key autoincrement, " +
                NoteTable.Cols.UUID + ", " + NoteTable.Cols.TITLE + ", " +
                NoteTable.Cols.DATE + ", " + NoteTable.Cols.BODY + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }


}
