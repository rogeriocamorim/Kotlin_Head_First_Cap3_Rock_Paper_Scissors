fun main(args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    compareBothOptions(gameChoice, userChoice)
}

fun getGameChoice(gameOptions: Array<String>): String{
    return gameOptions[(Math.random() * gameOptions.size).toInt()]
}

fun getUserChoice(gameOptions: Array<String>): String{
    var userOptionValide = false
    var userInput = ""
    while (!userOptionValide) {
        println("Please enter one of the following: ")
        for (item in gameOptions) print(" $item ")
        println()
        print("Choise: ")
        userInput = readLine() ?: ""
        userOptionValide = checkUserOption(userInput.toLowerCase().capitalize(), gameOptions)
    }
    return userInput.toLowerCase().capitalize()
}

fun checkUserOption(userOption: String, gameOptions: Array<String>): Boolean{
    return if (userOption in gameOptions) {
        true
    }
    else{
        println("Enter a valid option.")
        false
    }
}

fun compareBothOptions(gameChoice: String, userChoice: String){
    val result: String =
        if (gameChoice == userChoice) {
            "Tie"
        }
        else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
            (userChoice == "Paper" && gameChoice == "Rock") ||
            (userChoice == "Scissors" && gameChoice == "Paper")) {
            "You win"
        } else {
            "You Lose !"
        }
    println("You chose $userChoice. I chose $gameChoice. $result")
}
