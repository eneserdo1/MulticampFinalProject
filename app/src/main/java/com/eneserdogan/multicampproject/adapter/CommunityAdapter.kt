package com.eneserdogan.multicampproject.adapter

import Community
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.eneserdogan.multicampproject.DetailActivity
import com.eneserdogan.multicampproject.R
import kotlinx.android.synthetic.main.recycler_item.view.*

class CommunityAdapter(val list:List<Community>,val context: Context):RecyclerView.Adapter<CommunityAdapter.MyViewHolder>(),CellClickListener {
    class MyViewHolder(view:View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityAdapter.MyViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CommunityAdapter.MyViewHolder, position: Int) {
        holder.itemView.recyclerview_name.text=list[position].name
        holder.itemView.recyclerview_imageview.load(list[position].banner)
        holder.itemView.setOnClickListener {
            //onCellClickListener(list[position])
            val intent = Intent(context,DetailActivity::class.java)
            val data=list[position]
            intent.putExtra("banner",data.banner)
            intent.putExtra("description",data.description)
            intent.putExtra("photo",data.leader.photo)
            intent.putExtra("name",data.leader.name)
            intent.putExtra("youtube",data.links.youtube)
            intent.putExtra("twitter",data.links.twitter)
            intent.putExtra("instagram",data.links.instagram)
            intent.putExtra("participation",data.links.participation)
            context.startActivity(intent)


        }
    }

    override fun onCellClickListener(data: Community) {
        val intent = Intent(context,DetailActivity::class.java)
        context.startActivity(intent)


    }
}