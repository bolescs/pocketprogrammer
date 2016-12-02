package cameron.boles.android.pocketprogrammer.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

import cameron.boles.android.pocketprogrammer.Note;
import cameron.boles.android.pocketprogrammer.database.NoteDbSchema.NoteTable;

/**
 * Created by Cameron Boles on 11/25/16.
 *
 * Retrieve info from database by wrapping the cursor object.
 *
 */

public class NoteCursorWrapper extends CursorWrapper
{
    public NoteCursorWrapper(Cursor cursor)
    {
        super(cursor);
    }

    public Note getNote()
    {
        String uuidString = getString(getColumnIndex(NoteTable.Cols.UUID));
        String title = getString(getColumnIndex(NoteTable.Cols.TITLE));
        long date = getLong(getColumnIndex(NoteTable.Cols.DATE));
        String body = getString(getColumnIndex(NoteTable.Cols.BODY));

        Note note = new Note(UUID.fromString(uuidString));
        note.setTitle(title);
        note.setDate(new Date(date));
        note.setBody(body);

        return note;
    }
}
