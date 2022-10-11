package com.haura.bittaqwaappmaster.menus.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.haura.bittaqwaappmaster.R
import com.haura.bittaqwaappmaster.menus.doa.model.DoaModel
import kotlinx.android.synthetic.main.activity_detail_doa.*

class DetailDoaActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DOA = "extra_doa"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_doa)

        val doa = intent.getParcelableExtra<DoaModel>(EXTRA_DOA) as DoaModel
        setSupportActionBar(toolbar_detail_doa)
        supportActionBar?.title = doa.title

        tv_title_doa.text = doa.title
        tv_title_arab.text = doa.doa
        tv_title_latin.text = "(${doa.latin})"
        tv_title_arti.text = doa.translate
        tv_title_riwayat.text = doa.profile
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