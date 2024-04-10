package com.enzofarias.cp2_rm98792

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculator = findViewById<Button>(R.id.buttonCalc)
        val buttonAccountPhone = findViewById<Button>(R.id.buttonAccountPhone)
        val buttonStudentSign = findViewById<Button>(R.id.buttonStudentSign)

        // Definir ações ao tap
        buttonCalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        // Definir ações ao tap
        buttonAccountPhone.setOnClickListener {
            val intent = Intent(this, PhoneActivity::class.java)
            startActivity(intent)
        }

        // função de assinatura
        buttonStudentSign.setOnClickListener {
            showSignature()
        }
    }

    // exibir a assinatura
    private fun showSignature() {
        val mySign = """
            Nome: Enzo Farias
            RM: 98792
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Desenvolvido Por")
            .setMessage(mySign)
            .setPositiveButton("Ok") { dialog, which ->

            }
            .show()
    }

}