package com.example.profildiri

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_edit_profil.*
import kotlinx.android.synthetic.main.activity_main.*

class EditProfilActivity : AppCompatActivity() {
    private var namaEdit : String = ""
    private var emailEdit : String = ""
    private var telpEdit : String = ""
    private var alamatEdit : String = ""
    private var genderEdit : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)
        val intentData = intent.extras
        val namaUser = intentData?.getString("nama")
        val emailUser = intentData?.getString("email")
        val telpUser = intentData?.getString("telp")
        val alamatUser = intentData?.getString("alamat")
        edtProfilName.setText(namaUser)
        edtProfilEmail.setText(emailUser)
        edtProfilTelp.setText(telpUser)
        edtProfilAlmt.setText(alamatUser)
        btnEditSave.setOnClickListener { saveData() }

    }
    private fun saveData(){
        namaEdit = edtProfilName.text.toString()
        genderEdit = spinnerProfilGender.selectedItem.toString()
        emailEdit = edtProfilEmail.text.toString()
        telpEdit = edtProfilTelp.text.toString()
        alamatEdit = edtProfilAlmt.text.toString()
        if (!namaEdit.isEmpty() ) {
            val result = Intent()
            result.putExtra("nama", namaEdit)
            result.putExtra("gender", genderEdit)
            result.putExtra("email", emailEdit)
            result.putExtra("telp", telpEdit)
            result.putExtra("alamat", alamatEdit)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }

}