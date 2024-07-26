def can_place_cows(stalls, n_cows, min_dist):
    count = 1
    last_position = stalls[0]
    
    for i in range(1, len(stalls)):
        if stalls[i] - last_position >= min_dist:
            count += 1
            last_position = stalls[i]
            if count >= n_cows:
                return True
    return False

def largest_minimum_distance(n, c, stalls):
    stalls.sort()
    
    left = 0
    right = stalls[-1] - stalls[0]
    result = 0
    
    while left <= right:
        mid = (left + right) // 2
        
        if can_place_cows(stalls, c, mid):
            result = mid
            left = mid + 1
        else:
            right = mid - 1
    
    return result

def main():
    t = int(input())
    for _ in range(t):
        n, c = map(int, input().split())
        stalls = [int(input()) for _ in range(n)]
        print(largest_minimum_distance(n, c, stalls))

if __name__ == "__main__":
    main()
