package puzzles.day7

import util.Data
import groovy.json.*

static void main(String[] args) {
    var directory = reconstituteDirectoryStructure()


}

static Node reconstituteDirectoryStructure()
{
    def tree = new Node(null, "root")
    var currentNode = tree

    Data.terminalInput.eachLine {
        var bits = it.split(" ")

        switch (bits[0]){
            case '$':
                if (bits[1] == 'cd')
                {
                    switch (bits[2]){
                        case "..":
                            currentNode = currentNode.parent()
                            break
                        case "/":
                            currentNode = tree
                            break
                        default:
                            currentNode = currentNode.find {x -> x.name() == bits[2]} as Node
                    }
                }
                break;
            case "dir":
                currentNode.appendNode(bits[1])
                break
            default:
                // It'll be a file
                currentNode.appendNode(bits[1], bits[0] as int)
        }
    }
    println new JsonBuilder( tree ).toPrettyString()
    return tree
}