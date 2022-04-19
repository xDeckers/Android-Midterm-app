package com.example.mid_term

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

var Player1 = ""
var Player2 = ""


class PvP_Setup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvp_setup)

        val Start_PvP: Button = findViewById(R.id.buttonStart1);
        val Start_Bot: Button = findViewById(R.id.buttonStart2);
        val Back_Button: Button = findViewById(R.id.buttonBack);

        Start_PvP.setOnClickListener {
            val Intent = Intent(this, PvP_Game::class.java)//.putExtra(PvP, true)
            Player1 = findViewById<EditText>(R.id.P1_name).text.toString()
            Player2 = findViewById<EditText>(R.id.P2_name).text.toString()
            PvP = true
            startActivity(Intent)
        }

        Start_Bot.setOnClickListener {
            val Intent = Intent(this, PvP_Game::class.java)//.putExtra(PvP, false)
            Player1 = findViewById<EditText>(R.id.P1_name).text.toString()
            PvP = false
            startActivity(Intent)
        }

        Back_Button.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }


    }
}