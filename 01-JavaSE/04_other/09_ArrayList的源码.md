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
// ArrayList的源码。 
// ArrayList底层是数组。 elementData   size 
class ArrayList{
    
    // ArrayList底层用于存储数据的数组。
    Object[] elementData;
    
    // size 数组底层存储的数据的多少。 
    int size;
   
    // ArrayList的无参构造方法。 
    public ArrayList() {
        // 当前对象。DEFAULTCAPACITY_EMPTY_ELEMENTDATA {}
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    
    // 在无参方法里面，elementData 赋值了一个空的。 在什么时候，一定会对它进行初始化。 
    // 添加数据的时候，一定会进行初始化。  现在，要看添加方法。 
    public boolean add(E e) {
        // 结构改变次数。用来确定自己结构化改变的次数。 在迭代里面。 
        // 在迭代器里面，存储了一个int值。就是原有集合结构化改变次数。 等到你用原有集合直接操作，结构化改变次数+1.与之前存的不一样，直接报错。 
        modCount++;
        
        //  需要添加的数据     DEFAULTCAPACITY_EMPTY_ELEMENTDATA    0
        add(e, elementData, size);
        return true;
    }
    
    //                                               0
     private void add(E e, Object[] elementData, int s) {
         // 0  == 0
        if (s == elementData.length)
            // 成立，进入了这里面。 
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }
    
    private Object[] grow() {
        return grow(size + 1);
    }
    
    //                            1  
    private Object[] grow(int minCapacity) {
        // oldCapacity = 0
        int oldCapacity = elementData.length;
        //
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            // 进入到这里面。 
            //					10				1
            // Math.max(DEFAULT_CAPACITY, minCapacity) 
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }
    
    
}

```







## JDK8关于ArrayList的源码

### 初始化代码

```JAVA
class ArrayList{
    
    // 底层实际存储数据的数组
    Object[] elementData;
    
    // 存储的元素的个数。 
    int size;
   
    // elementData里面，也没有效复制。所以还得看添加方法。 
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    
    
    // 初始化，一定是在第一行。 
    public boolean add(E e) {
        //					    0+1=1
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
    
    //											1
    private void ensureCapacityInternal(int minCapacity) {
        // 两个方法嵌套。是把内层方法的返回值，作为外层方法的参数传入。 
        // 所以先看 calculateCapacity(elementData, minCapacity)
        // ensureExplicitCapacity()
        //                                             {}        1
        //  calculateCapacity(elementData, minCapacity)  === 10 
        // 
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }
    
    //												{}               1
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            // Math.max(10, 1)
            // 返回10
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }
    
    //											10
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        //   10   - 0 > 0
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    
    //                      10
    private void grow(int minCapacity) {
        // oldCapacity = 0
        int oldCapacity = elementData.length;
        // newCapacity = 1.5 * oldCapacity = 0
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        
        //     0     -   10 < 0
        if (newCapacity - minCapacity < 0)
            // newCapacity = 10
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // elementData = 长度是10.
        // Arrays.copyOf。 如果能拷贝上，就把数据拷贝过来；拷不过来，就填null。 
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // ArrayList初始化长度是10. 
    
    // 扩容怎么扩的？
}
```



### 扩容策略

```java
class ArrayList{
    
    // 底层实际存储数据的数组
    Object[] elementData;

    // 存储的元素的个数。 
    int size;
    
    // 扩容。 在什么时候会扩容？一定是在添加的时候，会满。 
    
    
    // 现在，elementData里面，有多少数据。 数组长10. 
    public boolean add(E e) {
        //                      10 + 1=11
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }
    
    //										  11
    private void ensureCapacityInternal(int minCapacity) {
        // calculateCapacity(elementData, minCapacity)
        // ensureExplicitCapacity(11)
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }
    
    // elementData = new Object[10]                                  11
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }
    
    //										  11
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        //  11   - 10 > 0
        if (minCapacity - elementData.length > 0)
            //    11
            grow(minCapacity);
    }
    
    //							11
    private void grow(int minCapacity) {
        // oldCapacity = 10
        int oldCapacity = elementData.length;
        // newCapacity = oldCapacity + 0.5 *oldCapacity = 1.5  * oldCapacity = 15
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        
        //    15 - 11 > 0
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // Arrays.copyOf(elementData, newCapacity); 把之前的数据拷贝过来。 
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    
    // 扩容策略，是按1.5倍来的。 
    
}
```



```JAVA
// 1.看源码的时候，不要紧盯着一行去看。 要看大体的逻辑。 
// 看大体的逻辑。 有时候，一些特殊的行，很可能是因为出现过一些特殊的bug，然后补上去的。
// 所以如果每一行要理解的话，成本非常的大。 

// toB. 
// 环境非常的多。 
// 研发，会去帮忙排查。 这里确实有bug。 

// 补丁。 
```



```JAVA
// 添加方法。 删除方法， indexOf   size 
class ArrayList{
    
    // 底层实际存储数据的数组
    Object[] elementData;

    // 存储的元素的个数。 
    int size;
    
    
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    
   public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }
    
    
    // ArrayList其他的方法，大家可以自己看一下。 
    
}
```







```JAVA
// modCount等会看。 
    
    
// 迭代器，是干什么的。遍历的。 
// 如果说，是一个数组的话。用一个int就可以完成遍历； 如果是个链表，指针。 
// ArrayList的底层，是什么东西。 数组。  它的底层，用int就行。 
// Iterator： 接口。 Itr这个类，就是ArrayList里面，用来实现 Iterator的类。 


class ArrayList{
    // 底层实际存储数据的数组
    Object[] elementData;

    // 存储的元素的个数。 
    int size;
   
    // 结构化改变次数。   add  remove   
    int modCount;
    
    
     public Iterator<E> iterator() {
        return new Itr();
    }
    
     private class Itr implements Iterator<E> {
         // Itr里面的成员变量。 
         // cursor = 0； 
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
         
         // 在创建这个Itr的时候。 expectedModCount 就存储了，生成迭代器的那一刻的modCount值。 
        int expectedModCount = modCount;
         
         
         // 成员方法。 hasNext()  next()
         public boolean hasNext() {
            return cursor != size;
        }
         
         public E next() {
             // 先检查。 expectedModCount和modCount的是否相等。 
            checkForComodification();
             // i =  1
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
             // cursor = 2
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }
         
         public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
     }
    
}

```















