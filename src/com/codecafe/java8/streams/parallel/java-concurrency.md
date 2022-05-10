> We solve one set of problems only to create a new set of problems.

* Java 1 introduced the concept of THREADS. It was really great at that time. Using Threads to parallelize tasks using only one set of APIs. You don't have to write different code for different
  operating systems. But after sometime, programmers realized that Threads are really not that lightweight. It was not a good idea to create threads after threads.


* Java 5 introduced ExecuterServices. It was a great API. It was a pool of threads and eventually turned out to be a pool of problems !!
  It gave rise to a problem called - **POOL INDUCED DEADLOCK**.


* Java 7 solved this problem with the Fork Join pool which was based on the concept of Work Stealing.
  - https://www.oracle.com/technical-resources/articles/java/fork-join.html
  - https://www.baeldung.com/java-work-stealing
  - https://www.logicbig.com/tutorials/core-java-tutorial/java-multi-threading/fork-and-join.html
  - https://stackify.com/java-thread-pools/

+ Java 8 parallel streams use Java 7's Fork Join Pool i.e. the common fork join pool.

Notice the output of ObservingThreads.java :

```java
t:7--Thread[main,5,main]
  t:8--Thread[ForkJoinPool.commonPool-worker-4,5,main]
  t:2--Thread[ForkJoinPool.commonPool-worker-11,5,main]
  t:3--Thread[ForkJoinPool.commonPool-worker-9,5,main]
  t:1--Thread[ForkJoinPool.commonPool-worker-15,5,main]
  t:6--Thread[ForkJoinPool.commonPool-worker-8,5,main]
  t:5--Thread[ForkJoinPool.commonPool-worker-13,5,main]
  t:4--Thread[ForkJoinPool.commonPool-worker-6,5,main]
  t:9--Thread[ForkJoinPool.commonPool-worker-2,5,main]
  t:10--Thread[ForkJoinPool.commonPool-worker-1,5,main]
```