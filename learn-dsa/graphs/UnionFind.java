class UnionFind {
  private int[] root;

  // constructor to initialize each element's root as it's own
  public UnionFind(int size){
    root = new int[size];

    for(int i = 0; i < size; i++){
      root[i] = i;
    }
  }

  // keep searching until the root is the same as the element
  public int find(int x){
    while(root[x] != x){
      x = root[x];
    }
    return x;
  }

  public void union(int x, int y){
    int rootX = find(x);
    int rootY = find(y);
    if(rootX != rootY){
      root[rootY] = rootX;
    }
  }

  public boolean connected(int x, int y){
    return find(x) == find(y);
  }
  public static void main(String[] args){
    UnionFind uf = new UnionFind(10);

    uf.union(1,2);
    uf.union(2,5);
    uf.union(5,6);
    uf.union(6,7);
    uf.union(3,8);
    uf.union(8,9);

    System.out.println(uf.connected(1,5));
  }
}