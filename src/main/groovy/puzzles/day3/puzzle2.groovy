package puzzles.day3

import puzzles.day2.Move
import util.Data

static void main(String[] args) {

    println(Data.rucksacks.readLines().collate(3).sum {
        getPriority(it[0].toList().intersect(it[1].toList()).intersect(it[2].toList())[0].toCharacter())
    })
}

private int getPriority(Character c)
{
    c.isUpperCase() ? (int) c.charValue() - 38 : (int) c.charValue() - 96
}




