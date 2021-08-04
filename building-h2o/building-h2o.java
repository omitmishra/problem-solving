class H2O {
     private Semaphore HSemaphore = new Semaphore(2);
    private Semaphore OSemaphore = new Semaphore(0);

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            HSemaphore.acquire(1);
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            if(HSemaphore.availablePermits() == 0) {
               OSemaphore.release();
            }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        OSemaphore.acquire(1);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        HSemaphore.release(2);
       // HSemaphore.release();
    }
}