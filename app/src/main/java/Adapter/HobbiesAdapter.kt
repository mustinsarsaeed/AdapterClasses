package Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import Model.Hobby
import com.example.myapplication.R
import com.example.myapplication.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, val hobbies :List<Hobby>): RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var currentHobby: Hobby? = null
        var currentPosition: Int = 0
        init {
            itemView.setOnClickListener{
                context.showToast(currentHobby!!.title + "Clicked to ")
                Toast.makeText(context, currentHobby!!.title + "Clicked to ",Toast.LENGTH_SHORT).show()
            }
            itemView.img_share.setOnClickListener{
                val message : String  = "My Hobby is :" + currentHobby!!.title
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"
                context.startActivity(Intent.createChooser(intent,"Select Share app"))
            }
        }
        fun setData (hobby : Hobby?, position: Int){
            itemView.txt_title.text = hobby!!.title
            this.currentHobby = hobby
            this.currentPosition = position
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item,parent, false)
        return MyViewHolder(view)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
           val hobby = hobbies[position]
        holder.setData(hobby,position)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }
}