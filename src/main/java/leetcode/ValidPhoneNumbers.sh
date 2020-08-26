#!/bin/bash
# LeetCode Solution No.0193.
# https://leetcode.com/problems/valid-phone-numbers
# Yifan Gu

# Read from the file file.txt and output all valid phone numbers to stdout.
awk '/^([0-9]{3}-|\([0-9]{3}\))[0-9]{3}-[0-9]{4}$/' file.txt
