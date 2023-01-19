package com.example.retrofitexample_0.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.retrofitexample_0.viewModel.MarsViewModel
import com.example.retrofitexample_0.R
import com.example.retrofitexample_0.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private lateinit var _binding: FragmentSecondBinding
    private val viewModel : MarsViewModel by activityViewModels()
    var idMars: String= ""
    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idMars = it.getString("id","")
        }
    }





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                Glide.with(_binding.ivTerrain)
                    .load(it.imgSrc).centerCrop().into(_binding.ivTerrain)
                _binding.tvPrice.text= it.price.toString()
                _binding.tvType.text = it.type
            }
        })




        _binding.btnReturn.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }


}