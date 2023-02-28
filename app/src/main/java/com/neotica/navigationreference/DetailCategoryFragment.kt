package com.neotica.navigationreference

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neotica.navigationreference.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : Fragment() {
    //Step 21.1 Configure Binding
    private var _binding: FragmentDetailCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Step 21.2 Inflate the layout for this fragment
        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Step 22: Override onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Step 23: GetEXTRA
        val dataName = arguments?.getString(CategoryFragment.EXTRA_NAME)
        val dataDesc = arguments?.getLong(CategoryFragment.EXTRA_STOCK)

        binding.apply {
            tvCategoryName.text = dataName
            tvCategoryDescription.text = "Stock : $dataDesc"
        }
    }
}