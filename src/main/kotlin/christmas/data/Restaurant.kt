package christmas.data

class Restaurant {
    fun order(input: String): Map<MenuList, String> {
        val menuEntries = input.split(",")
        return menuEntries.map { entry ->
            val parts = entry.split("-")
            val menuName = parts[0].trim()
            val quantity = parts[1].trim()

            val menu = MenuList.valueOf(menuName)
            menu to quantity
        }.toMap()
    }

    fun ValueToInt(orderList: Map<MenuList, String>): Map<MenuList, Int> {
        return orderList.mapValues { it.value.toInt() }
    }
}