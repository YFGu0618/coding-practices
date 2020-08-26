#!/bin/bash
# LeetCode Solution No.0195.
# https://leetcode.com/problems/tenth-line
# Yifan Gu

# Read from the file file.txt and output the tenth line to stdout.
awk 'NR==10' file.txt
