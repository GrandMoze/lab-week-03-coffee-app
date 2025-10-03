package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeList = listOf(
            view.findViewById<TextView>(R.id.affogato),
            view.findViewById<TextView>(R.id.americano),
            view.findViewById<TextView>(R.id.latte)
        )

        coffeeList.forEach { coffee ->
            val bundle = Bundle().apply {
                putInt(COFFEE_ID, coffee.id)
            }
            coffee.setOnClickListener {
                findNavController().navigate(R.id.coffee_id_action, bundle)
            }
        }
    }
}