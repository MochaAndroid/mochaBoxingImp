package com.mocha.boxing_imp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by ChenSL on 2017/4/5.
 */

public class BoxingBaseFragment extends Fragment {
    private boolean mNeedPendingUserVisibleHint;
    private boolean mLastUserVisibleHint;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mNeedPendingUserVisibleHint) {
            setUserVisibleCompat(mLastUserVisibleHint);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getActivity() == null) {
            mNeedPendingUserVisibleHint = true;
            mLastUserVisibleHint = isVisibleToUser;
        } else {
            setUserVisibleCompat(isVisibleToUser);
        }
    }

    void setUserVisibleCompat(boolean userVisibleCompat) {
    }
}
