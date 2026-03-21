n = int(input())
arr = input().split()
arr = [int(i) for i in arr]
sum = sum(arr)
print((n * (n + 1) // 2) - sum)

