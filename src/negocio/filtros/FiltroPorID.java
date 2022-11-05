package negocio.filtros;

import dependencias.*;
import negocio.Cidade;

public class FiltroPorID implements Filter<Cidade>{

    private int id;
    
	public FiltroPorID(int id) {
        this.id = id;
    }

    @Override
	public boolean isAccept(Cidade record) {
		return (record.getId() == (this.id));
	}

    
    
}
