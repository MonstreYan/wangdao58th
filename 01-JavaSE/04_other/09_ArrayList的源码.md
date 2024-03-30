# ArrayList的源码

1.elementData,底层是个数组。 它的初始长度是多少呢？

```JAVA
class ArrayList{
    
    // 底层存储数据的数组。
    Object[] elementData;
    
    // size. 实际存储的数据长度。
    int size;
   
    public ArrayList() {
        // private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
        // 空的。 
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    // 在构造方法里面，没有对elementData进行赋值。在什么时候，一定会进行赋值。 
    // 所以在，添加的时候一定要进行初始化。 否则肯定会报错。   ===》 add
   
    //                  "zs"
   public boolean add(E e) {
        modCount++;
       //   zs     {}         0 
        add(e, elementData, size);
        return true;
    }
    
    //                 zs               {}          0
    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            // 增长，扩容。 
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }
    
    
    private Object[] grow() {
        //           0+1
        return grow(size + 1);
    }
   
    	
   //   							1
   private Object[] grow(int minCapacity) {
       // oldCapacity = 0
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            // JDK 。 
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            // Math.max(DEFAULT_CAPACITY, minCapacity) 
            //                   10        1
            // 初始化长度为10.
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }
    
}
```









2.数组是怎么扩容的，扩容的策略。 



```JAVA
class ArrayList{
    
    // 底层存储数据的数组。
    Object[] elementData;
    
    // size. 实际存储的数据长度。
    int size;

    
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }
    
    public E remove(int index) {
        // 检查下标。 
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        // elementData    要删除的下标
        fastRemove(es, index);

        return oldValue;
    }
    
    
    // 			             elementData     index
    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            // src   srcPos 
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }
    
    
}
```





