package christmas.data
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RestaurantTest {
    private var restaurant = Restaurant()

    @Test
    fun `예외 - 잘못 된 주문을 했을 때`() {
        assertThrows<IllegalArgumentException> {
            restaurant.order("a")
        }
    }

    @Test
    fun `예외 - 중복되는 주문을 했을 때`() {
        assertThrows<IllegalArgumentException> {
            restaurant.order("해산물파스타-1,해산물파스타-1")
        }
    }

    @Test
    fun `예외 - 주문이 (-)로 구분되지 않을 때 `() {
        assertThrows<IllegalArgumentException> {
            restaurant.order("해산물파스타2,제로콜라-5")
        }
    }

    @Test
    fun `예외 - 주문이 (,)로 구분되지 않을 때 `() {
        assertThrows<IllegalArgumentException> {
            restaurant.order("해산물파스타-2제로콜라-1")
        }
    }

    @Test
    fun `예외 - 수량이 이상할 때`() {
        assertThrows<IllegalArgumentException> {
            restaurant.order("해산물파스타-2,제로콜라-A")
        }
    }


}