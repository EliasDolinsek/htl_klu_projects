import random


def get_random_numbers():
    result = []
    for i in range(100):
        result.append(random.randint(1, 100))

    return result


def do_bubble_sort(numbers: list):
    n = len(numbers)
    for i in range(n-1):
        for j in range(n-i-1):
            if(numbers[j] > numbers[j+1]):
                numbers[j], numbers[j+1] = numbers[j+1], numbers[j]

    return numbers


def partition(arr, low, high):
    i = (low-1)
    pivot = arr[high]

    for j in range(low, high):
        if arr[j] <= pivot:
            i = i+1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i+1], arr[high] = arr[high], arr[i+1]
    return (i+1)


def do_quick_sort(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)
        do_quick_sort(arr, low, pi-1)
        do_quick_sort(arr, pi+1, high)

    return arr

bubble_sort_nums = get_random_numbers()
print("###BEFORE###")
print(bubble_sort_nums)
print("###AFTER###")
print(do_bubble_sort(bubble_sort_nums))

print("\n\n")

quick_sort_nums = get_random_numbers()
print("###BEFORE###")
print(quick_sort_nums)
print("###AFTER###")
print(do_quick_sort(quick_sort_nums, 0, len(quick_sort_nums) - 1))
