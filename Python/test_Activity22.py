import pytest

def sum_test():
    num1=25
    num2=32

    sum=num1+num2

    assert sum==57

def diff_test():

    num1=25
    num2=10

    diff= num1-num2

    assert diff == 15

@pytest.marker.activity
def product_test():

    num1=10
    num2=10

    prod= num1*num2

    assert prod==100

@pytest.marker.activity
def div_test():
    num1=20
    num2=5

    div= num1/num2

    assert div==4



