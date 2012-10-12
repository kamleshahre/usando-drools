package br.com.alexandre.drools;

import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

public class DroolsFactory {

	private KnowledgeBase kBase;
	
	public DroolsFactory(final List<String> fileResources) {
		if (fileResources != null) {
			// Cria Builder de base de conhecimento
	        final KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	        
	        for (String fileResource : fileResources) {
	        	kBuilder.add(ResourceFactory.newClassPathResource(fileResource), ResourceType.DRL);
	        }
	    	
	        // Cria base de conhecimento
	        this.kBase = kBuilder.newKnowledgeBase();	
		}
	}
	
	public StatelessKnowledgeSession getInstance() {		
        // Retorna uma nova Stateless KnowledgeSession 
        final StatelessKnowledgeSession statelessKnowledgeSession = kBase.newStatelessKnowledgeSession();
        
        return statelessKnowledgeSession;
	}

	
}
