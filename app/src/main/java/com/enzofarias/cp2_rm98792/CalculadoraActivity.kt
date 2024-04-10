package com.enzofarias.cp2_rm98792

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val firstNumberEdit = findViewById<EditText>(R.id.textoValor1)
        val secondNumberEdit = findViewById<EditText>(R.id.textoValor2)
        val groupOperations = findViewById<RadioGroup>(R.id.radioGroup)
        val calculateButton = findViewById<Button>(R.id.button)

        calculateButton.setOnClickListener {
            val firstNumber = firstNumberEdit.text.toString().toDoubleOrNull()
            val secondNumber = secondNumberEdit.text.toString().toDoubleOrNull()

            if (firstNumber == null || secondNumber == null) {
                Toast.makeText(this, "Os campos de valor são obrigatórios.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val operationResult = when (groupOperations.checkedRadioButtonId) {
                R.id.radioSoma -> firstNumber + secondNumber
                R.id.radioSubtracao -> firstNumber - secondNumber
                R.id.radioMultiplicacao -> firstNumber * secondNumber
                R.id.radioDivisao -> if (secondNumber != 0.0) {
                    firstNumber / secondNumber
                } else "Não é possível fazer divisão por zero."
                else -> null
            }

            if (operationResult == null) {
                Toast.makeText(this, "Operação inválida.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Resultado: $operationResult", Toast.LENGTH_SHORT).show()
            }
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
