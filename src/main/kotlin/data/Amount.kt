package data

class Amount() {

    fun beforeDiscount(orderList: Map<Menu, Int>): Int {
        return orderList.entries.sumBy { (menu, quantity) -> menu.price * quantity }
    }
}