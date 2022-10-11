package com.haura.bittaqwaappmaster.menus.jadwalsholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.haura.bittaqwaappmaster.R
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_menu_jadwal_sholat.*
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class MenuJadwalSholatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_jadwal_sholat)

        setSupportActionBar(toolbar_menu_jadwal_sholat)

        initView()
    }

    private fun initView() {
        val c: Date = Calendar.getInstance().time
        val df = SimpleDateFormat("E, dd MMM", Locale.getDefault())
        val formattedDate: String = df.format(c)

        tv_date_pray.text = formattedDate

        initGetDataJadwalSholat(c, "jakarta")
    }

    private fun initGetDataJadwalSholat(date: Date, city: String) {
        val df = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formattedDate: String = df.format(date)

        val client = AsyncHttpClient()
        val url = "https://api.pray.zone/v2/times/day.json?city=$city&date=$formattedDate"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                pb_jadwal_sholat.visibility = View.INVISIBLE
                val response = responseBody?.let { String(it) }

                try {
                    val responseObject = JSONObject(response)
                    val dataResult = responseObject.getJSONObject("results")
                    val dataDatetimeArray = dataResult.getJSONArray("datetime")
                    val dataObjectDatetime = dataDatetimeArray.getJSONObject(0)
                    val dataObjectTimes = dataObjectDatetime.getJSONObject("times")

                    tv_pray_time_imsak.text = dataObjectTimes.getString("Imsak")
                    tv_pray_time_subuh.text = dataObjectTimes.getString("Fajr")
                    tv_pray_time_sunrise.text = dataObjectTimes.getString("Imsak")
                    tv_pray_time_dzuhur.text = dataObjectTimes.getString("Dhuhr")
                    tv_pray_time_ashar.text = dataObjectTimes.getString("Asr")
                    tv_pray_time_maghrib.text = dataObjectTimes.getString("Maghrib")
                    tv_pray_time_isya.text = dataObjectTimes.getString("Isha")


                    val dataObjectLocation = dataResult.getJSONObject("location")
                    tv_location.text = dataObjectLocation.getString("city")


                } catch (e: Exception) {
                    Toast.makeText(this@MenuJadwalSholatActivity, e.message, Toast.LENGTH_SHORT)
                        .show()
                    e.printStackTrace()
                }

            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                pb_jadwal_sholat.visibility = View.INVISIBLE
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error?.message}"
                }
                Toast.makeText(this@MenuJadwalSholatActivity, errorMessage, Toast.LENGTH_SHORT)
                    .show()
            }

        })
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