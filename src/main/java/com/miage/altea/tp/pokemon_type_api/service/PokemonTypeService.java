package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokemonTypeService {
    PokemonType getPokemonType(int id);
    PokemonType getPokemonType(String name);
    List<PokemonType> getAllPokemonTypes();
    List<PokemonType> getPokemonType(List<String> types);

    void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository);
    void setTranslationRepository(TranslationRepository translationRepository);
}
