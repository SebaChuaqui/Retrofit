package com.example.retrofit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.model.Terrain
import kotlinx.android.synthetic.main.fragment_first.*
import java.util.Observer


class FirstFragment : Fragment(), MarsAdapter.Mars {

    lateinit var mViewModel: MarsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(MarsViewModel::class.java)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { //Me aseguro de que la vista se crea
        super.onViewCreated(view, savedInstanceState)

        val mRecyclerView = recyclerView
        val mAdapter = MarsAdapter(this)

        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = GridLayoutManager(context, 2)

        mViewModel.exposeLiveDataFromServer().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            Log.d("VIEW", it.toString())

            mAdapter.updateListMars(it)

        })

           // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    override fun passMars(mTerrain: Terrain) {
        TODO("Not yet implemented")
    }
}


