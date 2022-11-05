package negocio.filtros;

import dependencias.*;
import negocio.Cidade;

public class FiltroPorNome implements Filter<Cidade>{
    private String nome;

    public FiltroPorNome(String n) {
        this.nome = n;
    }

    @Override
    public boolean isAccept(Cidade record) {
        return (record.getNome().equalsIgnoreCase(this.nome));
    }
}
