package puzzles

import util.Data

static void main(String[] args) {

    int fattestElf = 0
    int currentElf = 0
    Data.calories.inputStream.readLines().forEach { x ->
        if (x.empty) {
            if (currentElf > fattestElf) {
                fattestElf = currentElf
            }
            currentElf = 0
        }
        else {
            currentElf += x.toInteger()
        }
    }
    print(fattestElf)
}