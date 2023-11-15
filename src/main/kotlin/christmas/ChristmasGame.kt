package christmas

import christmas.data.Amount
import christmas.data.Event
import christmas.inputView.InputView
import christmas.outputView.OutputView

class ChristmasGame {
    private var inputView = InputView()
    private var amount = Amount()

    fun play(){
        val date = inputView.readDate()
        val menuList = inputView.readMenu()
        val outputView = OutputView(menuList,date)

        outputView.printMenu()
        println()

        outputView.printAmountBeforeDiscount()
        println()

        val gift = outputView.printGiftMenu()
        println()

        val event = Event(date)
        val christmasDiscount = event.dDayChristmas()
        val weekdayDiscount = event.weekdayDiscount(menuList)
        val weekendDiscount = event.weekendDiscount(menuList)
        val specialDiscount = event.specialDiscount()

        outputView.printBenefitsDetails(christmasDiscount,weekdayDiscount,weekendDiscount,specialDiscount,gift)
        println()

        val totalBenefits = amount.totalBenefits(christmasDiscount,weekdayDiscount,weekendDiscount,specialDiscount,gift)
        outputView.printTotalBenefits(totalBenefits)
        println()

        val discount = amount.discount(christmasDiscount,weekdayDiscount,weekendDiscount,specialDiscount)
        outputView.printAmountResult(discount)
        println()

        val badge = event.giftBadge(totalBenefits)
        outputView.printEventBadge(badge)
    }
}