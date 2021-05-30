package br.com.caique.tests.factory;

import br.com.caique.entities.Financing;

public class FinancingFactory {

    public static Financing criarFinanciamentoVazio(){
        return new Financing();
    }

    public static Financing criarFinanciamentoValido(){
        Financing finance =  new Financing();
        finance.setValorTotalFinanciamento(100000.00);
        finance.setValorRendaLiquidaCliente(4000.0);
        finance.setQtdeMesesFinanciamento(40);
        return finance;
    }
}
