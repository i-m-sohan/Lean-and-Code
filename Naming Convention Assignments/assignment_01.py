import random
def rollDice(noOfFaces):
    rolledNumber=random.randint(1, noOfFaces)
    return rolledNumber


def main():
    noOfFaces=6
    iSReadyToRoll=True
    while iSReadyToRoll:
        iSReadyToRoll=input("Ready to roll? Enter Q to Quit")
        if iSReadyToRoll.lower() !="q":
            rolledNumber=rollDice(noOfFaces)
            print("You have rolled a",rolledNumber)
        else:
            iSReadyToRoll=False

main();