package com.example.challengedatabaseroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengedatabaseroom.Room.Note
import kotlinx.android.synthetic.main.adapter_note.view.*

class NoteAdapter(private val notes:ArrayList<Note>,private val Listener: OnAdapterListener):
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder> () {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_note, parent, false)
        )

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes [position]
        holder.view.text_title.text = note.title
        holder.view.text_title.setOnClickListener{
            Listener.onClik( note )
        }
        holder.view.icon_edit.setOnClickListener{
            Listener.onUpdate( note )
        }
        holder.view.icon_delete.setOnClickListener{
            Listener.onDelete( note )

        }
    }

    override fun getItemCount() = notes.size


    class NoteViewHolder( val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Note>){
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }
    interface OnAdapterListener{
        fun onClik(note: Note)
        fun onUpdate(note: Note)
        fun onDelete(note: Note)
    }

}


