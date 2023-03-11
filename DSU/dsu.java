class DSU {
  private int[] par;
  private int[] rnk;
  private int c;
  public DSU(int n) {
      par = new int[n+1];
      rnk = new int[n+1];
      c=n;
      for (int i = 1; i <= n; ++i) par[i] = i;
  }
  public int find(int i) {
    return (par[i] == i ? i : (par[i] = find(par[i])));
  }
  public boolean same(int i, int j) {
    return find(i) == find(j);
  }
  public void swap(int i, int j){
      int temp = i;
      i = j;
      j = temp;
  }
  public int count(){
      return c;
  }
  public Boolean merge(int i, int j) {
    if ((i = find(i)) == (j = find(j))) {
        c --;
        return false;
    }
    if (rnk[i] > rnk[j]) swap(i, j);
    par[i] = j;
    if (rnk[i] == rnk[j]) rnk[j]++;
    return true;
  }
};
