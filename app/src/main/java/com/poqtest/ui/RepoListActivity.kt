package com.poqtest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.poqtest.R
import com.poqtest.databinding.ActivityRepoListBinding
import com.poqtest.di.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class RepoListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityRepoListBinding
    private lateinit var mViewModel: RepoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repo_list)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(RepoListViewModel::class.java)

        binding.viewModel = mViewModel
    }
}
