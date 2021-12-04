package com.kurilov.worldscillstrainingtasktwo.ui.menu

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kurilov.worldscillstrainingtasktwo.R
import com.kurilov.worldscillstrainingtasktwo.data.Record
import com.squareup.picasso.Picasso

class MenuAdapter(private val items: List<Record>, private val menuItemClickListener: MenuActivity.MenuItemClickListener)  :
    RecyclerView.Adapter<MenuAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.menu_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.itemNameTextView?.text = item.name
        Picasso.get()
            .load(item.imageMenu)
            .into(holder.itemImageView)

        holder.itemView.setOnClickListener{
            val pos = holder.bindingAdapterPosition
            if(pos != DiffUtil.DiffResult.NO_POSITION) {
                menuItemClickListener.onClickPairItem(pos)
            }
        }

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemNameTextView: TextView? = null
        var itemImageView: ImageView? = null

        init {

            itemNameTextView = itemView.findViewById(R.id.menu_item_name)
            itemImageView = itemView.findViewById(R.id.menu_item_image)

        }
    }

    override fun getItemCount() = items.size
}