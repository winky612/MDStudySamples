package com.yifeng.mdstudysamples.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import com.yifeng.mdstudysamples.R
import com.yifeng.mdstudysamples.fragment.change.MainFragment
//import kotlinx.android.synthetic.main.activity_fragments.*

class FragmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)
        if (null == savedInstanceState){
            var transaction = supportFragmentManager.beginTransaction();
            val fm_main = MainFragment()
            transaction.add(R.id.id_content, fm_main)
            transaction.commit()
        }
    }


//    private fun initFM() {
//
////        FragmentTransaction transaction = get.beginTransaction()
//        if (fm_main == null) {
//            fm_main = mainFragment()
//            transaction.add(R.id.id_content, fm_main)
//            Log.i("TAG", "主Fragment")
//        } else {
//            transaction.show(fm_main)
//        }
//        transaction.commit()
//    }
}
