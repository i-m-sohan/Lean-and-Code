import random
def isGuessValid(guessedNumber):
    if guessedNumber.isdigit() and 1<= int(guessedNumber) <=100:
        return True
    else:
        return False

def main():
    targetNo=random.randint(1,100)
    isGuessCorrect=False
    guessedNumber=input("Guess a number between 1 and 100:")
    guessCount=0
    while not isGuessCorrect:
        if not isGuessValid(guessedNumber):
            guessedNumber=input("I wont count this one Please enter a number between 1 to 100")
            continue
        else:
            guessCount+=1
            guessedNumber=int(guessedNumber)

        if guessedNumber<targetNo:
            guessedNumber=input("Too low. Guess again")
        elif guessedNumber>targetNo:
            guessedNumber=input("Too High. Guess again")
        else:
            print("You guessed it in",guessCount,"guesses!")
 
main()