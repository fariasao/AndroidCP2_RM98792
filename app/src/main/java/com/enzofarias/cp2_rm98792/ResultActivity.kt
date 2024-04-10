package com.enzofarias.cp2_rm98792

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val fixedCharge = intent.getDoubleExtra("fixedCharge", 0.0)
        val localCallCost = intent.getDoubleExtra("localCallCost", 0.0)
        val cellularCallCost = intent.getDoubleExtra("cellularCallCost", 0.0)

        val finalTotal = fixedCharge + localCallCost + cellularCallCost

        val resultTextView = findViewById<TextView>(R.id.resultadoView)
        resultTextView.text = String.format("Taxa: \t\t R$ %.2f\n" +
                "Chamada Local: \t\t R$ %.2f\n" +
                "Chamada Celular: \t\t R$ %.2f\n\n" +
                "Total: R$ %.2f", fixedCharge, localCallCost, cellularCallCost, finalTotal)

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
