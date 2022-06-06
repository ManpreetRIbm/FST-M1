# Using pytest: Create a new test file and write test to validate the following cases:

import pytest

def test_addition():
    num1=100
    num2=40

    sum = num1+num2
    assert sum == 140

def test_subtraction():
    num1=15
    num2=30

    diffs = num1-num2
    assert diffs == -15

def test_multiplication():
    num1=20
    num2=4

    mult = num1*num2
    assert mult == 80

def test_division():
    num1=40
    num2=10

    divisn = num1/num2
    assert divisn == 4