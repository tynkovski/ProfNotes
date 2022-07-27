package com.tynkovski.android.profnotes.presentation.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tynkovski.android.profnotes.R
import com.tynkovski.android.profnotes.core.spanString
import com.tynkovski.android.profnotes.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvRegistrationAppeal.apply {
            text = text.spanString(
                startIndex = 4,
                endIndex = 24,
                color = requireContext().getColor(R.color.green)
            )
        }

        binding.tvRecoveryAppeal.apply {
            text = text.spanString(
                startIndex = 24,
                endIndex = 43,
                color = requireContext().getColor(R.color.yellow)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}