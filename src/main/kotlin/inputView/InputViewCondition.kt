package inputView

import data.Menu

class InputViewCondition {

    fun dateCheck(input: String) {
        when {
        !(input.toInt() in MINIMUM_DAY..MAXIMUM_DAY) -> throw IllegalArgumentException(ERR0R_DATE_RANGE)
        input.isBlank() -> throw IllegalArgumentException(ERROR_BLACK)
        input.isEmpty() -> throw IllegalArgumentException(ERROR_EMPTY)
        !input.matches(Regex("\\d+")) -> throw IllegalArgumentException(ERROR_NOT_NUMBER)
        }
    }

    fun menuCheck(input: String): Map<Menu, Int> {
        val menuEntries = input.split(",")
        return menuEntries.map { entry ->
            val parts = entry.split("-")
            val menuName = parts[0].trim()
            val quantity = parts[1].trim().toInt()

            val menu = Menu.valueOf(menuName)
            menu to quantity
        }.toMap()
    }


    companion object{
        const val MAXIMUM_DAY = 31
        const val MINIMUM_DAY = 1
        const val ERR0R_DATE_RANGE = "[ERROR] 날짜는 1 ~ 31의 정수 입니다."
        const val ERROR_BLACK = "[ERROR] 공백없이 입력해 주세요"
        const val ERROR_EMPTY = "[ERROR] 날짜를 입력하지 않았습니다. 다시 입력해주세요"
        const val ERROR_NOT_NUMBER = "[ERROR] 1 ~ 31 숫자를 입력해 주세요."
    }
}