package br.com.caique.entities;

public class Financing {
    private double valorTotalFinanciamento;
    private double valorRendaLiquidaCliente;
    private Integer qtdeMesesFinanciamento;

    //----------------------------------
    // Construtores
    //----------------------------------

    public Financing() {
    }

    public Financing(double valorTotalFinanciamento, double valorRendaLiquidaCliente, Integer qtdeMesesFinanciamento) {
        setValorTotalFinanciamento(valorTotalFinanciamento);
        setValorRendaLiquidaCliente(valorRendaLiquidaCliente);
        setQtdeMesesFinanciamento(qtdeMesesFinanciamento);
        prestacaoValida();
    }

    //----------------------------------
    //    Getters and Setters
    //----------------------------------
    public double getValorTotalFinanciamento() {
        return valorTotalFinanciamento;
    }

    public void setValorTotalFinanciamento(double valorTotalFinanciamento) {
        if (valorTotalFinanciamento <= 0.0){
            throw new IllegalArgumentException("O valor total do financiamento nao pode ser zerado ou negativo");
        }

        if(this.valorTotalFinanciamento >0){
            this.valorTotalFinanciamento = valorTotalFinanciamento;
            prestacaoValida();
        } else {
            this.valorTotalFinanciamento = valorTotalFinanciamento;
        }
    }

    public double getValorRendaLiquidaCliente() {
        return valorRendaLiquidaCliente;
    }

    public void setValorRendaLiquidaCliente(double valorRendaLiquidaCliente) {
        if (valorRendaLiquidaCliente <= 0.0){
            throw new IllegalArgumentException("O valor renda liquida do cliente nao pode ser zerado ou negativo");
        }

        if(this.valorRendaLiquidaCliente >0){
            this.valorRendaLiquidaCliente = valorRendaLiquidaCliente;
            prestacaoValida();
        } else {
            this.valorRendaLiquidaCliente = valorRendaLiquidaCliente;
        }
    }

    public Integer getQtdeMesesFinanciamento() {
        return qtdeMesesFinanciamento;
    }

    public void setQtdeMesesFinanciamento(Integer qtdeMesesFinanciamento) {
        if (qtdeMesesFinanciamento <= 0.0){
            throw new IllegalArgumentException("A quantidade de meses do financiamento nao pode ser zerada ou negativa");
        }

        //se nao nula e maior que zeros verificar se prestacao esta valida
        if(this.qtdeMesesFinanciamento != null && this.qtdeMesesFinanciamento > 0){
            this.qtdeMesesFinanciamento = qtdeMesesFinanciamento;
            prestacaoValida();
        } else {
            this.qtdeMesesFinanciamento = qtdeMesesFinanciamento;
        }

    }

    //----------------------------------
    //    outros métodos
    //----------------------------------
    public double obterValorEntrada(){

        return (this.valorTotalFinanciamento * 20)/100;
    }

    public double obterValorPrestacao(){
        return (this.valorTotalFinanciamento - obterValorEntrada())/this.qtdeMesesFinanciamento;
    }

    public void prestacaoValida(){
        if ((this.valorRendaLiquidaCliente/2) < obterValorPrestacao()){
            throw new IllegalArgumentException("Prestacao do financiamento invalida, verifique condicoes");
        }
    }
}
