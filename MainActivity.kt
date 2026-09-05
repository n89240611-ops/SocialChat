package com.socialchat.app

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 80, 48, 48)
        }

        val title = TextView(this).apply {
            text = "Social Chat"
            textSize = 30f
        }

        val subtitle = TextView(this).apply {
            text = "Welcome! Your Android app is ready to build."
            textSize = 18f
            setPadding(0, 24, 0, 24)
        }

        val button = Button(this).apply {
            text = "Start Chat"
            setOnClickListener { subtitle.text = "Chat screen coming next." }
        }

        root.addView(title)
        root.addView(subtitle)
        root.addView(button)
        setContentView(root)
    }
}
