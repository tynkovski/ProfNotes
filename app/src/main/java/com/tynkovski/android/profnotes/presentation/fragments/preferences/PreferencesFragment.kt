package com.tynkovski.android.profnotes.presentation.fragments.preferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tynkovski.android.profnotes.databinding.FragmentPreferencesBinding

class PreferencesFragment : Fragment() {
    private val binding by viewBinding(FragmentPreferencesBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val preferencesViewModel =
            ViewModelProvider(this).get(PreferencesViewModel::class.java)
        val root: View = binding.root

        val textView: TextView = binding.textPreferences
        preferencesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}