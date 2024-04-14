package com.example.trainerhelper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var context: Context,
                    var muscules:ArrayList<String>
                    ): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var muscule: TextView
        var musculeRow:ConstraintLayout
        var animT:Animation
        init{
            muscule=itemView.findViewById(R.id.textMuscule)
            musculeRow=itemView.findViewById(R.id.musculeRow)
            animT=AnimationUtils.loadAnimation(context,R.anim.transtateanim)
            muscule.animation=animT
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater: LayoutInflater = LayoutInflater.from(context)
        var view:View=inflater.inflate(R.layout.muscules_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.muscule.text=muscules[position]
        holder.musculeRow.setOnClickListener {
            var intent1=Intent(context,TrainActivity::class.java)
            context.startActivity(intent1)
        }
    }

    override fun getItemCount(): Int {
        return muscules.size
    }

}