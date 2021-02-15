package com.jydev.pagingexample.ui

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.paging.AsyncPagedListDiffer
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import com.jydev.pagingexample.AnimalAdapter
import com.jydev.pagingexample.ItemDecoration
import com.jydev.pagingexample.R
import com.jydev.pagingexample.base.BaseActivity
import com.jydev.pagingexample.data.AnimalDataSourceImpl
import com.jydev.pagingexample.databinding.ActivityMainBinding
import com.jydev.pagingexample.model.Animal
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity() {
    private val viewModel : MainViewModel by viewModel{ parametersOf()}
    private val bind by binding<ActivityMainBinding>(R.layout.activity_main)
    private val dataSource : AnimalDataSourceImpl by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        bind.run  {
            mainViewModel = viewModel
            itemDecoration = ItemDecoration()
            animalAdapter = AnimalAdapter().apply {
                viewModel.animalList.observe(this@MainActivity, Observer(this::submitList))
            }
        }
    }
}