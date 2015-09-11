package com.djgzhiyong.happycar;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.zzy.simplelib.utils.PlatformUtil;

public class MainActivity extends RootAction {

    @ViewInject(R.id.drawer_layout)
    private DrawerLayout mDrawerLayout;

    private DrawerFragment mDrawerFragment;
    private MainFragment mMainFragment;
    private FragmentManager mFragmentManager;

    @Override
    public int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void create() {
        mFragmentManager = getFragmentManager();

        mDrawerFragment = (DrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);

        mDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        mMainFragment = new MainFragment();
        replaceContentFragment(mMainFragment);
    }


    public void replaceContentFragment(Fragment framgment) {
        mFragmentManager.beginTransaction()
                .replace(R.id.container, framgment).commit();
    }


    public void restoreActionBar() {
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        mActionBar.setDisplayShowTitleEnabled(true);
    }


    @Override
    public int setMenuId() {
        return R.menu.main;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(mDrawerFragment.getView())) {
                mDrawerLayout.closeDrawers();
            } else {
                mDrawerLayout.openDrawer(mDrawerFragment.getView());
            }
        } else if (item.getItemId() == R.id.action_search) {
            PlatformUtil.jumpActivity(this, SearchActivity.class);
        }
        return false;
    }


}
