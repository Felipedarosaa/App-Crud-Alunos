package com.example.teste_app2023
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextOldName: EditText
    private lateinit var editTextNewName: EditText
    private lateinit var textViewList: TextView
    private var students = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Removendo a barra do cabeçalho
        supportActionBar!!.hide()

        editTextName = findViewById(R.id.edit_text_name)
        textViewList = findViewById(R.id.text_view_list)
        editTextOldName = findViewById(R.id.edit_text_old_name)
        editTextNewName = findViewById(R.id.edit_text_new_name)

        findViewById<View>(R.id.button_add).setOnClickListener { addStudent() }
        findViewById<View>(R.id.button_delete).setOnClickListener { deleteStudent() }

        findViewById<View>(R.id.button_update).setOnClickListener {
            val oldName = editTextOldName.text.toString()
            val newName = editTextNewName.text.toString()
            updateStudent(oldName, newName)
        }
    }

     fun addStudent() {
        val name = editTextName.text.toString()
        students.add(name)
        editTextName.text.clear()
        updateList()
    }

    fun deleteStudent() {
        val name = editTextName.text.toString()
        students.remove(name)
        editTextName.text.clear()
        updateList()
    }

    fun updateStudent(oldName: String, newName: String) {
        if (students.contains(oldName)) {
            students[students.indexOf(oldName)] = newName
            updateList()
        } else {
            // error: oldName não encontrado na lista
            Toast.makeText(this, "Nome não encontrado", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateList() {
        val stringBuilder = StringBuilder()
        for (student in students) {
            stringBuilder.append(student)
            stringBuilder.append("\n")
        }
        textViewList.text = stringBuilder.toString()
    }


}