#!/bin/bash
# LeetCode Solution No.0192.
# https://leetcode.com/problems/word-frequency
# Yifan Gu

# Read from the file words.txt and output the word frequency list to stdout.
awk '\
{
  for (i = 1; i <= NF; i++) {
    ++D[$i];
  }
}
END {
  for (i in D) {
    print i, D[i]
  }
}' words.txt | sort -nr -k 2
