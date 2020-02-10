package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.context.i18n.LocaleContextHolder;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    @Autowired
    public PokemonTypeRepository pokemonTypeRepository;

    @Autowired
    public TranslationRepository translationRepository;

    public PokemonTypeServiceImpl() {
    }

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository, TranslationRepository translationRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
        this.translationRepository = translationRepository;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        PokemonType pokemonType = pokemonTypeRepository.findPokemonTypeById(id);
        pokemonType.setName( translationRepository.getPokemonName(id, LocaleContextHolder.getLocale()) );
        return pokemonType;
    }

    @Override
    public PokemonType getPokemonType(String name) {
        return pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> getPokemonType(List<String> types) {
        return pokemonTypeRepository.findAllPokemonType(types);
    }

    @Override
    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Override
    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        var allPokemonTypes = pokemonTypeRepository.findAllPokemonType();
        for ( var pokemonType : allPokemonTypes ) {
            pokemonType.setName( translationRepository.getPokemonName(pokemonType.getId(), LocaleContextHolder.getLocale()) );
        }
        return allPokemonTypes;
    }
}
