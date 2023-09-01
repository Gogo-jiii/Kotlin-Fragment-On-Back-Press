package com.example.fragmentonbackpress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentonbackpress.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOneBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnGotoSecondFragment.setOnClickListener {
            gotoSecondFragment()
        }
        return view
    }

    private fun gotoSecondFragment() {
        val fragment2 = FragmentTwo()
        val fragmentManager: FragmentManager = parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack("Fragment2")
        fragmentTransaction.replace(R.id.container, fragment2, "Fragment2")
        fragmentTransaction.commit()
    }
}