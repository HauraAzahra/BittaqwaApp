package com.haura.bittaqwaappmaster.menus.doa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.haura.bittaqwaappmaster.R
import kotlinx.android.synthetic.main.activity_menu_doa.*

class MenuDoaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_doa)

        setSupportActionBar(toolbar_menu_doa)
        initView()
    }

    private fun initView() {
        card_doa_pagi_malam.setOnClickListener {
            val intent = Intent(this, DetailListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_doa_pagi_malam))
            intent.putExtra("ext_icon", R.drawable.ic_doa_pagi_malam)
            startActivity(intent)
        }
        card_doa_rumah.setOnClickListener {
            val intent = Intent(this, DetailListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_doa_rumah))
            intent.putExtra("ext_icon", R.drawable.ic_doa_rumah)
            startActivity(intent)
        }
        card_doa_makanan_minuman.setOnClickListener {
            val intent = Intent(this, DetailListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_doa_makanan_minuman))
            intent.putExtra("ext_icon", R.drawable.ic_doa_makanan_minuman)
            startActivity(intent)
        }
        card_doa_perjalanan.setOnClickListener {
            val intent = Intent(this, DetailListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_doa_perjalanan))
            intent.putExtra("ext_icon", R.drawable.ic_doa_perjalanan)
            startActivity(intent)
        }
        card_doa_sholat.setOnClickListener {
            val intent = Intent(this, DetailListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_sholat))
            intent.putExtra("ext_icon", R.drawable.ic_doa_sholat)
            startActivity(intent)
        }
        card_doa_etika_baik.setOnClickListener {
            val intent = Intent(this, DetailListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_etika_baik))
            intent.putExtra("ext_icon", R.drawable.ic_doa_etika_baik)
            startActivity(intent)
        }
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