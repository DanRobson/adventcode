package puzzles.day1

import util.Data

static void main(String[] args) {

    int fattestElf = 0
    int currentElf = 0
    Data.calories.eachLine { x ->
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