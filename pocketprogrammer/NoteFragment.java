package cameron.boles.android.pocketprogrammer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by Cameron Boles on 11/17/16.
 *
 * This fragment is displayed when a note item is clicked.
 *   It allows for editing and deleting the note.
 */

public class NoteFragment extends Fragment
{
    private static final String ARG_NOTE_ID = "note_id";
    private static final String DIALOG_DELETE = "DialogDelete";
    private static final int REQUEST_PHOTO = 2;

    private Note mNote;
    private EditText mTitleField;
    private Button mDateButton;
    private EditText mNoteBody;
    private ImageButton mPhotoButton;
    private ImageView mPhotoView;
    private File mPhotoFile;
    private boolean isImageFitToScreen;

    //allows for other classes to reference items within this fragment.
    public static NoteFragment newInstance(UUID noteId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_NOTE_ID, noteId);

        NoteFragment fragment = new NoteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        UUID noteId = (UUID) getArguments().getSerializable(ARG_NOTE_ID);
        mNote = NoteLab.get(getActivity()).getNote(noteId);
        mPhotoFile = NoteLab.get(getActivity()).getPhotoFile(mNote);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPause()
    {
        super.onPause();

        NoteLab.get(getActivity()).updateNote(mNote);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_note, container, false);

        mTitleField = (EditText) v.findViewById(R.id.note_title);
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(mTitleField.getWindowToken(), 0);
        mTitleField.setText(mNote.getTitle());

        //save the title
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //no need.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mNote.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //no need.
            }
        });

        mNoteBody = (EditText) v.findViewById(R.id.note_body);
        mNoteBody.setText(mNote.getBody());

        //save the body
        mNoteBody.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mNote.setBody(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button) v.findViewById(R.id.note_date);
        mDateButton.setText(DateFormat.format("EEEE, MMM d, yyyy", mNote.getDate()).toString());
        mDateButton.setEnabled(false);

        PackageManager packageManager = getActivity().getPackageManager();

        //next few lines allow for taking photo.
        mPhotoButton = (ImageButton) v.findViewById(R.id.note_camera);
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        boolean canTakePhoto = mPhotoFile != null && captureImage.resolveActivity(packageManager) != null;
        mPhotoButton.setEnabled(canTakePhoto);

        if (canTakePhoto)
        {
            Uri uri = Uri.fromFile(mPhotoFile);
            captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }

        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });

        mPhotoView = (ImageView) v.findViewById(R.id.note_photo);
        updatePhotoView();

        //allows for note picture to be expanded when clicked.
        mPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isImageFitToScreen)
                {
                    isImageFitToScreen = false;
                    mPhotoView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    mPhotoView.setAdjustViewBounds(true);
                }
                else
                {
                    isImageFitToScreen = true;
                    mPhotoView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT));
                    mPhotoView.setScaleType(ImageView.ScaleType.FIT_XY);
                }
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode != Activity.RESULT_OK)
        {
            return;
        }

        if (requestCode == REQUEST_PHOTO)
        {
            updatePhotoView();
        }
    }

    //provides the format for the text sent when sharing notes with others.
    private String getNoteReport()
    {
        String dateFormat = "EEE, MMM dd";
        String dateString = DateFormat.format(dateFormat, mNote.getDate()).toString();

        String report = getString(R.string.note_report, mNote.getTitle(), dateString, mNote.getBody());
        return report;
    }

    //set ImageView to the taken photo.
    private void updatePhotoView()
    {
        if (mPhotoFile == null || !mPhotoFile.exists())
        {
            mPhotoView.setImageDrawable(null);
        }
        else
        {
            Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath(), getActivity());
            mPhotoView.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_note_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.delete_note:
                FragmentManager manager = getActivity().getSupportFragmentManager();
                DeleteDialogFragment dialog = DeleteDialogFragment.newInstance(mNote.getId());
                dialog.show(manager, DIALOG_DELETE);
                return true;

            case R.id.share_note:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, getNoteReport());
                i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.note_report_subject));
                i = Intent.createChooser(i, getString(R.string.send_report));
                startActivity(i);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
