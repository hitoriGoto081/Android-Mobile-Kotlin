package com.example.linkapp

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LinkAdapter(
    val items: List<LinktreeModel>,
    val listener: AdapterListener,
): RecyclerView.Adapter<LinkAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.image)
        val title = itemView.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_link,parent,false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.image)
        holder.title.text = item.title
        holder.itemView.setOnClickListener{
            listener.onClick(item)
        }
    }
    interface AdapterListener{
        fun onClick(linktree: LinktreeModel)
    }
}