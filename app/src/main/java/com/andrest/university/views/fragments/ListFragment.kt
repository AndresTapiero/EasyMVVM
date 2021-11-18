package com.andrest.university.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrest.university.adapters.StudentsAdapter
import com.andrest.university.databinding.FragmentListBinding
import com.andrest.university.viewmodel.StudentViewModel

class ListFragment : Fragment() {


    private lateinit var binding: FragmentListBinding
    private lateinit var mStudentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)
        // Recyclerview
        val adapter = StudentsAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        mStudentViewModel.readAllData.observe(viewLifecycleOwner, Observer { students ->
            adapter.setData(students)
        })
        return binding.root
    }

}