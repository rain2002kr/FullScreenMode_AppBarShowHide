package com.example.fullscreenmode_appbarshowhide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_FullScreenOn.setOnClickListener{
            fullScreenMode(true)
        }
        bt_FullScreenOff.setOnClickListener{
            fullScreenMode(false)
        }

        bt_ActionBarShow.setOnClickListener{
            appBarMode(true)
        }
        bt_ActionBarHide.setOnClickListener{
            appBarMode(false)
        }

        editText.addTextChangedListener(  object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                fullScreenMode(true)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                fullScreenMode(true)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                fullScreenMode(true)
            }
        })

        bt_scr2_move.setOnClickListener{
            val intent = Intent(baseContext,Main2Activity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

    private fun fullScreenMode(switch : Boolean){
        var uiOption = window.decorView.systemUiVisibility
        if(switch){
            uiOption =  View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        }else {
            uiOption =  View.SYSTEM_UI_LAYOUT_FLAGS
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
        window.decorView.setSystemUiVisibility(uiOption)
    }

    private fun appBarMode(switch : Boolean){
        if(switch){
            supportActionBar?.show()
        }else {
            supportActionBar?.hide()
        }
    }

}
