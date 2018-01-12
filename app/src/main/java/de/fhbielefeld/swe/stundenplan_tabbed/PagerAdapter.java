package de.fhbielefeld.swe.stundenplan_tabbed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import de.fhbielefeld.swe.stundenplan_tabbed.Tage.DienstagFragment;
import de.fhbielefeld.swe.stundenplan_tabbed.Tage.DonnerstagFragment;
import de.fhbielefeld.swe.stundenplan_tabbed.Tage.FreitagFragment;
import de.fhbielefeld.swe.stundenplan_tabbed.Tage.MittwochFragment;
import de.fhbielefeld.swe.stundenplan_tabbed.Tage.MontagFragment;

/**
 * Created by Sugi86 on 11.01.2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs){
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                MontagFragment tab1 = new MontagFragment();
                return tab1;
            case 1:
                DienstagFragment tab2 = new DienstagFragment();
                return tab2;
            case 2:
                MittwochFragment tab3 = new MittwochFragment();
                return tab3;
            case 3:
                DonnerstagFragment tab4 = new DonnerstagFragment();
                return tab4;
            case 4:
                FreitagFragment tab5 = new FreitagFragment();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public  int getCount(){
        return mNumOfTabs;
    }

}
