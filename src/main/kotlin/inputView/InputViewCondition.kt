package inputView

import data.MenuList


class InputViewCondition {

    fun dateCheck(input: String) {
        when {
            !input.matches(Regex("\\d+")) -> throw IllegalArgumentException(ERROR_NOT_NUMBER)
            !(input.toInt() in MINIMUM_DAY..MAXIMUM_DAY) -> throw IllegalArgumentException(ERR0R_DATE_RANGE)
            input.isBlank() -> throw IllegalArgumentException(ERROR_BLACK)
            input.isEmpty() -> throw IllegalArgumentException(ERROR_EMPTY)
        }
    }


    companion object {
        const val MAXIMUM_DAY = 31
        const val MINIMUM_DAY = 1
        const val ERR0R_DATE_RANGE = "[ERROR] 날짜는 1 ~ 31의 정수 입니다."
        const val ERROR_BLACK = "[ERROR] 공백없이 입력해 주세요"
        const val ERROR_EMPTY = "[ERROR] 날짜를 입력하지 않았습니다. 다시 입력해주세요"
        const val ERROR_NOT_NUMBER = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
    }
}