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

println elves.max()
