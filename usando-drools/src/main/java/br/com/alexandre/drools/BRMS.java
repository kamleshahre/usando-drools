package br.com.alexandre.drools;

import java.util.Arrays;

import org.drools.command.CommandFactory;
import org.drools.runtime.StatelessKnowledgeSession;

public class BRMS {
	private final StatelessKnowledgeSession kSession;
	
	public BRMS(final StatelessKnowledgeSession kSession) {
		this.kSession = kSession;
	}
	
	@SuppressWarnings("unchecked")
	public void execute(Object... objetos) {
    	kSession.execute(CommandFactory.newInsertElements(Arrays.asList(objetos)));
	}
}
