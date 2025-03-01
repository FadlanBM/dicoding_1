package com.example.restaurantreview.ui.UpComing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.restaurantreview.core.data.source.model.ListEventsItem
import com.example.restaurantreview.core.data.source.remote.network.State
import com.example.restaurantreview.databinding.FragmentUpcomingBinding
import com.example.restaurantreview.ui.adapter.UpComingRecyclerViewAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpComingFragment : Fragment() {

    private var _binding: FragmentUpcomingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UpcomingViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpcomingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        getEvent()
        binding.swipeRefreshLayout.setOnRefreshListener {
            // Set swipeRefreshLayout isRefreshing to true when refreshing starts
            getEvent()
        }
        viewModel.state.observe(viewLifecycleOwner){
            binding.swipeRefreshLayout.isRefreshing = it
        }
        return root
    }

    private fun getEvent(){
        viewModel.getEventByActive(0,null).observe(viewLifecycleOwner) {
            when (it.state) {
                State.SUCCESS -> {
                    val response = it.data
                    val listEvent= mutableListOf<ListEventsItem>()
                    if (response != null) {
                        val dataEvent = response.listEvents
                       if (dataEvent!=null){
                           for (item in dataEvent) {
                               val summary=item?.summary
                               val mediaCover=item?.mediaCover
                               val registan=item?.registrants
                               val imageLogo=item?.imageLogo
                               val link=item?.link
                               val description = item?.description
                               val ownerName=item?.ownerName
                               val cityName=item?.cityName
                               val name=item?.name
                               val quota=item?.quota
                               val id=item?.id
                               val beginTime=item?.beginTime
                               val endTime=item?.endTime
                               val category=item?.category
                               listEvent.add(ListEventsItem(summary,mediaCover,registan,imageLogo,link,description,ownerName,cityName,quota,name,id,beginTime,endTime,category))
                           }
                       }
                        val adapter=UpComingRecyclerViewAdapter(listEvent)
                        binding.rvItemData.adapter=adapter
                        viewModel.stopLoading()
                    }
                }
                State.ERROR -> {
                    lifecycleScope.launch {
                        delay(4000)
                        viewModel.stopLoading()
                    }
                    Toast.makeText(requireContext(),it.message.toString(), Toast.LENGTH_LONG).show()
                }
                State.LOADING -> {
                    viewModel.startLoading()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}