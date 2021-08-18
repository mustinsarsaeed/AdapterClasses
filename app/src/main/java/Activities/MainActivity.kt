package Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name: String = edtname.text.toString()
        val pass: String = edtpassword.text.toString()
        val eml: String = edtemail.text.toString()
        val adr: String = edtAddress.text.toString()

        SendBtntoNextActivity.setOnClickListener {


            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_name", name)
            intent.putExtra("user_password", pass)
            intent.putExtra("user_email", eml)
            intent.putExtra("user_addres", adr)
            startActivity(intent)
        }

            sharebtn.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, name)
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Select Share app"))
                showToast("Button was Clicked")
            }
         }
    }
