package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding
import com.google.android.gms.analytics.HitBuilders

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_title,
                container,
                false
        )

        // 4. Call setHasOptionsMenu() in onCreateView of TitleFragment
        setHasOptionsMenu(true)


        val application = requireActivity().application as TriviaApplication
        val tracker = application.getDefaultTracker()


        binding.playButton.setOnClickListener {
            tracker?.send(
                    HitBuilders.EventBuilder()
                            .setCategory("Title Fragment")
                            .setAction("Play Button Clicked")
                            .build()
            )
            view?.findNavController()?.navigate(R.id.action_titleFragment_to_gameFragment)
        }

        // binding.playButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))

        return binding.root

    }

    //  5. Override onCreateOptionsMenu and inflate menu resource
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        return inflater.inflate(R.menu.overflow_menu, menu)
    }

    // 6. Override onOptionsItemSelected and call NavigationUI.onNavDestinationSelected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}