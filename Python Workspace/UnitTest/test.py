import unittest

from cap import func

class TestCas(unittest.TestCase):

	def check(self):
		self.assertEqual('a*4','aaaa')


	def one_word(self):
		text='python'
		result=func(text)
		self.assertEqual(result,'Python')

	def multiple_word(self):
		text='monty python'
		result=cap.func(text)
		self.assertEqual(result,'Monty Python')

if __name__ == '__main__':
			unittest.main()		