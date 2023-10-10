package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.models.Valyuta
import com.example.myapplication.network.ApiClient
import com.example.myapplication.network.ApiServis
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val api=ApiClient.getApi().create(ApiServis::class.java)

        api.getServis().enqueue(object :retrofit2.Callback<ArrayList<Valyuta>>{
            override fun onResponse(
                call: Call<ArrayList<Valyuta>>,
                response: Response<ArrayList<Valyuta>>
            ) {
                if(response.isSuccessful){
                    binding.tvText.text=response.body().toString()
                }
                else{
                    Toast.makeText(this@MainActivity, "Yuklashdagi xatolik", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<Valyuta>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ulanishdagi xatolik", Toast.LENGTH_SHORT).show()
            }
        })
    }
}