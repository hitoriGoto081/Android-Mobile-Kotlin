package com.example.linkapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import java.net.URL

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.image)
        val title = findViewById<TextView>(R.id.title)
        val subtitle = findViewById<TextView>(R.id.subtitle)
        val list = findViewById<RecyclerView>(R.id.list)

        image.setImageResource(R.drawable.imgprofile)
        title.text = "Saiyed Muda"
        subtitle.text = "Tugas Mid"

        list.adapter = linkAdapter

    }
    private val linkAdapter by lazy {
        val items = listOf<LinktreeModel>(
            LinktreeModel("Google",R.drawable.logogoogle,"https://google.com"),
            LinktreeModel("Facebook",R.drawable.logofb,"https://facebook.com"),
            LinktreeModel("YouTube",R.drawable.logoyoutube,"https://youtube.com"),
            LinktreeModel("Github",R.drawable.logogithub,"https://github.com"),
            LinktreeModel("HackerRank",R.drawable.logohk,"https://hackerrank.com"),
        )
        LinkAdapter(items,object: LinkAdapter.AdapterListener{
            override fun onClick(linktree: LinktreeModel) {
                openUrl(linktree.url)
            }
        })
    }
    private fun openUrl(url: String){
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        startActivity(openUrl)
    }
}





