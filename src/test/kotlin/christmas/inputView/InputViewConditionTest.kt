package christmas.inputView

import christmas.data.Restaurant
import christmas.inputView.InputViewCondition
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class InputViewConditionTest {
    var inputViewCondition = InputViewCondition()
    var restaurant = Restaurant()


    @Test
    fun `예외 - 날짜 정수 입력시`() {
        assertThrows<IllegalArgumentException> {
           inputViewCondition.dateCheck("a")
        }
    }

    @Test
    fun `예외 - 날짜가 1보다 작을 때`() {
        assertThrows<IllegalArgumentException> {
            inputViewCondition.dateCheck("0")
        }
    }

    @Test
    fun `예외 - 날짜가 31보다 클 때`() {
        assertThrows<IllegalArgumentException> {
            inputViewCondition.dateCheck("40")
        }
    }

    @Test
    fun `예외 - 날짜를 입력하지 않았을 때`() {
        assertThrows<IllegalArgumentException> {
            inputViewCondition.dateCheck("")
        }
    }

    @Test
    fun `예외 - 주문 갯수 20개 초과할 때`() {
        var input = "바비큐립-15,레드와인-6,초코케이크-4"
        var orderList = restaurant.order(input)

        assertThrows<IllegalArgumentException> {
            inputViewCondition.menuCheck(orderList)
        }
    }

    @Test
    fun `예외 - 주문 갯수 1개보다 작을때`() {
        var input = "바비큐립-0"
        var orderList =restaurant.order(input)

        assertThrows<IllegalArgumentException> {
            inputViewCondition.menuCheck(orderList)
        }
    }

    @Test
    fun `예외 - 음료만 주문 했을 때`() {
        var input = "레드와인-4"
        var orderList =restaurant.order(input)

        assertThrows<IllegalArgumentException> {
            inputViewCondition.menuCheck(orderList)
        }
    }






}