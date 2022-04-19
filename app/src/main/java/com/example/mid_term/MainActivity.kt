package com.example.mid_term

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

var PvP = false;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //val PvE_Button: Button = findViewById(R.id.buttonPvE);
        val PvP_Button: Button = findViewById(R.id.buttonPvP);
        val Exit_Button: Button = findViewById(R.id.buttonExit);

        /*PvE_Button.setOnClickListener {
            val Intent = Intent(this, PvE_Setup::class.java)
            startActivity(Intent)
        }*/

        PvP_Button.setOnClickListener {
            val Intent = Intent(this, PvP_Setup::class.java)
            startActivity(Intent)
        }

        Exit_Button.setOnClickListener{
            exitProcess(0);
        }
    }

}