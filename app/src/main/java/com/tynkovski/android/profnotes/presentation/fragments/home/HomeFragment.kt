package com.tynkovski.android.profnotes.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tynkovski.android.profnotes.R
import com.tynkovski.android.profnotes.core.colorString
import com.tynkovski.android.profnotes.core.underlineString
import com.tynkovski.android.profnotes.databinding.FragmentHomeBinding
import com.tynkovski.android.profnotes.presentation.fragments.home.recyclerview.NoteAdapter
import com.tynkovski.android.profnotes.presentation.fragments.home.recyclerview.NoteDecorator

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvProfileGreetings.apply {
                text = getString(viewModel.getCurrentDayStage(), viewModel.profileName.value)
                    .colorString(0, 12, requireContext().getColor(R.color.gray))
            }

            tvTodayDescription.apply {
                text = viewModel.getCurrentDayInfo()
            }

            tvNewsDescription.apply {
                text = viewModel.getNews()
            }

            tvAllTasks.apply {
                text = text.underlineString()
            }

            rvLocalTasks.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = NoteAdapter().apply {
                    viewModel.notes.observe(viewLifecycleOwner) { notes ->
                        if (notes.isNotEmpty()) {
                            setItems(notes)
                        }
                    }
                }
                addItemDecoration(
                    NoteDecorator(resources.getDimensionPixelOffset(R.dimen.note_margin))
                )
            }

            tvLocalTasksCount.apply {
                text = "${viewModel.notes.value?.size}"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}