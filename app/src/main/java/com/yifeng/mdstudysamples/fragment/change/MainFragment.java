package com.yifeng.mdstudysamples.fragment.change;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.yifeng.mdstudysamples.R;

public class MainFragment extends Fragment {
    String TAG = "TAG";
    Handler mHandler;
    View view = null;
    FragmentManager fm;
    FragmentTransaction transaction;
    Button mFirstBt;
    Button mSecondBt;
    Button mThreadBt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main, container, false);
        //mHandler = mainActivity.mHandler;
        //绑定界面的按钮  实现按钮的点击事件
        findview();
        Log.i(TAG, "显示主Fragment");
        return view;
    }

    private void findview() {

        // 绑定主Fragment里面的三个按钮
        mFirstBt = (Button) view.findViewById(R.id.firstbt);
        mSecondBt = (Button) view.findViewById(R.id.secondbt);
        mThreadBt = (Button) view.findViewById(R.id.threadbt);
        Log.i(TAG, "按钮绑定");
        mFirstBt.setOnClickListener(new btOnclick());
        mSecondBt.setOnClickListener(new btOnclick());
        mThreadBt.setOnClickListener(new btOnclick());
    }

    class btOnclick implements OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.firstbt:
                    // 点击第一个按钮  创建第一个Fragment
                    selectFM(1);
                    break;
                case R.id.secondbt:
                    // 点击第二个按钮  创建第二个Fragment
                    selectFM(2);
                    break;
                case R.id.threadbt:
                    // 点击第三个按钮  创建第三个Fragment
                    selectFM(3);
                    break;
                default:
                    break;
            }
        }

    }

    void selectFM(int i) {
        fm = getFragmentManager();
        transaction = fm.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        https://stackoverflow.com/questions/8345089/android-fragmenttransaction-settransitionstyle
//        transaction.setTransitionStyle()
        switch (i) {
            case 1:
                FirstFragment fm_first = new FirstFragment();
                transaction.hide(this);
                transaction.add(R.id.id_content, fm_first);
                transaction.addToBackStack(null);
                Log.i("TAG", "进入port");
                break;
            case 2:
                SecondFragment fm_second = new SecondFragment();
                transaction.hide(this);
                transaction.add(R.id.id_content, fm_second);
                transaction.addToBackStack(null);
                break;
            case 3:
                ThreadFragment fm_thread = new ThreadFragment();
                transaction.hide(this);
                transaction.add(R.id.id_content, fm_thread);
                transaction.addToBackStack(null);
                break;
            default:
                break;
        }
        transaction.commit();
    }


}
