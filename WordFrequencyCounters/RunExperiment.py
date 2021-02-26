import subprocess, time, datetime, csv
from subprocess import STDOUT,PIPE
from datetime import datetime


def runJava(javaCmd, numRuns, printWords, fileName):
    """Runs a given word frequency Java program a given amount of times and prints
    the runtime of each run.

    Args:
        javaCmd (String): Command executed to run the Java program
        numRuns (Integer): Number of experiments to run
        printWords (Boolean): Whether or not the word frequencies should be printed
    """
    with open(fileName, "w") as csvFile:
        writer = csv.writer(csvFile)
        writer.writerow(["Run #", "Runtime", "Command"])

    for i in range(1, numRuns + 1):
        start = datetime.now()
        result = subprocess.run([javaCmd], shell = True, stdout = subprocess.PIPE, universal_newlines=True)
        if printWords:
            print(result.stdout)
            print()
        time = datetime.now()-start

        with open(fileName, "a") as csvFile:  
            writer = csv.writer(csvFile)
            writer.writerow([i, time, javaCmd])
        
        print("Run", i, ":", time)
        print()

    csvFile.close()

if __name__ == "__main__":
    runJava("java SequentialFreq book.txt text1.txt", 2, True, "testFile.csv")