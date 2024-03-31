package com.example.trainerhelper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var context: Context,
                    var muscules:ArrayList<String>
                    ): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var muscule: Button
        init{
            muscule=itemView.findViewById(R.id.buttonMuscule)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater: LayoutInflater = LayoutInflater.from(context)
        var view:View=inflater.inflate(R.layout.muscules_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.muscule.text=muscules[position]
    }

    override fun getItemCount(): Int {
        return muscules.size
    }
}