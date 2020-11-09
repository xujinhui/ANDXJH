package com.example.a02kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var mvcModel:MyViewModel;
    private var xjh_tag:String = "xjh_tag:"
//    String TAG = "XXX_LOG";
//    private TextWatcher textWatcher = new TextWatcher() {}

    class ButtonOnClickEvent: View.OnClickListener {
        override fun onClick(v: View?) {
            Log.d("tag___", "onClick: ")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.actionBar?.hide()
//        getActionBar.hide();

        Log.d(xjh_tag, "onCreate: ")

        var nameFD = findViewById<EditText>(R.id.editTextTextPersonName)
        val sender = findViewById<Button>(R.id.button_login)
        sender.setOnClickListener(ButtonOnClickEvent())

//         var value = intent.getStringExtra("name");
//        var bd = intent.extras();

        sender.setOnClickListener { v ->

//            v.visibility = sender.isInvisible;
//            sender.setText(R.string.user_name)
//            Toast.makeText(applicationContext, "Hello world 1", Toast.LENGTH_LONG).show()
//            Toast.makeText(this, "Hello world 1", Toast.LENGTH_LONG).show()

            var indent = Intent(this,SixActivity::class.java)
            startActivity(indent)
        }

//        sender.setOnClickListener(){
//            Toast.makeText(applicationContext, "Hello world 2", Toast.LENGTH_LONG).show()
//        };

        fun caseAlert(v: View){
            Toast.makeText(applicationContext, "Hello world 2", Toast.LENGTH_LONG).show()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(xjh_tag, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(xjh_tag, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(xjh_tag, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(xjh_tag, "onStop: ")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(xjh_tag, "onRestart: ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(xjh_tag, "onDestroy: ")

    }


}