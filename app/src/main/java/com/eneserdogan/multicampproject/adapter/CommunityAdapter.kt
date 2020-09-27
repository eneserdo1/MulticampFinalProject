package com.eneserdogan.multicampproject.adapter

import Community
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.eneserdogan.multicampproject.DetailFragment
import com.eneserdogan.multicampproject.R
import kotlinx.android.synthetic.main.recycler_item.view.*

class CommunityAdapter(val list: List<Community>, val context: Context) :
    RecyclerView.Adapter<CommunityAdapter.MyViewHolder>(), CellClickListener {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommunityAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CommunityAdapter.MyViewHolder, position: Int) {
        holder.itemView.recyclerview_name.text = list[position].name
        holder.itemView.recyclerview_imageview.load(list[position].banner)
        holder.itemView.setOnClickListener {
            val data = list[position]
            val bundle = Bundle()
            bundle.putString("banner", data.banner)
            bundle.putString("description", data.description)
            bundle.putString("photo", data.leader.photo)
            bundle.putString("name", data.leader.name)
            bundle.putString("youtube", data.links.youtube)
            bundle.putString("twitter", data.links.twitter)
            bundle.putString("instagram", data.links.instagram)
            bundle.putString("participation", data.links.participation)
            //context.startActivity(intent)
           // var navController: NavController=""

            //navController.navigate(R.id.action_communityListFragment_to_detailFragment, bundle)
            val detail=DetailFragment()
            detail.arguments=bundle
            Navigation.findNavController(holder.itemView).navigate(R.id.action_communityListFragment_to_detailFragment,bundle)


        }
    }

    override fun onCellClickListener(data: Community) {
        /* val intent = Intent(context,DetailActivity::class.java)
         context.startActivity(intent)*/


    }

}

