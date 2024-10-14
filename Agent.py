from Connect4State import Piece, ConnectFourState
import copy
import random
class Agent:


#this constructor should not take any parameters
#You can change the body of the constructor
#if you want/need to
	def __init__(self):
		return


#this method's header should not change
#This is the main method you'll be implementing
#it should return the number of the column where
#the next move will be made.
#This method can only take 5 seconds or less to run
#Any more and the game will immediately end
#and the other player will win by default
	def getNextMove(self, gameState):
		count = 0
		myColor = 1
		for i in range(len(gameState.board)):
			for j in range(len(gameState.board[i])):
				if gameState.board[i][j] == Piece.RED or gameState.board[i][j] == Piece.YELLOW:
					count = count + 1
					if(count%2==0):
						#red
						myColor = 1
					else:
						#yellow
						myColor = 2
		return self.pickNextBoard(gameState, myColor)


	def heuristic(self,gameState):
		scoreForRed = 0
		scoreForYellow = 0
		for i in range(gameState.numCols - gameState.connectNum + 1):
			for j in range(gameState.colHeight):
				pieces = [gameState.board[i + k][j] for k in range(gameState.connectNum)]
				if all([k == pieces[0] for k in pieces]) and pieces[0] != Piece.UNFILLED:
					if (pieces[0] == Piece.RED):
						scoreForRed += 10000
					else:
						scoreForYellow += 10000
		for i in range(gameState.numCols):
			for j in range(gameState.colHeight - gameState.connectNum + 1):
				pieces = [gameState.board[i][j + k] for k in range(gameState.connectNum)]
				if all([k == pieces[0] for k in pieces]) and pieces[0] != Piece.UNFILLED:
					if (pieces[0] == Piece.RED):
						scoreForRed += 10000
					else:
						scoreForYellow += 10000
		for i in range(gameState.numCols - gameState.connectNum + 1):
			for j in range(gameState.colHeight - gameState.connectNum + 1):
				pieces = [gameState.board[i + k][j + k] for k in range(gameState.connectNum)]
				if all([k == pieces[0] for k in pieces]) and pieces[0] != Piece.UNFILLED:
					if (pieces[0] == Piece.RED):
						scoreForRed += 10000
					else:
						scoreForYellow += 10000
		for i in range(gameState.numCols - gameState.connectNum + 1):
			for j in range(gameState.connectNum - 1, gameState.colHeight):
				pieces = [gameState.board[i + k][j - k] for k in range(gameState.connectNum)]
				if all([k == pieces[0] for k in pieces]) and pieces[0] != Piece.UNFILLED:
					if (pieces[0] == Piece.RED):
						scoreForRed += 10000
					else:
						scoreForYellow += 10000
		# allindexOfMoves
		indexsOfMoves = []
		for i in range(gameState.numCols):
			indexsOfMoves.append(0)
		for i in range(gameState.numCols):
			if (gameState.board[i][0] != Piece.UNFILLED):
				indexsOfMoves[i] = -1
			else:
				for k in range((gameState.colHeight) - 1):
					if (gameState.board[i][k] == Piece.UNFILLED and (
						gameState.board[i][k + 1] == Piece.RED or gameState.board[i][k + 1] == Piece.YELLOW)):
						indexsOfMoves[i] = k
		for i in range(len(indexsOfMoves)):
			if (gameState.board[i][5] == Piece.UNFILLED and indexsOfMoves[i] == 0):
				indexsOfMoves[i] = 5

		# Ones for red
		for i in range(gameState.numCols):
			for j in range(gameState.colHeight):
				if ((i != 0 and i != 6) and (j != 0 and j != 5)):
		# if it's just a one
		# print(j)
					if (gameState.board[i][j] == Piece.RED and
				gameState.board[i][j - 1] != Piece.RED and
				gameState.board[i][j + 1] != Piece.RED and
				gameState.board[i - 1][j - 1] != Piece.RED and
				gameState.board[i + 1][j - 1] != Piece.RED and
				gameState.board[i - 1][j] != Piece.RED and
				gameState.board[i + 1][j] != Piece.RED and
				gameState.board[i + 1][j + 1] != Piece.RED and
				gameState.board[i - 1][j + 1] != Piece.RED):
						if (j == indexsOfMoves[i] or
					j == indexsOfMoves[i + 1] or
					j == indexsOfMoves[i + 1] + 1 or
					j == indexsOfMoves[i + 1] + 2 or
					j == indexsOfMoves[i - 1] or
					j == indexsOfMoves[i - 1] + 1 or
					j == indexsOfMoves[i - 1] + 2):
							scoreForRed += 1
						else:
							scoreForRed += 0.5
				else:
					if j == 0 and i == 0:
						if (gameState.board[i][j] == Piece.RED and
					gameState.board[i][j + 1] != Piece.RED and
					gameState.board[i + 1][j + 1] != Piece.RED and
					gameState.board[i + 1][j] != Piece.RED):
							if (j == indexsOfMoves[i + 1] + 1 or
						j == indexsOfMoves[i + 1] + 2):
								scoreForRed += 1
							else:
								scoreForRed += 0.5
					else:
						if i == 0 and j == 5:
							if (gameState.board[i][j] == Piece.RED and
					gameState.board[i][j - 1] != Piece.RED and
					gameState.board[i + 1][j - 1] != Piece.RED and
					gameState.board[i + 1][j] != Piece.RED):
								if (j == indexsOfMoves[i] or
						j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i + 1] + 1):
									scoreForRed += 1
								else:
									scoreForRed += 0.5
						else:
							if i == 6 and j == 0:
								if (gameState.board[i][j] == Piece.RED and
					gameState.board[i - 1][j] != Piece.RED and
					gameState.board[i - 1][j + 1] != Piece.RED and
					gameState.board[i][j + 1] != Piece.RED):
									if (j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] + 1):
										scoreForRed += 1
									else:
										scoreForRed += 0.5
							else:
								if i == 6 and j == 5:
									if (gameState.board[i][j] == Piece.RED and
					gameState.board[i - 1][j] != Piece.RED and
					gameState.board[i - 1][j - 1] != Piece.RED and
					gameState.board[i][j - 1] != Piece.RED):
										if (j == indexsOfMoves[i] or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] + 1):
											scoreForRed += 1
										else:
											scoreForRed += 0.5
								else:
									if (i != 0 or i != 6) and j == 0:
										if (gameState.board[i][j] == Piece.RED and
					gameState.board[i - 1][j] != Piece.RED and
					gameState.board[i - 1][j + 1] != Piece.RED and
					gameState.board[i][j + 1] != Piece.RED and
					gameState.board[i + 1][j + 1] != Piece.RED and
					gameState.board[i + 1][j] != Piece.RED):
											if (j == indexsOfMoves[i + 1] + 1 or
						j == indexsOfMoves[i + 1] + 2 or
						j == indexsOfMoves[i - 1] + 1 or
						j == indexsOfMoves[i - 1] + 2):
												scoreForRed += 1
											else:
												scoreForRed += 0.5
									else:
										if (j != 0 or j != 5) and i == 6:
											if (gameState.board[i][j] == Piece.RED and
					gameState.board[i][j - 1] != Piece.RED and
					gameState.board[i - 1][j - 1] != Piece.RED and
					gameState.board[i - 1][j] != Piece.RED and
					gameState.board[i - 1][j + 1] != Piece.RED and
					gameState.board[i][j + 1] != Piece.RED):
												if (j == indexsOfMoves[i] or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] + 1 or
						j == indexsOfMoves[i - 1] + 2):
													scoreForRed += 1
												else:
													scoreForRed += 0.5
										else:
											if (i != 0 or i != 6) and j == 5:
												if (gameState.board[i][j] == Piece.RED and
					gameState.board[i - 1][j] != Piece.RED and
					gameState.board[i - 1][j - 1] != Piece.RED and
					gameState.board[i][j - 1] != Piece.RED and
					gameState.board[i + 1][j - 1] != Piece.RED and
					gameState.board[i + 1][j] != Piece.RED):
														if (j == indexsOfMoves[i] or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i - 1] + 1 or
						j == indexsOfMoves[i + 1] + 1):
															scoreForRed += 1
														else:
															scoreForRed += 0.5
											else:
												if (gameState.board[i][j] == Piece.RED and
				gameState.board[i][j + 1] != Piece.RED and
				gameState.board[i + 1][j + 1] != Piece.RED and
				gameState.board[i + 1][j] != Piece.RED and
				gameState.board[i + 1][j - 1] != Piece.RED and
				gameState.board[i][j - 1] != Piece.RED):
													if (j == indexsOfMoves[i] or
					j == indexsOfMoves[i + 1] or
					j == indexsOfMoves[i + 1] + 1 or
					j == indexsOfMoves[i + 1] + 2):
														scoreForRed += 1
													else:
														scoreForRed += 0.5

		##ones for Yellow
		for i in range(gameState.numCols):
			for j in range(gameState.colHeight):
				if ((i != 0 and i != 6) and (j != 0 and j != 5)):
		# if it's just a one
					if (gameState.board[i][j] == Piece.YELLOW and
				gameState.board[i][j - 1] != Piece.YELLOW and
				gameState.board[i][j + 1] != Piece.YELLOW and
				gameState.board[i - 1][j - 1] != Piece.YELLOW and
				gameState.board[i + 1][j - 1] != Piece.YELLOW and
				gameState.board[i - 1][j] != Piece.YELLOW and
				gameState.board[i + 1][j] != Piece.YELLOW and
				gameState.board[i + 1][j + 1] != Piece.YELLOW and
				gameState.board[i - 1][j + 1] != Piece.YELLOW):
						if (j == indexsOfMoves[i - 1] or
					j == indexsOfMoves[i + 1] or
					j == indexsOfMoves[i + 1] - 1 or
					j == indexsOfMoves[i - 1] - 1 or
					j == indexsOfMoves[i - 1] + 1 or
					j == indexsOfMoves[i + 1] + 1):
							scoreForYellow += 1
						else:
							scoreForYellow += 0.5
				else:
					if j == 0 and i == 0:
						if (gameState.board[i][j] == Piece.YELLOW and
					gameState.board[i][j + 1] != Piece.YELLOW and
					gameState.board[i + 1][j + 1] != Piece.YELLOW and
					gameState.board[i + 1][j] != Piece.YELLOW):
							if (j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i + 1] + 1):
								scoreForYellow += 1
							else:
								scoreForYellow += 0.5
					else:
						if i == 0 and j == 5:
							if (gameState.board[i][j] == Piece.YELLOW and
					gameState.board[i][j - 1] != Piece.YELLOW and
					gameState.board[i + 1][j - 1] != Piece.YELLOW and
					gameState.board[i + 1][j] != Piece.YELLOW):
								if (j == indexsOfMoves[i] - 1 or
						j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i + 1] - 1):
									scoreForYellow += 1
								else:
									scoreForYellow += 0.5
						else:
							if i == 6 and j == 0:
								if (gameState.board[i][j] == Piece.YELLOW and
					gameState.board[i - 1][j] != Piece.YELLOW and
					gameState.board[i - 1][j + 1] != Piece.YELLOW and
					gameState.board[i][j + 1] != Piece.YELLOW):
									if (j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] - 1):
										scoreForYellow += 1
									else:
										scoreForYellow += 0.5
							else:
								if i == 6 and j == 5:
									if (gameState.board[i][j] == Piece.YELLOW and
					gameState.board[i - 1][j] != Piece.YELLOW and
					gameState.board[i - 1][j - 1] != Piece.YELLOW and
					gameState.board[i][j - 1] != Piece.YELLOW):
										if (j == indexsOfMoves[i] - 1 or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] - 1):
											scoreForYellow += 1
										else:
											scoreForYellow += 0.5
								else:
									if (i != 0 or i != 6) and j == 0:
										if (gameState.board[i][j] == Piece.YELLOW and
					gameState.board[i - 1][j] != Piece.YELLOW and
					gameState.board[i - 1][j + 1] != Piece.YELLOW and
					gameState.board[i][j + 1] != Piece.YELLOW and
					gameState.board[i + 1][j + 1] != Piece.YELLOW and
					gameState.board[i + 1][j] != Piece.YELLOW):
											if (j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] + 1 or
						j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i + 1] + 1):
												scoreForYellow += 1
											else:
												scoreForYellow += 0.5
									else:
										if (j != 0 or j != 5) and i == 6:
											if (gameState.board[i][j] == Piece.YELLOW and
					gameState.board[i][j - 1] != Piece.YELLOW and
					gameState.board[i - 1][j - 1] != Piece.YELLOW and
					gameState.board[i - 1][j] != Piece.YELLOW and
					gameState.board[i - 1][j + 1] != Piece.YELLOW and
					gameState.board[i][j + 1] != Piece.YELLOW):
												if (j == indexsOfMoves[i] - 1 or
						j == indexsOfMoves[i - 1] - 1 or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] + 1):
													scoreForYellow += 1
												else:
													scoreForYellow += 0.5
										else:
											if (i != 0 or i != 6) and j == 5:
												if (gameState.board[i][j] == Piece.YELLOW and
					gameState.board[i - 1][j] != Piece.YELLOW and
					gameState.board[i - 1][j - 1] != Piece.YELLOW and
					gameState.board[i][j - 1] != Piece.YELLOW and
					gameState.board[i + 1][j - 1] != Piece.YELLOW and
					gameState.board[i + 1][j] != Piece.YELLOW):
													if (j == indexsOfMoves[i] - 1 or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i - 1] - 1 or
						j == indexsOfMoves[i + 1] - 1):
														scoreForYellow += 1
													else:
														scoreForYellow += 0.5
		else:
			if (gameState.board[i][j] == Piece.YELLOW and
				gameState.board[i][j + 1] != Piece.YELLOW and
				gameState.board[i + 1][j + 1] != Piece.YELLOW and
				gameState.board[i + 1][j] != Piece.YELLOW and
				gameState.board[i + 1][j - 1] != Piece.YELLOW and
				gameState.board[i][j - 1] != Piece.YELLOW):
				if (j == indexsOfMoves[i] - 1 or
					j == indexsOfMoves[i + 1] - 1 or
					j == indexsOfMoves[i + 1] or
					j == indexsOfMoves[i + 1] + 1):
					scoreForYellow += 1
				else:
					scoreForYellow += 0.5

		for i in range(gameState.numCols):
			for j in range(gameState.colHeight):
				if ((i != 0 and i != 6) and (j != 0 and j != 5)):
		# if it's just a one
		# print(j)
					if (gameState.board[i][j] == Piece.RED and
				(gameState.board[i][j - 1] == Piece.RED or
				 gameState.board[i][j + 1] == Piece.RED or
				 gameState.board[i - 1][j - 1] == Piece.RED or
				 gameState.board[i + 1][j - 1] == Piece.RED or
				 gameState.board[i - 1][j] == Piece.RED or
				 gameState.board[i + 1][j] == Piece.RED or
				 gameState.board[i + 1][j + 1] == Piece.RED or
				 gameState.board[i - 1][j + 1] == Piece.RED)):
						if (j == indexsOfMoves[i] or
					j == indexsOfMoves[i + 1] or
					j == indexsOfMoves[i + 1] + 1 or
					j == indexsOfMoves[i + 1] + 2 or
					j == indexsOfMoves[i - 1] or
					j == indexsOfMoves[i - 1] + 1 or
					j == indexsOfMoves[i - 1] + 2):
							scoreForRed += 3
						else:
							scoreForRed += 1.5
				else:
					if j == 0 and i == 0:
						if (gameState.board[i][j] == Piece.RED and
					(gameState.board[i][j + 1] == Piece.RED or
					 gameState.board[i + 1][j + 1] == Piece.RED or
					 gameState.board[i + 1][j] == Piece.RED)):
							if (j == indexsOfMoves[i + 1] + 1 or
						j == indexsOfMoves[i + 1] + 2):
								scoreForRed += 3
							else:
								scoreForRed += 1.5
					else:
						if i == 0 and j == 5:
							if (gameState.board[i][j] == Piece.RED and
					(gameState.board[i][j - 1] == Piece.RED or
					 gameState.board[i + 1][j - 1] == Piece.RED or
					 gameState.board[i + 1][j] == Piece.RED)):
								if (j == indexsOfMoves[i] or
						j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i + 1] + 1):
									scoreForRed += 3
								else:
									scoreForRed += 1.5
						else:
							if i == 6 and j == 0:
								if (gameState.board[i][j] == Piece.RED and
					(gameState.board[i - 1][j] == Piece.RED or
					 gameState.board[i - 1][j + 1] == Piece.RED or
					 gameState.board[i][j + 1] == Piece.RED)):
									if (j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] + 1):
										scoreForRed += 3
									else:
										scoreForRed += 1.5
							else:
								if i == 6 and j == 5:
									if (gameState.board[i][j] == Piece.RED and
					(gameState.board[i - 1][j] == Piece.RED or
					 gameState.board[i - 1][j - 1] == Piece.RED or
					 gameState.board[i][j - 1] == Piece.RED)):
										if (j == indexsOfMoves[i] or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] + 1):
											scoreForRed += 3
										else:
											scoreForRed += 1.5
								else:
									if (i != 0 or i != 6) and j == 0:
										if (gameState.board[i][j] == Piece.RED and
					(gameState.board[i - 1][j] == Piece.RED or
					 gameState.board[i - 1][j + 1] == Piece.RED or
					 gameState.board[i][j + 1] == Piece.RED or
					 gameState.board[i + 1][j + 1] == Piece.RED or
					 gameState.board[i + 1][j] == Piece.RED)):
											if (j == indexsOfMoves[i + 1] + 1 or
						j == indexsOfMoves[i + 1] + 2 or
						j == indexsOfMoves[i - 1] + 1 or
						j == indexsOfMoves[i - 1] + 2):
												scoreForRed += 3
											else:
												scoreForRed += 1.5
									else:
										if (j != 0 or j != 5) and i == 6:
											if (gameState.board[i][j] == Piece.RED and
					(gameState.board[i][j - 1] == Piece.RED or
					 gameState.board[i - 1][j - 1] == Piece.RED or
					 gameState.board[i - 1][j] == Piece.RED or
					 gameState.board[i - 1][j + 1] == Piece.RED or
					 gameState.board[i][j + 1] == Piece.RED)):
												if (j == indexsOfMoves[i] or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] + 1 or
						j == indexsOfMoves[i - 1] + 2):
													scoreForRed += 3
												else:
													scoreForRed += 1.5
										else:
											if (i != 0 or i != 6) and j == 5:
												if (gameState.board[i][j] == Piece.RED and
					(gameState.board[i - 1][j] == Piece.RED or
					 gameState.board[i - 1][j - 1] == Piece.RED or
					 gameState.board[i][j - 1] == Piece.RED or
					 gameState.board[i + 1][j - 1] == Piece.RED or
					 gameState.board[i + 1][j] == Piece.RED)):
													if (j == indexsOfMoves[i] or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i - 1] + 1 or
						j == indexsOfMoves[i + 1] + 1):
														scoreForRed += 3
													else:
														scoreForRed += 1.5
											else:
												if (gameState.board[i][j] == Piece.RED and
				(gameState.board[i][j + 1] == Piece.RED or
				 gameState.board[i + 1][j + 1] == Piece.RED or
				 gameState.board[i + 1][j] == Piece.RED or
				 gameState.board[i + 1][j - 1] == Piece.RED or
				 gameState.board[i][j - 1] == Piece.RED)):
													if (j == indexsOfMoves[i] or
					j == indexsOfMoves[i + 1] or
					j == indexsOfMoves[i + 1] + 1 or
					j == indexsOfMoves[i + 1] + 2):
														scoreForRed += 3
													else:
														scoreForRed += 1.5

		##ones for Yellow
		for i in range(gameState.numCols):
			for j in range(gameState.colHeight):
				if ((i != 0 and i != 6) and (j != 0 and j != 5)):
		# if it's just a one
					if (gameState.board[i][j] == Piece.YELLOW and
				(gameState.board[i][j - 1] == Piece.YELLOW or
				 gameState.board[i][j + 1] == Piece.YELLOW or
				 gameState.board[i - 1][j - 1] == Piece.YELLOW or
				 gameState.board[i + 1][j - 1] == Piece.YELLOW or
				 gameState.board[i - 1][j] == Piece.YELLOW or
				 gameState.board[i + 1][j] == Piece.YELLOW or
				 gameState.board[i + 1][j + 1] == Piece.YELLOW or
				 gameState.board[i - 1][j + 1] == Piece.YELLOW)):
						if (j == indexsOfMoves[i - 1] or
					j == indexsOfMoves[i + 1] or
					j == indexsOfMoves[i + 1] - 1 or
					j == indexsOfMoves[i - 1] - 1 or
					j == indexsOfMoves[i - 1] + 1 or
					j == indexsOfMoves[i + 1] + 1):
							scoreForYellow += 3
						else:
							scoreForYellow += 1.5
				else:
					if j == 0 and i == 0:
						if (gameState.board[i][j] == Piece.YELLOW and
					(gameState.board[i][j + 1] == Piece.YELLOW or
					 gameState.board[i + 1][j + 1] == Piece.YELLOW or
					 gameState.board[i + 1][j] == Piece.YELLOW)):
							if (j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i + 1] + 1):
								scoreForYellow += 3
							else:
								scoreForYellow += 1.5
					else:
						if i == 0 and j == 5:
							if (gameState.board[i][j] == Piece.YELLOW and
					gameState.board[i][j - 1] != Piece.YELLOW and
					gameState.board[i + 1][j - 1] != Piece.YELLOW and
					gameState.board[i + 1][j] != Piece.YELLOW):
								if (j == indexsOfMoves[i] - 1 or
						j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i + 1] - 1):
									scoreForYellow += 3
								else:
									scoreForYellow += 1.5
						else:
							if i == 6 and j == 0:
								if (gameState.board[i][j] == Piece.YELLOW and
					(gameState.board[i - 1][j] == Piece.YELLOW or
					 gameState.board[i - 1][j + 1] == Piece.YELLOW or
					 gameState.board[i][j + 1] == Piece.YELLOW)):
									if (j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] - 1):
										scoreForYellow += 3
									else:
										scoreForYellow += 1.5
							else:
								if i == 6 and j == 5:
									if (gameState.board[i][j] == Piece.YELLOW and
					(gameState.board[i - 1][j] == Piece.YELLOW or
					 gameState.board[i - 1][j - 1] == Piece.YELLOW or
					 gameState.board[i][j - 1] == Piece.YELLOW)):
										if (j == indexsOfMoves[i] - 1 or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] - 1):
											scoreForYellow += 3
										else:
											scoreForYellow += 1.5
								else:
									if (i != 0 or i != 6) and j == 0:
										if (gameState.board[i][j] == Piece.YELLOW and
					(gameState.board[i - 1][j] == Piece.YELLOW or
					 gameState.board[i - 1][j + 1] == Piece.YELLOW or
					 gameState.board[i][j + 1] == Piece.YELLOW or
					 gameState.board[i + 1][j + 1] == Piece.YELLOW or
					 gameState.board[i + 1][j] == Piece.YELLOW)):
											if (j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] + 1 or
						j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i + 1] + 1):
												scoreForYellow += 3
											else:
												scoreForYellow += 1.5
									else:
										if (j != 0 or j != 5) and i == 6:
											if (gameState.board[i][j] == Piece.YELLOW and
					(gameState.board[i][j - 1] == Piece.YELLOW or
					 gameState.board[i - 1][j - 1] == Piece.YELLOW or
					 gameState.board[i - 1][j] == Piece.YELLOW or
					 gameState.board[i - 1][j + 1] == Piece.YELLOW or
					 gameState.board[i][j + 1] == Piece.YELLOW)):
												if (j == indexsOfMoves[i] - 1 or
						j == indexsOfMoves[i - 1] - 1 or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i - 1] + 1):
													scoreForYellow += 3
												else:
													scoreForYellow += 1.5
										else:
											if (i != 0 or i != 6) and j == 5:
												if (gameState.board[i][j] == Piece.YELLOW and
					(gameState.board[i - 1][j] == Piece.YELLOW or
					 gameState.board[i - 1][j - 1] == Piece.YELLOW or
					 gameState.board[i][j - 1] == Piece.YELLOW or
					 gameState.board[i + 1][j - 1] == Piece.YELLOW or
					 gameState.board[i + 1][j] == Piece.YELLOW)):
													if (j == indexsOfMoves[i] - 1 or
						j == indexsOfMoves[i - 1] or
						j == indexsOfMoves[i + 1] or
						j == indexsOfMoves[i - 1] - 1 or
						j == indexsOfMoves[i + 1] - 1):
														scoreForYellow += 3
													else:
														scoreForYellow += 1.5
											else:
												if (gameState.board[i][j] == Piece.YELLOW and
				(gameState.board[i][j + 1] == Piece.YELLOW or
				 gameState.board[i + 1][j + 1] == Piece.YELLOW or
				 gameState.board[i + 1][j] == Piece.YELLOW or
				 gameState.board[i + 1][j - 1] == Piece.YELLOW or
				 gameState.board[i][j - 1] == Piece.YELLOW)):
													if (j == indexsOfMoves[i] - 1 or
					j == indexsOfMoves[i + 1] - 1 or
					j == indexsOfMoves[i + 1] or
					j == indexsOfMoves[i + 1] + 1):
														scoreForYellow += 3
													else:
														scoreForYellow += 1.5

		return scoreForRed - scoreForYellow


	def pickNextBoard(self, gameState, color):
		temp = copy.deepcopy(gameState.board)


		indexOfMoves = []
		testerGames = []
		for i in range(gameState.numCols):
			testerGames.append(copy.deepcopy(gameState.board))
			for k in range(gameState.colHeight - 1):
				if gameState.board[i][k] == Piece.UNFILLED and gameState.board[i][k + 1] != Piece.UNFILLED:
					indexOfMoves.append(k)
				else:
					indexOfMoves.append(-1)


		for i in range(len(testerGames)):
			temp = copy.deepcopy(testerGames[i])
			if indexOfMoves[i] != -1:
				if color == 1:
					temp[i][indexOfMoves[i]] = Piece.RED
				else:
					temp[i][indexOfMoves[i]] = Piece.YELLOW
			testerGames[i] = copy.deepcopy(temp)


		indexOfMoves2D = []
		testerGames2D = []


		for i in range(len(testerGames)):
			indexOfMoves2D.append([])
			testerGames2D.append([])

		for j in range(len(testerGames)):
			for i in range(gameState.numCols):
				testerGames2D[j].append(copy.deepcopy(testerGames[j]))
				for k in range(gameState.colHeight - 1):
					if testerGames2D[j][i][k] == Piece.UNFILLED and testerGames2D[j][i][k + 1] != Piece.UNFILLED:
						indexOfMoves2D[j].append(k)
					else:
						indexOfMoves2D[j].append(-1)

		print(testerGames2D)
		for i in range(len(testerGames2D)):
			for j in range(len(testerGames2D)):
				temp = copy.deepcopy(testerGames2D[i][j])
				if indexOfMoves2D[i][j] != -1:
					if color != 1:
						temp[i][indexOfMoves2D[i][j]] = Piece.RED
					else:
						temp[i][indexOfMoves2D[i][j]] = Piece.YELLOW
				testerGames2D[i][j] = copy.deepcopy(temp)


		numbers2D = copy.deepcopy(testerGames2D)
		for i in range(len(testerGames2D)):
			for j in range(len(testerGames2D)):
				myGameStateObj = ConnectFourState(numCols = 7, colHeight = 6, connectNum = 4, pieceWidth = 50)
				myGameStateObj.board = copy.deepcopy(testerGames2D[i][j])
				numbers2D[i][j] = self.heuristic(myGameStateObj)

		indexsOfMoves = []
		for i in range(gameState.numCols):
			indexsOfMoves.append(0)
		for i in range(gameState.numCols):
			if (gameState.board[i][0] != Piece.UNFILLED):
				indexsOfMoves[i] = -1
			else:
				for k in range((gameState.colHeight) - 1):
					if (gameState.board[i][k] == Piece.UNFILLED and (
							gameState.board[i][k + 1] == Piece.RED or gameState.board[i][k + 1] == Piece.YELLOW)):
						indexsOfMoves[i] = k
		for i in range(len(indexsOfMoves)):
			if (gameState.board[i][5] == Piece.UNFILLED and indexsOfMoves[i] == 0):
				indexsOfMoves[i] = 5

		numbers1D = []
		for i in range(gameState.numCols):
			numbers1D.append(min(numbers2D[i]))
		for i in range(len(indexsOfMoves)):
			if(indexsOfMoves[i]==-1):
				numbers1D[i]=-10000
		return numbers1D.index(max(numbers1D))