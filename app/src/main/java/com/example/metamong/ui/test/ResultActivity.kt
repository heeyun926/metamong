package com.example.metamong.ui.test

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metamong.R
import com.example.metamong.databinding.ActivityResultBinding
import com.example.metamong.databinding.ItemMetamongresultBinding
import com.example.metamong.ui.main.HomeActivity_Sub
import com.example.metamong.model.ProfileData

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data : MutableList<ProfileData> = loadData()
        val profileAdapter = ProfileAdapter(this)
        profileAdapter.datas =data
        binding.metamongResult.adapter = profileAdapter

        binding.btnMain.setOnClickListener{
            val intent = Intent (this, HomeActivity_Sub::class.java)
            startActivity(intent)
        }
    }



    fun loadData(): MutableList<ProfileData> {
        val list = mutableListOf<ProfileData>()
        with(list){
            add(
                ProfileData(
                    R.drawable.desktop_side,"Programmer","#꼼꼼하고 #응용을 잘하는","논리력 : 현상이나" +
                    "동작 원리에 대해 논리적으로 잘 이해하는 능력과 사람의 생각을 컴퓨터의 언어 얼마나 잘 표현할 수 있는 능력이 해당되지 않을까 한다" +
                    "집중력 : 한 가지를 맘 잡으면 푹 빠져서 다른 일에 신경 쓰는 것을 줄이고 계속 생각하며 개발한다 ")
            )
            add(
                ProfileData(
                    R.drawable.mobile_side,"UXUI Designer","#꼼꼼하고 #응용을 잘하는","문제해결 능력 : 진정한 문제를" +
                    "발견하고 시각화하는 능력,여러개의 답을 발견하고 비교/검증하는 능력, 선택한 해결책을 설득하고 제품화하는 능력" +
                    "고객이 해결해달라고 요청한 것 뿐만 아니라 진정으로 사용자에게 필요한 것을 발견하고 해결하는 것을 말한다.")
            )

        }
        return list
    }
}

class ProfileAdapter(val context: Context): RecyclerView.Adapter<ProfileAdapter.Holder>(){
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
            binding.contenImage.setImageResource(data.image)
            binding.contentTitle.text = data.name
            binding.contentTag.text = data.tag

            binding.root.setOnClickListener{
                val intent = Intent(context, ResultDatailActivity::class.java)
                intent.putExtra("data",data)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)


            }
        }
    }
}


