package puzzles

import util.Data

static void main(String[] args) {

    var elves = new ArrayList<int>()
    int elf = 0
    Data.calories.inputStream.readLines().forEach { x ->
        if (x.empty) {
            elves.add(elf)
            elf = 0
        }
        else {
            elf += x.toInteger()
        }
    }
    println(elves)
    print(elves.sort().reverse().collate(3)[0].sum())
}