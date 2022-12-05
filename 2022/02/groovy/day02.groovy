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
    X: LOSS,
    Y: DRAW,
    Z: WIN,
]

totalScore = 0

while (in.hasNextLine()) {
    line = in.nextLine()

    def (opponent, outcome) = line.tokenize(' ')

    def shape = findShape(mappings[opponent], mappings[outcome])

    println "$line: (shape: $shape)"

    def s = score(shape, mappings[outcome])

    totalScore += s

    println "round: (outcome: ${mappings[outcome]}, score: $s)"
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

def findShape(opponent, outcome) {
    println "opponent: $opponent, outcome: $outcome"
    switch (opponent) {
        case 'rock' -> switch (outcome) {
            case WIN -> 'paper'
            case DRAW -> 'rock'
            case LOSS -> 'scissors'
        }
        case 'paper' -> switch (outcome) {
            case WIN -> 'scissors'
            case DRAW -> 'paper'
            case LOSS -> 'rock'
        }
        case 'scissors' -> switch (outcome) {
            case WIN -> 'rock'
            case DRAW -> 'scissors'
            case LOSS -> 'paper'
        }
    }
}
