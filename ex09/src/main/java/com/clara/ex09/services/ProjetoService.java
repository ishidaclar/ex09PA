package com.clara.ex09.services;

import com.clara.ex09.models.ProjetoModel;
import com.clara.ex09.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<ProjetoModel> findAll(){
        return projetoRepository.findAll();
    }

    public Optional<ProjetoModel> findById(Long id){
        return projetoRepository.findById(id);
    }

    public ProjetoModel criarProjeto(ProjetoModel projetoModel){
        return projetoRepository.save(projetoModel);
    }

    public void deletar(Long id){
        projetoRepository.findById(id);
    }

    public ProjetoModel atualizar(Long id, ProjetoModel projetoModel){
        ProjetoModel model = projetoRepository.findById(id).get();
        model.setNome(projetoModel.getNome());
        return projetoRepository.save(model);
    }
}
