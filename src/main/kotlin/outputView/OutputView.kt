package outputView

import data.Amount
import data.Menu

class OutputView(val orderList: Map<Menu, Int>,var date: Int) {
    var amount = Amount()
    var amountBeforeDiscount = amount.beforeDiscount(orderList)
    fun printMenu() {
        println(MESSAGE_SEE_BENEFITS_FRONT+"$date"+ MESSAGE_SEE_BENEFITS_BACK)
        println()
        println(MESSAGE_ORDER_MENU_LIST)
        for ((menu, quantity) in orderList) {
            println("${menu} ${quantity}개")
        }
    }

    fun printAmountBeforeDiscount() {
        println(MESSAGE_AMOUNT_BEFORE_DISCOUNT)
        println(amountBeforeDiscount)
    }

    fun printGiftMenu() {
        println(MESSAGE_GIFT_MENU)
        if (amountBeforeDiscount >= GIFT_MENU_CRITERIA_PRICE) {
            println(MESSAGE_GIFT_MENU_KIND)
            return
        }
        println(MESSAGE_GIFT_MENU_NOTHING)
    }

    fun printbenefitsDetails() {
        println(MESSAGE_BENEFITS_DETAILS)

    }

    companion object {
        const val MESSAGE_SEE_BENEFITS_FRONT = "12월 "
        const val MESSAGE_SEE_BENEFITS_BACK = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
        const val MESSAGE_ORDER_MENU_LIST = "<주문 메뉴>"
        const val MESSAGE_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>"
        const val MESSAGE_GIFT_MENU = "<증정 메뉴>"
        const val GIFT_MENU_CRITERIA_PRICE = 120_000
        val MESSAGE_GIFT_MENU_KIND = "${Menu.샴페인} 1개"
        const val MESSAGE_GIFT_MENU_NOTHING = "없음"
        const val MESSAGE_BENEFITS_DETAILS = "<혜택 내역>"
    }

}