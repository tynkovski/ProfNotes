package com.tynkovski.android.profnotes.presentation.fragments.preferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tynkovski.android.profnotes.databinding.FragmentPreferencesBinding

class PreferencesFragment : Fragment() {
    private val binding by viewBinding(FragmentPreferencesBinding::bind)
    private val viewModel: PreferencesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root: View = binding.root
        val textView: TextView = binding.textPreferences
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
}