package cameron.boles.android.pocketprogrammer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import java.util.UUID;

/**
 * Created by Cameron Boles on 11/28/16.
 *
 * This class creates a dialog pop up for when a user attempts to delete
 *      a note from the LIST OF NOTES.
 */

public class DeleteFromListDialog extends DialogFragment
{
    public static final String ARG_NOTE = "note_id";

    public static DeleteFromListDialog newInstance(UUID noteId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_NOTE, noteId);

        DeleteFromListDialog fragment = new DeleteFromListDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final UUID noteID = (UUID) getArguments().getSerializable(ARG_NOTE);

        return new AlertDialog.Builder(getActivity()).setTitle(R.string.delete_dialog)
                .setPositiveButton(R.string.delete_note, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        NoteLab.get(getActivity()).deleteNote(noteID);
                        Intent i = new Intent(getActivity(), NoteListActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(i);
                    }
                }).setNegativeButton(android.R.string.cancel, null)
                .create();
    }
}
