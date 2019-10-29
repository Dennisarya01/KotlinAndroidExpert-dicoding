package com.dicoding.footballapps.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.dicoding.footballapps.model.DataModel
import com.dicoding.footballapps.ui.FootballClubUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class FootballAdapter (val items: List<DataModel>, val listener: (DataModel) -> Unit) :
    RecyclerView.Adapter<FootballAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(FootballClubUI().createView(
        AnkoContext.Companion.create(parent.context, parent)))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }


    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        val image = itemView.findViewById<ImageView>(FootballClubUI.clubImage)
        val name = itemView.findViewById<TextView>(FootballClubUI.clubName)

        fun bind(item: DataModel, listener: (DataModel) -> Unit) {
            Glide.with(itemView.context)
                .load(item.image)
                .into(image)

            name.text = item.nameClub

            itemView.setOnClickListener { listener(item) }
        }
    }
}