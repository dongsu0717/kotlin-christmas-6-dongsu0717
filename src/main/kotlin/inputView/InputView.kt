package inputView

import camp.nextstep.edu.missionutils.Console
import data.MenuList
import data.Restaurant

class InputView {
    var inputViewCondition = InputViewCondition()
    var restaurant = Restaurant()

    fun readDate(): Int {
        println(MESSAGE_GREETING)
        println(MESSAGE_WHEN_ARE_YOU_VISIT)
        while (true) {
            try {
                var input = Console.readLine()
                inputViewCondition.dateCheck(input)

                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readMenu(): Map<MenuList, Int> {
        println(MESSAGE_ORDER_MENU)
        var input = Console.readLine()
        while (true) {
            try {
                val orderList = restaurant.order(input)

                return orderList
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object {
        const val MESSAGE_GREETING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        const val MESSAGE_WHEN_ARE_YOU_VISIT = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
        const val MESSAGE_ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
    }
}