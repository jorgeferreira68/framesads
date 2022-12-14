package br.edu.ifms.detran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.dto.InfracaoDto;
import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.repository.InfracaoRepository;
import br.edu.ifms.detran.service.exception.DataIntegrityException;
import br.edu.ifms.detran.service.exception.ObjectNotFoundException;

@Service
public class InfracaoService {
	
	@Autowired
	private InfracaoRepository repo;
	
	public Infracao fromDto(InfracaoDto objDto) {
		return new Infracao(objDto.getId(), objDto.getDescricao(), objDto.getPontos(), objDto.getValor());
	}
	
	public Infracao buscarPorId(Integer id) {
		Optional<Infracao> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Infracao.class.getName()));		
	}
	
	public Infracao insert (Infracao obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public Infracao update(Infracao obj) {
		Infracao newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Infracao newObj, Infracao obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setPontos(obj.getPontos());
		newObj.setValor(obj.getValor());
	}
	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		buscarPorId(id);
		try {
			repo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover. Verifique a integridade referencial.");
		}
	}
	
	public List<Infracao> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
}
