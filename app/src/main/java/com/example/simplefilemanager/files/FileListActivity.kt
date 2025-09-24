package com.example.simplefilemanager.files

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplefilemanager.Adapters.MyAdapter
import com.example.simplefilemanager.databinding.ActivityFileListBinding
import java.io.File

class FileListActivity : AppCompatActivity() {

    private lateinit var fileListBinding: ActivityFileListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fileListBinding = ActivityFileListBinding.inflate(layoutInflater)
        setContentView(fileListBinding.root)

        val path = intent.getStringExtra("path") ?: return
        val root = File(path)
        val fileAndDirectory = root.listFiles() ?: arrayOf()


        fileListBinding.textView.isVisible = fileAndDirectory.isEmpty()


        fileListBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        fileListBinding.recyclerView.adapter = MyAdapter(this, fileAndDirectory)
    }
}
