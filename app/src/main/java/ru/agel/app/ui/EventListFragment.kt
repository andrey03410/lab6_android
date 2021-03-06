package ru.agel.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.recyclerview.widget.LinearLayoutManager
import ru.agel.app.databinding.FragmentEventsBinding
import ru.agel.app.ui.event.EventAdapter
import ru.agel.app.ui.event.EventViewModel
import java.util.*

class EventListFragment : Fragment() {
    private lateinit var binding: FragmentEventsBinding
    private val eventAdapter = EventAdapter()
    private val eventViewModel: EventViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addEventButton.setOnClickListener {
            eventViewModel.showAddEventFragment()
        }

        binding.recyclerView.apply {
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(context)
        }

        eventViewModel.getEvents().observe(viewLifecycleOwner){
            eventAdapter.add(it)
        }
    }
}