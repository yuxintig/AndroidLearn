package com.shinonon.advance;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.Snackbar;
import com.kirshi.framework.base.BaseActivity;
import com.shinonon.advance.databinding.ActivityMainBinding;
import com.shinonon.advance.fragment.DashboardFragment;
import com.shinonon.advance.fragment.HomeFragment;
import com.shinonon.advance.fragment.NotificationFragment;

/**
 * @author Finger
 */
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(v.toolbar);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        v.viewPager.setAdapter(adapter);
        v.viewPager.setOffscreenPageLimit(adapter.getCount() - 1);
        v.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                v.navigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        v.navigation.setOnNavigationItemSelectedListener(item -> {
            v.toolbar.setTitle(item.getTitle());
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    v.viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    v.viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    v.viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        });
        bindNavigationDrawer();
        v.toolbar.setTitle(v.navigation.getMenu().getItem(0).getTitle());
    }

    public void onFabClicked(View view) {
        showSnackBar("onFabClicked");
    }

    private void bindNavigationDrawer() {
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, v.drawerLayout, v.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        v.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        v.navView.setNavigationItemSelectedListener(item -> {
            final int id = item.getItemId();
            switch (id) {
                case R.id.nav_tool:
                    showSnackBar("nav_tool");
                    break;
                case R.id.nav_share:
                    showSnackBar("nav_share");
                    break;
                case R.id.nav_gallery:
                    showSnackBar("nav_gallery");
                    break;
                case R.id.nav_send:
                    showSnackBar("nav_send");
                    break;
            }
            v.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

    }

    private static class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(@NonNull FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return HomeFragment.newInstance();
                case 1:
                    return DashboardFragment.newInstance();
                case 2:
                    return NotificationFragment.newInstance();
            }
            return HomeFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public Snackbar showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(v.container, message, Snackbar.LENGTH_SHORT);
        runOnUI(snackbar::show);
        return snackbar;
    }
}