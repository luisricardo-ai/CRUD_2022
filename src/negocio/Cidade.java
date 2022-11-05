package negocio;

public class Cidade {
    
    private int id;
    private String nome;
    private String uf;

    public Cidade( int idCidade, String nomeCidade, String ufCidade ){
        this.setId(idCidade);
        this.setNome(nomeCidade);
        this.setUf(ufCidade);
    }

    public Cidade(){
        this.id = 0;
        this.nome = null;
        this.uf = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id >= 0)
            this.id = id;
        else
            throw new RuntimeException("Error: ID's negativos não são suportados, verifique o id " + id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(this.validateString(nome))
            this.nome = nome;
        else 
            throw new RuntimeException("Error: Caracteres inválidos conteúdo do Registro");
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        if(validateString(uf) && uf.length() > 0 && uf.length() <= 2)
            this.uf = uf;
        else
            throw new RuntimeException("Error: Caracteres inválidos conteúdo do Registro ou tamanho inválido");
    }

    @Override
    public boolean equals( Object objeto ){
        Cidade c = (Cidade)objeto;
        return (this.id == c.getId());
    }

    private boolean validateString(String content) {
        boolean op = true;

        CharSequence[] numero = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; 
        for(CharSequence n: numero){
            if(content.contains(n))
                op = false;
                break;
        }
        return op;
    }
}
