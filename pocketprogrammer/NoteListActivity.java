package cameron.boles.android.pocketprogrammer;

import android.support.v4.app.Fragment;

/**
 * Created by Cameron Boles on 11/17/16.
 *
 * This activity simply creates the NoteListFragment.
 */

public class NoteListActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new NoteListFragment();
    }
}
