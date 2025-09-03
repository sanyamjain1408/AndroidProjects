package com.example.a17_loginsignup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a17_loginsignup.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class signupActivity : AppCompatActivity() {
    private val binding : ActivitySignupBinding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Initialize Firebase
        auth = FirebaseAuth.getInstance()

        binding.signin.setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }

        binding.registersignup.setOnClickListener {

            //get text from text field
            val email = binding.email.text.toString()
            val username = binding.username.text.toString()
            val password = binding.Password.text.toString()
            val repeatpasword = binding.confirmpassword.text.toString()

            //check if any field is blank or not
            if (email.isEmpty()|| username.isEmpty()|| password.isEmpty()|| repeatpasword.isEmpty()){

                Toast.makeText(this, "Please Fill All The Details", Toast.LENGTH_SHORT).show()
            }else if (password != repeatpasword){
                Toast.makeText(this, "Repeat Password Must be Same", Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this){task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, LogInActivity::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this, "Registration Faild : ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

    }
}