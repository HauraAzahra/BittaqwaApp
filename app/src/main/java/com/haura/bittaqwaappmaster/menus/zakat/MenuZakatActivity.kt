package com.haura.bittaqwaappmaster.menus.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.haura.bittaqwaappmaster.R
import kotlinx.android.synthetic.main.activity_menu_zakat.*
import java.text.NumberFormat
import java.util.*

class MenuZakatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_zakat)

        setSupportActionBar(toolbar_menu_zakat)
        initView()
    }

    private fun initView() {
        btn_zakat.setOnClickListener {
            val formatAmount = NumberFormat.getNumberInstance(Locale("id", "ID"))
                .format(et_amount_zakat.getNumericValue())

            tv_harta_amount.text = "Rp $formatAmount"


            if (et_amount_zakat.getNumericValue()?.toInt()!! >= 85000000) {
                val zakat = et_amount_zakat.getNumericValue()!!.toInt() * (2.5 / 100)
                val formatZakat = NumberFormat.getNumberInstance(Locale("id", "ID"))
                    .format(zakat)

                tv_amount_zakat.text = "Rp $formatZakat"


            } else {
                Toast.makeText(
                    this,
                    "Total Harta masih belum mencapai nisab (85gr Emas)",
                    Toast.LENGTH_LONG
                ).show()
                tv_amount_zakat.text = "Rp 0"
            }
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