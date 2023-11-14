package data

class Restaurant {
    fun order(input: String): Map<MenuList, Int> {
        val menuEntries = input.split(",")
        return menuEntries.map { entry ->
            val parts = entry.split("-")
            val menuName = parts[0].trim()
            val quantity = parts[1].trim().toInt()

            val menu = MenuList.valueOf(menuName)
            menu to quantity
        }.toMap()
    }
}