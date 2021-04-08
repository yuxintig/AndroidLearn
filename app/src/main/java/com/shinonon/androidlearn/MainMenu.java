package com.shinonon.androidlearn;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shinonon.androidlearn.databinding.ActivityMainmenuBinding;
import com.shinonon.androidlearn.fragment.ContactFragment;
import com.shinonon.androidlearn.fragment.FoundFragment;
import com.shinonon.androidlearn.fragment.MeFragment;
import com.shinonon.androidlearn.fragment.MessageFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {
    private ActivityMainmenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainmenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MessageFragment());
        fragmentList.add(new ContactFragment());
        fragmentList.add(new FoundFragment());
        fragmentList.add(new MeFragment());


        FragmentManager fragmentManager = getSupportFragmentManager();
        binding.viewpager.setAdapter(new FragmentStatePagerAdapter(fragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NotNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @NotNull
            @Override
            public Object instantiateItem(@NotNull ViewGroup container, int position) {
                Fragment fragment = (Fragment) super.instantiateItem(container, position);
                getSupportFragmentManager().beginTransaction().show(fragment).commitAllowingStateLoss();
                return fragment;
            }

            @Override
            public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
                Fragment fragment = fragmentList.get(position);
                getSupportFragmentManager().beginTransaction().hide(fragment).commit();
            }
        });
        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.bottomView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        binding.bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.message:
                        binding.viewpager.setCurrentItem(0,true);
                        return true;
                    case R.id.contact:
                        binding.viewpager.setCurrentItem(1,true);
                        return true;
                    case R.id.found:
                        binding.viewpager.setCurrentItem(2,true);
                        return true;
                    case R.id.me:
                        binding.viewpager.setCurrentItem(3,true);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}