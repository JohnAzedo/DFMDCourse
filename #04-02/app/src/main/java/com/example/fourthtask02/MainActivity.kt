package com.example.fourthtask02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), ButtonFragment.IncrementListener{
    private var counterFragment1: CounterFragment? = null
    private var counterFragment2: CounterFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonFragment: Fragment = ButtonFragment()
        val sm = supportFragmentManager
        val fm = sm.beginTransaction()

        counterFragment1 = sm.findFragmentById(R.id.frag_counter_01) as CounterFragment?
        counterFragment2 = sm.findFragmentById(R.id.frag_counter_02) as CounterFragment?

        if(counterFragment1 == null || counterFragment2==null){
            counterFragment1 = CounterFragment()
            counterFragment2 = CounterFragment()
        }

        fm.replace(R.id.frag_counter_01, counterFragment1!!)
        fm.replace(R.id.frag_counter_02, counterFragment2!!)
        fm.add(R.id.frag_button, buttonFragment)
        fm.commit()
    }

    override fun orderIncrement() {
        counterFragment1?.increment()
        counterFragment2?.increment()
    }





}