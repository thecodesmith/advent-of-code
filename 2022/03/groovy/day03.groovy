in = new Scanner(System.in)

totalPriority = 0

lowerBaseline = ascii('a')
upperBaseline = ascii('A')

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
