package christmas

import data.Amount
import data.Event
import inputView.InputView
import outputView.OutputView

class ChristmasGame {
    var inputView = InputView()

    fun play(){
        var date = inputView.readDate()
        var menuList = inputView.readMenu()             // menuList = 주문메뉴 리스트
        var outputView = OutputView(menuList,date)

        outputView.printMenu()
        println()

        outputView.printAmountBeforeDiscount()
        println()

        var gift = outputView.printGiftMenu()
        println()

        var event = Event(date)
        var christmasDiscount = event.dDayChristmas()
        var weekdayDiscount = event.weekdayDiscount(menuList)
        var weekendDiscount = event.weekendDiscount(menuList)
        var specialDiscount = event.specialDiscount()

        outputView.printBenefitsDetails(christmasDiscount,weekdayDiscount,weekendDiscount,specialDiscount,gift)
        println()

        outputView.printTotalBenefits(christmasDiscount,weekdayDiscount,weekendDiscount,specialDiscount,gift)
        println()









    }
}