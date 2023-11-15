package christmas.inputView

import christmas.data.MenuList


class InputViewCondition {

    fun dateCheck(input: String) {
        if(!input.matches(Regex("\\d+"))) {
            throw IllegalArgumentException(ERROR + ERR0R_INCORRECT_DATE)
        }
        if (!(input.toInt() in MINIMUM_DAY..MAXIMUM_DAY)){
            throw IllegalArgumentException(ERROR + ERR0R_INCORRECT_DATE)
        }
    }

    fun typeCheck(order: Map<MenuList,String>){
        if (order.any { !it.value.matches(Regex("\\d+")) }) {
            throw IllegalArgumentException(ERROR + ERROR_INCORRECT_ORDER )
        }
    }

    //메뉴판에 없는 메뉴 주문 추가, 형식이 다른경우 오류, 여러가지 테스트 코드 추가
    fun menuCheck(orderList: Map<MenuList,Int>) {
        if (orderList.values.sum() > MAXIMUM_ORDER_NUMBER) {
            throw IllegalArgumentException(ERROR + ERROR_MAXIMUM_ORDER_OF_NUMBER)
        }

        if (orderList.values.sum() < MINIMUM_ORDER_NUMBER ) {
            throw IllegalArgumentException(ERROR + ERROR_INCORRECT_ORDER)
        }

        if (orderList.filter { it.key.type == MENULIST_TYPE_DRINK }.isNotEmpty() && orderList.size == 1) {
            throw IllegalArgumentException(ERROR + ERROR_NOT_ONLY_DRINK)
        }

        if (orderList.keys.distinct().size != orderList.keys.size) {
            throw IllegalArgumentException(ERROR + ERROR_INCORRECT_ORDER)
        }
    }


    companion object {
        const val MAXIMUM_DAY = 31
        const val MINIMUM_DAY = 1
        const val MAXIMUM_ORDER_NUMBER = 20
        const val MINIMUM_ORDER_NUMBER = 1

        val MENULIST_TYPE_DRINK = "음료"

        const val ERROR = "[ERROR] "
        const val ERR0R_INCORRECT_DATE = "유효하지 않은 날짜입니다. 다시 입력해 주세요."


        const val ERROR_MAXIMUM_ORDER_OF_NUMBER = "최대 주문 갯수는 20개입니다."
        const val ERROR_NOT_ONLY_DRINK = "음료만 주문할 수 없습니다."
        const val ERROR_INCORRECT_ORDER = "유효하지 않은 주문입니다. 다시 입력해 주세요."

    }
}