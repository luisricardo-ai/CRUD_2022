package negocio.filtros;

import dependencias.*;
import negocio.Cidade;

public class FiltroPorUf implements Filter<Cidade> {

    private String uf;

    public FiltroPorUf(String cidade) {
        this.uf = cidade;
    }

    @Override
    public boolean isAccept(Cidade record) {
        return (record.getUf().equalsIgnoreCase(uf));
    }
    
}
