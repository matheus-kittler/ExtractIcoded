package com.example.extract_icoded.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.extract_icoded.R
import com.example.extract_icoded.model.Installment
import kotlinx.android.synthetic.main.row_extract.view.*

class Adapter : RecyclerView.Adapter<Adapter.ExtractViewHolder> {

    var context: Context
    var installments: List<Installment>
    var inflater: LayoutInflater
    var onExtractClickListener: OnExtractClickListener
    var selectedInstallment: Int = 0



    constructor(context: Context, onExtractClickListener: OnExtractClickListener) : super() {
        this.context = context
        this.installments = ArrayList()
        this.inflater = LayoutInflater.from(context)
        this.onExtractClickListener = onExtractClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtractViewHolder {
        return  ExtractViewHolder(inflater.inflate(R.layout.row_extract, parent, false))
    }

    override fun getItemCount(): Int = installments.size

    override fun onBindViewHolder(holder: ExtractViewHolder, position: Int) {
        val installment = installments[position]

        holder.itemView.rbMark.isChecked = installment.selected ?: false // ?: faz com que o selected fique como default false
        holder.itemView.tvCarnet.setText(installment.carnet)
        holder.itemView.tvInstallment.setText(installment.installment)
        holder.itemView.tvValue.setText(installment.value)

        var day: String = installment.pastDue!!.split("/") [0]
        var month: String = installment.pastDue!!.split("/") [0]

         when (month) {
            "1" -> {
                holder.itemView.rbMark.setText(day+"JAN")
            }
             "2" -> {
                 holder.itemView.rbMark.setText(day+"FEV")
             }
             "3" -> {
                 holder.itemView.rbMark.setText(day+"MAR")
             }
             "4" -> {
                 holder.itemView.rbMark.setText(day+"APR")
             }
             "5" -> {
                 holder.itemView.rbMark.setText(day+"MAY")
             }
             "6" -> {
                 holder.itemView.rbMark.setText(day+"JUN")
             }
             "7" -> {
                 holder.itemView.rbMark.setText(day+"JUL")
             }
             "8" -> {
                 holder.itemView.rbMark.setText(day+"AUG")
             }
             "9" -> {
                 holder.itemView.rbMark.setText(day+"SEP")
             }
             "10" -> {
                 holder.itemView.rbMark.setText(day+"OCT")
             }
             "11" -> {
                 holder.itemView.rbMark.setText(day+"NOV")
             }
             "12" -> {
                 holder.itemView.rbMark.setText(day+"DEC")
             }
             return when(month) {

                month -> holder.itemView.rbMark.setText(day + " OCT")

                 else -> {
                         holder.itemView.rbMark.setText(day)
                 }
             } -> month
        }
        holder.itemView.setOnClickListener {
            installments.get(selectedInstallment).selected = false // quando o user clicar em outra linha ele irá "apagar"
            notifyItemChanged(selectedInstallment) // faz mudar visualmente o que explica acima

            var isSelected: Boolean = holder.itemView.rbMark.isChecked
            holder.itemView.rbMark.isChecked = !isSelected
            installment.selected = !isSelected
            selectedInstallment = holder.adapterPosition
            notifyItemChanged(holder.adapterPosition)

            if (!isSelected && onExtractClickListener != null) {
                onExtractClickListener.onExtractClick(installment)
            }
        }
    }

    class ExtractViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    interface  OnExtractClickListener {
        fun onExtractClick(installment: Installment)
    }
}


