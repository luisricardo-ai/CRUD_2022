package persistencia;

// DEPENDENCIAS 
import java.util.ArrayList;
import dependencias.*;
import negocio.Cidade;

public class CidadeDao implements IDao<Cidade, Integer> {

    @Override
    public void create(Cidade objeto) {
        Cidade c = read( objeto.getId() );

        if( c == null ) {
            ArrayList<Cidade> lista = readAll();

            Arquivo arquivo = new Arquivo("dim_cidade.txt");

            if(arquivo.abrirEscrita()) {
                for(Cidade cidade: lista){
                    arquivo.escreverLinha( cidade.getId() + ";" + cidade.getNome() + ";" + cidade.getUf());
                }
                arquivo.escreverLinha( objeto.getId() + ";" + objeto.getNome() + ";" + objeto.getUf() );
                arquivo.fecharArquivo();
            }
        }
    }

    @Override
    public Cidade read(Integer primaryKey) {
        // VERIFICA SE O ITEM RECEBIDO ESTÁ REGISTRADO
        ArrayList<Cidade> lista = readAll();

        Cidade c = null;

        for(Cidade cidade: lista) {
            if(cidade.getId() == primaryKey){
                c = cidade;
                break;
            }
        }
        return c;
    }

    @Override
    public ArrayList<Cidade> readAll() {
        ArrayList<Cidade> lista = new ArrayList();
        Arquivo x = new Arquivo("dim_cidade.txt");

        if(x.abrirLeitura()) {
            String linha = x.lerLinha();

            while( linha != null ) {
                // REGEX DO CONTEUDO
                String[] linhaConteudo = linha.split( ";" );

                // ATRIBUTOS DO OBJETO
                int id = Integer.parseInt(linhaConteudo[0]);
                String nome = linhaConteudo[1];
                String uf = linhaConteudo[2];

                // CRIAÇÃO DO OBJETO
                Cidade cidade = new Cidade( id, nome, uf );
                lista.add( cidade );

                linha = x.lerLinha();
            }
        }
        return lista;
    }

    @Override
    public ArrayList<Cidade> readAll(Filter<Cidade> filtro) {
        ArrayList<Cidade> selecionados = new ArrayList();
        ArrayList<Cidade> todasCidades = readAll();

        for(Cidade cidade: todasCidades) {
            if( filtro.isAccept(cidade) )
                selecionados.add(cidade);
        }
        return selecionados;
    }

    @Override
    public void update(Cidade objeto) {
        Cidade c = read( objeto.getId() );

        if( c != null) {
            ArrayList<Cidade> lista = readAll();
            lista.remove(c); 
            lista.add(objeto);

            Arquivo arquivo = new Arquivo("dim_cidade.txt");
            if( arquivo.abrirEscrita() ){
                for(Cidade cidade: lista)
                    arquivo.escreverLinha( cidade.getId() + ";" + cidade.getNome() + ";" + cidade.getUf() );
                arquivo.fecharArquivo();
            }
        }
    }

    @Override
    public void delete(Integer primaryKey) {
        Cidade c = read( primaryKey );

        if( c != null ) {
            ArrayList<Cidade> lista = readAll();
            lista.remove( c );

            Arquivo arquivo = new Arquivo( "dim_cidade.txt" );
            if( arquivo.abrirEscrita() ) {
                for( Cidade cidade: lista ){
                    arquivo.escreverLinha( cidade.getId() + ";" + cidade.getNome() + ";" + cidade.getUf() );
                }
                arquivo.fecharArquivo();
            }
        }
    }
}