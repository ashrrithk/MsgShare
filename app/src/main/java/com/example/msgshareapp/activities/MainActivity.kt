package com.example.msgshareapp.activities

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.msgshareapp.Constants
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object
    {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener{
            Log.i(TAG, "Button was clicked !")
            showToast(resources.getString(R.string.btn_was_clicked), Toast.LENGTH_SHORT)
        }

        btnSendMsgToNextActivity.setOnClickListener{
            val message:String = etUserMessage.text.toString()

            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener{

            val message : String = etUserMessage.text.toString()
             val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to :"))
        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}
