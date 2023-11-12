package outputView

import data.Amount
import data.Menu

class OutputView(orderList: Map<Menu, Int>) {
    var amount = Amount()
    var orderList = orderList
    fun printMenu() {
        println(ORDER_MENU_LIST)
        for ((menu, quantity) in orderList) {
            println("${menu} ${quantity} 개")
        }
    }

    fun printAmountBeforeDiscount() {
        println(AMOUNT_BEFORE_DISCOUNT)
        var amountBeforeDiscount = amount.beforeDiscount(orderList)
        println(amountBeforeDiscount)
    }

    fun printGiftMenu() {
        println(GIFT_MENU)

    }


    companion object{
        const val ORDER_MENU_LIST = "<주문 메뉴>"
        const val AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>"
        const val GIFT_MENU = "<증정 메뉴>"
    }
}