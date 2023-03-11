class DSU :
    def __init__(self, n: int):
        self.par = list(range(n))
        self.rnk = [0] * (n)
        self.c = 0
        
    def find(self, i: int) -> int:
            if self.par[i] != i:
                self.par[i] = self.find(self.par[i])
            return self.par[i]
        
    def same(self, i: int, j: int):
            return self.find(i) == self.find(j)
        
    def count(self) ->int :
        return self.c
    
    def merge(self, i: int, j: int) :
            i = self.find(i)
            j = self.find(j)
            
            if i == j:
                return
            else:
                c -= 1
            if self.rnk[i] > self.rnk[j]:
                i, j = j, i
            self.par[i] = j
            if self.rnk[i] == self.rnk[j]:
                self.rnk[j] += 1
