package com.tynkovski.android.profnotes.presentation.fragments.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tynkovski.android.profnotes.R
import com.tynkovski.android.profnotes.core.colorString
import com.tynkovski.android.profnotes.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels()

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
}