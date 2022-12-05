in = new Scanner(System.in)

lowerBaseline = ascii('a')
upperBaseline = ascii('A')

// println 'Part 1'
// part1()

println 'Part 2'
part2()

def part1() {
    totalPriority = 0
    warnings = 0

    while (in.hasNextLine()) {
        line = in.nextLine()
        int mid = line.size() / 2

        def compartment1 = line.substring(0, mid).toList()
        def compartment2 = line.substring(mid).toList()
        def items = compartment1.intersect(compartment2).toSet()
        def p = priority(items.first())

        totalPriority += p

        println "shared: $items $p - $compartment1  $compartment2"

        if (items.size() > 1) {
            println '  WARNING: multiple items'
            warnings++
        }
    }

    println "total: $totalPriority ($warnings warnings)"
}

def part2() {

    totalPriority = 0

    while (in.hasNextLine()) {
        def elf1 = in.nextLine()
        def elf2 = in.nextLine()
        def elf3 = in.nextLine()

        def badge = elf1.toList().intersect(elf2.toList()).intersect(elf3.toList()).first()

        def p = priority(badge)
        totalPriority += p

        println "badge: $badge, priority: $p"
    }

    println "total: $totalPriority"
}

def priority(item) {
    switch (item) {
        case 'a'..'z' -> ascii(item) - lowerBaseline + 1
        case 'A'..'Z' -> ascii(item) - upperBaseline + 27
    }
}

int value(char c) {
    switch (c) {
        case 'a'..'z' -> ascii(c) - ascii('a') + 1
        case 'A'..'Z' -> ascii(c) - ascii('A') + 1
    }
}

int ascii(String s) {
    ((int)((char)s))
}
