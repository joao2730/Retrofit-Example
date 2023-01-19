package com.example.retrofitexample_0.UI

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofitexample_0.UI.Adapter.AdapterMars
import com.example.retrofitexample_0.viewModel.MarsViewModel
import com.example.retrofitexample_0.R
import com.example.retrofitexample_0.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: MarsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AdapterMars()
        binding.rvTerrains.adapter= adapter
        binding.rvTerrains.layoutManager = GridLayoutManager(context,2)

        adapter.selectedItem().observe(viewLifecycleOwner, Observer {


            it.let {
                viewModel.selected(it)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        })


        // Forma antigua sin coroutines
//    viewModel.liveDataFromInternet.observe(viewLifecycleOwner, Observer {
//        it?.let {
//
//            binding.textviewFirst.text= it.toString()
//        }
//    })


        viewModel.liveDataFromInternet.observe(viewLifecycleOwner, Observer {

            if (it != null)
            it?.let {
                adapter.update(it)
                Log.d("LISTADO", it.toString())
            }
        })
    }
}





















