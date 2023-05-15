package com.example.taopiksodikin_312110541

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.taopiksodikin_312110541.adapter.AdapterTeamBola
import com.example.taopiksodikin_312110541.databinding.ActivityMainBinding
import com.example.taopiksodikin_312110541.model.pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listpemain = java.util.ArrayList<pemain>()
        listpemain.add(pemain("Taopik",R.drawable.taopik,"GK","2.00m","Kalimantan","12 Mei 1969"))
        listpemain.add(pemain("ceking",R.drawable.ceking,"FK","1.25m","jogja ","10 Agustus 2001"))
        listpemain.add(pemain("bombom",R.drawable.bombom,"FK","1.64m","ciamis","11 Agustus 2001"))
        listpemain.add(pemain("wawan",R.drawable.madunjpg,"BK","1.68m","jatinegara","12 Agustus 2001"))
        listpemain.add(pemain("Yanto",R.drawable.madunjpg,"FWB","5.62m","bantar gebang","13 Agustus 2001"))

        binding.list.adapter= AdapterTeamBola(this, listpemain , object : AdapterTeamBola.OnClickListener{
            override fun detailData(item: pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val position = this.findViewById<TextView>(R.id.txtposisiPemain)
                    val tempatlahir = this.findViewById<TextView>(R.id.txttinggalPemain)
                    val tgllahir = this.findViewById<TextView>(R.id.txttanggallhrPemain)
                    val tinggi = this.findViewById<TextView>(R.id.txttinggiPemain)
                    val btn = this.findViewById<Button>(R.id.btnclose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    position.text = "${item?.posisi}"
                    tempatlahir.text = "${item?.Tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"
                    tinggi.text = "${item?.tinggi}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()
            }
        })
    }

}


