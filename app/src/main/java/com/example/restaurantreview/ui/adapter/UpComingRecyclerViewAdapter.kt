package com.example.restaurantreview.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantreview.R
import com.example.restaurantreview.core.data.source.model.ListEventsItem
import com.example.restaurantreview.util.DateUtils
import com.squareup.picasso.Picasso

class UpComingRecyclerViewAdapter(private val item:List<ListEventsItem>):RecyclerView.Adapter<UpComingRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val title:TextView=view.findViewById(R.id.tv_title_event)
        val owner:TextView=view.findViewById(R.id.tv_owner)
        val location:TextView=view.findViewById(R.id.tv_location)
        val quota:TextView=view.findViewById(R.id.tv_quota)
        val beginTime:TextView=view.findViewById(R.id.tv_begin_time)
        val imageCover:ImageView=view.findViewById(R.id.imageEvent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.event_recycler_view,parent,false))
    }

    override fun getItemCount(): Int {
        return  item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data=item[position]
        holder.title.text=data.name
        holder.owner.text=data.ownerName
        holder.location.text=data.cityName
        holder.quota.text=data.quota.toString()
        holder.beginTime.text=DateUtils.formatDate(data.beginTime.toString())
        Picasso.get().load(data.mediaCover).into(holder.imageCover)
    }
}