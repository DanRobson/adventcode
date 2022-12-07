package puzzles.day5

import puzzles.day2.Move
import util.Data

static void main(String[] args) {

    // Arrays.asList(ArrayList<Character>::new)*9 would be beautiful, if it didn't leave all the lists linked
    def stacks = new ArrayList<LinkedList<Character>>()
    for (int i in 0..8) stacks.add(new LinkedList<Character>())
    var bits = Data.stacks.text.split("\n\n")

    // Establish stacks
    bits[0].split("\n").toList().reverse().forEach {
        it.toCharArray().toList().collate(4).collect {it[1]}.eachWithIndex { x, i ->
            if (x.letter) stacks[i].add(x)
        }
    }
    println(stacks)
    puzzle1(stacks, bits[1].split("\n"))
    puzzle2(stacks, bits[1].split("\n"))
}

static void puzzle1(ArrayList<LinkedList<Character>> stacks, String[] moves)
{
    // Get and process moves
    moves.toList().forEach {
        println(it)
        def (number, startingStack, endStack) = it =~/\d+/
        for (int i in 1..(number as int)) stacks[endStack as int - 1].add(stacks[startingStack as int - 1].removeLast())
        println(stacks)
    }
    println(stacks.collect {it.last})
}

static void puzzle2(ArrayList<LinkedList<Character>> stacks, String[] moves)
{
    moves.toList().forEach {
        println(it)
        def (number, startingStack, endStack) = it =~/\d+/
        def start = stacks[startingStack as int - 1]
        def containers = start.subList(start.size() - (number as int), start.size())

        stacks[endStack as int - 1].addAll(containers)
        containers.clear()
        println(stacks)
    }
    println(stacks.collect {it.last})
}
