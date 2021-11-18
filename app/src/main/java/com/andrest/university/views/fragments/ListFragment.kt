package com.andrest.university.views.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrest.university.R
import com.andrest.university.adapters.StudentsAdapter
import com.andrest.university.databinding.FragmentListBinding
import com.andrest.university.util.Resources.Companion.ARE_YOU_SURE_DELETE
import com.andrest.university.util.Resources.Companion.DELETE_EVERYTHING
import com.andrest.university.util.Resources.Companion.NO
import com.andrest.university.util.Resources.Companion.SUCCESSFULLY_DELETE
import com.andrest.university.util.Resources.Companion.YES
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

        //Add menu
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteAllUsers()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUsers() {

        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton(YES) { _, _ ->
            mStudentViewModel.deleteAllUsers()
            Toast.makeText(requireContext(), SUCCESSFULLY_DELETE, Toast.LENGTH_SHORT)
                .show()
        }
        builder.setNegativeButton(NO) { _, _ -> }
        builder.setTitle(DELETE_EVERYTHING)
        builder.setMessage(ARE_YOU_SURE_DELETE)
        builder.create().show()
    }
}