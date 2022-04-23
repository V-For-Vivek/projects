from json import load
from difflib import get_close_matches


def printTitle(string):
    print("*"*60, "\n\n\t\t", string, "\n\n", "*"*60, sep="")

def getMeaning(Dict, word):
    isLowerCaseWordInDictionary = word.lower() in Dict
    isTitleCaseWordInDictionary = word.title() in Dict
    isUpperCaseWordInDictionary = word.upper() in Dict
    isUserWordIsCloseToDictionaryWord = len(get_close_matches(word, Dict.keys())) > 0
    
    if isLowerCaseWordInDictionary:
        return Dict[word]
    
    elif isTitleCaseWordInDictionary:
        return Dict[word.title()]
    
    elif isUpperCaseWordInDictionary:
        return Dict[word.upper()]
    
    elif isUserWordIsCloseToDictionaryWord:
        match = get_close_matches(word, Dict.keys())[0]
        print("Do You Mean {} ".format(match)) 
        dicide = input("Press y for yes or n for No : ")
        
        if dicide == "y" or dicide == "Y":
            return Dict[match]
        
        elif dicide == "n" or dicide == "N":
            return "Word is not in Dictionary !"

        else:
            return "Enter only y or n"


def main():
    with open ("data.json") as json_file:
        Dict = load(json_file)
        printTitle("English Word Dictionary")
        word = input("Word To Search >")
        print()
        if word == "":
            printf("Please Enter a Word")
        else:
            output = getMeaning(Dict, word)
            if type(output) == list:
                for line in output:
                    print(line)
            else:
                print(output)
            print()


if __name__ == "__main__":
    main()
    input("Press enter to exit....................")
