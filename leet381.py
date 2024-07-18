import random
class RandomizedCollection:

    def __init__(self):
        self.dict1 = defaultdict(int)
        self.values =[]
        

    def insert(self, val: int) -> bool:
        self.values.append(val)
        self.dict1[val]+=1
        if self.dict1[val]!=1:
            return False
        return True
        
    def remove(self, val: int) -> bool:
        if self.dict1[val]!=0:
            self.values.remove(val)
            self.dict1[val]-=1
            return True
        return False
        

    def getRandom(self) -> int:
        return random.choice(self.values)
        


# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
