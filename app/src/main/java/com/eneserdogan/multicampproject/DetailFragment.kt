package com.eneserdogan.multicampproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import coil.load
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {
    lateinit var banner: String
    lateinit var photo:String
    lateinit var description:String
    lateinit var name:String
    lateinit var youtube:String
    lateinit var twitter:String
    lateinit var instagram:String
    lateinit var participation:String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Detail geldi")

        banner=requireArguments().getString("banner")!!
        println("banner--"+banner)
        description= requireArguments().getString("description")!!
        photo= requireArguments().getString("photo")!!
        name= requireArguments().getString("name")!!
        youtube= requireArguments().getString("youtube")!!
        twitter= requireArguments().getString("twitter")!!
        instagram= requireArguments().getString("instagram")!!
        participation= requireArguments().getString("participation")!!



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detail_banner.load(banner)
        detail_photo.load(photo)
        detail_name.text=name
        detail_description.text=description


        youtube_txt.setOnClickListener {
            web_page_open(youtube)
        }
        instagram_txt.setOnClickListener {
            web_page_open(instagram)
        }
        twitter_txt.setOnClickListener {
            web_page_open(twitter)
        }
        participation_txt.setOnClickListener {
            web_page_open(participation)
        }

    }
    fun web_page_open(urls: String) { // for more than one url
        val uris = Uri.parse(urls)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        startActivity(intents)
    }


}