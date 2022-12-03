in = new Scanner(System.in)

elves = []
calories = 0

while (in.hasNextLine()) {
    line = in.nextLine()

    if (line.empty) {
        elves << calories
        calories = 0
        continue
    }

    calories += line as int
}

elves << calories

println "Elf carrying most calories: ${elves.max()}"
println "Three Elves carrying most calories: ${elves.sort().reverse().take(3).sum()}"
