class ProductOfNumbers {

     List<Integer> l;
    public ProductOfNumbers() {
        l=new ArrayList();
    }
    
    public void add(int num) {
        l.add(num);
    }
    
    public int getProduct(int k) {
        int i=l.size()-1;int p=1;
        while(k>0)
        {
            p=p*l.get(i);
            i--;
            k--;
        }
        return p;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */