import random
def is_guess_valid(guessed_number):
    if guessed_number.isdigit() and 1<= int(guessed_number) <=100:
        return True
    else:
        return False

def main():
    target_number=random.randint(1,100)
    is_guess_correct=False
    guessed_number=input("Guess a number between 1 and 100:")
    guess_count=0
    while not is_guess_correct:
        if not is_guess_valid(guessed_number):
            guessed_number=input("I wont count this one Please enter a number between 1 to 100")
            continue
        else:
            guess_count+=1
            guessed_number=int(guessed_number)

        if guessed_number<target_number:
            guessed_number=input("Too low. Guess again")
        elif guessed_number>target_number:
            guessed_number=input("Too High. Guess again")
        else:
            print("You guessed it in",guess_count,"guesses!")
            is_guess_correct=True


main()
