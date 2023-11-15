package christmas.inputView

import christmas.data.MenuList


class InputViewCondition {

    fun dateCheck(input: String) {
        if (!input.matches(Regex("\\d+"))) {
            throw IllegalArgumentException("$ERROR$ERR0R_INCORRECT_DATE\n$DATE_CHECK")
        }
        if (!(input.toInt() in MINIMUM_DAY..MAXIMUM_DAY)) {
            throw IllegalArgumentException("$ERROR$ERR0R_INCORRECT_DATE\n$DATE_CHECK")
        }
    }

    fun overlapCheck(menuEntries: List<String>) {
        val overlap = menuEntries.toSet()
        if (overlap.size != menuEntries.size) {
            throw IllegalArgumentException("$ERROR$ERROR_INCORRECT_ORDER\n$MENU_OVERLAP")
        }
    }

    fun inputTypeCheck(parts: List<String>) {
        if (parts.size != 2) {
            throw IllegalArgumentException("$ERROR$ERROR_INCORRECT_ORDER\n$MENU_QUANTITY_SEPARATION")
        }
    }

    fun menuInCheck(menuName: String): MenuList {
        val menu = MenuList.findByName(menuName)
        if (menu == null) {
            throw IllegalArgumentException("$ERROR$ERROR_INCORRECT_ORDER\n$MENU_NOT_IN_MENULIST")
        }
        return menu
    }

    fun quantityCheck(quantityStr: String): Int {
        val quantity = quantityStr.toIntOrNull()
        if (quantity == null) {
            throw IllegalArgumentException("$ERROR$ERROR_INCORRECT_ORDER\n$MENU_QUANTITY_CHECK")
        }
        return quantity
    }

    fun menuCheck(orderList: Map<MenuList, Int>) {
        val orderListTOSet = orderList.keys.toSet()
        if (orderListTOSet.size != orderList.keys.size) {
            throw IllegalArgumentException("$ERROR$ERROR_INCORRECT_ORDER\n$MENU_OVERLAP")
        }
        if (orderList.values.sum() > MAXIMUM_ORDER_NUMBER) {
            throw IllegalArgumentException("$ERROR$ERROR_INCORRECT_ORDER\n$MAXIMUM_ORDER_OF_NUMBER")
        }
        if (orderList.values.sum() < MINIMUM_ORDER_NUMBER) {
            throw IllegalArgumentException("$ERROR$ERROR_INCORRECT_ORDER\n$MINIMUN_ORDER_OF_NUMBER")
        }
        if (orderList.filter { it.key.type == MENULIST_TYPE_DRINK }.isNotEmpty() && orderList.size == 1) {
            throw IllegalArgumentException("$ERROR$ERROR_INCORRECT_ORDER\n$NOT_ONLY_DRINK")
        }
    }


    companion object {
        const val MAXIMUM_DAY = 31
        const val MINIMUM_DAY = 1
        const val MAXIMUM_ORDER_NUMBER = 20
        const val MINIMUM_ORDER_NUMBER = 1

        const val MENULIST_TYPE_DRINK = "음료"

        const val ERROR = "[ERROR] "
        const val ERR0R_INCORRECT_DATE = "유효하지 않은 날짜입니다. 다시 입력해 주세요."
        const val ERROR_INCORRECT_ORDER = "유효하지 않은 주문입니다. 다시 입력해 주세요."

        const val DATE_CHECK = "날짜는 1 ~ 31 숫자입니다."

        const val MENU_OVERLAP = "메뉴가 중복 되었습니다"
        const val MENU_QUANTITY_SEPARATION = "메뉴항목과 수량은 '-'로 구분되어야합니다."
        const val MENU_NOT_IN_MENULIST = "선택한 메뉴 항목이 존재하지 않습니다."
        const val MENU_QUANTITY_CHECK = "수량을 1~20사이 숫자로 입력해주세요"
        const val MAXIMUM_ORDER_OF_NUMBER = "최대 주문 갯수는 20개 입니다."
        const val MINIMUN_ORDER_OF_NUMBER = "최소 주문 갯수는 1개 입니다."
        const val NOT_ONLY_DRINK = "음료만 주문할 수 없습니다."


    }
}