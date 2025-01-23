package com.example.hw5_m5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw5_m5.databinding.FragmentOnBoardViewPagerBinding

class OnBoardViewPagerFragment : Fragment() {
    private val binding by lazy {
        FragmentOnBoardViewPagerBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        val position = arguments?.getInt(ARG_ONBOARD_POSITION) ?: 0
        with(binding) {
            when (position) {
                0 -> {
                    tvText.text = "It`s Funs and many more"
                    lottie.setAnimation(R.raw.lottie)
                }
                1 -> {
                    tvText.text = "Have a good time " +
                            "You Should take the time to help those who need you"
                    lottie.setAnimation(R.raw.lottie)
                }
                2 -> {
                    tvText.text = "Cherishing love " +
                            "It is now no longer possible for you to cherish love"
                    lottie.setAnimation(R.raw.lottie)
                }
                3 -> {
                    tvText.text = "Have a breakup? " +
                            "We have made the correction  for you don`t worry Maybe someone is waiting for you"
                    lottie.setAnimation(R.raw.lottie)
                }
            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}