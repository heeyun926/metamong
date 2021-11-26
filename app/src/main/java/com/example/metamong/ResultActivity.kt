package com.example.metamong

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.databinding.ActivityResultBinding
import com.example.metamong.databinding.ItemMetamongresultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data:MutableList<ProfileData> = loadData()
        val profileAdapter = ProfileAdapter()
        profileAdapter.datas =data
        binding.metamongResult.adapter = profileAdapter

    }

    fun loadData(): MutableList<ProfileData> {
        val list = mutableListOf<ProfileData>()
        with(list){
            add(ProfileData(getDrawable(R.drawable.desktop_side)!!,"Programmer","#꼼꼼하고 #응용을 잘하는"))
            add(ProfileData(getDrawable(R.drawable.desktop_side)!!,"Programmer","#꼼꼼하고 #응용을 잘하는"))
            add(ProfileData(getDrawable(R.drawable.desktop_side)!!,"Programmer","#꼼꼼하고 #응용을 잘하는"))
            add(ProfileData(getDrawable(R.drawable.desktop_side)!!,"Programmer","#꼼꼼하고 #응용을 잘하는"))
        }
        return list
    }
}

class ProfileAdapter: RecyclerView.Adapter<ProfileAdapter.Holder>(){
    var datas = mutableListOf<ProfileData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =ItemMetamongresultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = datas[position]
        holder.setProfiles(data)

    }

    override fun getItemCount(): Int =datas.size


    inner class Holder(val binding: ItemMetamongresultBinding): RecyclerView.ViewHolder(binding.root){
        fun setProfiles(data: ProfileData){
            binding.contenMain
        }
    }
}


