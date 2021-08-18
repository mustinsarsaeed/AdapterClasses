package Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       val bundle: Bundle? = intent.extras
        val user = bundle!!.getString("user_name")
        val pass = bundle.getString("user_password")
        val eml = bundle.getString("user_email")
        val adress = bundle.getString("user_addres")

        setuser.text = user
        setpassword.text = pass
        setemail.text = eml
        setAddress.text = adress
    }

    }
