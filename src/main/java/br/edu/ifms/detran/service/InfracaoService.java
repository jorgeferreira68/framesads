package br.edu.ifms.detran.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.repository.InfracaoRepository;

@Service
public class InfracaoService {
	
	@Autowired
	private InfracaoRepository repo;
	
	public void inserir (Infracao infracao) {
		
	}

}
