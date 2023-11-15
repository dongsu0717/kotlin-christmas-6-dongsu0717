package christmas.data

import christmas.inputView.InputViewCondition

class Restaurant {
    val inputViewCondition = InputViewCondition()
    fun order(input: String): Map<MenuList, Int> {
        val menuEntries = input.split(",")
        inputViewCondition.overlapCheck(menuEntries)

        val orderList = menuEntries.associate { entry ->
            val parts = entry.split("-")
            inputViewCondition.inputTypeCheck(parts)

            val menuName = parts[FIRST_INDEX].trim()
            val quantityStr = parts[SECOND_INDEX].trim()

            var menu = inputViewCondition.menuInCheck(menuName)
            var quantity = inputViewCondition.quantityCheck(quantityStr)
            menu to quantity
        }
        return orderList
    }

    companion object {
        const val FIRST_INDEX = 0
        const val SECOND_INDEX = 1
    }
}
