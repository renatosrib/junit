package src.test.groovy

import org.junit.Test
import src.main.groovy.entidades.Compra
import src.main.groovy.entidades.ItemDaCompra
import src.main.groovy.entidades.Produto

/**
 * Testes relacionados a compra
 */
class CompraTest {

    @Test
    public void deveAdicionarItemACompra() {
        //Dado
        Compra compra = new Compra()
        Produto produto1 = new Produto(nome: 'Teste', preco: new BigDecimal('12.90'))
        ItemDaCompra itemDaCompra = new ItemDaCompra(produto: produto1, quantidade: 2)

        //When
        compra.adicionarItem(itemDaCompra)

        //Then
        assert compra.itens.contains(itemDaCompra)
    }

    @Test
    public void deveCalcularSubTotal() {
        //Dado
        Compra compra = new Compra()
        Produto produto1 = new Produto(nome: 'Teste', preco: new BigDecimal('12.00'))
        Produto produto2 = new Produto(nome: 'Teste', preco: new BigDecimal('24.00'))
        ItemDaCompra itemDaCompra1 = new ItemDaCompra(produto: produto1, quantidade: 2)
        ItemDaCompra itemDaCompra2 = new ItemDaCompra(produto: produto2, quantidade: 1)
        compra.adicionarItem(itemDaCompra1)
        compra.adicionarItem(itemDaCompra2)

        //When
        BigDecimal subTotal = compra.subTotal()

        //Then
        assert subTotal == 48
    }
}
