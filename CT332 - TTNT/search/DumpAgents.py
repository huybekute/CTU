from game import Agent, Directions

# class DumpAgents(Agent):
#     def getAction(self, state):
#         return Directions.EAST

# class DumpAgents(Agent):
#     def getAction(self, state):
#         print("Location: ", state.getPacmanPosition())
#         print("Action hientai: ", state.getLegalPacmanActions())
#         if(Directions.EAST in state.getLegalPacmanActions()):
#             print("di ve phia dong")
#             return Directions.EAST
#         else:
#             print("dung lai")
#             return Directions.STOP

import random

class DumpAgents(Agent):
    def getAction(self, state):
        return random.choice(state.getLegalPacmanActions())
