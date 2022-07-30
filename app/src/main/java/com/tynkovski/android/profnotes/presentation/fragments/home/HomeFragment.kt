package com.tynkovski.android.profnotes.presentation.fragments.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tynkovski.android.profnotes.R
import com.tynkovski.android.profnotes.core.colorString
import com.tynkovski.android.profnotes.core.underlineString
import com.tynkovski.android.profnotes.databinding.FragmentHomeBinding
import com.tynkovski.android.profnotes.presentation.fragments.home.recyclerview.NoteAdapter
import com.tynkovski.android.profnotes.presentation.fragments.home.recyclerview.NoteDecorator

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()

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

}