package cameron.boles.android.pocketprogrammer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Cameron Boles on 11/29/16.
 *
 * Labels and initializes each tab of the converter.
 */

public class ConvPagerAdapter extends FragmentStatePagerAdapter
{
    public ConvPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new DecConvertFragment();
                break;
            case 1:
                frag=new HexConvertFragment();
                break;
            case 2:
                frag=new BinConvertFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="Decimal";
                break;
            case 1:
                title="Hex";
                break;
            case 2:
                title="Binary";
                break;
        }

        return title;
    }
}
