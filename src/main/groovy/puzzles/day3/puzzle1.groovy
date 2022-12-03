package puzzles.day3

import puzzles.day2.Move
import util.Data

static void main(String[] args) {

    var commonItems = new ArrayList<Character>()
    Data.rucksacks.eachLine {
        var compartments = it.toList().collate(it.length().intdiv(2))
        var commonItem = compartments[0].intersect(compartments[1])

        // Common item can actually show up more than once in the intersection, but just take the first example
        commonItems.add(commonItem[0].toCharacter())
    }

    commonItems.forEach {x -> println(x.toString() + ": " + getPriority(x))}
    println(commonItems.sum {x -> getPriority(x)})
}

private int getPriority(Character c)
{
    c.isUpperCase() ? (int) c.charValue() - 38 : (int) c.charValue() - 96
}
