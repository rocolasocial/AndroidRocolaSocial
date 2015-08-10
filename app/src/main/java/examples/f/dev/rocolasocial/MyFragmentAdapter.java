package examples.f.dev.rocolasocial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Salvador on 07/08/2015.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private int position;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public CharSequence getPageTitle(int position) {
        this.position = position;

        String Title = null;

        switch (position) {
            case 0:
                Title = "Canciones";
                break;
            case 1:
                Title = "Artistas";
                break;
            case 2:
                Title = "Listas";
                break;

        }
        return Title;
    }
}
