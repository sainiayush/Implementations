class DSU {
  private int[] par;
  private int[] rnk;
  private int[] sz;
  private int c;
  public DSU(int n) {
      par = new int[n+1];
      rnk = new int[n+1];
      sz = new int[n+1];
      c=n;
      sz[0]=1;
      for (int i = 1; i <= n; ++i) {
        par[i] = i;
        sz[i] = 1;
      }
  }
  public int find(int i) {
    return (par[i] == i ? i : (par[i] = find(par[i])));
  }
  public int get_size(int i){
    return sz[find(i)];
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
    if ((i = find(i)) == (j = find(j))) return false;
    else --c;
    if (rnk[i] > rnk[j]) swap(i, j);
    par[i] = j;
    sz[j] += sz[i];
    if (rnk[i] == rnk[j]) rnk[j]++;
    return true;
  }
};
