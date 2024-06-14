package tmp;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class TestThreads {

    @Test
    public void shouldPrintPropertiesOfMainThread() {
        Thread currentThread = Thread.currentThread();

        System.out.println("Thread id is: " + currentThread.threadId());
        System.out.println("Thread name is: " + currentThread.getName());
        System.out.println("Thread priority is: " + currentThread.getPriority());
        System.out.println("Thread state is: " + currentThread.getState());
        System.out.println("Thread group of the thread is: " + currentThread.getThreadGroup());

        System.out.println(currentThread.isDaemon());
        System.out.println(currentThread.getStackTrace());
        System.out.println(currentThread.getClass());
        System.out.println(currentThread.getContextClassLoader());
    }

    @Test
    public void shouldPrintPropertiesOfAdditionalThreads() {
        Thread mainThread = Thread.currentThread();
        System.out.println("Thread name is: " + mainThread.getName());

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Second thread started!");
                System.out.println("Inside secondThred is: " + Thread.currentThread().getName());
            }
        });

        Thread thirdThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Third thread started!");
                System.out.println("Inside thirdThread is: " + Thread.currentThread().getName());
            }
        });

        secondThread.start();
        thirdThread.start();

        System.out.println(secondThread.getName());
        System.out.println(thirdThread.getName());
        System.out.println("Main thread eneded!");
    }

    @Test
    public void testThreadSleepMethod() {
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(60);
                System.out.println("Waked up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();

        System.out.println(thread.isAlive());
    }

    @Test
    public void shouldTestInterruptMethod() {
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
    }

    @Test
    public void shouldTestIsInterruptedFlag() {
        Runnable task = () -> {
            while(!Thread.currentThread().isInterrupted()) {
                //Do some work
            }
            System.out.println("Finished");
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
    }

    @Test
    public void shouldTestJoinMethod() throws InterruptedException {
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
        System.out.println("Finished");
    }

    // Выполнение синхронизации по объекту object
    @Test
    public void shouldTestSynchronized() {
        Object object = new Object();
        synchronized(object) {
            System.out.println("Hello World");
        }
    }

    // Блок синхронизации
    @Test
    public void shouldTestSynchronizedBlock() throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                System.out.println("thread");
            }
        };

        Thread th1 = new Thread(task);
        th1.start();
        synchronized (lock) {
            for (int i = 0; i < 8; i++) {
                Thread.currentThread().sleep(1000);
                System.out.print("  " + i);
            }
            System.out.println(" ...");
        }
    }

    @Test
    public void shouldTestWaitAndNotify() throws InterruptedException {
        Object lock = new Object();
        // task будет ждать, пока его не оповестят через lock
        Runnable task = () -> {
            synchronized(lock) {
                try {
                    lock.wait();
                } catch(InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
            // После оповещения нас мы будем ждать, пока сможем взять лок
            System.out.println("thread");
        };
        Thread taskThread = new Thread(task);
        taskThread.start();
        // Ждём и после этого забираем себе лок, оповещаем и отдаём лок
        Thread.currentThread().sleep(3000);
        System.out.println("main");
        synchronized(lock) {
            lock.notify();
        }
    }

    @Test
    public void shouldTestSemaphore() {
        Semaphore semaphore = new Semaphore(0);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            // Просим разрешение и ждём, пока не получим его
            e.printStackTrace();
        }
        System.out.println("Hello, World!");
    }

    @Test
    public void shouldTestLockSupport() throws InterruptedException {
        Runnable task = () -> {
            //Запаркуем текущий поток
            System.err.println("Will be Parked");
            LockSupport.park();
            // Как только нас распаркуют - начнём действовать
            System.err.println("Unparked");
        };
        Thread th = new Thread(task);
        th.start();
        Thread.currentThread().sleep(2000);
        System.err.println("Thread state: " + th.getState());

        LockSupport.unpark(th);
        Thread.currentThread().sleep(2000);
    }

    @Test
    public void shouldTestReentrantLock() throws InterruptedException {
        Runnable task = () -> {
            //Запаркуем текущий поток
            System.err.println("Will be Parked");
            LockSupport.park();
            // Как только нас распаркуют - начнём действовать
            System.err.println("Unparked");
        };
        Thread th = new Thread(task);
        th.start();
        Thread.currentThread().sleep(2000);
        System.err.println("Thread state: " + th.getState());

        LockSupport.unpark(th);
        Thread.currentThread().sleep(2000);
    }

    // Executor interface
    @Test
    public void shouldTestExecutor() {
        Runnable task = () -> System.out.println("Task executed");
        Executor executor = (runnable) -> {
            new Thread(runnable).start();
        };
        executor.execute(task);
    }

    @Test
    public void shouldTestExecutorSerivce() throws ExecutionException, InterruptedException {
        Callable<String> task = () -> Thread.currentThread().getName();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            Future result = service.submit(task);
            System.out.println(result.get());
        }
        service.shutdown();
    }

}

// synchronized block
// wait, notify