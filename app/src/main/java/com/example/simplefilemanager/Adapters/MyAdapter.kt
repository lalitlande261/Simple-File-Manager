package com.example.simplefilemanager.Adapters


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.simplefilemanager.R
import com.example.simplefilemanager.databinding.RecycleItemBinding
import com.example.simplefilemanager.files.FileListActivity
import java.io.File




class MyAdapter(private val context: Context, private val fileAndDirectory: Array<File>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(val binding : RecycleItemBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = RecycleItemBinding.inflate(LayoutInflater.from(context),parent,false)
return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
           val file = fileAndDirectory[position]
        holder.binding.txtItem.text = file.name


        if (file.isDirectory) {
            holder.binding.imgItem.setImageResource(R.drawable.icon_folder)
        } else {
            holder.binding.imgItem.setImageResource(R.drawable.icon_file)
        }

        holder.itemView.setOnClickListener {
            if (file.isDirectory) {
                val intent = Intent(context, FileListActivity::class.java)
                intent.putExtra("path", file.absolutePath)
                context.startActivity(intent)
            } else {

                Toast.makeText(context, "This is a file", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun getItemCount():Int= fileAndDirectory.size


}