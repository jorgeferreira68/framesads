package br.edu.ifms.detran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.dto.MultaDto;
import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.model.Multa;
import br.edu.ifms.detran.repository.MultaRepository;
import br.edu.ifms.detran.service.exception.DataIntegrityException;
import br.edu.ifms.detran.service.exception.ObjectNotFoundException;

@Service
public class MultaService {
	
	@Autowired
	private MultaRepository repo;
	
	public Multa inserir(Multa multa) {
		multa.setId(null);
		return repo.save(multa);
	}
	
	public Multa fromDto(MultaDto objDto) {
		return new Multa(objDto.getId(), objDto.getCidade(), objDto.getAno(), null, null);
	}
	
	public Multa buscarPorId(Integer id) {
		Optional<Multa> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Infracao.class.getName()));		
	}
	
	public Multa insert (Multa obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public Multa update(Multa obj) {
		Multa newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Multa newObj, Multa obj) {
		newObj.setCidade(obj.getCidade());
		newObj.setAno(obj.getAno());
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
	
	public List<Multa> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	
}
