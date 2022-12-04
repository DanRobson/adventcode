package puzzles.day4

import puzzles.day2.Move
import util.Data

static void main(String[] args) {

    var containedRanges = 0
    var overlappingRanges = 0
    Data.assignments.eachLine {
        var ranges = it.split(',')*.split('-')*.collect { it.toInteger() }
        var firstRange = ranges[0][0] .. ranges[0][1]
        var secondRange = ranges[1][0] .. ranges[1][1]
        if (firstRange.containsAll(secondRange) || secondRange.containsAll(firstRange)) containedRanges++
        if (firstRange.intersect (secondRange)) overlappingRanges++
    }
    println("Elves with fully contained assignments: $containedRanges")
    println("Elves with overlapping assigments: $overlappingRanges")
}
