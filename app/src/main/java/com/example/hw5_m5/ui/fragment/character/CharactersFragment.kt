package com.example.hw5_m5.ui.fragment.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw5_m5.databinding.FragmentCharactersBinding
import com.example.hw5_m5.ui.adapter.CharactersAdapter
import com.example.hw5_m5.utils.OnItemClick
import com.example.m5lesson4_retrofitmvvm_rickandmortyapi.data.models.Character
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
    class CharactersFragment : Fragment(), OnItemClick {

        private lateinit var binding: FragmentCharactersBinding
        private val viewModel: CharactersViewModel by viewModels()
        private val adapter by lazy {
            CharactersAdapter(viewModel, this)
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            binding = FragmentCharactersBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupRecyclerView()
            viewModel.getCharacters()

            viewModel.charactersData.observe(viewLifecycleOwner) { data ->
                adapter.submitList(data)
            }
        }
         private fun setupRecyclerView() = with(binding.recyclerView) {
             layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
             adapter = this@CharactersFragment.adapter
         }

        override fun onItemClick(character: Character) {
            val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(character)
            findNavController().navigate(action)
        }
    }