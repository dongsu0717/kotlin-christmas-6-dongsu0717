package christmas.inputView

import christmas.data.Amount
import christmas.data.MenuList


class InputViewCondition {

    fun dateCheck(input: String) {
        if(!input.matches(Regex("\\d+"))) {
            throw IllegalArgumentException(ERROR + ERROR_NOT_NUMBER)
        }
        if (!(input.toInt() in MINIMUM_DAY..MAXIMUM_DAY)){
            throw IllegalArgumentException(ERROR + ERR0R_DATE_RANGE)
        }
        if (input.isBlank()) {
            throw IllegalArgumentException(ERROR + ERROR_BLACK)
        }
        if (input.isEmpty()) {
            throw IllegalArgumentException(ERROR + ERROR_EMPTY)
        }
    }

    fun numCheck(order: Map<MenuList,String>){
        if (order.any { !it.value.matches(Regex("\\d+")) }) {
            throw IllegalArgumentException(ERROR + ERROR_INCORRECT_ORDER )
        }
    }

    fun menuCheck(orderList: Map<MenuList,Int>) {
        if (orderList.isEmpty()) {
            throw IllegalArgumentException(ERROR + ERROR_BLACK)
        }

        if (orderList.values.sum() > MAXIMUM_ORDER_NUMBER) {
            throw IllegalArgumentException(ERROR + ERROR_MAXIMUM_ORDER_OF_NUMBER)
        }

        if (orderList.values.sum() < MINIMUM_ORDER_NUMBER ) {
            throw IllegalArgumentException(ERROR + ERROR_MINIMUM_ORDER_OF_NUMBER)
        }

        if (orderList.filter { it.key.type == MENULIST_TYPE_DRINK }.isNotEmpty() && orderList.size == 1) {
            throw IllegalArgumentException(ERROR + ERROR_NOT_ONLY_DRINK)
        }

        if (orderList.keys.distinct().size != orderList.keys.size) {
            throw IllegalArgumentException(ERROR + ERROR_REDUNDANT_ORDER)
        }

        if (orderList.keys.any { it !in MenuList.values() }) {
            throw IllegalArgumentException(ERROR + ERROR_NOT_IN_MENU)
        }
    }


    companion object {
        const val MAXIMUM_DAY = 31
        const val MINIMUM_DAY = 1
        const val MAXIMUM_ORDER_NUMBER = 20
        const val MINIMUM_ORDER_NUMBER = 1

        val MENULIST_TYPE_DRINK = "음료"

        const val ERROR = "[ERROR] "
        const val ERR0R_DATE_RANGE = "날짜는 1 ~ 31의 정수 입니다."
        const val ERROR_BLACK = "공백없이 입력해 주세요"
        const val ERROR_EMPTY = "아무것도 입력하지 않았습니다. 다시 입력해주세요"
        const val ERROR_NOT_NUMBER = "유효하지 않은 날짜입니다. 다시 입력해 주세요."

        const val ERROR_MAXIMUM_ORDER_OF_NUMBER = "최대 주문 갯수는 20개입니다."
        const val ERROR_MINIMUM_ORDER_OF_NUMBER = "주문 갯수는 1개 이상이어야 합니다."
        const val ERROR_NOT_ONLY_DRINK = "음료만 주문할 수 없습니다."
        const val ERROR_REDUNDANT_ORDER = "중복해서 주문할 수 없습니다."
        const val ERROR_NOT_IN_MENU = "없는 메뉴는 주문 할 수 없습니다."
        const val ERROR_INCORRECT_ORDER = "유효하지 않은 주문입니다. 다시 입력해 주세요."

    }
}