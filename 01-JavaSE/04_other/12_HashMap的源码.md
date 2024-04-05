

# 提前看一下

```JAVA
class HashMap{
    
    // HashMap的底层结构，是  数组 + 链表 + 红黑树。 
    Node<K,V>[] table;
    
    // 存储的键值对个数。 
    int size;
    
    // final float DEFAULT_LOAD_FACTOR = 0.75f;
    float loadFactor;
   
    
    // 空的构造方法里面。 
    public HashMap() {
        // 0.75f. 在空构造方法中，只对加载因子进行了赋值。 加载因子，就是控制HashMap存储数据的疏密程度。 
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }
    
    // 在空构造方法里面，没有对数组进行初始化。 在添加方法的时候一定进行了初始化。 
    //	key是传入的key , value是传入的value
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
    
    // hash方法的作用。 就是传入一个 key，返回一个int。 
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    
    //                 hash 根据key算出来的int值。 
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        
        // table 就是底层的数组。 
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        
        // 如果当前的大小，超过了阈值。 这时候会进行扩容。 
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
    
    
}
```



```JAVA
// p是什么东西？  p是数组该位置的数据。 Node(hash  key  value  next )
// hash  key  value  传入
// 1.传入的hash和该数组位置的hash。 相同。
if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
```



重点关注两个问题

- 数组初始长度是16. 在哪里初始化的
- 扩容机制是2倍，在哪



# 初始化代码

```JAVA
class HashMap{
    // HashMap的底层结构，是  数组 + 链表 + 红黑树。 
    Node<K,V>[] table;
    
    // 存储的键值对个数。 
    int size;
    
    // final float DEFAULT_LOAD_FACTOR = 0.75f;
    float loadFactor;
    
    // 阈值。 
    int threshold;
    
    // 空构造方法里面，没有对底层的table进行任何的初始化。 所以，现在要看初始化，应该看添加方法。
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }
    
    // 		key是传入的key； value是传入的value
    public V put(K key, V value) {
        // hash(key) : 把key变成hash值， int值。
        return putVal(hash(key), key, value, false, true);
    }
    
    //    hash就是根据key，算出来的int值； 
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        
        // table是底层的数组。 table还没有赋值，现在是个null。
        // 所以，现在进入到 里面去。 
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
    
    
    final Node<K,V>[] resize() {
        // oldTab = table = null
        Node<K,V>[] oldTab = table;
        // oldCap = 0
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        // oldThr = threshold = 0
        int oldThr = threshold;
        // newCap newThr=0
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            // newCap = DEFAULT_INITIAL_CAPACITY (16) = 16
            newCap = DEFAULT_INITIAL_CAPACITY;
            // newThr = (int) * (0.75 * 16) = 12
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        // threshold = newThr = 12;
        threshold = newThr;
        // newTab = new Node[16]
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
    
}
```





- 初始化长度是16. 



# 扩容代码

问题1： 扩容的应该在哪里找？  添加。

问题2： 添加着，添加着，就会扩容。 



```JAVA
class HashMap{
    // HashMap的底层结构，是  数组 + 链表 + 红黑树。 
    Node<K,V>[] table;
    
    // 存储的键值对个数。 
    int size;
    
    // final float DEFAULT_LOAD_FACTOR = 0.75f;
    float loadFactor;
    
    // 阈值。 
    int threshold;
    
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
    
   
    
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        
        // 如果该位置没有数据，直接创建新节点。 
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            // 能走到else说明有数据。
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
    
    // 现在，这个resize方法，是什么时候进来的。
    // put 
    // table = new Node[16];
    final Node<K,V>[] resize() {
        // oldTab = table  =  Node[16]
        Node<K,V>[] oldTab = table;
        // oldCap = oldTab.length = 16
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        
        // oldThr = threshold = 12
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            // newCap = oldCap << 1 = 2*oldCap
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                // newThr = 24
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        //threshold = 24
        threshold = newThr;
        // newTab = new Node[32]
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
    
}


```







```JAVA
看源码，有的时候不要一行一行瞅。主要是看大致的逻辑。理解逻辑就行。 
```





