package data

class Amount(val orderList: Map<Menu, Int> ) {

    fun beforeDiscount(): Int {
        return orderList.entries.sumBy { (menu, quantity) -> menu.price * quantity }
    }
}