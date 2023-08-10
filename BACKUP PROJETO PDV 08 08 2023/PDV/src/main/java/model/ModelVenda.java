
package model;

import java.sql.Date;


public class ModelVenda {
    
    private int idVenda;
    private int cliente;
    private int produto;
    private Date dataVenda;
    private double venValorLiquido;
    private double venValorBruto;
    private double venValorDesconto;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getVenValorLiquido() {
        return venValorLiquido;
    }

    public void setVenValorLiquido(double venValorLiquido) {
        this.venValorLiquido = venValorLiquido;
    }

    public double getVenValorBruto() {
        return venValorBruto;
    }

    public void setVenValorBruto(double venValorBruto) {
        this.venValorBruto = venValorBruto;
    }

    public double getVenValorDesconto() {
        return venValorDesconto;
    }

    public void setVenValorDesconto(double venValorDesconto) {
        this.venValorDesconto = venValorDesconto;
    }
    
    
    
    
}
