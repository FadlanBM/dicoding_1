package com.example.restaurantreview

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.restaurantreview.core.data.source.remote.network.State
import com.example.restaurantreview.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModel()

    companion object {
        private const val TAG = "MainActivity"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
//
//        val linearLayout=LinearLayoutManager(this)
//        binding.rvReview.layoutManager=linearLayout
//        val itemDecoration=DividerItemDecoration(this,linearLayout.orientation)
//        binding.rvReview.addItemDecoration(itemDecoration)

        getRestoran(binding)
        getEventByID(binding)
    }

    private fun getRestoran(binding: ActivityMainBinding){
        viewModel.getEventByActive(0,null).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    val transactionDetail = it.data
                    Log.d("EventData",transactionDetail.toString())
                }
                State.ERROR -> {

                }
                State.LOADING -> {
                }
            }
        }
    }

    private fun getEventByID(binding: ActivityMainBinding){
        viewModel.getEventByID(9183).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    val transactionDetail = it.data
                    Log.d("EventDataByID",transactionDetail.toString())
                }
                State.ERROR -> {

                }
                State.LOADING -> {

                }
            }
        }
    }
}