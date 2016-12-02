package cameron.boles.android.pocketprogrammer;


import android.content.Intent;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

/**
 * Created by Cameron Boles on 11/17/16.
 *
 * This fragment displays a RecyclerView of note objects.
 *      It allows for adding new notes and deleting notes via swiping.
 */

public class NoteListFragment extends Fragment
{
    private static final String DIALOG_DELETE = "DialogDelete";

    private RecyclerView mNoteRecyclerView;
    private NoteAdapter mAdapter;
    private TextView mEmptyView;
    private ImageButton mNewNoteButton;
    //private DividerItemDecoration mDividerItemDecoration;
    private ImageButton mNewNoteScrollButton;
    private static int direction = -1;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);


        mEmptyView = (TextView) view.findViewById(R.id.empty_notes_view);
        mNewNoteButton = (ImageButton) view.findViewById(R.id.new_note_button);
        mNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewNote();
            }
        });

        mNoteRecyclerView = (RecyclerView) view.findViewById(R.id.note_recycler_view);
        mNoteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final LinearLayoutManager manager = (LinearLayoutManager) mNoteRecyclerView.getLayoutManager();

        mNewNoteScrollButton = (ImageButton) view.findViewById(R.id.new_note_button2);
        mNewNoteScrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewNote();
            }
        });

        final Animation bottomUp = AnimationUtils.loadAnimation(getContext(),
                R.anim.bottom_up);
        final Animation bottomDown = AnimationUtils.loadAnimation(getContext(),
                R.anim.bottom_down);

        //The onScrollListener allows us to do stuff when the user scrolls up or down.
        //  In this case, when the user scrolls down, our new note button will slide off
        //  the screen via the bottomDown animation created above.
        //  When the user scrolls up, the new note button will return via the bottumUp animation.
        mNoteRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);
                if (manager.findFirstVisibleItemPosition() == 0)
                {
                    return;
                }
                else if (dy > 0 && direction == -1)
                {
                    direction = 1;
                    mNewNoteScrollButton.startAnimation(bottomDown);
                    mNewNoteScrollButton.setVisibility(View.INVISIBLE);
                }
                else if (dy < 0 && direction == 1)
                {
                    direction = -1;
                    mNewNoteScrollButton.startAnimation(bottomUp);
                    mNewNoteScrollButton.setVisibility(View.VISIBLE);
                }

            }
        });

        //The ItemTouchHelper allows us to create an animation for when a RecyclerView entry is swiped,
        //      and allows us to react to the swipe.  In this case, swiping an entry will delete it.
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir)
            {
                NoteHolder noteHolder = (NoteHolder) viewHolder;
                int itemPosition = noteHolder.getAdapterPosition();
                Note note = noteHolder.mNote;

                FragmentManager manager = getActivity().getSupportFragmentManager();
                DeleteFromListDialog dialog = DeleteFromListDialog.newInstance(note.getId());
                dialog.show(manager, DIALOG_DELETE);
                mAdapter.notifyItemRemoved(itemPosition);
                mAdapter.notifyDataSetChanged();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(this.mNoteRecyclerView);

        updateUI();

        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.notes_page_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.new_note:
                Note note = new Note();
                NoteLab.get(getActivity()).addNote(note);
                Intent intent = NotePagerActivity.newIntent(getActivity(), note.getId());
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Sets the adapter for the RecyclerView and dynamically changes the UI based on the note list.
    public void updateUI()
    {
        NoteLab noteLab = NoteLab.get(getActivity());
        List<Note> notes = noteLab.getNotes();

        if (mAdapter == null) {
            mAdapter = new NoteAdapter(notes);
            mNoteRecyclerView.setAdapter(mAdapter);
        }
        else
        {
            mAdapter.setNotes(notes);
            mAdapter.notifyDataSetChanged();
        }

        if (notes.isEmpty())
        {
            mNoteRecyclerView.setVisibility(View.GONE);
            mNewNoteScrollButton.setVisibility(View.GONE);
            mEmptyView.setVisibility(View.VISIBLE);
            mNewNoteButton.setVisibility(View.VISIBLE);
        }
        else
        {
            mNoteRecyclerView.setVisibility(View.VISIBLE);
            mNewNoteScrollButton.setVisibility(View.VISIBLE);
            mEmptyView.setVisibility(View.GONE);
            mNewNoteButton.setVisibility(View.GONE);
        }
    }

    //create a new note.
    private void createNewNote()
    {
        Note note = new Note();
        NoteLab.get(getActivity()).addNote(note);
        Intent intent = NotePagerActivity.newIntent(getActivity(), note.getId());
        startActivity(intent);
    }

    //This inner class is required in order to set what the RecyclerView will display
    //      and how it will react to clicks.
    private class NoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView mTitleTextView;
        private TextView mDateTextView;
        String body;
        private Note mNote;

        public NoteHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_note_title_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_note_date_view);
        }

        public void bindNote(Note note)
        {
            mNote = note;
            body = mNote.getBody();
            mTitleTextView.setText(mNote.getTitle());
            mDateTextView.setText(DateFormat.format("EEEE, MMM d, yyyy", mNote.getDate()).toString());
        }

        @Override
        public void onClick(View v)
        {
            v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
            Intent intent = NotePagerActivity.newIntent(getActivity(), mNote.getId());
            startActivity(intent);
        }
    }

    //This inner class creates our own adapter for the RecyclerView.
    private class NoteAdapter extends RecyclerView.Adapter<NoteHolder>
    {
        private List<Note> mNotes;

        public NoteAdapter(List<Note> notes)
        {
            mNotes = notes;
        }

        @Override
        public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_note, parent, false);
            return new NoteHolder(view);
        }

        @Override
        public void onBindViewHolder(NoteHolder holder, int position)
        {
            Note note = mNotes.get(position);
            holder.bindNote(note);
        }

        @Override
        public int getItemCount()
        {
            return mNotes.size();
        }

        public void setNotes(List<Note> notes)
        {
            mNotes = notes;
        }
    }
}
