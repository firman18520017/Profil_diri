package com.example.profildiri

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        ambilData()
        btnEditName.setOnClickListener { navigasiKeEditProfil() }
        btnCall.setOnClickListener { dialPhoneNumber(txtTelp.text.toString()) }


    }
    companion object {
        //set variabel REQUEST_CODE = 100
        val REQUEST_CODE = 100
    }

    private fun navigasiKeEditProfil() {
        val intent = Intent(this, EditProfilActivity::class.java)
        val namaUser = txtName.text.toString()
        val genderUser = txtGender.text.toString()
        val emailUser = txtEmail.text.toString()
        val telpUser = txtTelp.text.toString()
        val alamatUser = txtAddress.text.toString()
        intent.putExtra("nama", namaUser)
        intent.putExtra("gender", genderUser)
        intent.putExtra("email", emailUser)
        intent.putExtra("telp", telpUser)
        intent.putExtra("alamat", alamatUser)
        startActivityForResult(intent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data:Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                val nama = data?.getStringExtra("nama")
               val gender = data?.getStringExtra("gender")
                val email = data?.getStringExtra("email")
                val telp = data?.getStringExtra("telp")
                val alamat = data?.getStringExtra("alamat")
                txtName.text = nama
                txtGender.text = gender
                txtEmail.text = email
                txtTelp.text = telp
                txtAddress.text = alamat
            }else{
                Toast.makeText(this, "Edit failed",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun ambilData(){
        val bundle = intent.extras
        val nama = bundle?.getString("nama")
        val gender = bundle?.getString("gender")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")
        txtName.text = nama
        txtGender.text = gender
        txtEmail.text = email
        txtTelp.text = telp
        txtAddress.text = alamat
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {  startActivity(intent)
        }
    }
}


