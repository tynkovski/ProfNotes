package com.tynkovski.android.profnotes.presentation.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import com.tynkovski.android.profnotes.R
import com.tynkovski.android.profnotes.core.colorString
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

        with(binding) {
            tvRegistrationAppeal.apply {
                text = text.colorString(4, 24, color = requireContext().getColor(R.color.green))
            }

            tvRecoveryAppeal.apply {
                text = text.colorString(24, 43, requireContext().getColor(R.color.yellow))
            }

            btnLogin.apply {
                isEnabled = true
                setOnClickListener {
                    findNavController(binding.root).navigate(R.id.action_navigation_login_to_navigation_home)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}