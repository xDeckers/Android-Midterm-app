package com.example.mid_term

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import kotlin.random.Random

public class PvP_Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvp_game)
        if (PvP.equals(false)){
            Player2 = "Computer"
        }

        var activePlayer = "x"
        var lastActive = "x"
        var turns = 0
        var randomVal = 0

        val Grid = mutableListOf<Button>(
            findViewById(R.id.tile11),
            findViewById(R.id.tile12),
            findViewById(R.id.tile13),
            findViewById(R.id.tile21),
            findViewById(R.id.tile22),
            findViewById(R.id.tile23),
            findViewById(R.id.tile31),
            findViewById(R.id.tile32),
            findViewById(R.id.tile33)
        )
        val whoPlaying: TextView = findViewById(R.id.LiveTurn)

        fun resetBoard() {
            /*var i = 0
            for ( i in 0..8){
                Grid[i].text = ""
            }*/

            Grid[0].text = " "
            Grid[1].text = " "
            Grid[2].text = " "
            Grid[3].text = " "
            Grid[4].text = " "
            Grid[5].text = " "
            Grid[6].text = " "
            Grid[7].text = " "
            Grid[8].text = " "

            turns = 0
            //activePlayer = "x"
            //lastActive = "x"
            whoPlaying.setText("Go on do a turn")
        }

        fun DisplayWin(lastActive: String) {
            var winner = ""
            when (lastActive){
                "x" -> winner = Player1
                "o" -> winner = Player2
                "n" -> winner = "Friendship"
            }

            AlertDialog.Builder(this)
                .setTitle(winner + " Won")
                .setPositiveButton("Reset")
                { _,_ ->
                    resetBoard()
                }
                .setCancelable(false)
                .show()
            return
        }

        fun WinCheck() {
            turns++
            //Horizontal
            if(Grid[0].text == lastActive && Grid[1].text == lastActive && Grid[2].text == lastActive) {DisplayWin(lastActive);return }
            if(Grid[3].text == lastActive && Grid[4].text == lastActive && Grid[5].text == lastActive) {DisplayWin(lastActive);return }
            if(Grid[6].text == lastActive && Grid[7].text == lastActive && Grid[8].text == lastActive) {DisplayWin(lastActive);return }
            //Vertical
            if(Grid[0].text == lastActive && Grid[3].text == lastActive && Grid[6].text == lastActive) {DisplayWin(lastActive);return }
            if(Grid[1].text == lastActive && Grid[4].text == lastActive && Grid[7].text == lastActive) {DisplayWin(lastActive);return }
            if(Grid[2].text == lastActive && Grid[5].text == lastActive && Grid[8].text == lastActive) {DisplayWin(lastActive);return }
            //Diagonal
            if(Grid[0].text == lastActive && Grid[4].text == lastActive && Grid[8].text == lastActive) {DisplayWin(lastActive);return }
            if(Grid[6].text == lastActive && Grid[4].text == lastActive && Grid[2].text == lastActive) {DisplayWin(lastActive);return }

            if (turns == 9){
                lastActive = "n"
                DisplayWin(lastActive)
            }
        }

        fun currentTurn() {
            var currT = ""
            if(activePlayer == "x")
                currT = "Its " + Player1 +" turn"
            else if(activePlayer == "o")
                currT = "Its " + Player2 +" turn"
            whoPlaying.setText(currT)
            return
        }


        fun RandomNum(){
            randomVal  = Random.nextInt(0,9)
            Log.d("bot", randomVal.toString())
            if (Grid[randomVal].text != " "){
                RandomNum()
            }
        }

        fun MarkTile(btn:Button) {
            if (btn.text != " ")
                return;
            if (activePlayer.equals("x")) {
                btn.text = "x"
                lastActive = "x"
                activePlayer = "o"
                currentTurn()
                WinCheck()
            }

            else if (activePlayer.equals("o")) {
                btn.text = "o"
                lastActive = "o"
                activePlayer = "x"
                currentTurn()
                WinCheck()
            }

            if(PvP.equals(false) && lastActive=="x" && turns!=9){
                RandomNum()
                MarkTile(Grid[randomVal])
            }
        }

        val Restart_Button: Button = findViewById(R.id.buttonRestart);
        val Menu_Button: Button = findViewById(R.id.buttonMenu);

        Menu_Button.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        Restart_Button.setOnClickListener {
            resetBoard()
        }

        Grid[0].setOnClickListener{ MarkTile(Grid[0]) }
        Grid[1].setOnClickListener{ MarkTile(Grid[1]) }
        Grid[2].setOnClickListener{ MarkTile(Grid[2]) }
        Grid[3].setOnClickListener{ MarkTile(Grid[3]) }
        Grid[4].setOnClickListener{ MarkTile(Grid[4]) }
        Grid[5].setOnClickListener{ MarkTile(Grid[5]) }
        Grid[6].setOnClickListener{ MarkTile(Grid[6]) }
        Grid[7].setOnClickListener{ MarkTile(Grid[7]) }
        Grid[8].setOnClickListener{ MarkTile(Grid[8]) }

    }

}