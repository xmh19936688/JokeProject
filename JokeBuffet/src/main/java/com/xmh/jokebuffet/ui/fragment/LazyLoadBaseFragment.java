package com.xmh.jokebuffet.ui.fragment;


import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by mengh on 2015/12/10 010.
 */
public abstract class LazyLoadBaseFragment extends Fragment {
    /** Fragment当前状态是否可见 */
    protected boolean isVisible;
    /**是否调用过lazyLoad*/
    protected boolean hasLoaded =false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 可见
     */
    protected void onVisible() {
        if(hasLoaded){
            return;
        }
        lazyLoad();
        hasLoaded =true;
    }


    /**
     * 不可见
     */
    protected void onInvisible() {

    }

    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    protected abstract void lazyLoad();

    protected boolean isViewAllInWindow(View view){
        //获取屏幕高度
        WindowManager windowManager = getActivity().getWindowManager();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        int windowHeight = defaultDisplay.getHeight();
        int windowWidth= defaultDisplay.getWidth();
        //获取view坐标
        int[] location=new int[2];
        view.getLocationInWindow(location);
        //获取view大小
        int height = view.getHeight();
        int width = view.getWidth();
        if(location[0]<0){
            return false;
        }
        if(location[1]<0){
            return false;
        }
        if(location[0]+width>windowWidth){
            return false;
        }
        return location[1] + height <= windowHeight;
    }
}
