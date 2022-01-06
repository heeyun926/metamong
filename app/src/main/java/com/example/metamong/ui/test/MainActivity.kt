package com.example.metamong.ui.test

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.example.metamong.R
import com.example.metamong.notworked.BaseActivity
import com.example.metamong.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun permissionGranted(requestCode: Int) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,99)
    }

    override fun permissionDenied(requestCode: Int) {
        Toast.makeText(baseContext,"권한 거부됨",Toast.LENGTH_LONG).show()
    }
    override fun onActivityResult(requestCode: Int,resultCode:Int, data:Intent?){
        super.onActivityResult(requestCode,resultCode,data)
        if (requestCode == 10){
            if(resultCode == Activity.RESULT_OK){
                Log.d("카메라","True")
            }else{
                Log.d("카메라","False")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext1.isEnabled = false

        //카메라 권한 부여
        binding.logo.setOnClickListener{
            requirePermissions(arrayOf(Manifest.permission.CAMERA),10)
        }

        //라디어 버튼 제어
        binding.radioGroup1.setOnCheckedChangeListener {group, checkId ->
            when(checkId){
            R.id.pencilSelect -> {
                binding.btnNext1.isEnabled = true
                binding.pencil.setImageResource(R.drawable.pencil)
                binding.talk.setImageResource(R.drawable.noselect_talk)
            }

            R.id.talkSelect ->{
                binding.btnNext1.isEnabled = true
                binding.pencil.setImageResource(R.drawable.noselect_pencil)
                binding.talk.setImageResource(R.drawable.talk)
            }
            }
        }

        binding.btnNext1.setOnClickListener{
            val intent = Intent (this, ResultActivity::class.java)
            startActivity(intent)
        }


    }

}