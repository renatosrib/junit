package entidades

/**
 * Representa uma compra
 */
class Compra {
    Date dataDaCompra
    List<ItemDaCompra> itens = []

    public boolean adicionarItem(ItemDaCompra itemDaCompra) {
        itens.add(itemDaCompra)
    }

    public BigDecimal subTotal() {
        BigDecimal subTotal = 0
        itens.each {
            subTotal += it.produto.preco * it.quantidade
        }
        return subTotal
    }
}
