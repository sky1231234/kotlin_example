package com.example.kotlin

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.kotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_register
import kotlinx.android.synthetic.main.register.*

class Register : AppCompatActivity() {

    val TAG : String ="Register"
    var isBlank = false
    var PWCheck = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        pw_re_register.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }


            //입력이 끝났을 때
            //비밀번호 일치하는지 확인
            override fun afterTextChanged(p0: Editable?) {
                if (pw_register.getText().toString().equals(pw_re_register.getText().toString())) {
                    pw_check.setText("비밀번호가 일치합니다.")
                    pw_check.setTextColor(ContextCompat.getColor(this@Register, R.color.black))
                    PWCheck = true
                } else {
                    pw_check.setText("비밀번호가 일치하지 않습니다.")
                    pw_check.setTextColor(ContextCompat.getColor(this@Register, R.color.red))
                    PWCheck = false
                }
            }
        })

        //회원가입 버튼
        btn_register.setOnClickListener {

            val id = id_register.text.toString()
            val pw = pw_register.text.toString()
            val pw_re = pw_re_register.text.toString()
            val name = name_register.text.toString()

            //빈칸일때
            if (id.isEmpty() || pw.isEmpty() || pw_re.isEmpty() || name.isEmpty()) {
                isBlank = false
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                Log.e("tag", "빈칸")
            } else { //빈칸 아닐때

                if(PWCheck){
                    isBlank = true
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Log.e("tag", "빈칸xx")
                }else{
                    Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                }
            }

//        if(isExistBlank){
//            btn_register.isEnabled = true
//            Log.e("tag1","빈칸xx")
//
//        }else{
//            btn_register.isEnabled = false
//            Log.e("tag1","빈칸")
//
//        }
        }

    }
}
