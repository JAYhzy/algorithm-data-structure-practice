cmake_minimum_required(VERSION 3.23)
project(C___crucial)

set(CMAKE_CXX_STANDARD 14)


add_executable(double_linklist data_struct/double_linklist.cpp data_struct/binary_sort_tree.cpp data_struct/AVL.cpp)
add_executable(Huffman_Tree data_struct/Huffman_Tree.cpp)
add_executable(KMP data_struct/KMP.cpp)
add_executable(sequence_list data_struct/sequence_list.cpp)
add_executable(stack data_struct/stack.cpp)
add_executable(static_linklist data_struct/static_linklist.cpp)
add_executable(traversal data_struct/traversal_非递归中序.cpp)
add_executable(double_linklist_creat data_struct/增删改查double_linklist.cpp)
add_executable(static_linklist_creat data_struct/增删改查static_linklist.cpp)
add_executable(binary_sort_tree data_struct/binary_sort_tree.cpp)
add_executable(AVL data_struct/AVL.cpp)