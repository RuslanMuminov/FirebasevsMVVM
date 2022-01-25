package com.example.firebasevsmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.firebasevsmvvm.adapter.ComputersAdapter
import com.example.firebasevsmvvm.databinding.ActivityMainBinding
import com.example.firebasevsmvvm.viewmodels.ComputersViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ComputersAdapter
    private lateinit var viewModel: ComputersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ComputersAdapter()

        viewModel = ViewModelProvider(this) [ComputersViewModel::class.java]

        viewModel.getMutableList().observe(this, {
            adapter.differ.submitList(it)
        })

        binding.rv.adapter = adapter
    }
}