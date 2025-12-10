import pytest
 

@pytest.fixture
def amount():
   amount = 0
   return amount
 
# Set up the paremeterized test method
@pytest.mark.parametrize("earned, spent, expected", [ (30, 10, 20), (20, 2, 18), ])
def test_transactions(amount, earned, spent, expected):
	
    # Add money to your wallet
    amount += earned
 
    # Subtract amount from wallet
    amount -= spent
 
    # Assertion
    assert amount == expected
