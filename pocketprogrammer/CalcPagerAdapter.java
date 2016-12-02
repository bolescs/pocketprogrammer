package cameron.boles.android.pocketprogrammer;

/**
 * Created by Cameron Boles on 10/20/16.
 *
 * Labels and initializes each tab of the calculator.
 *
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CalcPagerAdapter extends FragmentStatePagerAdapter
{
    public CalcPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new DecCalcFragment();
                break;
            case 1:
                frag=new HexCalcFragment();
                break;
            case 2:
                frag=new BinCalcFragment();
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
