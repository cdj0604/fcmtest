package com.example.fcmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("FCM Log", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }
                val token = task.result!!.token
                Log.d("FCM Log", "FCM 토큰: $token")
                Toast.makeText(this@MainActivity, token, Toast.LENGTH_SHORT).show()
            })
    }
}
