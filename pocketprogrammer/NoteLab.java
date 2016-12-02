package cameron.boles.android.pocketprogrammer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import cameron.boles.android.pocketprogrammer.database.NoteCursorWrapper;
import cameron.boles.android.pocketprogrammer.database.NoteDbSchema.NoteTable;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import cameron.boles.android.pocketprogrammer.database.NoteBaseHelper;

/**
 * Created by Cameron Boles on 11/17/16.
 *
 * This class allows for manipulating the database of notes.
 */

public class NoteLab
{
    private static NoteLab sNoteLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static NoteLab get(Context context)
    {
        if (sNoteLab == null)
        {
            sNoteLab = new NoteLab(context);
        }
        return sNoteLab;
    }

    private NoteLab(Context context)
    {
        mContext = context.getApplicationContext();
        mDatabase = new NoteBaseHelper(mContext).getWritableDatabase();

    }

    public void addNote(Note n)
    {
        ContentValues values = getContentValues(n);
        mDatabase.insert(NoteTable.NAME, null, values);
    }

    public void deleteNote(UUID noteID)
    {
        String uuidString = noteID.toString();
        mDatabase.delete(NoteTable.NAME, NoteTable.Cols.UUID + " = ?",
                new String []{uuidString});
    }

    public List<Note> getNotes()
    {
        List<Note> notes = new ArrayList<>();
        NoteCursorWrapper cursor = queryNotes(null, null);

        try
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                notes.add(cursor.getNote());
                cursor.moveToNext();
            }
        }
        finally
        {
            cursor.close();
        }

        return notes;
    }

    public Note getNote(UUID id)
    {
        NoteCursorWrapper cursor = queryNotes(NoteTable.Cols.UUID + " = ?",
                new String[] {id.toString()});

        try
        {
            if (cursor.getCount() == 0)
            {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getNote();
        }
        finally
        {
            cursor.close();
        }
    }

    //retrieve the taken image from the device's files.
    public File getPhotoFile(Note note)
    {
        File externalFilesDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (externalFilesDir == null)
        {
            return null;
        }

        return new File(externalFilesDir, note.getPhotoFilename());
    }

    public void updateNote(Note note)
    {
        String uuidString = note.getId().toString();
        ContentValues values = getContentValues(note);

        mDatabase.update(NoteTable.NAME, values, NoteTable.Cols.UUID + " = ?", new String[] {uuidString});
    }

    //This method stores the aspects of each Note object into the database.
    //  each Note's title is stored in the TITLE column, body in BODY column, etc...
    private static ContentValues getContentValues(Note note)
    {
        ContentValues values = new ContentValues();
        values.put(NoteTable.Cols.UUID, note.getId().toString());
        values.put(NoteTable.Cols.TITLE, note.getTitle());
        values.put(NoteTable.Cols.DATE, note.getDate().getTime());
        values.put(NoteTable.Cols.BODY, note.getBody());

        return values;
    }

    //This method allows for accessing specific locations in the databse.
    private NoteCursorWrapper queryNotes(String whereClause, String[] whereArgs)
    {
        Cursor cursor = mDatabase.query(
                NoteTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new NoteCursorWrapper(cursor);
    }
}
