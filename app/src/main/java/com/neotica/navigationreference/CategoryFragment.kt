package com.neotica.navigationreference

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.neotica.navigationreference.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {
    //Step 15.1: Create a null checker to the binding
    private var _binding: FragmentCategoryBinding? = null

    //Step 15.2 Get the binding if not null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Step 15.3 Inflate the layout for this fragment
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Step 17: SetonClickListener on button
        binding.btnCategoryLifestyle.setOnClickListener { view ->
            //Step 25 Create a new variable containing navigation directions.
            val toDetailCategoryFragment =
                CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            //Step 26 SendArgs
            toDetailCategoryFragment.name = "Lifestyle"
            toDetailCategoryFragment.stock = 7
            //Step 27 Find NavController and navigate to intended direction.
            view.findNavController().navigate(toDetailCategoryFragment)
        }
    }

    //Step 20: override onDestroy if null.
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}