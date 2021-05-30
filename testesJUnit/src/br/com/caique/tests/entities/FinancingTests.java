package br.com.caique.tests.entities;

import br.com.caique.entities.Financing;
import br.com.caique.tests.factory.FinancingFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinancingTests {

    @Test
    public void valorTotalFinanciamentoDeveSerPositivo(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financiamento = new Financing(-100000.0,4000.0,40);
        });
    }

    @Test
    public void valorRendaLiquidaClienteDeveSerPositivo(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financiamento = new Financing(100000.0,-4000.0,40);
        });
    }
    @Test
    public void qtdeMesesFinanciamentoDeveSerPositivo(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financiamento = new Financing(100000.0,4000.0,-40);
        });
    }
    @Test
    public void valorDaEntradaDeveSer20PorCentoDoValorTotalDoFinanciamento(){
        //passo>> Arrange
        double valorTotalFinanciamento = 100000.0;
        double expectedValue = 20000.0;
        Financing financiamento = FinancingFactory.criarFinanciamentoVazio();
        financiamento.setValorTotalFinanciamento(valorTotalFinanciamento);


        //passo>> Act:
        double valorEntrada = financiamento.obterValorEntrada();

        //passo>> Assert
        Assertions.assertEquals(expectedValue, valorEntrada);
    }
    @Test
    public void valorDaPrestacaoDeveSer80PorCentoDoValorTotalDoFinanciamentoDivididoPelaQtdeDeMeses(){
        //passo>> Arrange
        double expectedValue = 2000.0;
        Financing financiamento = FinancingFactory.criarFinanciamentoValido();

        //passo>> Act:
        double valorPrestacao = financiamento.obterValorPrestacao();

        //passo>> Assert
        Assertions.assertEquals(expectedValue, valorPrestacao);
    }
    @Test
    public void valorDaPrestacaoNaoDeveSerMaiorQueMetadeDaRendaDoClienteAoCriarOFinanciamento(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financiamento = new Financing(100000.0, 4000.00, 20);
        });
    }

    @Test
    public void valorDaPrestacaoNaoDeveSerMaiorQueMetadeDaRendaDoClienteAoAtualizarValorTotalDoFinanciamento(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financiamento = FinancingFactory.criarFinanciamentoValido();
            financiamento.setValorTotalFinanciamento(200000.0);
        });
    }
    @Test
    public void valorDaPrestacaoNaoDeveSerMaiorQueMetadeDaRendaDoClienteAoAtualizarValorDaRenda(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financiamento = FinancingFactory.criarFinanciamentoValido();
            financiamento.setValorRendaLiquidaCliente(2000.0);
        });
    }
    @Test
    public void valorDaPrestacaoNaoDeveSerMaiorQueMetadeDaRendaDoClienteAoAtualizarQtdeMesesFinanciamento(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financiamento = FinancingFactory.criarFinanciamentoValido();
            financiamento.setQtdeMesesFinanciamento(20);
        });
    }
    @Test
    public void financiamentoDeveSerValidoAoAlterarQtdeMesesFinancimentoParaValorAceitavel(){
        //passo>> Arrange
        Integer expectedValue = 45;
        Financing financiamento = FinancingFactory.criarFinanciamentoValido();

        //passo>> Act:
        financiamento.setQtdeMesesFinanciamento(45);

        //passo>> Assert
        Assertions.assertEquals(expectedValue, financiamento.getQtdeMesesFinanciamento());
    }
    @Test
    public void financiamentoDeveSerValidoAoAlterarValorRendaClienteParaValorAceitavel(){
        //passo>> Arrange
        double expectedValue = 4100.0;
        Financing financiamento = FinancingFactory.criarFinanciamentoValido();

        //passo>> Act:
        financiamento.setValorRendaLiquidaCliente(4100.0);

        //passo>> Assert
        Assertions.assertEquals(expectedValue, financiamento.getValorRendaLiquidaCliente());
    }
    @Test
    public void financiamentoDeveSerValidoAoAlterarValorTotalFinanciadoDentroDasCondicoesParaFinanciar(){
        //passo>> Arrange
        double expectedValue = 99999.0;
        Financing financiamento = FinancingFactory.criarFinanciamentoValido();

        //passo>> Act:
        financiamento.setValorTotalFinanciamento(99999.0);

        //passo>> Assert
        Assertions.assertEquals(expectedValue, financiamento.getValorTotalFinanciamento());
    }
}
