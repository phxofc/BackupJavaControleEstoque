
package model;


public class ModelVendaProduto {
    private int idVendasProduto;
    private int produto;
    private int venda;
    private double venProValor;
    private int venProQuantidade;

    public int getIdVendasProduto() {
        return idVendasProduto;
    }

    public void setIdVendasProduto(int idVendasProduto) {
        this.idVendasProduto = idVendasProduto;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public double getVenProValor() {
        return venProValor;
    }

    public void setVenProValor(double venProValor) {
        this.venProValor = venProValor;
    }

    public int getVenProQuantidade() {
        return venProQuantidade;
    }

    public void setVenProQuantidade(int venProQuantidade) {
        this.venProQuantidade = venProQuantidade;
    }
    
    
}
