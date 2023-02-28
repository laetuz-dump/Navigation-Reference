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
        _binding = FragmentCategoryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Step 17: SetonClickListener on button
        binding.btnCategoryLifestyle.setOnClickListener { view ->
            //Step 18: Define Bundle()
            val mBundle = Bundle()
            //Step 19: Bundle PutString and PutLong to the navController -> intended action.
            mBundle.putString(EXTRA_NAME, "Lifestyle")
            mBundle.putLong(EXTRA_STOCK, 7)
            view.findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment, mBundle)
        }
    }

    //Step 20: override onDestroy if null.
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        //Step 16: Create extra variables
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_STOCK = "extra_stock"
    }
}