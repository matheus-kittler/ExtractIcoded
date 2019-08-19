package com.example.extract_icoded.view.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import com.example.extract_icoded.R
import com.example.extract_icoded.view.extract.ExtractActivity
import com.example.extract_icoded.model.Data
import com.example.extract_icoded.model.Login
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityInteraction {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = MainActivityViewModel(this)

        btnEnter.setOnClickListener{
            clLoader.visibility = View.VISIBLE
            viewModel.checkLogin(etFieldName.text.toString(), etFieldPassw.text.toString())
        }
    }

    fun openAlertDialog(msg: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            .setTitle("Erro")
            .setMessage(msg)
            .setNeutralButton("Ok", null)
        builder.create().show()
    }

    override fun onExtractLoaded(data: Data) {
        clLoader.visibility = View.GONE
        val intent = Intent(this, ExtractActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }

    override fun onError(msg: String) {
        clLoader.visibility = View.GONE
        openAlertDialog(msg)
    }

    override fun onLoginSuccess(login: Login) {
        viewModel.loadExtract(login)
    }
}
