package data

import java.time.DayOfWeek
import java.time.LocalDate

class Event(val date: Int) {
    var inputDate = LocalDate.of(YEAR, MONTH, date)
    var visitedDay = inputDate.dayOfWeek

    fun dDayChristmas(): Int {
        var discountPrice = NOTHING_DISCOUNT
        if (date >= THE_FIRST_DAY_DECEMBER && date <= CHRISTMAS_DAY) {
            discountPrice = D_DAY_STANDARD_DISCOUNT + (date - 1) * D_DAY_ADD_DISCOUNT
        }
        return discountPrice
    }

    fun weekdayDiscount(orderList: Map<MenuList, Int>): Int {
        var count = 0
        var disconutPrice = when (visitedDay) {
            DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY ->
                WEEKDAY_DISCOUNT

            DayOfWeek.FRIDAY, DayOfWeek.SATURDAY ->
                NOTHING_DISCOUNT
        }
        for ((menu, quantity) in orderList) {
            if (menu.type == "디저트") {
                count += quantity
            }
        }
        return disconutPrice * count
    }

    fun weekendDiscount(orderList: Map<MenuList, Int>): Int {
        var count = NOTHING
        var disconutPrice = when (visitedDay) {
            DayOfWeek.FRIDAY, DayOfWeek.SATURDAY ->
                WEEKEND_DISCOUNT

            DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY ->
                NOTHING_DISCOUNT
        }
        for ((menu, quantity) in orderList) {
            if (menu.type == "메인") {
                count += quantity
            }
        }
        return disconutPrice * count
    }

    fun specialDiscount(): Int {
        var disconutPrice = NOTHING_DISCOUNT
        if (visitedDay == DayOfWeek.SUNDAY || date == CHRISTMAS_DAY) {
            disconutPrice = SPECIAL_DISCOUNT
        }
        return disconutPrice
    }

    fun giftBadge(totalBenefits: Int): String {
        return if (totalBenefits in BADGE_STANDARD_ZERO..<BADGE_STANDARD_STAR) {
            BADGE_NOTHING
        } else if (totalBenefits in BADGE_STANDARD_STAR..<BADGE_STANDARD_TREE) {
            STAR
        } else if (totalBenefits in BADGE_STANDARD_TREE..<BADGE_STANDARD_SANTA) {
            TREE
        } else SANTA
    }

    companion object {
        const val MONTH = 12
        val YEAR = LocalDate.now().year
        const val THE_FIRST_DAY_DECEMBER = 1
        const val CHRISTMAS_DAY = 25
        const val D_DAY_STANDARD_DISCOUNT = 1000
        const val D_DAY_ADD_DISCOUNT = 100
        const val WEEKDAY_DISCOUNT = 2023
        const val WEEKEND_DISCOUNT = 2023
        const val SPECIAL_DISCOUNT = 1000
        const val NOTHING_DISCOUNT = 0
        const val NOTHING = 0
        const val BADGE_STANDARD_ZERO = 0
        const val BADGE_STANDARD_STAR = 5000
        const val BADGE_STANDARD_TREE = 10_000
        const val BADGE_STANDARD_SANTA = 20_000
        const val BADGE_NOTHING = "없음"
        const val STAR = "별"
        const val TREE = "트리"
        const val SANTA = "산타"
    }
}