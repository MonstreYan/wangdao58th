

ArrayDeque是一个循环数组。 

```JAVA
class ArrayDeque{
    // 底层用来存储数据的数组。 
    Object[] elements;
    
    // 指示头的
    int head;
    
    // 指示尾的
    int tail;
    
    public ArrayDeque() {
        elements = new Object[16];
    }
    
    // 添加方法。 
    public void addLast(E e) {
        if (e == null)
            throw new NullPointerException();
        // 直接把数据存到 tail 所在的位置。 
        elements[tail] = e;
        // 把tail的结果 +1。 对length进行取余。 
        if ( (tail = (tail + 1) & (elements.length - 1)) == head)
            // 双倍扩容。 
            doubleCapacity();
    }
    
    
    // 有参构造方法， 传入一个int值。 然后是怎么操作的？
    public ArrayDeque(int numElements) {
        allocateElements(numElements);
    }
    
    private void allocateElements(int numElements) {
        elements = new Object[calculateSize(numElements)];
    }
    
    
    // 										13
    private static int calculateSize(int numElements) {
        // private static final int MIN_INITIAL_CAPACITY = 8;
        int initialCapacity = MIN_INITIAL_CAPACITY;
        
        // 如果，传入的值，小于8. 这时候，直接返回8. 
        // 否则进入。 if。 
        
        if (numElements >= initialCapacity) {
            // initialCapacity =  numElements = 13
            // 1101
            initialCapacity = numElements;
            
            // initialCapacity |= (initialCapacity >>>  1);
            // 这一行，拆成几个步骤？
            // initialCapacity >>>  1
            // initialCapacity = (initialCapacity) | (initialCapacity >>>  1)
            
            //  1101     initialCapacity
            //  0110     initialCapacity >>>  1
            //  1111
            
            initialCapacity |= (initialCapacity >>>  1);
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;

            if (initialCapacity < 0)   // Too many elements, must back off
                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
        }
        return initialCapacity;
    }
   
    
}
```





```JAVA
24
    // 0001 1000
private static int calculateSize(int numElements) {
    int initialCapacity = MIN_INITIAL_CAPACITY;

    if (numElements >= initialCapacity) {
        
        // initialCapacity = 0001 1000
        initialCapacity = numElements;
        
        // initialCapacity |= (initialCapacity >>>  1);
        // 0001 1000     initialCapacity
        // 0000 1100     (initialCapacity >>>  1)
        // 0001 1100  == initialCapacity
        

        initialCapacity |= (initialCapacity >>>  1);  // num +=3;
        // initialCapacity |= (initialCapacity >>>  1); ===> initialCapacity = initialCapacity |(initialCapacity >>>  1);
        
        // 0001 1100   initialCapacity
        // 0000 0111    (initialCapacity >>>  2)
        // 0001 1111
        
        initialCapacity |= (initialCapacity >>>  2);
        initialCapacity |= (initialCapacity >>>  4);
        initialCapacity |= (initialCapacity >>>  8);
        initialCapacity |= (initialCapacity >>> 16);
        initialCapacity++;
        
        // // 0010 0000 === 32

        if (initialCapacity < 0)   // Too many elements, must back off
            initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
    }
    return initialCapacity;
}

// 32   0010 0000
// 0010 0000
// 0011 0000
// 0011 1100
// 0011 1111

// 我们能不能，从第一位非0的开始，填1. 

// log2（n）
```







