package com.example.hw5_m5.ui.fragment.character.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil3.load
import com.example.hw5_m5.databinding.FragmentCharacterDetailBinding
import com.example.hw5_m5.ui.fragment.character.CharactersViewModel
import com.example.m5lesson4_retrofitmvvm_rickandmortyapi.data.models.Character
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailBinding
    private val viewModel: CharactersViewModel by viewModels()
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalize()

    }

    private fun initalize() = with(binding){
        val character = args.character as Character
        name.text = character?.name
        status.append(character?.status)
        species.append(character?.species)
        gender.append(character?.gender)
        origin.append(character?.origin?.name ?: "???")
        location.append(character?.location?.name ?: "???")
        image.load(character.image)

        character.episode?.firstOrNull()?.let { episodeUrl ->
            viewModel.getEpisodeNameForCharacter(episodeUrl){episodeName ->
                firstSeen.append(episodeName)
            }
        }

        viewModel.saveViewedCharacter(character)
    }
}