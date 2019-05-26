package com.example.aboutmekotlin

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutmekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // data binding views
   private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Shubham Dhage")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        // findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickName(it)
        // }

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        // val editText = findViewById<EditText>(R.id.nickname_edit)
        // val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        // nicknameTextView.text = editText.text
        // editText.visibility = View.GONE
        // view.visibility = View.GONE
        // nicknameTextView.visibility = View.VISIBLE

        binding.apply {
            // nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        // Hide Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
