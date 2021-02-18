package com.example.fourthtask02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), ButtonFragment.IncrementListener{
    private var counterFragment1: CounterFragment = CounterFragment()
    private var counterFragment2: CounterFragment = CounterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonFragment: Fragment = ButtonFragment()
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()

        if(savedInstanceState != null){
            counterFragment1 = supportFragmentManager.getFragment(savedInstanceState, "frag1") as CounterFragment
            counterFragment2 = supportFragmentManager.getFragment(savedInstanceState, "frag2") as CounterFragment
        }

        fragmentTransaction.replace(R.id.frag_counter_01, counterFragment1)
        fragmentTransaction.replace(R.id.frag_counter_02, counterFragment2)
        fragmentTransaction.replace(R.id.frag_button, buttonFragment)
        fragmentTransaction.commit()


    }

    override fun orderIncrement() {
        counterFragment1.increment()
        counterFragment2.increment()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        supportFragmentManager.putFragment(outState, "frag1", counterFragment1)
        supportFragmentManager.putFragment(outState, "frag2", counterFragment2)
    }



}