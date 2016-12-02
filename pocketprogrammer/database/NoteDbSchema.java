package cameron.boles.android.pocketprogrammer.database;

/**
 * Created by Cameron Boles on 11/24/16.
 *
 * Declare database column labels.
 *
 */

public class NoteDbSchema
{
    public static final class NoteTable
    {
        public static final String NAME = "notes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String BODY = "body";
        }
    }
}
