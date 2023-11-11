package outputView

import data.Menu

class OutputView {
    fun printMenu(orderList: Map<Menu, Int>) {
        println(ORDER_MENU_LIST)
        for ((menu, quantity) in orderList) {
            println("${menu} ${quantity} 개")
        }
    }

    fun printAmountBeforeDiscount(orderList: Map<Menu, Int>) {

    }

    companion object{
        const val ORDER_MENU_LIST = "<주문 메뉴>"
    }
}