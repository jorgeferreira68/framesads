package br.edu.ifms.detran.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.model.Carro;
import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.model.Multa;
import br.edu.ifms.detran.repository.CarroRepository;
import br.edu.ifms.detran.repository.InfracaoRepository;
import br.edu.ifms.detran.repository.MultaRepository;

@Service
public class DBService {

	@Autowired
	private CarroRepository carro;
	
	
	@Autowired
	private InfracaoRepository infracao;
	
	@Autowired
	private MultaRepository multa;
	
	
	public void instantiateTestDatabase() throws ParseException {

		Carro car1 = new Carro (null, "Fusca", "VW","AAA 0410" );
		Carro car2 = new Carro (null, "Variant", "VW","AAA 0420" );
		Carro car3 = new Carro (null, "Opala", "GM","AAA 0430" );
		Carro car4 = new Carro (null, "Brasilia", "VW","AAA 0440" );
		Carro car5 = new Carro (null, "Sandero", "RN","AAA 0450" );
		
		Infracao inf1 = new Infracao (null, "Ultrapassagem em faixa continua", 10, 195.0);
		Infracao inf2 = new Infracao (null, "Ultrapassagem em faixa continua", 10, 195.0);
		Infracao inf3 = new Infracao (null, "Ultrapassagem em faixa continua", 10, 195.0);
		Infracao inf4 = new Infracao (null, "Ultrapassagem em faixa continua", 10, 195.0);
		Infracao inf5 = new Infracao (null, "Ultrapassagem em faixa continua", 10, 195.0);
		
		Multa mul1 = new Multa(null, "Corumbá", 2022, car1, inf1);
		Multa mul2 = new Multa (null, "Corumbá", 2022, car2, inf2);
		Multa mul3 = new Multa (null, "Corumbá", 2022, car2, inf3);
		Multa mul4 = new Multa (null, "Corumbá", 2022, car2, inf4);
		Multa mul5 = new Multa (null, "Corumbá", 2022, car2, inf5);
		
		
		infracao.saveAll(Arrays.asList(inf1, inf2, inf3, inf4, inf5));
		carro.saveAll(Arrays.asList(car1, car2, car3, car4, car5));
		
	}
}