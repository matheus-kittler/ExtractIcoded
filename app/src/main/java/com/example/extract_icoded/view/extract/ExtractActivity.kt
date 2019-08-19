package com.example.extract_icoded.view.extract

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.extract_icoded.R
import com.example.extract_icoded.adapter.Adapter
import com.example.extract_icoded.model.Data
import com.example.extract_icoded.model.Installment
import kotlinx.android.synthetic.main.activity_extract.*

class ExtractActivity : AppCompatActivity() {

    lateinit var adapter: Adapter

//    val lazyAdapter: Adapter by lazy {
//        Adapter(this, object: Adapter.OnExtractClickListener {
//            override fun onExtractClick(installment: Installment) {
//                val builder: AlertDialog.Builder = AlertDialog.Builder(this@ExtractActivity)
//                    .setTitle("Data Parcelas")
//                    .setMessage(
//                        String.format("\nDias Atrasados: " +installment.detail!!.overdueDays +
//                                "\nData de Vencimento: " +installment.detail!!.overdueDate +
//                                "\nValor: " +installment.detail!!.totalValue +
//                                "\nValor com Juros: " +installment.detail!!.valueDiff +
//                                "\nLoja: " + installment.detail!!.store))
//                    .setNeutralButton("Ok", null)
//                builder.create().show()
//            }
//        })
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extract)


        adapter = Adapter(this, object: Adapter.OnExtractClickListener {
            override fun onExtractClick(installment: Installment) {
                 val builder: AlertDialog.Builder = AlertDialog.Builder(this@ExtractActivity)
                    .setTitle("Data Parcelas")
                    .setMessage(
                        String.format("\nDias Atrasados: " +installment.detail!!.overdueDays +
                            "\nData de Vencimento: " +installment.detail!!.overdueDate +
                            "\nValor: " +installment.detail!!.totalValue +
                            "\nValor com Juros: " +installment.detail!!.valueDiff +
                            "\nLoja: " + installment.detail!!.store))
                     .setNeutralButton("Ok", null)
                builder.create().show()
            }
        })

        rvExtract.adapter = adapter
        rvExtract.layoutManager = (LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))

        var data: Data = intent.getSerializableExtra("data") as Data
        adapter.installments = (data.installments)
        tvName.setText(data.name)
        tvAvaibleValue.setText(data.limits!!.available)
        tvLimitValue.setText(data.limits!!.total)
        tvUtilValue.setText(data.limits!!.expent)
        pbLoader.visibility = View.GONE
    }
}
