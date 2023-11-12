package outputView

import data.Amount
import data.Menu

class OutputView {
    var amount = Amount()

    fun printMenu(orderList: Map<Menu, Int>) {
        println(ORDER_MENU_LIST)
        for ((menu, quantity) in orderList) {
            println("${menu} ${quantity} 개")
        }
    }

    fun printAmountBeforeDiscount(orderList: Map<Menu, Int>) {
        println(AMOUNT_BEFORE_DISCOUNT)
        var amountBeforeDiscount = amount.beforeDiscount(orderList)
        println(amountBeforeDiscount)
    }

    companion object{
        const val ORDER_MENU_LIST = "<주문 메뉴>"
        const val AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>"

    }
}