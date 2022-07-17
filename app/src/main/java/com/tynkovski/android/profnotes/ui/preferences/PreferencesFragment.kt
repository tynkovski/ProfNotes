package com.tynkovski.android.profnotes.ui.preferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tynkovski.android.profnotes.databinding.FragmentPreferencesBinding

class PreferencesFragment : Fragment() {

    private var _binding: FragmentPreferencesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val preferencesViewModel =
            ViewModelProvider(this).get(PreferencesViewModel::class.java)

        _binding = FragmentPreferencesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPreferences
        preferencesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}