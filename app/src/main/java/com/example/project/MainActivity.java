package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ChatAdapter.ItemSelected{


    TabLayout tabLayout;
    ViewPager2 viewPager;
    FragmentAdapter adapter;

    RecyclerView chatRV;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.chatView);
        tabLayout = findViewById(R.id.tabLayout);
        chatRV = findViewById(R.id.chatView);
        layoutManager = new LinearLayoutManager(this);
        chatRV.setLayoutManager(layoutManager);
        viewPager.setAdapter(new ViewPagerAdapter(this));

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if (position == 0)
                            tab.setText("Chats");
                        else if (position == 1)
                            tab.setText("Status");
                        else
                            tab.setText("Calls");
                    }
                }).attach();


    }

    @Override
    public void onItemClicked(int index) {
        Intent i = new Intent(this,ChatActivity.class);
        i.putExtra("INDEX",index);
        startActivity(i);
    }
}