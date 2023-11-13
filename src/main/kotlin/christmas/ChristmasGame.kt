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

        outputView.printGiftMenu()
        println()

        var event = Event(date)


    }
}