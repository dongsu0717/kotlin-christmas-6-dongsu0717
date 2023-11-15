package christmas.data
import christmas.inputView.InputViewCondition
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EventTest {
    private var eventWeekend = Event(date = 1)
    private val eventWeekday = Event(date = 3)
    private val eventSepcial = Event(date = 25)
    private val eventNotDDay = Event(date = 26)
    private val restaurant = Restaurant()


    @Test
    fun `크리스마스 디데이 할인 - 12월 25일`() {
        assertThat(eventSepcial.dDayChristmas()).isEqualTo(3400)
    }

    @Test
    fun `크리스마스 디데이 할인 없음 - 12월 26일`() {
        assertThat(eventNotDDay.dDayChristmas()).isEqualTo(0)
    }

    @Test
    fun `평일 할인 메뉴 2개 있음 - 12월 3일`() {
        var orderList = restaurant.order("초코케이크-2,해산물파스타-1")
        assertThat(eventWeekday.weekdayDiscount(orderList)).isEqualTo(4046)
    }

    @Test
    fun `평일 할인 메뉴 없음 - 12월 3일`() {
        var orderList = restaurant.order("해산물파스타-1,레드와인-1")
        assertThat(eventWeekday.weekdayDiscount(orderList)).isEqualTo(0)
    }

    @Test
    fun `주말 할인 메뉴 3개 있음 - 12월 1일`() {
        var orderList = restaurant.order("초코케이크-1,바비큐립-3")
        assertThat(eventWeekend.weekendDiscount(orderList)).isEqualTo(6069)
    }


    @Test
    fun `주말 할인 메뉴 없음 - 12월 1일`() {
        var orderList = restaurant.order("초코케이크-1")
        assertThat(eventWeekend.weekendDiscount(orderList)).isEqualTo(0)
    }

    @Test
    fun `스페셜 할인 있음 - 12월 25일`() {
        assertThat(eventSepcial.specialDiscount()).isEqualTo(1000)
    }

    @Test
    fun `총혜택이 5000원보다 크거나 같고 10000원보다 작을 때 '별'배지 받기`() {
        var benefits6000 = eventWeekend.giftBadge(totalBenefits = 6000)
        assertThat(benefits6000).isEqualTo("별")
    }

    @Test
    fun `총혜택이 10000원보다 크거나 같고 20000원보다 작을 때 '트리'배지 받기`() {
        var benefits12000 = eventWeekend.giftBadge(totalBenefits = 12000)
        assertThat(benefits12000).isEqualTo("트리")
    }

    @Test
    fun `총혜택이 20000원보다 클때 '산타'배지 받기`() {
        var benefits24000 = eventWeekend.giftBadge(totalBenefits = 24000)
        assertThat(benefits24000).isEqualTo("산타")
    }


}