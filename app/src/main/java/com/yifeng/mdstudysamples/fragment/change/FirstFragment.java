package com.yifeng.mdstudysamples.fragment.change;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.yifeng.mdstudysamples.R;


public class FirstFragment extends Fragment {
	View view = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.one, container, false);
		//绑定组件
		findview();
		
		return view;
	}
	private void findview() {
		Button clickBt=(Button) view.findViewById(R.id.firstfragmentbt);
		//按钮的点击事件
		clickBt.setOnClickListener(new btOnclick());
	}
	class btOnclick implements OnClickListener {

		@Override
		public void onClick(View v) {
			openFragment();
		}
	}
	
	private void openFragment(){
		FourthFragment fm_four = new FourthFragment();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.hide(this);
		transaction.add(R.id.id_content, fm_four);
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		transaction.addToBackStack(null);
		transaction.commit();
	}
	

}
