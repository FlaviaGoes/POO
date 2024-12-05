
package pizzaria;

abstract class pizza {
    private int id;
    private float preco;
    private String descricao;
    private int quantidade;

    public pizza(int id, float preco, String descricao, int quantidade) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public pizza(int id, float valor, String descricao) {
        this.id = id;
        this.preco = valor;
        this.descricao = descricao;
    }

    public void setPreco(float valor) {
        this.preco = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public float getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void imprimir(){
        System.out.println("ID: " + id);
        System.out.println("Valor:: " + preco);
        System.out.println("Descrição: "+ descricao);
        System.out.println("Quantidade: "+ quantidade);
    }
}
