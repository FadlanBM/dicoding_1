package com.example.restaurantreview.ui.UpComing

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.restaurantreview.core.data.source.model.ListEventsItem
import com.example.restaurantreview.core.data.source.remote.network.State
import com.example.restaurantreview.databinding.FragmentUpcomingBinding
import com.example.restaurantreview.ui.adapter.UpComingRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.log

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
        return root
    }

    private fun getEvent(){
        viewModel.getEventByActive(0,null).observe(viewLifecycleOwner) {
            when (it.state) {
                State.SUCCESS -> {
                    val response = it.data
                    val ListEvent= mutableListOf<ListEventsItem>()
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
                               ListEvent.add(ListEventsItem(summary,mediaCover,registan,imageLogo,link,description,ownerName,cityName,quota,name,id,beginTime,endTime,category))
                           }
                       }
                        val adapter=UpComingRecyclerViewAdapter(ListEvent)
                        binding.rvItemData.adapter=adapter
                    }
                }
                State.ERROR -> {

                }
                State.LOADING -> {
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}