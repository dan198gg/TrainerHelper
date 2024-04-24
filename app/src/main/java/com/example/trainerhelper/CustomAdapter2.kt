package com.example.trainerhelper

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

    class CustomAdapter2(
        var context: Context,
        var img: ArrayList<Bitmap>,
        var trains:ArrayList<String>):
        RecyclerView.Adapter<CustomAdapter2.MyViewHolder2>() {
            inner class MyViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
                var image:ImageView
                var train:TextView
                init {   
                    image=itemView.findViewById(R.id.imageTrain)
                    train=itemView.findViewById(R.id.textTrain)
                }
            }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder2 {

            var inflater: LayoutInflater = LayoutInflater.from(context)
            var view:View=inflater.inflate(R.layout.train_row,parent,false)

            return MyViewHolder2(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder2, position: Int) {
            holder.image.setImageBitmap(img[position])
            holder.train.text=trains[position]
        }

        override fun getItemCount(): Int {
            return trains.size
        }
    }