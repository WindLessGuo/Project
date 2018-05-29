package com.wind.baselibrary.utils;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


public class ActivityUtils {

    private static List<Activity> activities = new ArrayList<>();


    public static void addActivity(Activity activity) {
        checkNotNull(activity, "Activity can't null");
        activities.add(activity);
    }


    public static void removeActivity(Activity activity) {
        checkNotNull(activity, "Activity can't null");
        activities.remove(activity);
    }


    public static void removeAll() {
        for (Activity activity : activities) {
            activity.finish();
        }
    }



    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

}
