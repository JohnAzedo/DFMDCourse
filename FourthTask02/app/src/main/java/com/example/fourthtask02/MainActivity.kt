package com.example.fourthtask02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), ButtonFragment.IncrementListener{
    private val counterFragment1: CounterFragment = CounterFragment()
    private val counterFragment2: CounterFragment = CounterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonFragment: Fragment = ButtonFragment()


        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frag_button, buttonFragment)
        fragmentTransaction.add(R.id.frag_counter_01, counterFragment1)
        fragmentTransaction.add(R.id.frag_counter_02, counterFragment2)
        fragmentTransaction.commit()
    }

    override fun orderIncrement() {
        counterFragment1.increment()
        counterFragment2.increment()
    }


}