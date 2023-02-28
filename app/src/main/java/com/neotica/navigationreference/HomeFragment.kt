package com.neotica.navigationreference

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.neotica.navigationreference.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //Step 11.1: Create a null checkers to the binding
    private var _binding: FragmentHomeBinding? = null

    //Step 11.2 get the binding if not null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        //Step 11.4 Since the layout is already null checked, there's no need for null safety on View {}
    ): View {
        //Step 11.3 Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Step 11.5 Override onViewCreated.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            //Step 11.6 Apply Navigation to fragment.
            btnCategory.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_categoryFragment)
            )
            //Step 11.7 Apply Navigation on Activity.
            btnProfile.setOnClickListener { view ->
                view.findNavController().navigate(R.id.action_homeFragment_to_profileActivity)
            }
        }
    }

    //Step 11.8 Override onDestroy if binding is null.
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}