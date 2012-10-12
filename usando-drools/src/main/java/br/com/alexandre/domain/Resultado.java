package br.com.alexandre.domain;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
	private List<Modalidade> modalidades = new ArrayList<Modalidade>();

	public List<Modalidade> getModalidades() {
		return modalidades;
	}

	public void addModalidade(final Modalidade modalidade) {
		this.modalidades.add(modalidade);
	}
}
