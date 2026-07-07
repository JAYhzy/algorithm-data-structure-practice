cmake_minimum_required(VERSION 3.23)
project(algorithm_1)

set(CMAKE_CXX_STANDARD 14)


add_executable(binary_search algorithm/Search/binary_search.cpp )

add_executable(radix_sort.cpp algorithm/Sort/radix_sort.cpp ..)
add_executable(merge_sort algorithm/Sort/merge_sort.cpp ..)
add_executable(counting_sort algorithm/Sort/counting_sort.cpp ..)
add_executable(insert_sort algorithm/Sort/insert_sort.cpp ..)
add_executable(quik_sort algorithm/Sort/quik_sort.cpp ..)
add_executable(select_sort algorithm/Sort/select_sort.cpp ..)

add_executable(high_precision_factorial algorithm/high_precision_factorial.cpp ..)