package com.jobs.assignment.presentation.ui.item

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.jobs.assignment.R
import com.smarteist.autoimageslider.SliderViewAdapter

class ImageSliderAdapter(private val context: Context, private var images: ArrayList<String>) :

    SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH>() {

    fun renewItems(sliderItems: ArrayList<String>) {
        images = sliderItems
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        images.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: String) {
        images.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_indicator_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(
        viewHolder: SliderAdapterVH,
        position: Int
    ) {
        Glide.with(viewHolder.imageView)
            .load(images[position])
            .fitCenter()
            .placeholder(R.drawable.empty_image)
            .into(viewHolder.imageView)

    }

    override fun getCount(): Int {
        return images.size
    }

    inner class SliderAdapterVH(itemView: View) :
        ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.mediaThumb)
    }

}