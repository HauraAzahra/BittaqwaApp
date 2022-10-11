package com.haura.bittaqwaappmaster.menus.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.haura.bittaqwaappmaster.R
import com.haura.bittaqwaappmaster.menus.doa.adapter.DoaListAdapter
import com.haura.bittaqwaappmaster.menus.doa.data.*
import com.haura.bittaqwaappmaster.menus.doa.model.DoaModel
import kotlinx.android.synthetic.main.activity_detail_list_doa.*

class DetailListDoaActivity : AppCompatActivity() {
    lateinit var title: String
    var logo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_list_doa)

        title = intent.getStringExtra("ext_title").toString()
        logo = intent.getIntExtra("ext_icon", 0)

        setSupportActionBar(toolbar_list_detail_doa)
        supportActionBar?.title = title
        initRecyclerview()
    }

    private fun initRecyclerview() {
        val list: ArrayList<DoaModel> = arrayListOf()
        when (title) {
            getString(R.string.text_doa_pagi_malam) -> list.addAll(DoaPagiDanMalamData.listDoaPagiDanMalamData)
            getString(R.string.text_doa_rumah) -> list.addAll(DoaRumahData.listDoaRumahData)
            getString(R.string.text_doa_makanan_minuman) -> list.addAll(DoaMakananDanMinumanData.listDoaMakananDanMinumanData)
            getString(R.string.text_doa_perjalanan) -> list.addAll(DoaPerjalananData.listDoaPerjalananData)
            getString(R.string.text_sholat) -> list.addAll(DoaSholatData.listDoaShalatData)
            getString(R.string.text_etika_baik) -> list.addAll(DoaEtikaBaikData.listDoaEtikaBaikData)
        }

        rv_doa.setHasFixedSize(true)
        rv_doa.layoutManager = LinearLayoutManager(this)
        val listDoa = DoaListAdapter(list, logo)
        rv_doa.adapter = listDoa
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}