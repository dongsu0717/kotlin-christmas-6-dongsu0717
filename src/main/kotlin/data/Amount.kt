package data

import outputView.OutputView

class Amount() {

    fun beforeDiscount(orderList: Map<Menu, Int>): Int {
        return orderList.entries.sumBy { (menu, quantity) -> menu.price * quantity }
    }

    fun totalBenefits(christmas: Int,
                      weekday: Int,
                      weekend: Int,
                      special: Int,
                      gift: Boolean): Int{
        var giftPrice = when(gift) {
            true -> Menu.샴페인.price
            false -> OutputView.NOTHING
        }
        return christmas + weekday + weekend + special + giftPrice
    }

    fun discount(christmas: Int,
                 weekday: Int,
                 weekend: Int,
                 special: Int,): Int {
        return christmas + weekday + weekend + special
    }
}