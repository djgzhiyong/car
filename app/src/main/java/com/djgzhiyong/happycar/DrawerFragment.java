package com.djgzhiyong.happycar;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.djgzhiyong.adapter.DrawerAdapter;
import com.djgzhiyong.viewmodel.MenuModel;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer.html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
public class DrawerFragment extends Fragment {

    @ViewInject(R.id.drawer_listview)
    private ListView mListView;

    private DrawerLayout mDrawerLayout;

    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    private ActionBarDrawerToggle mDrawerToggle;

    private View mFragmentContainerView;

    private int mCurrentSelectedPosition = 0;
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;

    private FragmentManager mFragmentManager;
    private List<MenuModel> menuModels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);
        ViewUtils.inject(this, view);
        setDrawerData();
        return view;
    }

    private void setDrawerData() {
        menuModels = new ArrayList<MenuModel>();
        menuModels.add(new MenuModel(null, "我的收藏", R.drawable.ic_favorite));
        menuModels.add(new MenuModel(null, "我的订单", R.drawable.ic_subject));
        menuModels.add(new MenuModel(null, "积分兑换", R.drawable.ic_shopping));
        menuModels.add(new MenuModel(null, "意见反馈", R.drawable.ic_announcement));
        menuModels.add(new MenuModel("400-888-888", "联系客服", R.drawable.ic_face));
        menuModels.add(new MenuModel("1.0", "版本更新", R.drawable.ic_autorenew));
        mListView.setAdapter(new DrawerAdapter(getActivity(), menuModels));
        mListView.setItemChecked(mCurrentSelectedPosition, true);
    }

    @OnItemClick(R.id.drawer_listview)
    public void itemClick(AdapterView<?> view, View v, int position, long id) {
        String title = menuModels.get(position).title;
        if ("版本更新".equals(title)) {
            replaceContentFragment(new CheckUpdateFragment());
        } else if ("意见反馈".equals(title)) {
            replaceContentFragment(new FeedbackFragment());
        } else if ("联系客服".equals(title)) {

        }
//        getActivity().get.setTitle(title);
        mDrawerLayout.closeDrawers();
    }


    public void replaceContentFragment(Fragment framgment) {
        mFragmentManager.beginTransaction()
                .replace(R.id.container, framgment).commit();
    }


//    public boolean isDrawerOpen() {
//        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
//    }

    /**
     * Users of this fragment must call this method to set up the navigation drawer interactions.
     *
     * @param fragmentId   The android:id of this fragment in its activity's layout.
     * @param drawerLayout The DrawerLayout containing this fragment's UI.
     */
    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener


        // ActionBarDrawerToggle ties together the the proper interactions
        // between the navigation drawer and the action bar app icon.
        mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),                    /* host Activity */
                mDrawerLayout,                    /* DrawerLayout object */
                R.drawable.ic_drawer,             /* nav drawer image to replace 'Up' caret */
                R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) {
                    return;
                }

                getActivity().invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) {
                    return;
                }

                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    SharedPreferences sp = PreferenceManager
                            .getDefaultSharedPreferences(getActivity());
                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
                }

                getActivity().invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };

        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void selectItem(int position) {

        mCurrentSelectedPosition = position;
        if (mListView != null) {
            mListView.setItemChecked(position, true);
        }
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }

    }


}
