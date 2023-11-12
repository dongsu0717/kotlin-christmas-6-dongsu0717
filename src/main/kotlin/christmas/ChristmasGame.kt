package christmas

import data.Amount
import inputView.InputView
import outputView.OutputView

class ChristmasGame {
    var inputView = InputView()
    var outputView = OutputView()
    var amount = Amount()

    fun play(){
        inputView.readDate()
        var menuList = inputView.readMenu()             // menuList = 주문메뉴 리스트
        outputView.printMenu(menuList)
        println()
        outputView.printAmountBeforeDiscount(menuList)

    }
}