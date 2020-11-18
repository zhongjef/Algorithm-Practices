if __name__ == '__main__':
    sum = 0
    for i in range(1, 100000):
        if "11" in str(i):
            sum += 1
    print(sum)