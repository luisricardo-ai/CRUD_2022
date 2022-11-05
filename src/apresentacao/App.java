package apresentacao;

import java.util.ArrayList;

import negocio.Cidade;
import negocio.filtros.*;
import persistencia.CidadeDao;

public class App {
    public static void main(String[] args) {
        //Cidade teste = new Cidade(0 , "Garibaldi", "RS");
        CidadeDao dao = new CidadeDao();

        dao.create( new Cidade(1,"Lajeado","RS" ));
        dao.create( new Cidade(2,"Estrela","RS" ));
        dao.create( new Cidade(3,"Curitiba","PR" ));
        dao.create( new Cidade(4,"Toledo","PR" ));
        dao.create( new Cidade(5,"Laguna","SC" ));
        dao.create( new Cidade(6,"Criciuma","SC" ));
        dao.create( new Cidade(7,"Lages","RS" ));
        dao.create( new Cidade(8,"Taquari","RS" ));
        dao.create( new Cidade(9,"Soledade","RS" ));

        dao.update(new Cidade(9,"Soledade","MG" ));

        FiltroPorUf filtroUf = new FiltroPorUf("MG");
        ArrayList<Cidade> listaUf = dao.readAll(filtroUf);
        for(Cidade c: listaUf)
            System.out.println( c.getId() + "-" + c.getNome());

        FiltroPorNome filtroNome = new FiltroPorNome("Soledade");
        ArrayList<Cidade> listaNome = dao.readAll(filtroNome);
        for(Cidade ci: listaNome)
            System.out.println(ci.getNome() + "-" + ci.getUf());

        FiltroPorID filtroId = new FiltroPorID(9);
        ArrayList<Cidade> listaId = dao.readAll(filtroId);
        for(Cidade cid: listaId)
            System.out.println(cid.getId() + "-" + cid.getUf());


    }
}
