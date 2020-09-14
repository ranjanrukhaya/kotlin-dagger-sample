package com.gaura.kotlindaggersample

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component =
                DaggerSharedPrefComponent.builder().sharedPrefModule(SharedPrefModule(this)).build()

        component.inject(this)

        btnSave.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("username", inUsername.text.toString().trim());
            editor.putString("number", inNumber.text.toString().trim());
            editor.apply();
        }

        btnGet.setOnClickListener {
            textSample.text = sharedPreferences.getString("username", "default") +
                    " " + sharedPreferences.getString("number", "default")
        }
    }
}