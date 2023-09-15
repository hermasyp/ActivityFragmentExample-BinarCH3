package com.catnip.activityfragmentexample.presentation.otheractivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.catnip.activityfragmentexample.R
import com.catnip.activityfragmentexample.databinding.ActivityOtherBinding
import com.catnip.activityfragmentexample.model.Person

class OtherActivity : AppCompatActivity() {

    private val binding: ActivityOtherBinding by lazy {
        ActivityOtherBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
    }

    private fun getIntentData() {
        val name = intent?.getStringExtra(ARGS_NAME).orEmpty()
        val age = intent?.getIntExtra(ARGS_AGE, 0) ?: 0
        val person = intent?.getParcelableExtra<Person>(ARGS_PERSON)
        Toast.makeText(this, "$name : $age", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val ARGS_NAME = "ARGS_NAME"
        const val ARGS_AGE = "ARGS_AGE"
        const val ARGS_PERSON = "ARGS_PERSON"

        fun newInstance(context: Context, name: String, age: Int) : Intent {
            val intent = Intent(context,OtherActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(ARGS_NAME,name)
            intent.putExtra(ARGS_AGE,age)
            return intent
        }
        fun startActivity(context: Context, name: String, age: Int, person: Person? = null) {
            val intent = Intent(context,OtherActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(ARGS_NAME,name)
            intent.putExtra(ARGS_AGE,age)
            intent.putExtra(ARGS_PERSON,person)
            context.startActivity(intent)
        }
    }
}
