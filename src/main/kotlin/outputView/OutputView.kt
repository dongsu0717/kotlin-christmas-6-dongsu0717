package outputView

import data.Amount
import data.Menu

//val orderList: Map<Menu, Int>,var date: Int  <- 이 파라미터 빼자
class OutputView(val orderList: Map<Menu, Int>, var date: Int) {
    var amount = Amount()
    var amountBeforeDiscount = amount.beforeDiscount(orderList)


    fun printMenu() {
        println(MESSAGE_SEE_BENEFITS_FRONT + "$date" + MESSAGE_SEE_BENEFITS_BACK)
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

    fun printGiftMenu(): Boolean {
        println(MESSAGE_GIFT_MENU)
        if (amountBeforeDiscount >= GIFT_MENU_CRITERIA_PRICE) {
            println(MESSAGE_GIFT_MENU_KIND)
            return true
        }
        println(MESSAGE_NOTHING_SERVICE)
        return false
    }

    fun printBenefitsDetails(
        christmas: Int,
        weekday: Int,
        weekend: Int,
        special: Int,
        gift: Boolean,
    ) {
        println(MESSAGE_BENEFITS_DETAILS)
        if (christmas != NOTHING) println(CHRISTMAS_D_DAY_DISCOUNT + "-${christmas}원")
        if (weekday != NOTHING) println(WEEKDAY_DISCOUNT + "-${weekday}원")
        if (weekend != NOTHING) println(WEEKEND_DISCOUNT + "-${weekend}원")
        if (special != NOTHING) println(SPECIAL_DISCOUNT + "-${special}원")
        if (gift) println(GIFT_EVENT + "-${Menu.샴페인.price}원")
        if(christmas == NOTHING &&
            weekday == NOTHING &&
            weekend == NOTHING &&
            special == NOTHING &&
            gift == false) println(MESSAGE_NOTHING_SERVICE)
    }

    fun printTotalBenefits(totalBenefits: Int) {
        println(MESSAGE_TOTAL_BENEFITS_DETAILS)
        if (totalBenefits !== 0){
            println("-${totalBenefits}원")
            return
        }
        println(MESSAGE_NOTHING_SERVICE)
    }

    fun printAmountResult(discount: Int) {
        println(MESSAGE_AMOUNT_AFTER_DISCOUNT)
        println("${amountBeforeDiscount-discount}원")
    }

    fun printEventBadge(badge: String) {
        println(MESSAGE_EVENT_BADGE)
        println(badge)
    }

    companion object {
        const val MESSAGE_SEE_BENEFITS_FRONT = "12월 "
        const val MESSAGE_SEE_BENEFITS_BACK = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"

        const val MESSAGE_ORDER_MENU_LIST = "<주문 메뉴>"

        const val MESSAGE_AMOUNT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>"

        const val MESSAGE_GIFT_MENU = "<증정 메뉴>"
        const val GIFT_MENU_CRITERIA_PRICE = 120_000
        val MESSAGE_GIFT_MENU_KIND = "${Menu.샴페인} 1개"
        const val MESSAGE_NOTHING_SERVICE = "없음"

        const val MESSAGE_BENEFITS_DETAILS = "<혜택 내역>"
        const val CHRISTMAS_D_DAY_DISCOUNT = "크리스마스 디데이 할인: "
        const val WEEKDAY_DISCOUNT = "평일 할인: "
        const val WEEKEND_DISCOUNT = "주말 할인: "
        const val SPECIAL_DISCOUNT = "특별 할인: "
        const val GIFT_EVENT = "증정 이벤트: "
        const val NOTHING = 0

        const val MESSAGE_TOTAL_BENEFITS_DETAILS = "<총혜택 금액>"

        const val MESSAGE_AMOUNT_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>"

        const val MESSAGE_EVENT_BADGE = "<12월 이벤트 배지>"
    }

}