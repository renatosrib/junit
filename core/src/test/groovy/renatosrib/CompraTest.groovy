package renatosrib

import entidades.Compra
import entidades.ItemDaCompra
import entidades.Produto
import org.junit.Test

import static org.junit.Assert.assertEquals


/**
 * Testes relacionados a compra
 */
class CompraTest {
    Produto produto
    Compra compra

    @Test
    void compraDeProdutosQuantidadeInteira() {
        //Given
        this.produto = new Produto(nome: 'Chocolate em barra', preco: new BigDecimal(5.0));
        ItemDaCompra itemDaCompra = new ItemDaCompra(produto: produto, quantidade: 2);
        this.compra = new Compra();
        //When
        this.compra.adicionarItem(itemDaCompra);
        //Then
        assertEquals(compra.subTotal(), 10, 0);
    }

    @Test
    void compraComQuantidadeDecimal() {
        //Given
        this.produto = new Produto(nome: 'Limão', preco: new BigDecimal(7.0));
        ItemDaCompra itemDaCompra = new ItemDaCompra(produto: produto, quantidade: 1.5);
        this.compra = new Compra();
        //When
        this.compra.adicionarItem(itemDaCompra);
        //Then
        assertEquals(compra.subTotal(), 10.50, 0);
    }

    @Test
    void compraDeDoisProdutosNaMesmaCompra() {
        //Given
        Produto limao = new Produto(nome: 'Limão', preco: new BigDecimal(7.0));
        Produto chocolate =  new Produto(nome: 'Chocolate em barra', preco: new BigDecimal(5.0));
        List<ItemDaCompra> items  = [
                new ItemDaCompra(produto: limao, quantidade: 1.5),
                new ItemDaCompra(produto: chocolate, quantidade: 2),
        ]
        this.compra = new Compra();

        //When
        //Adiciona itens à compra
        items.each { itemDaCompra ->
            this.compra.adicionarItem(itemDaCompra);

        }
        //Then
        assertEquals(compra.subTotal(), 20.50, 0);
    }
}
