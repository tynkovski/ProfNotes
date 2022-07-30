package com.tynkovski.android.profnotes.presentation.fragments.preferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tynkovski.android.profnotes.R
import com.tynkovski.android.profnotes.databinding.FragmentPreferencesBinding

class PreferencesFragment : Fragment(R.layout.fragment_preferences) {
    private val binding by viewBinding(FragmentPreferencesBinding::bind)
    private val viewModel: PreferencesViewModel by viewModels()
}