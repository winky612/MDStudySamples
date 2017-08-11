package com.yifeng.mdstudysamples.fragment.change;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yifeng.mdstudysamples.R;

public class SecondFragment extends Fragment {
	View view = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.two, container, false);
		return view;
	}

}
