package com.enzofarias.cp2_rm98792

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        val fixedChargeInput = findViewById<EditText>(R.id.textoFixo)
        val localMinutesInput = findViewById<EditText>(R.id.textoValor1)
        val cellularMinutesInput = findViewById<EditText>(R.id.textoValor2)
        val calculateButton = findViewById<Button>(R.id.button)

        calculateButton.setOnClickListener {
            val fixedCharge = fixedChargeInput.text.toString().toDoubleOrNull()
            val localMinutes = localMinutesInput.text.toString().toDoubleOrNull()
            val cellularMinutes = cellularMinutesInput.text.toString().toDoubleOrNull()

            if (localMinutes == null || cellularMinutes == null || fixedCharge == null) {
                Toast.makeText(this, "Os campos de valor são obrigatórios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val localCallCost = localMinutes * 0.04
            val cellularCallCost = cellularMinutes * 0.20

            val resultIntent = Intent(this, ResultActivity::class.java).apply {
                putExtra("fixedCharge", fixedCharge)
                putExtra("localCallCost", localCallCost)
                putExtra("cellularCallCost", cellularCallCost)
            }
            startActivity(resultIntent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
