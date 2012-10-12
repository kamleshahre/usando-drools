package br.com.alexandre;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.alexandre.domain.Investimento;
import br.com.alexandre.domain.Modalidade;
import br.com.alexandre.domain.Resultado;
import br.com.alexandre.drools.BRMS;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class DroolsTest {

	@Autowired
	private BRMS brms;
	
	@Test
	public void deveriaIndicarQueNaoEpossivelInvestirEmAcoes() {
		final Investimento investimento = new Investimento(90D);
    	final Resultado resultado = new Resultado();
    	
    	brms.execute(investimento, resultado);
    	  
    	assertEquals(0, resultado.getModalidades().size());
	}

	@Test
	public void deveriaIndicarQueEpossivelInvestirEmAcoesNaModalidadeBasica() {
		final Investimento investimento = new Investimento(1000D);
    	final Resultado resultado = new Resultado();
    	
    	brms.execute(investimento, resultado);
    	    	
    	assertEquals(1, resultado.getModalidades().size());
    	assertEquals(Modalidade.BASIC, resultado.getModalidades().get(0));
	}
	
	@Test
	public void deveriaIndicarQueEpossivelInvestirEmAcoesNaModalidadePrime() {
		final Investimento investimento = new Investimento(5500D);
    	final Resultado resultado = new Resultado();
    	
    	brms.execute(investimento, resultado);
    	    	
    	assertEquals(2, resultado.getModalidades().size());
    	assertEquals(Modalidade.BASIC, resultado.getModalidades().get(0));
    	assertEquals(Modalidade.PRIME, resultado.getModalidades().get(1));	

	}
}
