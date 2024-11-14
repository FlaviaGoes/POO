
package pizzaria;

abstract class pizza {
    private int id;
    private float valor;
    private String descricao;
    private int quantidade;

    public pizza(int id, float valor, String descricao, int quantidade) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public pizza(int id, float valor, String descricao) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public float getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void imprimir(){
        System.out.println("ID: " + id);
        System.out.println("Valor:: " + valor);
        System.out.println("Descrição: "+ descricao);
        System.out.println("Quantidade: "+ quantidade);
    }
}
