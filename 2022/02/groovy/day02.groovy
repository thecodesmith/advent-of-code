import static Outcome.*

in = new Scanner(System.in)

enum Outcome {
    WIN,
    LOSS,
    DRAW
}

mappings = [
    A: 'rock',
    B: 'paper',
    C: 'scissors',
    X: 'rock',
    Y: 'paper',
    Z: 'scissors',
]

totalScore = 0

while (in.hasNextLine()) {
    line = in.nextLine()

    def (opponent, me) = line.tokenize(' ')

    def shape = mappings[me]
    def round = "${mappings[opponent]} $shape".toString()
    def o = outcome(round)
    def s = score(shape, o)

    totalScore += s

    println "round: $round (outcome: $o, score: $s)"
}

println "total: $totalScore"

def outcome(round) {
    return switch (round) {
        case 'rock rock'         -> DRAW
        case 'rock paper'        -> WIN
        case 'rock scissors'     -> LOSS
        case 'paper rock'        -> LOSS
        case 'paper paper'       -> DRAW
        case 'paper scissors'    -> WIN
        case 'scissors rock'     -> WIN
        case 'scissors paper'    -> LOSS
        case 'scissors scissors' -> DRAW
    }
}

def score(shape, outcome) {
    switch (shape) {
        case 'rock' -> 1
        case 'paper' -> 2
        case 'scissors' -> 3
    } + switch (outcome) {
        case WIN -> 6
        case DRAW -> 3
        case LOSS -> 0
    }
}
