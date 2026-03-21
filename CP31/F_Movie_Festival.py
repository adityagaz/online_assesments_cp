def main():
    n = int(input())
    time_dict = {}  
    for _ in range(n):
        start, end = map(int, input().split())
        time_dict[start] = end  
    sorted_times = sorted(time_dict.items(), key=lambda x: x[1])
    
    def check(k):
        if k == 0:
            return True
        e = sorted_times[0][1]  # First end time
        ans = 1
        for i in range(1, len(sorted_times)):
            curr_start, curr_end = sorted_times[i]
            if e <= curr_start:
                ans += 1
                e = curr_end
                if ans >= k:
                    return True
        return False
    left, right = 0, n
    max_k = 0
    while left <= right:
        mid = left + (right - left) // 2
        if check(mid):
            max_k = mid
            left = mid + 1
        else:
            right = mid - 1
    
    print(max_k)
main()