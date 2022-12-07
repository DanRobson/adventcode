package puzzles.day6

import puzzles.day2.Move
import util.Data

static void main(String[] args) {
    getMarkerIndex(4)
    getMarkerIndex(14)
}

static void getMarkerIndex(int numberOfCharacters) {
    def runningCharacters = new char [numberOfCharacters].toList()
    def index = Data.dataStream.findIndexOf { Character x ->
        runningCharacters = runningCharacters.drop(1)
        runningCharacters.add(x)
        if (runningCharacters.toSet().size() == runningCharacters.size()) return true
        println(runningCharacters)
    } + 1
    println("Header marker: $runningCharacters at index: $index")
}
