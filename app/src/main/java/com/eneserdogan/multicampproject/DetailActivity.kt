package com.eneserdogan.multicampproject

import Community
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val banner=intent.getStringExtra("banner")
        val desription=intent.getStringExtra("description")
        val photo=intent.getStringExtra("photo")
        val name=intent.getStringExtra("name")
        val youtube=intent.getStringExtra("youtube")
        val twitter=intent.getStringExtra("twitter")
        val instagram=intent.getStringExtra("instagram")
        val participation=intent.getStringExtra("participation")

        detail_banner.load(banner)
        detail_photo.load(photo)
        detail_name.text=name
        //youtube_txt.text=youtube
        //instagram_txt.text=instagram
        //twitter_txt.text=twitter
        detail_description.text=desription


        youtube_txt.setOnClickListener {
            web_page_open(youtube)
        }
        instagram_txt.setOnClickListener {
            web_page_open(instagram)
        }
        twitter_txt.setOnClickListener {
            web_page_open(twitter)
        }



    }
    fun web_page_open(urls: String) { // for more than one url
        val uris = Uri.parse(urls)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        startActivity(intents)
    }
}
