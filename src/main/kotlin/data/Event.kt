package data
import java.time.DayOfWeek
import java.time.LocalDate
import kotlin.time.times

class Event(val date: Int) {
    var inputDate = LocalDate.of(YEAR, MONTH,date)
    var visitedDay = inputDate.dayOfWeek
    fun dDayChristmas(){

    }

    fun weekdayDiscount(orderList: Map<Menu,Int>): Int {
        var count = 0
        var disconutPrice = when(visitedDay){
            DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY ->
                WEEKDAY_DISCOUNT
            DayOfWeek.FRIDAY, DayOfWeek.SATURDAY ->
                NOTHING_DISCOUNT
        }
        for ((menu, quantity) in orderList) {
            if(menu.type == "디저트"){
                count += quantity
            }
        }
        println(count)
        return disconutPrice * count
    }

    fun weekendDiscount() {

    }

    fun specialDiscount() {

    }

    fun present() {

    }

    fun badge() {

    }
    companion object{
        const val MONTH = 12
        val YEAR = LocalDate.now().year
        const val WEEKDAY_DISCOUNT = 2023
        const val WEEKEND_DISCOUNT = 2023
        const val NOTHING_DISCOUNT = 0
    }
}