package com.tsu.sdp_mobile_app.regist.ui.login
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tsu.sdp_mobile_app.MainActivity
import com.tsu.sdp_mobile_app.databinding.ActivityLoginBinding
import com.tsu.sdp_mobile_app.regist.ui.Register.RegisterActivity
import com.tsu.sdp_mobile_app.regist.ui.forgetpw.ForgetActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val login = binding.button
        val forget = binding.btnforgetPassword
        val regist = binding.btnRegist

        login.setOnClickListener {
            //loginViewModel.login(username.text.toString(), password.text.toString())
            val nextPage = Intent(this, MainActivity::class.java)
            startActivity(nextPage)
        }

        forget.setOnClickListener{
            val nextPage = Intent(this, ForgetActivity::class.java)
            startActivity(nextPage)
        }

        regist.setOnClickListener {
            val nextPage = Intent(this, RegisterActivity::class.java)
            startActivity(nextPage)
        }
    }
}


//package com.tsu.sdp_mobile_app.regist.ui.login
//
//import android.app.Activity
//import android.content.Intent
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import android.os.Bundle
//import androidx.annotation.StringRes
//import androidx.appcompat.app.AppCompatActivity
//import android.text.Editable
//import android.text.TextWatcher
//import android.view.View
//import android.view.inputmethod.EditorInfo
//import android.widget.EditText
//import android.widget.Toast
//import com.tsu.sdp_mobile_app.MainActivity
//import com.tsu.sdp_mobile_app.R
//import com.tsu.sdp_mobile_app.admin.FacultyActivity
//import com.tsu.sdp_mobile_app.databinding.ActivityLoginBinding
//
//class LoginActivity : AppCompatActivity() {
//
//    private lateinit var loginViewModel: LoginViewModel
//    private lateinit var binding: ActivityLoginBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val username = binding.edtEmail
//        val password = binding.editTextTextPassword
//        val login = binding.button
//
//        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
//            .get(LoginViewModel::class.java)
//
//        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
//            val loginState = it ?: return@Observer
//
//            // disable login button unless both username / password is valid
//            login.isEnabled = loginState.isDataValid
//
//            if (loginState.usernameError != null) {
//                username.error = getString(loginState.usernameError)
//            }
//            if (loginState.passwordError != null) {
//                password.error = getString(loginState.passwordError)
//            }
//        })
//
//        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
//            val loginResult = it ?: return@Observer
//
//            if (loginResult.error != null) {
//                showLoginFailed(loginResult.error)
//            }
//            if (loginResult.success != null) {
//                updateUiWithUser(loginResult.success)
//            }
//            setResult(Activity.RESULT_OK)
//
//            //Complete and destroy login activity once successful
//            finish()
//        })
//
//        username.afterTextChanged {
//            loginViewModel.loginDataChanged(
//                username.text.toString(),
//                password.text.toString()
//            )
//        }
//
//        password.apply {
//            afterTextChanged {
//                loginViewModel.loginDataChanged(
//                    username.text.toString(),
//                    password.text.toString()
//                )
//            }
//
//            setOnEditorActionListener { _, actionId, _ ->
//                when (actionId) {
//                    EditorInfo.IME_ACTION_DONE ->
//                        loginViewModel.login(
//                            username.text.toString(),
//                            password.text.toString()
//                        )
//                }
//                false
//            }
//
//            login.setOnClickListener {
//                //loginViewModel.login(username.text.toString(), password.text.toString())
//                val nextPage = Intent(context, MainActivity::class.java)
//                startActivity(nextPage)
//            }
//        }
//    }
//
//    private fun updateUiWithUser(model: LoggedInUserView) {
//        val welcome = getString(R.string.welcome)
//        val displayName = model.displayName
//        // TODO : initiate successful logged in experience
//        Toast.makeText(
//            applicationContext,
//            "$welcome $displayName",
//            Toast.LENGTH_LONG
//        ).show()
//    }
//
//    private fun showLoginFailed(@StringRes errorString: Int) {
//        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
//    }
//}
//
///**
// * Extension function to simplify setting an afterTextChanged action to EditText components.
// */
//fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
//    this.addTextChangedListener(object : TextWatcher {
//        override fun afterTextChanged(editable: Editable?) {
//            afterTextChanged.invoke(editable.toString())
//        }
//
//        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//
//        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
//    })
//}