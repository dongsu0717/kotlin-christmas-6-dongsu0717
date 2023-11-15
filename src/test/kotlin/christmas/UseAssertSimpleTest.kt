package christmas

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class UseAssertSimpleTest : NsTest() {
    @Test
    fun `예외 - 날짜기준보다 큰 수 입력 테스트`() {
        assertSimpleTest {
            runException("100")
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `예외 - 날짜기준보다 작은 수 입력 테스트`() {
        assertSimpleTest {
            runException("-1")
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `예외 - 잘못 된 날짜 입력 테스트`() {
        assertSimpleTest {
            runException("a")
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `예외 - 날짜입력에 blank 입력시 테스트`() {
        assertSimpleTest {
            runException(" ")
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `예외 - 주문 음식이 중복 되었을 때`() {
        assertSimpleTest {
            runException("26", "해산물파스타-1,해산물파스타-1")
            assertThat(output()).contains(
                ("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            )
        }
    }

    @Test
    fun `예외 - 주문이 형식에 맞지 않을 때`() {
        assertSimpleTest {
            runException("26", "아이고")
            assertThat(output()).contains(
                ("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            )
        }
    }

    @Test
    fun `예외 - 주문 갯수가 이상할 때`() {
        assertSimpleTest {
            runException("26", "해산물파스타-A")
            assertThat(output()).contains(
                ("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            )
        }
    }

    @Test
    fun `예외 - 주문이 인덱스가(,)로 분리가 안될때`() {
        assertSimpleTest {
            runException("26", "해산물파스타-1,")
            assertThat(output()).contains(
                ("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            )
        }
    }

    @Test
    fun `예외 - 주문 갯수가 20개를 초과할때`() {
        assertSimpleTest {
            runException("26", "해산물파스타-10,초코케이크-5,레드와인-10")
            assertThat(output()).contains(
                ("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            )
        }
    }

    @Test
    fun `예외 - 주문 갯수가 1개가 안될 때`() {
        assertSimpleTest {
            runException("26", "해산물파스타-0")
            assertThat(output()).contains(
                ("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            )
        }
    }

    @Test
    fun `예외 - 음료만 주문 했을 때`() {
        assertSimpleTest {
            runException("26", "제로콜라-15")
            assertThat(output()).contains(
                ("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            )
        }
    }


    @Test
    fun `주문금액이 10,000원 이하일때 혜택 없음`() {
        assertSimpleTest {
            run("26", "타파스-1,제로콜라-1")
            assertThat(output()).contains(
                ("<증정 메뉴>$LINE_SEPARATOR".toString() + "없음"),
                ("<혜택 내역>$LINE_SEPARATOR".toString() + "없음"),
                ("<총혜택 금액>$LINE_SEPARATOR".toString() + "없음"),
                ("<12월 이벤트 배지>$LINE_SEPARATOR".toString() + "없음"),
            )
        }
    }

    @Test
    fun `혜택금액이 5000원보다 크거나 같고 10000원보다 작을 때 이벤트 배지 별`() {
        assertSimpleTest {
            run("25", "초코케이크-2")
            assertThat(output()).contains(
                ("<12월 이벤트 배지>$LINE_SEPARATOR".toString() + "별")
            )
        }
    }

    @Test
    fun `혜택금액이 10000원보다 크거나 같고 20000원보다 작을 때 이벤트 배지 트리`() {
        assertSimpleTest {
            run("25", "초코케이크-3")
            assertThat(output()).contains(
                ("<12월 이벤트 배지>$LINE_SEPARATOR".toString() + "트리")
            )
        }
    }

    @Test
    fun `혜택금액이 20000원보다 클때 이벤트 배지 산타`() {
        assertSimpleTest {
            run("25", "초코케이크-10")
            assertThat(output()).contains(
                ("<12월 이벤트 배지>$LINE_SEPARATOR".toString() + "산타")
            )
        }
    }

    @Test
    fun `평일 할인 2개 -4046`() {
        assertSimpleTest {
            run("4", "초코케이크-2")
            assertThat(output()).contains(
                ("평일 할인: -4046원")
            )
        }
    }

    @Test
    fun `주말 할인 2개 -4046`() {
        assertSimpleTest {
            run("29", "해산물파스타-2")
            assertThat(output()).contains(
                ("<혜택 내역>$LINE_SEPARATOR".toString() + "주말 할인: -4046원")
            )
        }
    }

    @Test
    fun `크리스마스 디데이 할인`() {
        assertSimpleTest {
            run("1", "해산물파스타-2")
            assertThat(output()).contains(
                ("<혜택 내역>$LINE_SEPARATOR".toString() + "크리스마스 디데이 할인:")
            )
        }
    }

    @Test
    fun `샴페인 증정 이벤트`() {
        assertSimpleTest {
            run("1", "해산물파스타-10")
            assertThat(output()).contains(
                ("<증정 메뉴>$LINE_SEPARATOR".toString() + "샴페인 1개")
            )
        }
    }

    @Test
    fun `주말 할인 빼고 모든 이벤트 다 받기`() {
        assertSimpleTest {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            assertThat(output()).contains(
                ("<증정 메뉴>$LINE_SEPARATOR".toString() + "샴페인"),
                ("<혜택 내역>$LINE_SEPARATOR".toString() + "크리스마스 디데이 할인: "),
                ("평일 할인: "),
                ("특별 할인: "),
                ("증정 이벤트: "),
                ("<총혜택 금액>$LINE_SEPARATOR".toString() + "-"),
                ("<12월 이벤트 배지>$LINE_SEPARATOR".toString() + "산타"),
            )
        }
    }

    @Test
    fun `평일, 특별 할인 빼고 모든 이벤트 다 받기`() {
        assertSimpleTest {
            run("1", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            assertThat(output()).contains(
                ("<증정 메뉴>$LINE_SEPARATOR".toString() + "샴페인"),
                ("<혜택 내역>$LINE_SEPARATOR".toString() + "크리스마스 디데이 할인: "),
                ("주말 할인: "),
                ("증정 이벤트: "),
                ("<총혜택 금액>$LINE_SEPARATOR".toString() + "-"),
                ("<12월 이벤트 배지>$LINE_SEPARATOR".toString() + "산타"),
            )
        }
    }





    override fun runMain() {
        main()
    }

    companion object {
        private val LINE_SEPARATOR = System.lineSeparator()
    }
}