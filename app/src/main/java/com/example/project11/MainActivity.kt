package com.example.project11

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import com.example.project11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            tilName.error = "Nama tidak boleh kosong"

            btnHideError.setOnClickListener {
                tilName.isErrorEnabled = false
            }

            etName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun afterTextChanged(p0: Editable?) {
                    if (p0.isNullOrBlank()) {
                        tilName.isErrorEnabled = true
                        tilName.error = "Nama tidak boleh kosong"
                    } else {
                        tilName.isErrorEnabled = false
                    }
                }
            })

            val mAdapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_list_item_1,
                listOf(
                    "Straight",
                    "Gay",
                    "Lesbo"
                )
            )
            actvSexOrientation.setAdapter(mAdapter)

            clRoot.setOnClickListener {
                actvSexOrientation.clearFocus()
                removeSoftKeyboard()
            }
        }
    }

    private fun removeSoftKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.actvSexOrientation.windowToken, 0)
    }
}