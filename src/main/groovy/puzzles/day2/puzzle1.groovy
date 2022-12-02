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

    def santaMoves = ['X': moves.find {it.prettyName == ("Rock")},
                      'Y': moves.find {it.prettyName == ("Paper")},
                      'Z': moves.find {it.prettyName == ("Scissors")}
    ]

    int runningTotal = 0

    Data.strategies.eachLine {
        var opponentMove = elfMoves[it.charAt(0).toString()] as Move
        var myMove = santaMoves[it.charAt(2).toString()] as Move

        println("Elf plays $opponentMove.prettyName")
        println("Bad Santa plays $myMove.prettyName")
        runningTotal += myMove.pointValue

        if (myMove.beats == opponentMove.prettyName)
        {
            println("$myMove.prettyName beats $opponentMove.prettyName")
            runningTotal += 6
        }
        else if (opponentMove.beats == myMove.prettyName)
        {
            println("$myMove.prettyName obliterated by $opponentMove.prettyName")
        }
        else
        {
            println("$myMove.prettyName bounces ineffectually off $opponentMove.prettyName")
            runningTotal += 3
        }
    }

    println("Total score: $runningTotal")
}


