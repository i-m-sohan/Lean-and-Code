def calculateArmstrongSum(inputNumber):
    armstrongSum = 0
    noOfDigits = 0

    tempInputNumber = inputNumber
    while tempInputNumber > 0:
        noOfDigits = noOfDigits + 1
        tempInputNumber = tempInputNumber // 10

    tempInputNumber = inputNumber
    for n in range(1, tempInputNumber + 1):
        remainder = tempInputNumber % 10
        armstrongSum = armstrongSum + (remainder ** noOfDigits)
        tempInputNumber //= 10
    return armstrongSum

inputNumber = int(input("\nPlease Enter the Number to Check for Armstrong: "))

if (inputNumber == calculateArmstrongSum(inputNumber)):
    print("\n %d is Armstrong Number.\n" % inputNumber)
else:
    print("\n %d is Not a Armstrong Number.\n" % inputNumber)