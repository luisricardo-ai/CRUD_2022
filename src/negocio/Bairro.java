package negocio;

public class Bairro {
    
    private int id;
    private String nome;
    private String rua;
    private int numero;
    private String complemento;
    private int idCidade;

    public Bairro(int id, String nome, String rua, int numero, String complemento, int idCidade) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.idCidade = idCidade;
    }

    public Bairro(int id, String nome, String rua, int numero, int idCidade) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.complemento = "<vazio>";
        this.idCidade = idCidade;
    }

    public int getId() {
        return this.id;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(id >= 0)
        this.numero = numero;
        else
            throw new RuntimeException("Error: Números negativos não são suportados, verifique o valor" + id);
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        if(id >= 0)
            this.idCidade = idCidade;
        else
            throw new RuntimeException("Error: ID's negativos não são suportados, verifique o id " + id);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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
