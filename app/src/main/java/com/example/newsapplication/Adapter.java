package com.example.newsapplication;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter
{

    public Adapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                FakeNewsFragment fakeNewsFragment = new FakeNewsFragment();
                return fakeNewsFragment;


            case 1:
                VerifiedNewsFragment verifiedNewsFragment = new VerifiedNewsFragment();
                return verifiedNewsFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch(position)
        {


            case 0:
                return "";

            default:
                return null;
        }
    }
}
