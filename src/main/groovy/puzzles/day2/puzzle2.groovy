package puzzles.day2

import util.Data

static void main(String[] args) {
    var moves = new ArrayList<Move>()
    moves.add(new Move(prettyName: "Rock", pointValue: 1, beats: 'Scissors'))
    moves.add(new Move(prettyName: "Paper", pointValue: 2, beats: 'Rock'))
    moves.add(new Move(prettyName: "Scissors", pointValue: 3, beats: 'Paper'))

    // Java doesn't like primitive types in a hashmap, otherwise I'd just do these as char
    def elfMoves = ["A": moves.find {it.prettyName == ("Rock")},
                    "B": moves.find {it.prettyName == ("Paper")},
                    "C" : moves.find {it.prettyName == ("Scissors")}
    ]

    int runningTotal = 0

    Data.strategies.eachLine {
        var opponentMove = elfMoves[it.charAt(0).toString()] as Move
        var winCondition = it.charAt(2)

        println("Elf plays $opponentMove.prettyName")

        var moveToPlay
        if (winCondition == 'X' as char)
        {
            moveToPlay = moves.find {x -> x.prettyName == opponentMove.beats }
            println("Bad Santa is a loser - plays $moveToPlay.prettyName")
        }
        else if (winCondition == 'Y' as char) {
            moveToPlay = opponentMove
            println("It's a draw, Santa plays $moveToPlay.prettyName")
            runningTotal += 3
        }
        else {
            moveToPlay = moves.find {x -> x.beats == opponentMove.prettyName }
            println("Bad Santa obliterates elf - plays $moveToPlay.prettyName")
            runningTotal += 6
        }

        runningTotal += moveToPlay.pointValue
    }

    println("Total score: $runningTotal")
}


