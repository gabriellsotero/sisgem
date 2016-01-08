package oompa.sisgemplus.model.enums;

public enum TaskTypes {
	NOT_USED,
	MATERIAIS{
	    @Override
	    public String toString() {
	      return "Materiais";
	    }
	  },
	CRONOGRAMA{
	    @Override
	    public String toString() {
	      return "Cronograma";
	    }
	  },
	DIVULGACAO{
	    @Override
	    public String toString() {
	      return "Divulgacao";
	    }
	  },
	REC_ARTISTICOS{
	    @Override
	    public String toString() {
	      return "Recursos Artísticos";
	    }
	  },
	PREST_SERVICO{
	    @Override
	    public String toString() {
	      return "Prestadores de Serviço";
	    }
	  },
	INGRESSOS{
	    @Override
	    public String toString() {
	      return "Ingressos";
	    }
	  },
	GERAL{
		    @Override
		    public String toString() {
		      return "Geral";
		    }
	}
}
