package christmas

import inputView.InputView
import outputView.OutputView

class ChristmasGame {
    var inputView = InputView()
    var outputView = OutputView()
    fun play(){
        inputView.readDate()
        var menuList = inputView.readMenu()
        outputView.printMenu(menuList)
    }
}