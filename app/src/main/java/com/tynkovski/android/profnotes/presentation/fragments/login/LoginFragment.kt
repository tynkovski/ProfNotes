package com.tynkovski.android.profnotes.presentation.fragments.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tynkovski.android.profnotes.R
import com.tynkovski.android.profnotes.core.colorSubString
import com.tynkovski.android.profnotes.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    companion object {
        const val LOGIN_TEXT_KEY = "LOGIN_TEXT"
        const val PASSWORD_TEXT_KEY = "PASSWORD_TEXT"
    }

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val loginTextWatcher: TextWatcher = object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable?) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    btnLogin.isEnabled = edLogin.text.toString().isNotEmpty() && edPassword.text.toString().isNotEmpty()
                }
            }

            tvRecoveryAppeal.apply {
                text = text.colorSubString(
                    requireContext().getString(R.string.forget_recovery),
                    requireContext().getColor(R.color.yellow)
                )
            }

            tvRegistrationAppeal.apply {
                text = text.colorSubString(
                    requireContext().getString(R.string.sign_in_without_autorization),
                    requireContext().getColor(R.color.green)
                )
            }

            edLogin.apply {
                addTextChangedListener(loginTextWatcher)
                setText(savedInstanceState?.getString(LOGIN_TEXT_KEY, ""))
            }

            edPassword.apply {
                addTextChangedListener(loginTextWatcher)
                setText(savedInstanceState?.getString(PASSWORD_TEXT_KEY, ""))
            }

            btnLogin.apply {
                setOnClickListener {
                    findNavController(binding.root).navigate(R.id.action_navigation_login_to_navigation_home)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LOGIN_TEXT_KEY, binding.edLogin.text.toString())
        outState.putString(PASSWORD_TEXT_KEY, binding.edPassword.text.toString())
    }
}