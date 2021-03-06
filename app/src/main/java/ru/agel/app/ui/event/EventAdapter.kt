package ru.agel.app.ui.event

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.agel.app.databinding.RecyclerviewEventItemBinding
import ru.agel.app.model.EventReminder
import java.text.SimpleDateFormat

internal class EventAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var events = mutableListOf<EventReminder>()

    fun add(newEvents: List<EventReminder>){
        events = newEvents as MutableList<EventReminder>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(RecyclerviewEventItemBinding.inflate(LayoutInflater.from(parent.context),
        parent,
        false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size
}

internal class ViewHolder(val binding: RecyclerviewEventItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(eventReminder: EventReminder){
        binding.apply {
            title.text = eventReminder.title
            description.text = eventReminder.desc
            date.text = SimpleDateFormat("dd.MM.yy\nHH:mm").format(eventReminder.dateStart)
        }
    }
}